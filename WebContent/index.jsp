<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- indica que se usan tags de struts dentro de este jsp -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- aca empieza el html -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio - ABM</title>
</head>
<body>
	<h1>Say my name</h1>
	<p>
		<a href="<s:url action='showForm'/>">Ver Formulario de personas</a>
	</p>
</body>
</html>