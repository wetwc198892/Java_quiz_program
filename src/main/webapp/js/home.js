$(document).ready(function () {
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/home',
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            if(location.href.indexOf("#reloaded")==-1){
                location.href=location.href+"#reloaded";
                location.reload();
            }
        }
    });
})

function js_method(params){
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/quiz',
        data:{
            quizId:params
        },
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            window.location.href = data.redirectUrl;
        }
    });
}