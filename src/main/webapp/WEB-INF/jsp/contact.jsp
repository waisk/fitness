<%-- 
    Document   : services
    Created on : 2-Oct-2016, 7:34:30 PM
    Author     : wais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="Ak Fitness Online Training Package Deals">
        <meta name="author" content="AKFitness">
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />

        <title>Ak Fitness Online Training Package Deals</title>

        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

        <!-- Awesome font-->
        <link href="${pageContext.request.contextPath}/webjars/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">

        <!-- Bootstrap social-->
        <link href="${pageContext.request.contextPath}/webjars/bootstrap-social/5.0.0/bootstrap-social.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="${pageContext.request.contextPath}/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/contact.css" rel="stylesheet">

        <!-- jQuery-->
        <script src="${pageContext.request.contextPath}/webjars/jquery/2.2.3/jquery.min.js"></script>
        <!-- Bootstrap-->
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/contact.js"></script>

        <!-- Bootstrap form helper js-->
        <script src="${pageContext.request.contextPath}/webjars/bootstrap-form-helpers/2.3.0/dist/js/bootstrap-formhelpers.min.js"></script>

        <script src="${pageContext.request.contextPath}/webjars/jquery-validation/1.15.1/jquery.validate.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/webjars/jquery.payment/1.4.1/lib/jquery.payment.min.js"></script>-->

    </head>
    <%@ include file="header.jsp" %>

    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <script type="text/javascript">
            $('#contactNav').addClass('active');
        </script>
        <div class="container">
            <div class="row">
                <br/><br/><br/><br/>
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" method="post">
                            <fieldset>
                                <legend class="text-center headerContact"><spring:message code="Contactus" text="Contact us"/></legend>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-1 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <spring:message code="FirstName" var="FirstName" text="First Name"/>
                                        <input id="c_fname" name="name" type="text" placeholder="${FirstName}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-1 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <spring:message code="LastName" var="LastName" text="Last Name"/>
                                        <input id="c_lname" name="name" type="text" placeholder="${LastName}" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-1 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                    <div class="col-md-8">
                                        <spring:message code="EmailAddress" var="EmailAddress" text="Email Address"/>
                                        <input id="c_email" name="email" type="text" placeholder="${EmailAddress}" class="form-control" required>
                                    </div>
                                </div>

                                <!--                                <div class="form-group">
                                                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-phone-square bigicon"></i></span>
                                                                    <div class="col-md-8">
                                <spring:message code="EmailAddress" var="EmailAddress" text="Email Address"/>
                                <input id="phone" name="phone" type="text" placeholder="Phone" class="form-control">
                            </div>
                        </div>-->

                                <div class="form-group">
                                    <span class="col-md-1 col-md-offset-1 text-center"><i class="fa fa-pencil-square-o bigicon"></i></span>
                                    <div class="col-md-8">
                                        <spring:message code="EnterMessageHere" var="EnterMessageHere" text="Enter your massage for us here. We will get back to you within 2 business days."/>
                                        <textarea class="form-control messageHeight" id="c_message" name="message" placeholder="${EnterMessageHere}"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" id="submitContactFormBtn" class="btn btn-primary btn-lg"><spring:message code="Submit" text="Submit"/></button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>

            <!-- FOOTER -->
            <%@ include file="footer.jsp" %>
            <%@ include file="systemErrorModal.jsp" %>

            <div class="modal fade" id="messageSentSuccessfulModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body" style="overflow-x: auto">
                            <button type="button" class="close" data-dismiss="modal" >&times;</button>
                            <spring:message code="MessageSentSuccessful" text="Your message has been sent successfully. You should receive a response within 24 hours."/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="invalidContactFormModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
                <div class="modal-dialog modal-sm">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <div class="alert alert-danger">
                        <spring:message code="InvalidContactForm" text="Please make sure the following fields are not empty: first name, email, message."/>
                    </div>
                </div>
            </div>                            

        </div>

    </body>
</html>
