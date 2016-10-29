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

        <link href="${pageContext.request.contextPath}/resources/css/services.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/resources/css/registration.css" rel="stylesheet">

        <!-- jQuery-->
        <script src="${pageContext.request.contextPath}/webjars/jquery/2.2.3/jquery.min.js"></script>
        <!-- Bootstrap-->
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/serviceRegistration.js"></script>
        
        <script src="${pageContext.request.contextPath}/webjars/jquery-validation/1.15.1/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery.payment/1.4.1/lib/jquery.payment.min.js"></script>
        <script type="text/javascript" src="https://js.stripe.com/v2/"></script>


    </head>
    <%@ include file="header.jsp" %>

    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <script type="text/javascript">
            $('#servicesNav').addClass('active');
        </script>
        <div class="container">
            <div class="container marketing">
                <div class="row">
                    <br/><br/><br/><br/>
                    <h1>Welcome to AK Fitness online training package deals</h1>
                    <br/>
                    <div class="col-xs-12 col-md-3">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    Bronze</h3>
                            </div>
                            <div class="panel-body">
                                <div class="the-price">
                                    <h1>
                                        $10<span class="subscript">/mo</span></h1>
                                    <small>1 month FREE trial</small>
                                </div>
                                <table class="table">
                                    <tr>
                                        <td>
                                            1 Account
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            1 Project
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            100K API Access
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            100MB Storage
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Custom Cloud Services
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            Weekly Reports
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="panel-footer">
                                <a class="btn btn-success" role="button" id="registerBtn1">Sign Up</a>
                                1 month FREE trial</div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-3">
                        <div class="panel panel-success">
                            <div class="cnrflash">
                                <div class="cnrflash-inner">
                                    <span class="cnrflash-label">MOST
                                        <br>
                                        POPULR</span>
                                </div>
                            </div>
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    Silver</h3>
                            </div>
                            <div class="panel-body">
                                <div class="the-price">
                                    <h1>
                                        $20<span class="subscript">/mo</span></h1>
                                    <small>1 month FREE trial</small>
                                </div>
                                <table class="table">
                                    <tr>
                                        <td>
                                            2 Account
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            5 Project
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            100K API Access
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            200MB Storage
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Custom Cloud Services
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            Weekly Reports
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="panel-footer">
                                <a id="registerBtn2" class="btn btn-success" role="button">Sign Up</a>
                                1 month FREE trial</div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-3">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    Gold</h3>
                            </div>
                            <div class="panel-body">
                                <div class="the-price">
                                    <h1>
                                        $35<span class="subscript">/mo</span></h1>
                                    <small>1 month FREE trial</small>
                                </div>
                                <table class="table">
                                    <tr>
                                        <td>
                                            5 Account
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            20 Project
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            300K API Access
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            500MB Storage
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Custom Cloud Services
                                        </td>
                                    </tr>
                                    <tr class="active">
                                        <td>
                                            Weekly Reports
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="panel-footer">
                                <a id="registerBtn3" class="btn btn-success" role="button">Sign Up</a> 1 month FREE trial</div>
                        </div>
                    </div>
                </div>

                <!-- FOOTER -->
                <%@ include file="footer.jsp" %>

                <jsp:include page="registration_modal.jsp" />

            </div>
        </div>

    </body>
</html>
