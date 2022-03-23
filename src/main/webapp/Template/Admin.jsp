<%--
  Created by IntelliJ IDEA.
  User: ahrrass
  Date: 22/03/2022
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Espace admin</title>
</head>
<body>
<h1>Welcom to admin page </h1>

<main class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <a href="insert.do">Ajouter Contact</a>

        <h6 class="border-bottom pb-2 mb-0">Available Contacts</h6>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Numero</th>
                    <th scope="col">Type</th>
                    <th scope="col">Traitement</th>

                </tr>
                </thead>

                <tbody>
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td>${contact.id}</td>
                        <td>${contact.nom}</td>
                        <td>${contact.adresse}</td>
                        <td>${contact.telephone}</td>
                        <td>${contact.tType}</td>
                        <td>
                            <form method="post" action="delete.do">
                                <input type="hidden" name="id" value="${contact.id}"  >
                                <input onclick="clicked(this)" class="btn btn-danger" value="Delete" type="submit">
                            </form>
                            <a class="btn btn-primary" href="update.do?id=${contact.id}" >Modifier</a>

                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</main>
<script>
    function clicked(e)
    {
        if(!confirm('Vous etes sur le point de supprimer le Contact ok pour proceder ?')) {
            e.preventDefault();
        }
    }
</script>
</body>
</html>
