<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddSujetSurvlet" method="post">
    <div>
        <label for="nom">Nom :</label>
        <input type="text" id="titre" />
    </div>
    <div>
        <label for="courriel">idsujet :</label>
        <input type="text" id="idSujet" />
    </div>
    <div>
        <label for="message">description :</label>
        <textarea id="description"></textarea>
    </div>
    <div>
        <label for="message">categorie :</label>
        <textarea id="categorie"></textarea>
    </div>
    <div class="button">
        <button type="submit">Envoyer votre message</button>
    </div>
</form>
</body>
</html>