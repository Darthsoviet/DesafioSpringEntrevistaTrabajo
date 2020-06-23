let form = '#show-transaction-form'
$('#showForm').click((e) => {
   e.preventDefault();

   $(form).toggleClass('hidden');

})
$(form).submit(function (e) {
   e.preventDefault();
   let transaction = {
      userId: $(form + ' #user_id').val(),
      transaction_id: $(form + ' #transaction_id').val()
   }
   fetch(`http://localhost:8080/api/v1/transactions/transaction/${transaction.transaction_id}/${transaction.userId}`, {
      method: "GET"
   }).then(res => {
      if (res.status === 200) {
         res.json().then((data) => {
            $('.container ul *').remove('*');
            $('.container ul').append(

               "<div class='card' style='width: 18rem;'>" +
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
         res.text().then((str)=>{
            $('.container ul *').remove('*');

            $('.container ul').append(`<div class="card-err"><h1 >${str}</h1></div>`)
         })
      }
   })





});