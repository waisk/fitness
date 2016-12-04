<%-- 
    Document   : systemErrorModal
    Created on : 4-Dec-2016, 3:59:23 PM
    Author     : wais
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="internalErrorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">
                <button type="button" class="close" data-dismiss="modal" >&times;</button>
                <spring:message code="InternalError" text="An error occured with our system. Please try again later."/>
            </div>
        </div>
    </div>
</div>
