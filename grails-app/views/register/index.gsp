<%@ page import="yeeband.UserType" %>
<html>

<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>

<body>

<p/>

<div class="jumbotron">

    <s2ui:form width='400' height='300' elementId='loginFormContainer'
               titleCode='spring.security.ui.register.description' center='true' class='jumbotron'>

        <g:form action='register' name='registerForm'>

            <g:if test='${emailSent}'>
                <br/>
                <g:message code='spring.security.ui.register.sent'/>
            </g:if>
            <g:else>

                <br/>

                <div class="form-group">
                    <input type="email" class="form-control" id="username" name="username" placeholder="Enter email">
                </div>

                <div class="form-group">
                    <g:select name="userTypeValue" from="${UserType.values()}" optionKey="id" valueMessagePrefix="ENUM.UserType"/>
                    %{--<my:enumSelect name="userType"/>--}%
                </div>

                <div class="form-group">
                    <g:passwordField name="password" value="${command?.password}" size="25" class="form-control" placeholder="Password" />
                </div>

                <div class="form-group">
                    <g:passwordField name="password2" value="${command?.password2}" size="25" class="form-control" placeholder="Password (again)"/>
                </div>

            %{--<table>--}%
            %{--<tbody>--}%

            %{--<s2ui:textFieldRow name='username' labelCode='user.username.label' bean="${command}"--}%
            %{--size='40' labelCodeDefault='Username' value="${command.username}"/>--}%


            %{--<s2ui:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"--}%
            %{--size='40' labelCodeDefault='Password' value="${command.password}"/>--}%

            %{--<s2ui:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"--}%
            %{--size='40' labelCodeDefault='Password (again)' value="${command.password2}"/>--}%

            %{--</tbody>--}%
            %{--</table>--}%

                <s2ui:submitButton elementId='create' form='registerForm'
                                   messageCode='spring.security.ui.register.submit'/>

            </g:else>

        </g:form>

    </s2ui:form>
</div>
<script>
    $(document).ready(function () {
        $('#username').focus();
    });
</script>

</body>
</html>
