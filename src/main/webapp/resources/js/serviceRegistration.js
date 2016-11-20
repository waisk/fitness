/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var trainingPackage = 0;
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

    $("#registerBtn").bind('click', function () {
        registerUser();
    });
    
    
    $("#firstName, #lastName, #displayName, #r_email, #r_password, #passwordConfirmation").on('change', function () {
        if (paymentFormReady() == true) {
            $("#registerBtn").prop('disabled', false);
        }else{
            $("#registerBtn").prop('disabled', true);
        }
    });

});

function paymentFormReady() {

    if ($("#firstName").val() != "" && $("#lastName").val() != "" && $("#displayName").val() != "" && $("#r_email").val() != ""
            && $("#r_password").val() != "" && $("#passwordConfirmation").val() != "") {
        return true;
    } else {
        return false;
    }

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
            $('#registrationModal').modal('hide');
            $('#invalidEmailExceptionModal').modal('hide');
            $('#invalidCreditCardModal').modal('hide');
            $('#registrationErrorModal').modal('hide');
            
            //open paypal modal but show only the proper button with the package id, hide the others buy now buttons
            $('#paypal'+trainingPackage).show();
            $('#paypalModal').modal();
        },
        error: function (response) {
            
            if(response.responseText === "invalidEmailException"){
                $('#invalidEmailExceptionModal').modal();
            }else if(response.responseText === "invalidDisplayNameException"){
                $('#invalidDisplayNameExceptionModal').modal();
            }else if(response.responseText === "invalidCreditCard"){
                $('#invalidCreditCardModal').modal();
            }else{
                $('#registrationErrorModal').modal();
            }
        }
    });

}

jQuery(document).ready(function ($) {
    

//    $("#registerBtn").prop('disabled', true);
    
    
//    
//    var readyInterval = setInterval(function () {
//        if (paymentFormReady) {
//            $("#registerBtn").prop('disabled', false);
//            clearInterval(readyInterval);
//        }
//    }, 250);
    
    
    
    

//    /* If you're using Stripe for payments */
//    function payWithStripe(e) {
//        e.preventDefault();
//
//        /* Abort if invalid form data */
//        if (!validator.form()) {
//            return;
//        }
//
//        /* Visual feedback */
//        $form.find('.subscribe').html('Validating <i class="fa fa-spinner fa-pulse"></i>').prop('disabled', true);
//
//        var PublishableKey = 'pk_test_6pRNASCoBOKtIshFeQd4XMUh'; // Replace with your API publishable key
//        Stripe.setPublishableKey(PublishableKey);
//
//        /* Create token */
//        var expiry = $form.find('[name=cardExpiry]').payment('cardExpiryVal');
//        var ccData = {
//            number: $form.find('[name=cardNumber]').val().replace(/\s/g, ''),
//            cvc: $form.find('[name=cardCVC]').val(),
//            exp_month: expiry.month,
//            exp_year: expiry.year
//        };
//
//        Stripe.card.createToken(ccData, function stripeResponseHandler(status, response) {
//            if (response.error) {
//                /* Visual feedback */
//                $form.find('.subscribe').html('Try again').prop('disabled', false);
//                /* Show Stripe errors on the form */
//                $form.find('.payment-errors').text(response.error.message);
//                $form.find('.payment-errors').closest('.row').show();
//            } else {
//                /* Visual feedback */
//                $form.find('.subscribe').html('Processing <i class="fa fa-spinner fa-pulse"></i>');
//                /* Hide Stripe errors on the form */
//                $form.find('.payment-errors').closest('.row').hide();
//                $form.find('.payment-errors').text("");
//                // response contains id and card, which contains additional card details            
//                console.log(response.id);
//                console.log(response.card);
//                var token = response.id;
//                // AJAX - you would send 'token' to your server here.
//                registerUser(token);
////                $.post('/account/stripe_card_token', {
////                    token: token
////                })
////                        // Assign handlers immediately after making the request,
////                        .done(function (data, textStatus, jqXHR) {
////                            $form.find('.subscribe').html('Payment successful <i class="fa fa-check"></i>');
////                        })
////                        .fail(function (jqXHR, textStatus, errorThrown) {
////                            $form.find('.subscribe').html('There was a problem').removeClass('success').addClass('error');
////                            /* Show Stripe errors on the form */
////                            $form.find('.payment-errors').text('Try refreshing the page and trying again.');
////                            $form.find('.payment-errors').closest('.row').show();
////                        });
//            }
//        });
//    }
//    /* Fancy restrictive input formatting via jQuery.payment library*/
//    $('input[name=cardNumber]').payment('formatCardNumber');
//    $('input[name=cardCVC]').payment('formatCardCVC');
//    $('input[name=cardExpiry').payment('formatCardExpiry');
//
//    /* Form validation using Stripe client-side validation helpers */
//    jQuery.validator.addMethod("cardNumber", function (value, element) {
//        return this.optional(element) || Stripe.card.validateCardNumber(value);
//    }, "Please specify a valid credit card number.");
//
//    jQuery.validator.addMethod("cardExpiry", function (value, element) {
//        /* Parsing month/year uses jQuery.payment library */
//        value = $.payment.cardExpiryVal(value);
//        return this.optional(element) || Stripe.card.validateExpiry(value.month, value.year);
//    }, "Invalid expiration date.");
//
//    jQuery.validator.addMethod("cardCVC", function (value, element) {
//        return this.optional(element) || Stripe.card.validateCVC(value);
//    }, "Invalid CVC.");
//
//    validator = $form.validate({
//        rules: {
//            cardNumber: {
//                required: true,
//                cardNumber: true
//            },
//            cardExpiry: {
//                required: true,
//                cardExpiry: true
//            },
//            cardCVC: {
//                required: true,
//                cardCVC: true
//            }
//        },
//        highlight: function (element) {
//            $(element).closest('.form-control').removeClass('success').addClass('error');
//        },
//        unhighlight: function (element) {
//            $(element).closest('.form-control').removeClass('error').addClass('success');
//        },
//        errorPlacement: function (error, element) {
//            $(element).closest('.form-group').append(error);
//        }
//    });
//
//    paymentFormReady = function () {
//        if ($form.find('[name=cardNumber]').hasClass("success") &&
//                $form.find('[name=cardExpiry]').hasClass("success") &&
//                $form.find('[name=cardCVC]').val().length > 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    $form.find('#registerBtn').prop('disabled', true);
//    var readyInterval = setInterval(function () {
//        if (paymentFormReady()) {
//            $form.find('#registerBtn').prop('disabled', false);
//            clearInterval(readyInterval);
//        }
//    }, 250);

});
