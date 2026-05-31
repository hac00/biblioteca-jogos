<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
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
        <form action="usuario" method="post">
            <input type="text" name="nome" placeholder="Nome" required>
            <input type="email" name="email" placeholder="E-mail" required>
            <input type="password" name="senha" placeholder="Senha" required>
            <button type="submit">Cadastrar</button>
        </form>
        <a href="index.jsp">Voltar para o Login</a>
    </div>
</div>
<jsp:include page="/WEB-INF/pages/includes/footer.jsp" />
</body>
</html>