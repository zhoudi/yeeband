<html>

<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>

<body>

<p/>

<div class="jumbotron">
    <h1><g:message code="index.title" default="Yeeband系统"/></h1>
    %{--<div class="login-inner">--}%
    <div class="container" style="width: 260px">
        <form action='${postUrl}' method='POST' id="loginForm" name="loginForm" autocomplete='off'>
            %{--<div class="sign-in">--}%

            <div class="form-group">
                <label class="sr-only" for="email">Email address</label>
                <input type="text" class="form-control" id="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label class="sr-only" for="password">Password</label>
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


            %{--<input type="text" id="username" size="20" class="form-control" style="width: 120px;" placeholder="Email address"/>--}%
            %{--<input type="password" name="j_password" id="password" class="input-block" size="20" />--}%
            %{--<table>--}%
            %{--<tr>--}%
            %{--</label>--}%
            %{--<td><input name="j_username" id="username" size="20" /></td>--}%
            %{--</tr>--}%
            %{--<tr>--}%
            %{--<td><label for="password"><g:message code='spring.security.ui.login.password'/></label></td>--}%
            %{--<td><input type="password" name="j_password" id="password" size="20" /></td>--}%
            %{--</tr>--}%
            %{--<tr>--}%
            %{--<td colspan='2'>--}%
            %{--<input type="checkbox" class="checkbox" name="${rememberMeParameter}" id="remember_me" checked="checked" />--}%
            %{--<label for='remember_me'><g:message code='spring.security.ui.login.rememberme'/></label> |--}%
            %{--<span class="forgot-link">--}%
            %{--<g:link controller='register' action='forgotPassword'><g:message code='spring.security.ui.login.forgotPassword'/></g:link>--}%
            %{--</span>--}%
            %{--</td>--}%
            %{--</tr>--}%
            %{--<tr>--}%
            %{--<td colspan='2'>--}%
            %{--<s2ui:linkButton elementId='register' controller='register' messageCode='spring.security.ui.login.register'/>--}%
            %{--<s2ui:submitButton elementId='loginButton' form='loginForm' messageCode='spring.security.ui.login.login'/>--}%
            %{--</td>--}%
            %{--</tr>--}%
            %{--</table>--}%

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
