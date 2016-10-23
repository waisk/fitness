/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var trainingPackage = 0;
jQuery(document).ready(function($) {
    
    $("#registerBtn1").bind('click', function(){
        trainingPackage = 1;
        $('#registrationModal').modal();
    });
    
    $("#registerBtn2").bind('click', function(){
        trainingPackage = 2;
        $('#registrationModal').modal();
    });
    
    $("#registerBtn3").bind('click', function(){
        trainingPackage = 3;
        $('#registrationModal').modal();
    });
    
    $("#registerBtn").bind('click', function(){
        
        //get all informations and register user and verify that credit card passed
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var displayName = $("#displayName").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var passwordConfirmation = $("#passwordConfirmation").val();
        var cardHolderName = $("#cardHolderName").val();
        var cardNumber = $("#cardNumber").val();
        var expiryMonth = $("#expiryMonth").val();
        var expiryYear = $("#expiryYear").val();
        var cvv = $("#cvv").val();

        var jsonRequest = JSON.stringify({"firstName": firstName, "lastName":lastName,"displayName":displayName, "email":email,
        "password":password, "passwordConfirmation":passwordConfirmation, "cardHolderName":cardHolderName, "cardNumber":cardNumber,
        "expiryMonth":expiryMonth, "expiryYear":expiryYear, "cvv":cvv});

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/registration",
            data: jsonRequest,
            success: function (data) {
                $('#registrationModal').modal('hide');
                //log him and return him to training page
                
            },
            error: function (e) {
                console.log("ERROR: ", e);
                $('#resetPasswordErrorModal').modal();
            }
        });
        
        trainingPackage = 3;
        $('#registrationModal').modal('hide');
    });
    
    
});
