<%-- 
    Document   : header
    Created on : 2-Oct-2016, 7:50:28 PM
    Author     : wais
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="container-fluid" style="background-color:#f57b20;color:#fff;height:50px;">
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
                            <!--<a class="navbar-brand" href="#">AK Fitness</a>-->
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li id="homeNav"><a href="/fitness"><spring:message code="Home" text="Home"/></a></li>
                                <li id="aboutNav"><a href="/about"><spring:message code="About" text="About"/></a></li>
                                <li id="servicesNav" ><a href="/fitness/services"><spring:message code="Services" text="Services"/></a></li>
                                <li id="testimonialsNav"><a href="#about"><spring:message code="Testimonials" text="Testimonials"/></a></li>
                                <li id="contactNav"><a href="#contact"><spring:message code="Contact" text="Contact"/></a></li>
<!--                                <li class="dropdown">
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
                                </li>-->
                                <!--                                <li class="dropdown">
                                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="Language" text="Language"/><span class="caret"></span></a>
                                                                    <ul class="dropdown-menu" id="allLanguages">
                                                                        <li><a href="?locale=en"><spring:message code="English" text="English"/></a></li>
                                                                        <li><a href="?locale=fr"><spring:message code="French" text="Français"/></a></li>
                                                                        <li><a href="?locale=es"><spring:message code="Spanish" text="Español"/></a></li>
                                                                    </ul>
                                                                </li>-->

                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><spring:message code="Login" text="Login"/></b> <span class="caret"></span></a>
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
                                                <!--							<div class="bottom text-center">
                                                                                                                New here ? <a href="#"><b>Join Us</b></a>
                                                                                                        </div>-->
                                            </div>
                                        </li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>

            </div>
        </div>
    </body>
</html>
