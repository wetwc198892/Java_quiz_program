$(document).ready(function () {
    $('#submit').click(function (e) {
        e.preventDefault();
        const reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        let userName = $('#userName').val();
        let password = $('#password').val();
        let birthDate = $('#birthDate').val();
        let address = $('#address').val();
        let email = $('#email').val();
        let isAdmin = $('#isAdmin').val();
        if (!reg.test(email)) {
            alert("Invalid Email Format");
            return false;
        }
        $.ajax({
            url: '/Week_3_Day_5_war_exploded/user',
            data: {
                userName: userName,
                password: password,
                birthDate: birthDate,
                email: email,
                address: address,
                isAdmin: isAdmin
            },
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                console.log(data);
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