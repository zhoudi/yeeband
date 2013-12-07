import yeeband.Role
import yeeband.User
import yeeband.UserRole

class BootStrap {

    def init = { servletContext ->

        if (User.count() == 0 && Role.count() == 0) {
            //init data
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            def initUser = new User(username: 'user', enabled: true, password: 'user', email: 'user@yeeband.com')
            initUser.save(flush: true)

            def initAdmin = new User(username: 'admin', enabled: true, password: 'admin', email: 'admin@yeeband.com')
            initAdmin.save(flush: true)

            UserRole.create initUser, userRole, true
            UserRole.create initAdmin, adminRole, true
        }

    }
    def destroy = {
    }
}
