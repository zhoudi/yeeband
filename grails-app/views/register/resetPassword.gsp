<html>

<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>

<body>

<p/>

<div class="jumbotron">

    <s2ui:form width='400' height='250' elementId='resetPasswordFormContainer'
               titleCode='spring.security.ui.resetPassword.header' center='true' class='jumbotron'>

        <g:form action='resetPassword' name='resetPasswordForm' autocomplete='off'>
            <g:hiddenField name='t' value='${token}'/>
            <div class="sign-in">

                <br/>
                <h4><g:message code='spring.security.ui.resetPassword.description'/></h4>

                <div class="form-group">
                    <g:textField name="password" value="${command?.password}" size="25" class="form-control" placeholder="Password" />
                </div>

                <div class="form-group">
                    <g:textField name="password2" value="${command?.password2}" size="25" class="form-control" placeholder="Password (again)"/>
                </div>



                <s2ui:submitButton elementId='reset' form='resetPasswordForm'
                                   messageCode='spring.security.ui.resetPassword.submit'/>

            </div>
        </g:form>

    </s2ui:form>
</div>
<script>
    $(document).ready(function () {
        $('#password').focus();
    });
</script>

</body>
</html>
