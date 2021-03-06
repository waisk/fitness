<%-- 
    Document   : forgotPasswordModal
    Created on : 8-Oct-2016, 5:59:58 PM
    Author     : wais
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade forgotPasswordBtn" id="forgotPasswordModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="panel-heading">
                <h3 class="panel-title"><spring:message code="ForgetPassword" text="Forgot Password?"/></h3>
            </div>
            <div class="modal-body" style="overflow-x: auto">
                <spring:message code="ForgotPasswordUsername" text="Please enter your username."/>
                <div class="input-group" style="width: 100%">
                    <label class="sr-only" for="username"><spring:message code="Username" text="Username"/></label>
                    <spring:message code="Username" var="Username" text="Username"/>
                    <input type="input" class="form-control" id="forgotUsername" placeholder="${Username}" required autofocus>
                </div>
                <br>
                <button class="btn btn-md btn-primary " id="forgotPasswordBtn" disabled ><spring:message code="Send" text="Send"/></button>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="forgotPasswordSentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <spring:message code="FollowResetInstructions" text="Follow the instructions in the email to reset your password"/><br/>
                <spring:message code="EmailDelay" text="Your email may take up to 5 minutes to arrive (depending on your email service provider)."/><br/>
                <spring:message code="IfNoEmail" text="If you don't receive an email, try the following:"/><br/>
                <spring:message code="CheckSpam" text="Check your spam or junk mail folder"/><br/>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="usernameDoesNotExist" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog modal-sm">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="alert alert-danger">
            <spring:message code="UserNameDoesNotExist" text="This username does not exist in our system. Please verify username."/>
        </div>
    </div>
</div>

<div class="modal fade" id="wrongTokenOrTokenExpired" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog modal-sm">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="alert alert-dismissible alert-danger">
            <spring:message code="WrongTokenOrTokenExpired" text="Wrong token or token is expired."/>
        </div>
    </div>
</div>

<div class="modal fade" id="resetPasswordSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <spring:message code="ResetPasswordSuccess" text="You have successfully reset your password. You can now log in."/>
                <br/>
                <button class="btn btn-sm btn-primary pull-right" id="resetPasswordConfirmationBtn"><spring:message code="Next" text="Next"/></button>
            </div>
        </div>
    </div>
</div>