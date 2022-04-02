$(document).ready(function() {

    var output = $('#op')
    var input = $("#ipword");

    $.ajax({
      type: "GET",
      url: "/words/all",
      success: function(data) {
        // console.log(data);
        $.each(data, function(i, item) {
            output.append('<li>' + item.word + '</li>');
        });
      }
    });

    $("#addWord").on('click', function() {
        var ip = {
            word: input.val()
        };
        $.ajax({
          type: "POST",
          url: "/words/add",
          data: JSON.stringify(ip),
          headers: {
            'Accept': "application/json",
            "Content-Type": "application/json",
          },
          dataType: "json",
          success: function (op) {
            console.log(op);
            output.append("<li>" + op.word + "</li>");
          },
        });
    });

});