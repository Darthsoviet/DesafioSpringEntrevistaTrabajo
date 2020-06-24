let form4 = "#ls-transaction-form";
$('#lsForm').click((e) => {
   e.preventDefault();
   $(form4).toggleClass('visible');




})

$(form4).submit(function (e) {
   e.preventDefault();
   let userId = $(form4 + ' #user_id').val();

   fetch(`http://localhost:8080/api/v1/transactions/week/${userId}`, {
      method: "GET"
   }).then(res => {
      if (res.status <= 200) {

         res.json().then((list) => {


            $('.container ul *').remove('*');
            $('.container ul').css({
               "grid-template-columns": "1fr"
            });
            $('.container ul').css({
               "grid-template-rows": "auto"
            });





            let elementList = list.map((data) => {

               return (
                  "<div class='card week-card' style='width: auto;'>" +
                  `<div class='card-head'>` +
                  `<h4>ID: ${data.userId}</h4>` +
                  `<p> ${data.weekStart}</p>` +
                  `<p>  ${data.weekEnd}</p>` +
                  `</div>` +
                  `<ul class='list-group list-group-flush'>` +
                  `<li class='list-group-item'>Quantity: ${data.quantity}</li>` +
                  `<li class='list-group-item'>Amount: $${data.amount}</li>` +
                  `<li class='list-group-item'>Total Amount: $${data.totalAmount}</li>` +
                  "</ul>" +
                  "</div>"
               );

            });
            $(".container ul").append(elementList);

         });

      } else {
         res.text().then(str => {
            $('.container ul *').remove('*');
            $('.container ul').css({
               "grid-template-columns": "1fr"
            });
            $('.container ul').append(`<div class="card-err"><h1 >${str}</h1></div>`);
         });


      }

   });





});