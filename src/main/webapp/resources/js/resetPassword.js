/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function($) {
   
    $("#resetNewPasswordBtn").click(function(event){
        event.preventDefault();
        var newPassword = $("#newPassword").val();
        var confirmPassword = $("#confirmPassword").val();

        var jsonRequest = JSON.stringify({"token": token, "newPassword":newPassword,"confirmPassword":confirmPassword});

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/resetPassword",
            data: jsonRequest,
            success: function (data) {
                $('#resetPasswordSent').modal();
            },
            error: function (e) {
                console.log("ERROR: ", e);
                $('#resetPasswordErrorModal').modal();
            }
        });
    });
});
