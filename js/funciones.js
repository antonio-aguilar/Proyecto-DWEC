//Intervalo del carrousel
$('.carousel slide').carousel({
    interval: 5000
  });


//Validación del formulario de registros de datos del viaje
//Validará que los campos estén rellenos

(function() {
  'use strict';
  window.addEventListener('load', function() {
    var forms = document.getElementsByClassName('needs-validation');
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();

//Envío de datos del formulario, método post, registro de los datos del viaje
$('#formulario').on('submit', function(e) {
  e.preventDefault();
  var form = $(this);

  var datosFormulario = new FormData(document.getElementById("formulario")[0]);
  $.ajax ({
    url: "https://travellog2.herokuapp.com/api/viajes",
    type: "post",
    data: datosFormulario,
    cache: false,
    contentType: false,
    processData: false,
  })
  .done(function(respuesta){
    console.log("Datos registrados");
  });

});



