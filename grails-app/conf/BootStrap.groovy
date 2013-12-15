import yeeband.Role
import yeeband.User
import yeeband.UserRole
import yeeband.UserType

class BootStrap {

    def init = { servletContext ->

        if (User.count() == 0 && Role.count() == 0) {
            //init data
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            def initUser = new User(username: 'user@yeeband.com', enabled: true, password: 'user', userType: UserType.User)
            initUser.save(flush: true)

            def initAdmin = new User(username: 'admin@yeeband.com', enabled: true, password: 'admin', userType: UserType.User)
            initAdmin.save(flush: true)

            UserRole.create initUser, userRole, true
            UserRole.create initAdmin, adminRole, true
        }

    }
    def destroy = {
    }
}
