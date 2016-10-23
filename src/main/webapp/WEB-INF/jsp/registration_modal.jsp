<%-- 
    Document   : registration_modal
    Created on : 22-Oct-2016, 6:33:19 PM
    Author     : wais
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="modal fade registration" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-keyboard="false">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body" style="overflow-x: auto">

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2">
                        <form role="form">
                            <h2><spring:message code="SignUp" text="Sign Up"/></h2>
                            <hr class="colorgraph">
                            <div class="row">
                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="first_name" id="firstName" class="form-control" placeholder="<spring:message code="FirstName" text="First Name"/>" tabindex="1">
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="last_name" id="lastName" class="form-control" placeholder="<spring:message code="LastName" text="Last Name"/>" tabindex="2">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" name="display_name" id="displayName" class="form-control" placeholder="<spring:message code="DisplayName" text="Display Name"/>" tabindex="3">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" id="email" class="form-control" placeholder="<spring:message code="EmailAddress" text="Email Address"/>" tabindex="4">
                            </div>
                            <div class="row">
                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="password" id="password" class="form-control" placeholder="<spring:message code="Password" text="Password"/>" tabindex="5">
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="password_confirmation" id="passwordConfirmation" class="form-control" placeholder="<spring:message code="ConfirmPassword" text="Confirm Password"/>" tabindex="6">
                                    </div>
                                </div>
                            </div>
                            
                                <div class="form-group">
                                        <input type="text" class="form-control" name="card-holder-name" id="cardHolderName" placeholder="<spring:message code="CardHolderName" text="Card Holder's Name"/>">
                                </div>
                                <div class="form-group">
                                        <input type="text" class="form-control" name="card-number" id="cardNumber" placeholder="<spring:message code="DebitCreditCardNumber" text="Debit/Credit Card Number"/>">
                                </div>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-xs-12 col-sm-12 col-md-10">
                                        <div class="row">
                                            <div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
                                                <select class="form-control" name="expiryMonth" id="expiryMonth">
                                                    <option><spring:message code="Month" text="Month"/></option>
                                                    <option value="01">Jan (01)</option>
                                                    <option value="02">Feb (02)</option>
                                                    <option value="03">Mar (03)</option>
                                                    <option value="04">Apr (04)</option>
                                                    <option value="05">May (05)</option>
                                                    <option value="06">June (06)</option>
                                                    <option value="07">July (07)</option>
                                                    <option value="08">Aug (08)</option>
                                                    <option value="09">Sep (09)</option>
                                                    <option value="10">Oct (10)</option>
                                                    <option value="11">Nov (11)</option>
                                                    <option value="12">Dec (12)</option>
                                                </select>
                                            </div>
                                            <div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
                                                <select class="form-control" name="expiryYear" id="expiryYear">
                                                    <option><spring:message code="Year" text="Year"/></option>
                                                    <option value="13">2013</option>
                                                    <option value="14">2014</option>
                                                    <option value="15">2015</option>
                                                    <option value="16">2016</option>
                                                    <option value="17">2017</option>
                                                    <option value="18">2018</option>
                                                    <option value="19">2019</option>
                                                    <option value="20">2020</option>
                                                    <option value="21">2021</option>
                                                    <option value="22">2022</option>
                                                    <option value="23">2023</option>
                                                </select>
                                            </div>
                                            
                                            <div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
                                                <input type="text" class="form-control" name="cvv" id="cvv" placeholder="<spring:message code="SecurityCode" text="Security Code"/>">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr class="colorgraph">
                            <div class="row">
                                <div class="col-xs-8 col-sm-9 col-md-9">
                                    <spring:message code="ByClicking" text="By clicking"/> <strong class="label label-primary"><spring:message code="Register" text="Register"/></strong>, <spring:message code="YouAgree" text="you agree to our"/> <a href="#" data-toggle="modal" data-target="#t_and_c_m"><spring:message code="TermsAndConditions" text="Terms and Conditions"/></a>.
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-12 col-sm-6 col-md-6 col-md-offset-3"><input type="submit" id="registerBtn" value="<spring:message code="Register" text="Register"/>" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                            </div>
                            <div class="modal-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </div>
        </div>
    </div>
</div>
