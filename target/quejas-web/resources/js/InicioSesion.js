$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.username = document.getElementById('username').value;
  datos.password = document.getElementById('txtPassword').value;

  const request = await fetch('api/appLogin', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (respuesta != 'FAIL') {
    localStorage.token = respuesta;
    localStorage.username = datos.username;
    window.location.href = 'https://diaco.sp.skdrive.net/quejas-web/secure/dashboard.xhtml';
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}