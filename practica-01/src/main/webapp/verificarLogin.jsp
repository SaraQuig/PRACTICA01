<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" import="com.recursos.login.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Usuario usuario = new Usuario();
	String nlogin = request.getParameter("usuario");
	String nclave = request.getParameter("clave");
	HttpSession sesion = request.getSession(); //Se crea la variable de sesión
	boolean respuesta = usuario.verificarUsuario(nlogin, nclave);
	if (respuesta) {
		sesion.setAttribute("usuario", usuario.getNombre()); //Se añade atributos
		sesion.setAttribute("perfil", usuario.getPerfil()); //Se añade atributos
		response.sendRedirect("menu.jsp"); //Se redirecciona a una página específica
	} else {
	%>
	<jsp:forward page="sesion.jsp">
		<jsp:param name="error"
			value="Datos incorrectos.<br>Vuelva a intentarlo." />
	</jsp:forward>
	<%
	}
	%>
</body>
</html>