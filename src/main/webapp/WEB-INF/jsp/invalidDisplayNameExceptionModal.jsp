<%-- 
    Document   : invalidCredentialsModal
    Created on : 8-Oct-2016, 7:18:40 PM
    Author     : wais
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="modal fade" id="invalidDisplayNameExceptionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal" >&times;</button>
                <spring:message code="DuplicateUsername" text="Username already exists"/>
            </div>
        </div>
    </div>
</div>
