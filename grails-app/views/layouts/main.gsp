<%@ page import="org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <title><g:layoutTitle default="${meta(name: 'app.name')}"/></title>
    <meta name="description" content="">
    <meta name="author" content="">

    <meta name="viewport" content="initial-scale = 1.0">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

    <r:require modules="bootstrap"/>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="72x72" href="${resource(dir: 'images', file: 'apple-touch-icon-72x72.png')}">
    <link rel="apple-touch-icon" sizes="114x114"
          href="${resource(dir: 'images', file: 'apple-touch-icon-114x114.png')}">

    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <a class="navbar-brand" href="${createLink(uri: '/')}">Yeeband</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li<%=request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : ''%>><a
                    href="${createLink(uri: '/')}"><i class="icon-home"></i> Home</a></li>

            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <li<%=c.logicalPropertyName == controllerName ? ' class="active"' : ''%>><g:link
                        controller="${c.logicalPropertyName}">${c.naturalName}</g:link></li>
            </g:each>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>


<div class="container-fluid">
    <g:layoutBody/>
    <hr>
    <footer>
        <p>&copy; yeeband 2013</p>
    </footer>
</div>

<r:layoutResources/>

</body>
</html>