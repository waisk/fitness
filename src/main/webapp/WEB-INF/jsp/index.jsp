<%-- 
    Document   : index
    Created on : 26-Sep-2016, 11:07:18 PM
    Author     : wais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="AKFitness online training">
        <meta name="author" content="AKFitness">
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />


        <title>AKFitness Online Training</title>

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
        
        <!-- jQuery-->
        <script src="${pageContext.request.contextPath}/webjars/jquery/2.2.3/jquery.min.js"></script>

        <!-- Bootstrap-->
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
        
    </head>
    <!-- NAVBAR
    ================================================== -->
    <body data-spy="scroll" data-target=".navbar" data-offset="50">

        <%@ include file="header.jsp" %>
        <script type="text/javascript">
            $('#homeNav').addClass('active');
        </script>

        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="${pageContext.request.contextPath}/resources/images/fitness1.jpg" alt="AK Fitness online training slide 1">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><spring:message code="MakeItHappen" text="Make it happen!"/></h1>
                            <p><spring:message code="MotivationQuote1" text="Are you willing to get to the next level? Do you have what it takes but don’t know how?"/></p>
                            <p><a class="btn btn-lg btn-primary" href="/fitness/services" role="button"><spring:message code="SignUp" text="Sign up today"/></a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="${pageContext.request.contextPath}/resources/images/fitness2.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><spring:message code="MotivationQuote2" text="Are you ready to get fit?"/></h1>
                            <!--<p><spring:message code="MotivationQuote2" text="Are you ready to get fit?"/></p>-->
                            <p><a class="btn btn-lg btn-primary" href="/fitness/services" role="button"><spring:message code="SignUp" text="Sign up today"/></a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="${pageContext.request.contextPath}/resources/images/fitness3.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><spring:message code="MotivationQuote3" text="Your success is OUR mission"/></h1>
                            <p><a class="btn btn-lg btn-primary" href="/fitness/services" role="button"><spring:message code="SignUp" text="Sign up today"/></a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2><spring:message code="WorkoutVideos" text="Workout Videos"/></h2>
                    <p><spring:message code="WorkoutVideosDesc" text="View full HD videos for each workout. Make sure you have the proper form for maximum results."/></p>
                    <!--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>-->
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2><spring:message code="ExpertTrainer" text="Expert Trainer"/></h2>
                    <p><spring:message code="ExpertTrainerDesc" text="You will be trained and given advice by one of the best in the industry. Coach AK will provide feedback and answer any of your questions."/></p>
                    <!--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>-->
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2><spring:message code="PlayEverywhere" text="Play Everywhere"/></h2>
                    <p><spring:message code="PlayEverywhereDesc" text="You can access the website from anywhere with internet connection. You can use your laptop, tv, tablet or phone."/></p>
                    <!--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>-->
                </div><!-- /.col-lg-4 -->
            </div><!-- /.row -->


            <!-- START THE FEATURETTES -->

            <hr class="featurette-divider">

            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">COACH AK (ATIF KHEDRI)</h2>
                    <p class="lead"><small>As the founder of AK Fitness – my clients and I have overcome physical parameters and exceeded expectations of many – parents wanting more for their children, individuals in their prime and baby-boomers taking care of their health. Let’s discuss your needs and make it happen! Before forming AK fitness – I played soccer at elite levels and have participated at numerous international fitness model competitions and have been rewarded and recognized amongst the very best in the industry. I have been certified and possess the necessary credentials to help you ignite your passion and fuel the journey.The AK Fitness “Body Morphing” blueprint will pave the path to your desired outcomes. You provide the will and we will be the fuel for the journey. At AK fitness Your success is OUR mission. We don’t stop until you reach your goal. Choose your destiny and Let’s make it Happen!</small></p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive center-block" src="${pageContext.request.contextPath}/resources/images/ak2.jpg" alt="Atif Khedri Profile Pic">
                </div>
            </div>

            <hr class="featurette-divider">
<!--
            <div class="row featurette">
                <div class="col-md-7 col-md-push-5">
                    <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
                    <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                </div>
                <div class="col-md-5 col-md-pull-7">
                    <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
                </div>
            </div>

            <hr class="featurette-divider">

            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                    <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
                </div>
            </div>

            <hr class="featurette-divider">-->

            <!-- /END THE FEATURETTES -->



            <!-- FOOTER -->
            <%@ include file="footer.jsp" %>

        </div><!-- /.container -->
    </body>
</html>

