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
        <%--<%@ include file="header.jsp" %>--%>
        <div class="container centered" style="width: 100%">
            <div class="col-sm-12 col-md-4 col-lg-4 col-sm-offset-0 col-md-offset-4 col-lg-offset-4" >
                <div class="form-group">
                    <div class="panel panel-primary" id="password_modal">
                        <div class="panel-heading">
                            <h3 class="panel-title">Change Password <span class="extra-title muted"></span></h3>
                        </div>
                        <div class="panel-body form-horizontal">
                            <div class="control-group">
                                <div class="form-group resetPassword">
                                    <label class="sr-only" for="email"><spring:message code="EmailAddress" text="Email address"/></label>
                                    <spring:message code="EmailAddress" var="EmailAddress" text="Email address"/>
                                    <input type="email" class="form-control" id="reset_email" placeholder="${EmailAddress}" required>
                                </div>
                            </div>
                            <div class="control-group resetPassword">
                                <div class="form-group">
                                    <label class="sr-only" for="newPassword"><spring:message code="NewPassword" text="New Password"/></label>
                                    <spring:message code="NewPassword" var="NewPassword" text="New Password"/>
                                    <input type="password" class="form-control" id="newPassword" placeholder="${NewPassword}" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="form-group resetPassword">
                                    <label class="sr-only" for="confirmPassword"><spring:message code="NewPassword" text="Confirm Password"/></label>
                                    <spring:message code="ConfirmPassword" var="ConfirmPassword" text="Confirm Password"/>
                                    <input type="password" class="form-control" id="confirmPassword" placeholder="${ConfirmPassword}" required>
                                </div>
                            </div>      
                        </div>
                        <div class="panel-footer">
                            <button class="btn btn-primary" id="password_reset_save">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="resetPasswordErrorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body" style="overflow-x: auto">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <spring:message code="RxOrdering.ServerError" text="AKFitness Server Error: Please try again later"/>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
