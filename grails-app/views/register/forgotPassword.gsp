<html>

<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <meta name="layout" content="main"/>
</head>

<body>

<p/>

<div class="jumbotron">

    <s2ui:form width='400' height='220' elementId='forgotPasswordFormContainer'
               titleCode='spring.security.ui.forgotPassword.header' center='true' class = 'jumbotron'>

        <g:form action='forgotPassword' name="forgotPasswordForm" autocomplete='off'>

            <g:if test='${emailSent}'>
                <br/>
                <g:message code='spring.security.ui.forgotPassword.sent'/>
            </g:if>

            <g:else>

                <br/>
                <h4><g:message code='spring.security.ui.forgotPassword.description'/></h4>

                <div class="form-group">
                    <label class="sr-only" for="username"><g:message code='spring.security.ui.forgotPassword.username'/></label>
                    <input type="email" class="form-control" id="username" name="j_username" placeholder="Enter email">
                </div>

                <s2ui:submitButton elementId='reset' form='forgotPasswordForm'
                                   messageCode='spring.security.ui.forgotPassword.submit'/>

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
