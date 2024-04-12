<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Confirmation Ajout animal</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout animal
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="ID" class="form-control" value="${animal.id }"/>
                </div>

                <div class="form-group">
                    <label class="control-label">Nom animal :</label>
                    <input type="text" name="Nom" class="form-control" value="${animal.nom }"/>
                </div>

                <div class="form-group">
                    <label class="control-label">Type :</label>
                    <input type="text" name="Type" class="form-control" value="${animal.type }"/>
                </div>

                <div class="form-group">
                    <label class="control-label">age :</label>
                    <input type="text" name="Age" class="form-control" value="${animal.age }"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
