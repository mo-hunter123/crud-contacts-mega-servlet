<%--
  Created by IntelliJ IDEA.
  User: ahrrass
  Date: 22/03/2022
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>OKAJDKF</title>
</head>
<body>

<main class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <form method="post" action="insert.do">
            <div class="form-group">
                <label >Nom</label>
                <input type="text" class="form-control" name="nom" placeholder="Nom">
            </div>
            <div class="form-group">
                <label >Adresse</label>
                <input type="text" class="form-control" name="adresse" placeholder="Adresse" >
            </div>
            <div class="form-group">
                <label >Telephone</label>
                <input type="text" class="form-control" name="numero" placeholder="Telephone">
            </div>
            <div class="form-group">
                <label >Type contact</label>
                <select name="type" class="form-control form-control-sm">
                    <option value="Professionel">Professionel</option>
                    <option value="Famille">Famille</option>
                    <option value="Education">Education</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</main>

</body>
</html>
