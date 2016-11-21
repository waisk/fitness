/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var trainingPackage = 0;
var oldTrainingPackage = "0";
var isPaymentCancelled = "false";


jQuery(document).ready(function ($) {

    $("#registerBtn").prop('disabled', true);
    
    $("#registerBtn1").bind('click', function () {
        trainingPackage = 1;
        $('#registrationModal').modal();
    });

    $("#registerBtn2").bind('click', function () {
        trainingPackage = 2;
        $('#registrationModal').modal();
    });

    $("#registerBtn3").bind('click', function () {
        trainingPackage = 3;
        $('#registrationModal').modal();
    });

    $("#registerBtn").click(function(event) {
        event.preventDefault();
        registerUser();
    });
    
    
    $("#firstName, #lastName, #displayName, #r_email, #r_password, #passwordConfirmation").on('change', function () {
        if (paymentFormReady() == true) {
            $("#registerBtn").prop('disabled', false);
        }else{
            $("#registerBtn").prop('disabled', true);
        }
    });
    
    //make sure that password and confirmPassword are the same
    $("input[type=password]").keyup(function () {

        if ($("#r_password").val() == $("#passwordConfirmation").val()) {
            $("#pwmatch").removeClass("glyphicon-remove");
//            $("#pwmatch").addClass("glyphicon-ok");
//            $("#pwmatch").css("color", "#00A41E");
            $("#passwordNoMatch").hide();
            $("#pwmatch").hide();
        } else {
            $("#passwordNoMatch").show();
            $("#pwmatch").show();
            $("#pwmatch").removeClass("glyphicon-ok");
            $("#pwmatch").addClass("glyphicon-remove");
            $("#pwmatch").css("color", "#FF0004");
            $("#registerBtn").prop("disabled", true);
        }
    });
    
    if(oldTrainingPackage != "" && isPaymentCancelled == "true"){
        //something went wrong here.
        //user is logged in
        //show the paymment modal again with the buy now button.
        $('#paypal'+oldTrainingPackage).show();
        $('#paypalModal').modal();
        
    }
    
});


function paymentFormReady() {

    if (validateEmail($("#r_email").val())) {
        $("#emailError").removeClass("glyphicon-remove");
        $("#emailNotValid").hide();
        $("#emailError").hide();
    } else {
        $("#emailNotValid").show();
        $("#emailError").show();
        $("#emailError").removeClass("glyphicon-ok");
        $("#emailError").addClass("glyphicon-remove");
        $("#emailError").css("color", "#FF0004");
    }

    if ($("#firstName").val() != "" && $("#lastName").val() != "" && $("#displayName").val() != "" && $("#r_email").val() != ""
            && $("#r_password").val() != "" && $("#passwordConfirmation").val() != "" && (validateEmail($("#r_email").val())==true)) {
        return true;
    } else {
        return false;
    }

}

function validateEmail(email) {
  var re = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i;
  return re.test(email);
}


function registerUser() {
    //get all informations and register user and verify that credit card passed
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var displayName = $("#displayName").val();
    var email = $("#r_email").val();
    var password = $("#r_password").val();
    var passwordConfirmation = $("#passwordConfirmation").val();
    //var cardHolderName = $("#cardHolderName").val();

//    var jsonRequest = JSON.stringify({"firstName": firstName, "lastName": lastName, "displayName": displayName, "email": email,
//        "password": password, "passwordConfirmation": passwordConfirmation, "cardHolderName": cardHolderName, "creditCardToken": creditCardToken,
//        "trainingPackage": trainingPackage});
//    
    var jsonRequest = JSON.stringify({"firstName": firstName, "lastName": lastName, "displayName": displayName, "email": email,
        "password": password, "passwordConfirmation": passwordConfirmation, "trainingPackage": trainingPackage});

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/fitness/registration",
        data: jsonRequest,
        success: function (data) {
            var response = data.message;
            if(response === "invalidEmailException"){
                $('#invalidEmailExceptionModal').modal();
            }else if(response === "invalidDisplayNameException"){
                $('#invalidDisplayNameExceptionModal').modal();
            }else if(response === "invalidCreditCard"){
                $('#invalidCreditCardModal').modal();
            }else if(response === "internalError"){
                $('#registrationErrorModal').modal();
            }else if(response === "success"){
            
                $('#registrationModal').modal('hide');
                $('#invalidEmailExceptionModal').modal('hide');
                $('#invalidCreditCardModal').modal('hide');
                $('#registrationErrorModal').modal('hide');
                $('#internalError').modal('hide');

                //open paypal modal but show only the proper button with the package id, hide the others buy now buttons
                $('#paypal'+trainingPackage).show();
                $('#paypalModal').modal();
            }
        },
        error: function (response) {
            $('#registrationErrorModal').modal();
        }
    });

}