$(document).ready(function() {
   // on ready
   if(localStorage.getItem("username") === null || localStorage.getItem("token") === null){
       window.location.href = 'https://diaco.sp.skdrive.net/quejas-web/login.xhtml';
   }else{
   }
});


