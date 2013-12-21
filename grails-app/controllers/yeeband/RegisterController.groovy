package yeeband

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.authentication.dao.NullSaltSource
import grails.plugin.springsecurity.ui.RegistrationCode

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

    def forgotPassword() {

        if (!request.post) {
            // show the form
            return
        }

        String username = params.username
        if (!username) {
            flash.error = message(code: 'spring.security.ui.forgotPassword.username.missing')
            redirect action: 'forgotPassword'
            return
        }

        String usernameFieldName = SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName
        def user = lookupUserClass().findWhere((usernameFieldName): username)
        if (!user) {
            flash.error = message(code: 'spring.security.ui.forgotPassword.user.notFound')
            redirect action: 'forgotPassword'
            return
        }

        def registrationCode = new RegistrationCode(username: user."$usernameFieldName")
        registrationCode.save(flush: true)

        String url = generateLink('resetPassword', [t: registrationCode.token])

        def conf = SpringSecurityUtils.securityConfig
        def body = message(code: conf.ui.forgotPassword.emailBody, args: [user.username, url]);
        mailService.sendMail {
            to user.username
            from conf.ui.forgotPassword.emailFrom
            subject message(code:conf.ui.forgotPassword.emailSubject)
            html body.toString()
        }

        [emailSent: true]
    }

    def register(RegisterCommand command) {

        if (command.hasErrors()) {
            render view: 'index', model: [command: command]
            return
        }

        String salt = saltSource instanceof NullSaltSource ? null : command.username
        def user = lookupUserClass().newInstance(userType: UserType.getById(command.userTypeValue), username: command.username,
                accountLocked: true, enabled: true)

        RegistrationCode registrationCode = springSecurityUiService.register(user, command.password, salt)
        if (registrationCode == null || registrationCode.hasErrors()) {
            // null means problem creating the user
            flash.error = message(code: 'spring.security.ui.register.miscError')
            flash.chainedParams = params
            redirect action: 'index'
            return
        }

        String url = generateLink('verifyRegistration', [t: registrationCode.token])

        def conf = SpringSecurityUtils.securityConfig
        def body = message(code: conf.ui.forgotPassword.emailBody, args: [user.username, url]);
        mailService.sendMail {
            to user.username
            from conf.ui.forgotPassword.emailFrom
            subject message(code:conf.ui.forgotPassword.emailSubject)
            html body.toString()
        }


        render view: 'index', model: [emailSent: true]
    }

}

class RegisterCommand {

    String username
    String userTypeValue
    String password
    String password2

    def grailsApplication

    static constraints = {
        username blank: false, validator: { value, command ->
            if (value) {
                def User = command.grailsApplication.getDomainClass(
                        SpringSecurityUtils.securityConfig.userLookup.userDomainClassName).clazz
                if (User.findByUsername(value)) {
                    return 'registerCommand.username.unique'
                }
            }
        }
        userTypeValue blank: false
        password blank: false, validator: RegisterController.passwordValidator
        password2 validator: RegisterController.password2Validator
    }
}
