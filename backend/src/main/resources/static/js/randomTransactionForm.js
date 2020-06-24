

$("#randomForm").click(function (e) {
   e.preventDefault();
  
   fetch(`http://localhost:8080/api/v1/transactions/random`, {
      method: "GET"
   }).then(res => {
      if (res.status === 200) {
         res.json().then((data) => {
            $('.container ul *').remove('*');
            $('.container ul').css({"grid-template-columns":"1fr"});

            $('.container ul').append(

               "<div class='card' style='width: auto;'>" +
               "<ul class='list-group list-group-flush'>" +
               `<li class='list-group-item'>Transaction id: ${data.transactionId}</li>` +
               `<li class='list-group-item'>Amount:  $${data.amount}</li>` +
               `<li class='list-group-item'>Description: ${data.description}</li>` +
               `<li class='list-group-item'>Date: ${data.date}</li>` +
               `<li class='list-group-item'>User id: ${data.userId}</li>` +
               "</ul>" +
               "</div>"
            )

         })
      }else{
         res.text().then(str=>{
            $('.container ul *').remove('*');
            $('.container ul').css({
               "grid-template-columns": "1fr"
            });
            $('.container ul').append(`<div class="card-err"><h1 >${str}</h1></div>`);
         });
      }
   })





});