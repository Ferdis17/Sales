/**
 * Created by Bi on 11/15/17.
 */

function serializeObject(form) {
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;
};

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear(),
        hour = d.getHours(),
        min = d.getMinutes(),
        second = d.getSeconds();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [month, day, year].join('-') + ' ' + [hour, min, second].join(':');
}

function generateCommentItem(title, postingTime, content) {
    const time = formatDate(postingTime);

    $(".comment-list").prepend($("<div>").addClass("comment-item")
        .append($("<div>").addClass("comment-title").text(title))
        .append($("<div>").addClass("comment-time").text(time))
        .append($("<div>").addClass("comment-content").text(content)));
}

$(document).ready(function () {
    const contextRoot = "/" + window.location.pathname.split('/')[1];

    $(".comment-btn").on("click", function () {
        const self = $(this);
        var data = $("#comment-form").serialize();

        const dataToSend = JSON.stringify(serializeObject($('#comment-form')));
        const dealId = $(".deal-id").data("dealid");

        $.ajax({
            type : 'POST',
            url : contextRoot + '/rest/comment/' + dealId,
            dataType : "json",
            data : dataToSend,
            contentType : 'application/json',
            success : function(response) {
                $('.error').text("");
                self.closest('form').find("input[type=text], textarea").val("");
                generateCommentItem(response.title, response.postingTime, response.content);
            },
            error : function(errorObject) {
                if (errorObject.responseJSON.errorType === "CommentValidationError") {
                    const errors = errorObject.responseJSON.errors;
                    $('.error').text("");
                    $.each(errors, function (i, error) {
                        const errMsg = error.message;

                        if (errMsg.indexOf("Title") !== -1) {
                            $(".title-error-message").text(errMsg);
                        }

                        if (errMsg.indexOf("Content") !== -1) {
                            $(".content-error-message").text(errMsg);
                        }
                    })
                } else {
                    alert(errorObject.responseJSON.errors(0));
                }
            }
        });
    })
})