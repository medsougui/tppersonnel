<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Modification des classes</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Modification des classes
            </div>
            <div class="card-body">
                <form action="updateClasse" method="post" >
                    <div hidden class="form-group" >
                        <label class="control-label">ID classe :</label>
                        <input type="text" name="id" class="form-control"
                            value="${classe.id}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom classe :</label>
                        <input type="text" name="nom" class="form-control"
                            value="${classe.nom}"/>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
