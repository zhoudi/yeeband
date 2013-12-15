// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = yeeband // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {

    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '%-d{yyyy-MM-dd HH:mm:ss}  [%t:%r] - [%p]  %m%n')
        appender new org.apache.log4j.DailyRollingFileAppender(name: "file",threshold: org.apache.log4j.Level.INFO,layout:pattern(conversionPattern: '%-d{yyyy-MM-dd HH:mm:ss}  [%t:%r] - [%p]  %m%n'),file: "logs/system.log",datePattern:"'.'yyyy-MM-dd")
        appender new org.apache.log4j.DailyRollingFileAppender(name: "error-file",threshold: org.apache.log4j.Level.ERROR,layout:pattern(conversionPattern: '%-d{yyyy-MM-dd HH:mm:ss}  [%t:%r] - [%p]  %m%n'),file: "logs/error.log",datePattern:"'.'yyyy-MM-dd")

    }

    root {
        info 'stdout','file',"error-file"
        additivity = true
    }

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugins',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
    info   'com.yeeband'
}

grails.plugin.databasemigration.changelogLocation = "changelogs"

// load config from
grails.config.locations =
    ["file:${userHome}/.grails/${appName}-config.groovy",
            "file:${userHome}/.grails/${appName}-dataSource.groovy"]

grails.app.context = "/"

grails.plugin.springsecurity.password.algorithm='bcrypt'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'yeeband.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'yeeband.UserRole'
grails.plugin.springsecurity.authority.className = 'yeeband.Role'
grails.plugin.springsecurity.requestMap.className = 'yeeband.Requestmap'
grails.plugin.springsecurity.controllerAnnotations.staticRules =[
        '/aclClass/**': ['ROLE_ADMIN'],
        '/aclSid/**': ['ROLE_ADMIN'],
        '/**': ['ROLE_ADMIN'],
        '/aclObjectIdentity/**': ['ROLE_ADMIN'],
        '/aclEntry/**': ['ROLE_ADMIN'],
        '/persistentLogin/**': ['ROLE_ADMIN'],
        '/requestmap/**': ['ROLE_ADMIN'],
        '/securityInfo/**': ['ROLE_ADMIN'],
        '/registrationCode/**': ['ROLE_ADMIN'],
        '/role/**': ['ROLE_ADMIN'],
        '/console/**': ['ROLE_ADMIN'],
        '/register/**': ['IS_AUTHENTICATED_ANONYMOUSLY']
]
grails.plugin.springsecurity.rememberMe.persistent = true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'yeeband.PersistentLogin'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/'


grails.plugin.springsecurity.ui.encodePassword = false
grails.plugin.springsecurity.ui.password.minLength=6
grails.plugin.springsecurity. ui.password.maxLength=64
grails.plugin.springsecurity.ui.password.validationRegex='^.*(?=.*\\d)(?=.*[a-zA-Z]).*$'
grails.plugin.springsecurity.ui.register.emailSubject = 'ui.register.email.subject'
grails.plugin.springsecurity.ui.register.emailBody = 'ui.register.email.body'
grails.plugin.springsecurity.ui.forgotPassword.emailBody = 'ui.forgot.password.email.body'
grails.plugin.springsecurity.ui.forgotPassword.emailSubject = 'ui.forgot.password.email.subject'
grails.plugin.springsecurity.ui.forgotPassword.emailFrom = 'Yeeband.com'

