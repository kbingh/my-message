$(function() {
    $("#userForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        var name = $("#userName").val();
        $.ajax({
            type: "POST",
            url: "/addUser?userName=" + name,
            dataType: "plain/text",
            success: function (result) {

                $(".list-group").append("<li>" + result.userName + "</li>");
            },

            data: name
        });

    });


    $.ajax({
        url: '/users',
        dataType: 'application/json',
        complete: function(data){
            console.log(data)
        },
        success: function(data){
            console.log(data)
        }



});

function sendMessage(){
    // Prevent the form from submitting via the browser.
    event.preventDefault();

    var sender = $("#messageSenderName").val();
    var receiver = $('#messageReceiverName option:selected').text();
    var message =  $("#messageBody").val();

    var messageJson = {

        "message": message,
        "fromUserName": sender,
        "toUserName": receiver
    }
    $.ajax({
        type: "POST",
        url: "/sendMessage",
        contentType: "application/json",
        data: messageJson,
        success: function (result) {


        }


    });

}


function findAll() {

    $.ajax({
        type: "GET",
        url: "/users",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            renderJsonList(result)
        }
    });
}

function renderJsonList(result){

    $( "#allUserNamesList").empty();

    $.each(result, function (id, user) {

        $(".list-group").append("<li>" + user.userName + "</li>");

    });

}