
let form2 = '#list-transaction-form'
$('#listForm').click((e) => {
   e.preventDefault();
   $(form2).toggleClass('visible');

})

$(form2).submit(function (e) {
   e.preventDefault();
   let userId = $(form2 + ' #user_id').val();

   fetch(`http://localhost:8080/api/v1/transactions/${userId}`, {
      method: "GET"
   }).then(res => {
      if (res.status <=200) {

         res.json().then((list) => {
            $('.container ul *').remove('*');
            if(window.innerWidth<700){
               $('.container ul').css({"grid-template-columns":"repeat(1,1fr)"});

            }else{
               $('.container ul').css({"grid-template-columns":"repeat(4,1fr)"});
            }
            

            let elementList = list.map((data) => {

               return (
                  "<div class='card' style='width: auto;'>" +
                  "<ul class='list-group list-group-flush'>" +
                  `<li class='list-group-item'>Transaction id: ${data.transactionId}</li>` +
                  `<li class='list-group-item'>Amount:  $${data.amount}</li>` +
                  `<li class='list-group-item'>Description: ${data.description}</li>` +
                  `<li class='list-group-item'>Date: ${data.date}</li>` +
                  `<li class='list-group-item'>User id: ${data.userId}</li>` +
                  "</ul>" +
                  "</div>"
               );

            });
            $(".container ul").append(elementList);

         });

      } else {
         res.text().then(str=>{
            $('.container ul *').remove('*');
            $('.container ul').css({
               "grid-template-columns": "1fr"
            });
            $('.container ul').append(`<div class="card-err"><h1 >${str}</h1></div>`);
         });
        


      }

   });





});