$(document).ready(function () {
    $('#login').click(function (e) {
        e.preventDefault();
        let userName = $('#userName').val();
        let password = $('#password').val();
        $.ajax({
            url: '/Week_3_Day_5_war_exploded/login',
            data: {
                userName: userName,
                password: password
            },
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                if (!data.serviceStatus.success) {
                    $('#credentialError').show();
                    $('#credentialError').html(data.serviceStatus.errorMessage);
                } else {
                    $('#credentialError').hide();
                    window.location.href = data.redirectUrl;
                }
            }
        })
    });
})