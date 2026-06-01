<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

<div class="header">
  <div class="logo" style="color: white; font-weight: bold; font-size: 20px; font-family: sans-serif;">
    🎮 GameLibrary Manager
  </div>
  <a href="${pageContext.request.contextPath}/jogo">Minha Biblioteca</a>
  <a href="${pageContext.request.contextPath}/wishlist">Lista de Desejos</a>
  <div style="color: white; font-family: sans-serif;">
    <c:if test="${not empty sessionScope.usuario}">
      Olá, <strong>${sessionScope.usuario.nome}</strong> |
      <a href="logout" style="color: #ff4a4a; text-decoration: none; margin-left: 5px;">Sair</a>
    </c:if>
  </div>
</div>