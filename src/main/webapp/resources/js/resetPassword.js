/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function($) {
   
   $("#newPassword, #newPasswordConfirm").change(function(event) {
        event.preventDefault();
        if ($("#newPassword").val() == $("#newPasswordConfirm").val()) {
            $("#newpwmatch").removeClass("glyphicon-remove");
            $("#newpasswordNoMatch").hide();
            $("#newpwmatch").hide();
            $("#resetNewPasswordBtn").prop("disabled", false);
        } else {
            $("#newpasswordNoMatch").show();
            $("#newpwmatch").show();
            $("#newpwmatch").removeClass("glyphicon-ok");
            $("#newpwmatch").addClass("glyphicon-remove");
            $("#newpwmatch").css("color", "#FF0004");
            $("#registerBtn").prop("disabled", true);
            $("#resetNewPasswordBtn").prop("disabled", true);
        }
    });
   
    $("#resetNewPasswordBtn").click(function(event){
        event.preventDefault();
        var newPassword = $("#newPassword").val();
        var confirmPassword = $("#newPasswordConfirm").val();

        var jsonRequest = JSON.stringify({"token": token, "newPassword":newPassword,"confirmPassword":confirmPassword});

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/resetPassword/new",
            data: jsonRequest,
            success: function (data) {
                if(data.message == "tokenExpired"){
                    $('#wrongTokenOrTokenExpired').modal();
                }else if(data.message == "success"){
                    $('#resetPasswordSuccess').modal();
                }else{
                    $('#internalErrorModal').modal();
                }
            },
            error: function(xhr, status, errorThrown) {
                console.log("ERROR: ", errorThrown);
                $('#internalErrorModal').modal();
            }
        });
    });
    
    $('#resetPasswordSuccess').on('hidden.bs.modal', function() {
        window.location.href = '/fitness';
    });

    $("#resetPasswordConfirmationBtn").click(function(event) {
        event.preventDefault();
        window.location.href = '/fitness';
    });
    
});
