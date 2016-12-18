<%-- 
    Document   : invalidCredentialsModal
    Created on : 8-Oct-2016, 7:18:40 PM
    Author     : wais
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="modal fade" id="invalidCredentials" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog modal-sm">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="alert alert-danger">
            <spring:message code="InvalidLoginCredentials" text="Invalid email or password"/>
        </div>
    </div>
</div>