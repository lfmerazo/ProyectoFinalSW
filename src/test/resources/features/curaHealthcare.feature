Feature: Funcionalidades en CuraHealtCare
  Rule: Yo como usuario quiero iniciar sesión en CURA Healthcare Service
    con el fin de poder agendar una cita medica.

    Background: Ingresar a la web
      Given que el usuario ingresa a la web CURA Healthcare Service

    @login-exitoso
    Scenario Outline: Validar que inicie sesión de manera correcta
      When ingreso el usuario <username> y contrasenia <password> correctos
      Then inicia sesion de manera exitosa
      Examples: [HAPPY PATH]
        |username |password          |
        |John Doe |ThisIsNotAPassword|

    @solicitud-exitosa
    Scenario Outline: Validar que se agende mi cita
      When ingreso el usuario <username> y contrasenia <password> correctos
      And diligencio la solicitud de cita
      Then se agenda la cita de manera exitosa
      Examples: [HAPPY PATH]
        |username |password          |
        |John Doe |ThisIsNotAPassword|

    @login-no-exitoso
    Scenario Outline: Validar que no inicie sesión
      When ingreso el usuario <username> y contrasenia <password> incorrectos
      Then el sistema no inicia sesion
      Examples: [UNHAPPY PATH]
        |username |password         |
        |John Doe |ThisIsNotAPassword1|
