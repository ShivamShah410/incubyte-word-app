$(document).ready(function () {
  var output = $("#tbody");
  var input = $("#ipword");


  loadWords();

  $("#addWord").on("click", function () {
    if (input.val() !== "" && input.val() !== null) {
      var ip = {
        word: input.val(),
      };

      $.ajax({
        type: "POST",
        url: "/words/add",
        data: JSON.stringify(ip),
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        dataType: "json",
        success: function (op) {
          output.append(
            "<tr>" +
              "<td>" +
              op.word +
              "</td>" +
              "<td>" +
              "<button id=" +
              op.id +
              " class='edit'>Edit</button>" +
              "</td>" +
              "<td>" +
              "<button id=" +
              op.id +
              " class='delete'>Delete</button>" +
              "</td>" +
              "</tr>"
          );
          input.val('');
        },
        error: function() {
          alert("Error adding Word");
        }
      });
    } else {
      alert("please enter some value!!");
    }
  });


  output.delegate('.delete', 'click', function () {
    var delEle = $(this);
    var id = $(this).attr("id");

    $.ajax({
      type: "DELETE",
      url: "/words/delete/" + id,
      success: function (op) {
        delEle.parent().parent().remove();
      },
      error: function () {
        alert("Error deleting Word");
      },  
    });
  });

  output.delegate(".edit", "click", function () {
    var editEle = $(this);
    var prevWord = editEle.parent().siblings()[0].innerText;
    var id = $(this).attr("id");
    var res = prompt("Enter the new word:", prevWord);

    if(res) {

      var ipdata = {
        "id": id,
        "word": res
      }

      $.ajax({
        type: "PUT",
        url: "/words/update/",
        data: JSON.stringify(ipdata),
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        dataType: "json",
        success: function (op) {
          editEle.parent().siblings()[0].innerText = res;
          // loadWords();
        },
        error: function () {
          alert("Error editing Word");
        },
      });
    }
  });

});


function loadWords() {

  var output = $("#tbody");

  output.empty();
  $.ajax({
    type: "GET",
    url: "/words/all",
    success: function (data) {
      $.each(data, function (i, item) {
        // output.append("<li>" + item.word + "</li>");
        output.append(
          "<tr>" +
            "<td>" +
            item.word +
            "</td>" +
            "<td>" +
            "<button id=" +
            item.id +
            " class='edit'>Edit</button>" +
            "</td>" +
            "<td>" +
            "<button id=" +
            item.id +
            " class='delete'>Delete</button>" +
            "</td>" +
            "</tr>"
        );
      });
    },
  });
}