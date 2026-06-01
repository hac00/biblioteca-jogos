<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cadastro.css">
    <title>GameLibrary - Criar Conta</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/includes/header.jsp" />
<div class="page-center">
    <div class="box">
        <h2>👤 Criar Conta</h2>
        <c:if test="${not empty erro}">
            <div style="color: red; background-color: #f8d7da; border: 1px solid #f5c6cb; padding: 10px; margin-bottom: 15px; border-radius: 4px;">
                    ${erro}
            </div>
        </c:if>
        <form action="usuario" method="post">
            <input type="text" name="nome" placeholder="Nome" value="${param.nome}" required>
            <input type="email" name="email" placeholder="E-mail" value="${param.email}" required>
            <input type="password" name="senha" placeholder="Senha" required>
            <button type="submit">Cadastrar</button>
        </form>
        <a href="index.jsp">Voltar para o Login</a>
    </div>
</div>
<jsp:include page="/WEB-INF/pages/includes/footer.jsp" />
</body>
</html>