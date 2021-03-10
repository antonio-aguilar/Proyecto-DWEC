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
  
    registrar();

});

function registrar() {
  
      var viaje = {
          descripcion_corta:$("#inputDescripcionCorta").val(),
          descripcion_larga: $("#inputDescripcionLarga").val(),
          fecha_inicio:$("#fechaInicio").val(),
          fecha_fin:$("#fechaFin").val(),          
          participantes:$("#inputParticipantes").val(),
          transporte:$("#inputTransporte").val()
      }

      var dataJson = JSON.stringify(viaje);
      alert(dataJson);
      $.ajax({
          url: "https://travellog2.herokuapp.com/api/viajes",
          type: "post",
          dataType: "json",
          contentType: "application/json",
          data: dataJson
      });
  }
