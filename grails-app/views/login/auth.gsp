<html>

<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>

<body>

<p/>

<div class="jumbotron">
    <h1><g:message code="index.title" default="Yeeband系统"/></h1>
    <div class="container" style="width: 260px">
        <form action='${postUrl}' method='POST' id="loginForm" name="loginForm" autocomplete='off'>

            <div class="form-group">
                <input type="email" class="form-control" id="username" name="j_username" placeholder="Enter email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="j_password" placeholder="Password">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" class="checkbox" name="${rememberMeParameter}" id="remember_me" />
                    <span class="forgot-link">
                        <g:link controller='register' action='forgotPassword'><g:message code='spring.security.ui.login.forgotPassword'/></g:link>
                    </span>
                </label>
            </div>
            <div class="btn btn-link">
                <s2ui:linkButton elementId='register' controller='register' messageCode='spring.security.ui.login.register'/>
            </div>
            <s2ui:submitButton  elementId='loginButton' form='loginForm' messageCode='spring.security.ui.login.login'/>

        </form>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('#username').focus();
    });

<s2ui:initCheckboxes/>

</script>

</body>
</html>
