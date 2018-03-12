$(function(){

    $("#messageTableData").empty();

    $("#newUserForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        var name = $("#userName").val();
        $.ajax({
            type: "POST",
            url: "/addUser/" + name,
            contentType: "application/json",
            dataType: "json",
            data: name,
            success: function (response) {
                alert(name + " successfully added!");
            },
            error: function (response) {
                alert(name + " failed to be added!");
            }
        });

    });

    $('#messageModal').on("show.bs.modal", function (e) {
        //$("#auctionLabel").html('Edit auction with id '+ $(e.relatedTarget).data('id'));
        $(".modal-body").html($(e.relatedTarget).attr("message"));
        $(".modal-title").html($(e.relatedTarget).attr("subject"));
    });
})

function getMessageList() {

    event.preventDefault();

    var id;

    $.each($("#inboxSelectList option:selected"), function () {

        id = $(this).val();
    });
    $.ajax({
        type: "GET",
        url: "/messages/" + id,
        contentType: "application/json",
        dataType: "json",
        success: function (result) {

            $("#messageTableData").empty();
            $.each(result, function (index, item) {

                var created = formatDate(item.createDate);;
                var message = item.message;
                var subject = item.subject;
                var sender = item.sender.userName;

                $.each(item.receiverList, function (i, obj){

                    var receiver = obj.userName;
                    var aTag = "<a href='#'  subject='" +  subject + "' message='" +  message + "'  id='myForm' data-toggle='modal' data-target='#messageModal'>" +
                        "<img src='image/message-circle-blue-35px.png' alt='mail icon' border='0'></a>";

                    $("#messageTableData").append("<tr id='myTbleRow'>" +
                        "<td>" + created + "</td><td>" + sender + "</td><td>" + receiver + "</td><td>" + subject + "</td><td>" + aTag + "</td></tr>");
                })
            });
        },
        error: function (error) {
            console.log(error)
        }
    });
}

function formatDate(dateAsInteger) {

    var date = new Date(dateAsInteger);
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    return date.getMonth()+1 + "/" + date.getDate() + "/" + date.getFullYear() + " " + strTime;
}

function sendMessage() {
    // Prevent the form from submitting via the browser.
    event.preventDefault();

    var sender;
    var senderId;

    var receiver;
    var receiverId;

    $.each($("#sentFromSelectList option:selected"), function () {
        sender = $(this).text();
        senderId = $(this).val();
    });
    $.each($("#sentToSelectList option:selected"), function () {
        receiver = $(this).text();
        receiverId = $(this).val();
    });

    var subject = $("#messageSubject").val();

    var message = $("#messageBody").val();

    var messageJson = {
        "message" : message,
        "subject" : subject,
        "sender" : {
            "userId" : senderId,
            "userName" : sender
        },
        "receiverList" : [{
            "userId" : receiverId,
            "userName" : receiver
        }]
    }
    $.ajax({
        type: "POST",
        url: "/sendMessage",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(messageJson),
        success: function (result) {

            console.log(result);

        },
        error: function (e) {
            console.log(e, "error");

        }
    });
}

function findAll() {

    $.ajax({
        type: "GET",
        url: "/users",
        contentType: "application/json",
        dataType: "json",
        success: function (result) {

            renderJsonList(result);
        },
        error: function (e) {
            $.each(result, function (index, item) {

                console.log(item);

            });
        }


    });

    // $.getJSON("/users", null, function(data) {
    //     $("#userSelectList option").remove(); // Remove all <option> child tags.
    //     $.each(data.users, function(index, item) { // Iterates through a collection
    //         $("#userSelectList").append( // Append an object to the inside of the select box
    //             $("<option></option>") // Yes you can do this.
    //                 .text(item.userName)
    //                 .val(item.userId)
    //         );
    //     });
    // });
}

function renderJsonList(result) {

    console.log(result.data);

    var count = 0;

    $.each(result, function (index, value) {


        $(".userSelectList").append(
            $("<option></option>").val(value.userId)
                .text(value.userName)
        );


    });
}