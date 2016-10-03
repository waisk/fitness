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
<!--        <div class="container-fluid" style="background-color:#f57b20;color:#fff;height:50px;">
            <div class="row scrollspy-container">
                <a href="https://www.facebook.com/AKFitnessStudio" target="_blank" class="btn btn-social-icon btn-facebook">
                    <span class="fa fa-facebook"></span>
                </a>
                <a class="btn btn-social-icon btn-twitter" href="https://twitter.com/akfitnessstudio" target="_blank">
                    <span class="fa fa-twitter"></span>
                </a>
                <a class="btn btn-social-icon btn-instagram" href="http://instagram.com/akfitnessstudio" target="_blank">
                    <span class="fa fa-instagram"></span>
                </a>
                <a class="btn btn-social-icon btn-youtube" href="https://www.youtube.com/user/akfitnessstudio" target="_blank">
                    <span class="fa fa-youtube"></span>
                </a>
                <div class="pull-right">
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" style="color:#0000FF; margin-top: 9px" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <spring:message code="Language" text="Language"/>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="allLanguages">
                            <li><a href="?locale=en"><spring:message code="English" text="English"/></a></li>
                            <li><a href="?locale=fr"><spring:message code="French" text="Français"/></a></li>
                            <li><a href="?locale=es"><spring:message code="Spanish" text="Español"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <span class='icon shortcode  ' style='font-size:18px !important;color:#ffffff;'>&#57491;</span>  647-352-2515</span></div></div>					</div>
        <div class="navbar-wrapper">
            <div class="container">

                <nav class="navbar navbar-default navbar-static-top" data-spy="affix" data-offset-top="50">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <img class="navbar-brand" src="${pageContext.request.contextPath}/resources/images/AK-Fitness-Logo400.png" alt="AK Fitness logo">
                            <a class="navbar-brand" href="#">AK Fitness</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="#about"><spring:message code="About" text="About"/></a></li>
                                <li><a href="/fitness/services"><spring:message code="Services" text="Services"/></a></li>
                                <li><a href="#about"><spring:message code="Testimonials" text="Testimonials"/></a></li>
                                <li><a href="#contact"><spring:message code="Contact" text="Contact"/></a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li class="dropdown-header">Nav header</li>
                                        <li><a href="#">Separated link</a></li>
                                        <li><a href="#">One more separated link</a></li>
                                    </ul>
                                </li>
                                                                <li class="dropdown">
                                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="Language" text="Language"/><span class="caret"></span></a>
                                                                    <ul class="dropdown-menu" id="allLanguages">
                                                                        <li><a href="?locale=en"><spring:message code="English" text="English"/></a></li>
                                                                        <li><a href="?locale=fr"><spring:message code="French" text="Français"/></a></li>
                                                                        <li><a href="?locale=es"><spring:message code="Spanish" text="Español"/></a></li>
                                                                    </ul>
                                                                </li>

                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                                    <ul id="login-dp" class="dropdown-menu">
                                        <li>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                                        <div class="form-group">
                                                            <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                                            <div class="help-block text-right"><a href="">Forget the password ?</a></div>
                                                        </div>
                                                        <div class="form-group">
                                                            <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox"> keep me logged-in
                                                            </label>
                                                        </div>
                                                    </form>
                                                </div>
                                                							<div class="bottom text-center">
                                                                                                                New here ? <a href="#"><b>Join Us</b></a>
                                                                                                        </div>
                                            </div>
                                        </li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>

            </div>
        </div>-->


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
                            <p><a class="btn btn-lg btn-primary" href="#" role="button"><spring:message code="SignUp" text="Sign up today"/></a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="${pageContext.request.contextPath}/resources/images/fitness2.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><spring:message code="MotivationQuote2" text="Are you ready to get fit?"/></h1>
                            <p><spring:message code="MotivationQuote2" text="Are you ready to get fit?"/></p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="${pageContext.request.contextPath}/resources/images/fitness3.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>One more for good measure.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
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
                    <h2>Heading</h2>
                    <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2>Heading</h2>
                    <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                    <h2>Heading</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
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
            <footer>
                <p class="pull-right"><a href="#">Back to top</a></p>
                <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div><!-- /.container -->
    </body>
</html>

