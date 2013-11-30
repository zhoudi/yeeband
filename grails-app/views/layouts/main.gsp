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

<nav class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="${createLink(uri: '/')}">Yeeband</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li<%=request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : ''%>><a
                            href="${createLink(uri: '/')}"><i class="icon-home"></i> Home</a></li>

                    %{--<div class="pull-right">--}%
                        %{--<ul class="nav pull-right">--}%
                            %{--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-cog"></i> 管理 <b class="caret"></b></a>--}%
                                %{--<ul class="dropdown-menu">--}%
                                    %{--<li<%=request.forwardURI == "${createLink(uri: '/mockDataDefinition/list')}" ? ' class="active"' : ''%>>--}%
                                        %{--<g:link controller="mockDataDefinition/index">Data define Admin</g:link></li>--}%
                                    %{--<li<%=request.forwardURI == "${createLink(uri: '/mockBind/list')}" ? ' class="active"' : ''%>>--}%
                                        %{--<g:link controller="mockBind/index">Bind Admin</g:link></li>--}%
                                    %{--<li<%=request.forwardURI == "${createLink(uri: '/mockUser/list')}" ? ' class="active"' : ''%>>--}%
                                        %{--<g:link controller="mockUser/index">User Admin</g:link></li>--}%
                                    %{--<li<%=request.forwardURI == "${createLink(uri: '/mockBindValue/list')}" ? ' class="active"' : ''%>>--}%
                                        %{--<g:link controller="mockBindValue/index">User value Admin</g:link></li>--}%
                                %{--</ul>--}%
                            %{--</li>--}%
                        %{--</ul>--}%
                    %{--</div>--}%


                    %{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">--}%
                        %{--<li<%=c.logicalPropertyName == controllerName ? ' class="active"' : ''%>><g:link--}%
                                %{--controller="${c.logicalPropertyName}">${c.naturalName}</g:link></li>--}%
                    %{--</g:each>--}%

                </ul>
            </div>
            %{--<g:form controller="search" action="index" class="navbar-form form-search pull-right">--}%
                %{--<div class="input-append">--}%
                    %{--<input class="span2 search-query" type="text" placeholder="请输入" name="q">--}%
                    %{--<g:textField name="q" class="span2 search-query" placeholder="请输入"/>--}%
                    %{--<g:submitButton  name="search" class="btn" style="padding:8px,12px" value="查询" />--}%
                    %{--<button class="btn" type="submit">查询</button>--}%
                %{--</div>--}%
            %{--</g:form>--}%
        </div>
    </div>
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