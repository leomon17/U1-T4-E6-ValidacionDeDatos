angular.module("routingApp").controller("SolicitudCtrl", [
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
            // let content = document.querySelectorAll('trix-editor');
            // let reasonContent = $('#reasonContent');
            if (!form.checkValidity()) {
              event.preventDefault();
              event.stopPropagation();
              // reasonContent.empty();
            }
            else {
              this.create(); 
            }
            form.classList.add('was-validated');
          }, false);
        });
      })();


      $(document).ready(function () {

        $('#state').select2({
          placeholder: 'SELECCIONAR ESTADO...',
        });
        $('#municipality').select2({
          placeholder: 'SELECCIONAR MUNICIPIO...',
        });
        $('#academicLevel').select2({
          placeholder: 'SELECCIONAR NIVEL ÁCADEMICO...',
        });

        let input = document.getElementById('dateBirth');
        let min = (input) =>{
        let actualDate = new Date();
          let fecha = (actualDate.getFullYear()-18) + "-" + ((actualDate.getMonth()+1) < 10 ? "0" + (actualDate.getMonth()+1): actualDate.getMonth()+1) + "-" +((actualDate.getDate()) < 10 ? "0" + (actualDate.getDate()): actualDate.getDate());
          input.max = fecha;
        };
        min(input);
      })

      $scope.solicitud = {
          id : null,
          name : "",
          lastname : "", 
          surname : "",
          dateBirth : null,
          email: "",
          phone: "",
          sexo: null,
          state: { id: null },
          municipality : { id: null },
          address : "",
          institution: "",
          academicLevel: { id: null },
          average: null,
          reason: "",
      }

      this.getRequests = () => {
        return $http({
          method: 'GET',
          url: APP_URL.url + "/solicitud",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + $scope.token,
          },
        }).then((res) => {
          setTimeout(executeDataTable, 1);
          $scope.listRequests = res.data;
        }).catch((e) => {
          console.log(e);
        })
      }
      
      this.create = () => {

        return $http({
          method: "POST",
          url: APP_URL.url + "/solicitud/save",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + $scope.token,
          },
          data: $scope.solicitud

        }).then(res => {
          // console.log(res);
          if (res.data) {
            // console.log(res.data);
            if (res.data.message != 'Notificación registrada correctamente') {
              let name = document.getElementById('name');
              let lastname = document.getElementById('lastname');
              let address = document.getElementById('address');
              let institution = document.getElementById('institution');
              let reason = document.getElementById('reason');

              if (res.data.name === " " || res.data.name === null) {   
                name.classList.add('error-input');
              }else {
                name.classList.remove('error-input');
                name.classList.add('error-success');
              }
              if (res.data.lastname === " " || res.data.lastname === null) {               
                lastname.classList.add('error-input');
              }else{
                lastname.classList.remove('error-input');
                lastname.classList.add('error-success');
              } 
              if (res.data.address === " " || res.data.address === null) {
                address.classList.add('error-input');
              }else{
                address.classList.remove('error-input');
                address.classList.add('error-success');
              } 
              if (res.data.institution === " " || res.data.institution === null) {
                institution.classList.add('error-input');
              }else {
                institution.classList.remove('error-input');
                institution.classList.add('error-success');
              }
              if (res.data.reason === " " || res.data.reason === null) {
                reason.classList.add('error-input');
              }else{
                reason.classList.remove('error-input');
                reason.classList.add('error-success');
              }
              notyf.error(res.data.message);
            } else {
              // this.getRequests();
              location.replace("#!/solicitud/");
              notyf.success(res.data.message);
            }
          } else {
            notyf.error('Ocurrió un error al crear la Notificación');
          }
    
        }, e => console.log("Error", e.message));
      };

      this.getStates = () => {
        return $http({
          method: 'GET',
          url: APP_URL.url + "/state",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + $scope.token,
          },
        }).then((res) => {
          $scope.listStates = res.data;
          // document.getElementById('state').remove(0);
        }).catch((e) => {
          console.log(e);
        })
      }

      this.getMunicipalities = () => {
        return $http({
          method: 'GET',
          url: APP_URL.url + "/municipality",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + $scope.token,
          },
        }).then((res) => {
          $scope.listMunicipalities = res.data;
          // document.getElementById('municipality').remove(0);
        }).catch((e) => {
          console.log(e);
        })
      }

      this.getAcademicLevels = () => {
        return $http({
          method: 'GET',
          url: APP_URL.url + "/academic-level",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + $scope.token,
          },
        }).then((res) => {
          $scope.listAcademicLevels = res.data;
        }).catch((e) => {
          console.log(e);
        })
      }

      this.deleteIndexOne = () => {
        document.getElementById('state').remove(0);
        document.getElementById('municipality').remove(0);
        document.getElementById('academicLevel').remove(0);
      }

      const cleanIndexOne = () => {
        return new Promise((resolve, reject) => {
          setTimeout(() =>{
            resolve(this.getStates(), 
            this.getMunicipalities(), 
            this.getAcademicLevels());
          },100)
        });
      }

      cleanIndexOne()
        .then(() => this.deleteIndexOne());
      
     
      // -----------------------DATA TABLES------------------------------

    function executeDataTable() {
      $('#solicitudTable').DataTable({
      language: {
          url: '//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json',
      },
      });
    }
},]);