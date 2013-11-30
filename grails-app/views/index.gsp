<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>
<body>
<div class="jumbotron">
    <h1><g:message code="index.title" default="Yeeband系统"/></h1>
    <p class="lead"><g:message code="index.lead" default=""/></p>
    <a class="btn btn-large btn-success" href="${createLink(uri: '/mockUser/create')}"><g:message code="index.start" default="xxxxxx"/></a>
</div>
</body>
</html>
