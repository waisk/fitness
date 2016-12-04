<%-- 
    Document   : resetPassword
    Created on : 8-Oct-2016, 7:28:42 PM
    Author     : wais
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="AKFitness reset password form">
        <meta name="author" content="AKFitness">
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />


        <title>AKFitness reset password form</title>

        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

        <!-- Awesome font-->
        <link href="${pageContext.request.contextPath}/webjars/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">

        <!-- Bootstrap social-->
        <link href="${pageContext.request.contextPath}/webjars/bootstrap-social/5.0.0/bootstrap-social.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="${pageContext.request.contextPath}/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/resetPassword.css" rel="stylesheet">

        <!-- jQuery-->
        <script src="${pageContext.request.contextPath}/webjars/jquery/2.2.3/jquery.min.js"></script>

        <!-- Bootstrap-->
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/resetPassword.js"></script>

    </head>
    <body>
        <script type="text/javascript">
            var token = "${token}";
        </script>
        
        <div class="container">
            <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2" style="padding-top: 70px">

                <form class="" id="onlineBookingForm" method="POST">


                        <!--<div class="panel-group" id="accordion">-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <spring:message code="ResetPassword" text="Reset your password"/>
                                    </h4>
                                </div>
                                    <div class="panel-body">
                                        <div class="row" style="padding: 15px">
                                            <div class="form-group">
                                                <spring:message code="NewPassword" text="New password"/>
                                                <input type="password" class="form-control" id="newPassword"  required>
                                            </div>
                                        </div>
                                        <div class="row" style="padding: 15px">
                                            <div class="form-group">
                                                <spring:message code="ConfirmNewPassword" text="Confirm new password"/>
                                                <input type="password" class="form-control" id="newPasswordConfirm" required>
                                                <span id="newpwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004; display: none" ></span> 
                                                <small id="newpasswordNoMatch" hidden="true"><spring:message code="PasswordNoMatch" text="Passwords do not match"/></small>
                                            </div>
                                        </div>

                                        <div class="row" style="margin-top: 10px">
                                            <div class="col-sm-7 col-md-7 col-sm-offset-3 col-md-offset-3">
                                                <button class="btn btn-lg btn-primary btn-block" id="resetNewPasswordBtn" disabled><spring:message code="Submit" text="Submit"/></button>
                                            </div>
                                        </div>
                                    </div>
                                <!--</div>-->
                            </div>
                                            
                        <!--</div>-->

                </form>
                                            <jsp:include page="forgotPasswordModal.jsp" />
                                            <jsp:include page="systemErrorModal.jsp" />

            </div>
        </div> <!-- /container -->
        <jsp:include page="footer.jsp" />

    </body>
</html>
