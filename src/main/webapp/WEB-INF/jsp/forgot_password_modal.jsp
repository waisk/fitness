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
                <spring:message code="ForgotPasswordEmail" text="Please enter your email."/>
                <spring:message code="Email" var="Email" text="Email"/>
                <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                <input type="email" name="forgotEmail" id="forgot_email" class="form-control" placeholder="${Email}" required autofocus>
                </div>
                <br>
                <button class="btn btn-md btn-primary " id="forgotPasswordBtn" disabled="true"><spring:message code="Send" text="Send"/></button>

            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="forgotPasswordSent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <spring:message code="ForgotPasswordSent" text="You will receive an email with your password soon."/>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="forgotPasswordErrorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <spring:message code="RxOrdering.ServerError" text="AKFitness Server Error: Please try again later"/>
            </div>
        </div>
    </div>
</div>
