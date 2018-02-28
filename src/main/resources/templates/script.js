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