angular.module("routingApp").controller("LoginCtrl", [
    "$rootScope",
    "$scope",
    "$http",
    "APP_URL",
    "$routeParams",
    "$window",
    function ($rootScope, $scope, $http, APP_URL, $routeParams, $window) {
      const notyf = new Notyf({
        duration: 2500,
        position: {
          x: "right",
          y: "top",
        },
      });
      
      (() => {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.prototype.slice.call(forms).forEach((form) => {
          form.addEventListener('submit', (event) => {
            if (!form.checkValidity()) {
              event.preventDefault();
              event.stopPropagation();
              notyf.error('Hay campos vacios o incorrectos');
            }
            else {
              this.login(); 
            }
            form.classList.add('was-validated');
          }, false);
        });
      })();

      $scope.user = {
        userName: null,
        password: null,
      };

      this.login = ()=>{
        return $http({
          method: "POST",
          url: APP_URL.url+"/user/verify",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
          },
          data: $scope.user,
        })
          .then((res) => {
            // console.log(res)
            if (res.data) {
              notyf.success('Usuario validado');
              $window.location.href = "#!/solicitud";
            } else {
              notyf.error("Usuario y/o Contraseña Incorrecto");
            }
          })
          .catch((err) => {
            console.log(err)
          });
      }  
    },
  ]);