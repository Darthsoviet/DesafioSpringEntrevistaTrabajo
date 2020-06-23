$("#addForm").click(function (e) { 
   e.preventDefault();
   
   $(".form-container").css({display:"flex"});
  
  
});

$("#postForm").submit(function (e) { 

   e.preventDefault();

   let transaction={
      amount:$("#postForm #amount").val(),
      description:$("#postForm #description").val(),
      date:$("#postForm #date").val(),
      userId:$("#postForm #user_id").val()
   }

   fetch(`http://localhost:8080/api/v1/transactions/user/${transaction.userId}`,
   {body:JSON.stringify(transaction),method:"POST",headers:{"Content-Type":"application/json"}}).
   then(response=>{
      if(response.status>=200 && response.status<300){
         $("#postM").css({color:"green"});
      }else{
         $("#postM").css({color:"crimson"});
      }
      $("#postM").append(response.status);     
   })
     
 
   
   
});
function quitModalForm(){
      $(".form-container").css({display:"none"});
}