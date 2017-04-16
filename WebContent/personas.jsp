<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM Manager</title>
</head>
<body>
	<s:form action="savePersona">
		<s:hidden name="id"></s:hidden>
		<s:textfield label="Nombre" name="name"></s:textfield>
		<s:textfield label="Edad" name="age"></s:textfield>
		<s:radio label="Genero" name="gender" list="#{'Femenino':'Femenino','Masculino':'Masculino'}" />
		<s:submit></s:submit>
		<s:actionerror/>
	</s:form>
		<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>G�nero</th>
			<th></th>
		</tr>
	<s:iterator value="personas" var="p">
		<tr>
			<td><s:property value="#p.id"/></td>
			<td><s:property value="#p.name"/></td>
			<td><s:property value="#p.age"/></td>
			<td><s:property value="#p.gender"/></td>
			<td>
			<s:url id="modifyURL" action="editPersona">
					<s:param name="id" value="#p.id"></s:param>
			</s:url>
			<s:a href="%{modifyURL}">
					<img src="edit.jpg" alt="Modificar Usuario" width="20" height="20">
			</s:a>
			</td>
			<td>
				<s:url id="deleteURL" action="deletePersona">
					<s:param name="id" value="#p.id"></s:param>
				</s:url>
				<s:a href="%{deleteURL}">
					<img src="delete.png" alt="Borrar Usuario" width="20" height="20">
				</s:a>

			</td>
		</tr>
	</s:iterator>
	</table>
		
</body>
</html>