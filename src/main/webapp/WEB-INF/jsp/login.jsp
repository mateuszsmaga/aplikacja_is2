<!DOCTYPE html>
<html lang="en">
  <head>
    <head> 
    <title>Logowanie</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
	</head>
  </head>

  <body>
  	
    <div class="container">
	  <div th:if="${param.error}">
        Nieprawidłowy użytkownik lub hasło.
      </div>
      <form th:action="@{/login}" method="post" class="form-signin">
      	<br/>
        <label for="username" class="sr-only">Użytkownik:</label>
        <input placeholder="nazwa użytkownika" type="text" name="username" id="username" class="form-control" prequired="true" autofocus="true"/>
        <label for="inputPassword" class="sr-only">Hasło:</label>
        <input placeholder="hasło" type="password" name="password" id="inputPassword" class="form-control" required="true"/>
        <button class="btn btn-outline-success btn-block" type="submit" value="Sign In">Zaloguj się</button>
      </form>
    </div> 
  </body>
</html>