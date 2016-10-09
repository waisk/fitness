<%-- 
    Document   : session_expired_modal
    Created on : 8-Oct-2016, 7:18:59 PM
    Author     : wais
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="sessionExpired" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <spring:message code="RxOrdering.SessionExpired" text="Session Expired"/>
            </div>
        </div>
    </div>
</div>
