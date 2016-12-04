/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
jQuery(document).ready(function ($) {
   
    $("#submitContactFormBtn").click(function(event){
        event.preventDefault();
        //POST call to controller
        var firstName = $("#c_fname").val();
        var lastName = $("#c_lname").val();
        var email = $("#c_email").val();
        var message = $("#c_message").val();

        var jsonRequest = JSON.stringify({"firstName": firstName, "lastName": lastName, "email": email, "message": message});

        $('#internalErrorModal').modal('hide');
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/contact",
            data: jsonRequest,
            success: function (data) {
                var response = data.message;
                if (response === "internalError") {
                    $('#internalErrorModal').modal();
                } else if (response === "success") {
                    $('#messageSentSuccessfulModal').modal();
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
                $('#registrationErrorModal').modal();
            }
        });
    });
});

