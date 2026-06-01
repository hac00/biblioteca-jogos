<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jogos.css?v=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
  <title>Minha Lista de Desejos - Wishlist</title>
  <style>
    .btn-action {
      padding: 4px 8px;
      border-radius: 4px;
      text-decoration: none;
      font-size: 13px;
      font-weight: bold;
    }
    .btn-edit { background: #e0e7ff; color: #4f46e5; }
    .btn-delete { background: #fee2e2; color: #ef4444; }
  </style>
</head>
<body>
<div class="page-wrapper">
  <jsp:include page="/WEB-INF/pages/includes/header.jsp" />

  <c:choose>
    <c:when test="${param.msg == 'salvo'}">
      <div class="msg">Item adicionado à sua Wishlist!</div>
    </c:when>
    <c:when test="${param.msg == 'excluido'}">
      <div class="msg">Item removido da Wishlist.</div>
    </c:when>
    <c:when test="${param.msg == 'editado'}">
      <div class="msg">Preço ou dados do desejo atualizados!</div>
    </c:when>
  </c:choose>

  <c:if test="${not empty erroValidacao}">
    <div class="msg" style="background-color: #f8d7da; color: #721c24;">${erroValidacao}</div>
  </c:if>

  <div class="container">
    <div class="card">
      <h2>${itemWishlist.id != null ? 'Editar Desejo' : 'Adicionar à Wishlist'}</h2>
      <form action="wishlist" method="post">
        <input type="hidden" name="id" value="${itemWishlist.id}">

        <label>Nome do Jogo</label>
        <input type="text" name="nome" value="${itemWishlist.nome}" placeholder="Ex: GTA VI" required>

        <label>Plataforma Alvo</label>
        <input type="text" name="plataforma" value="${itemWishlist.plataforma}" placeholder="Ex: PC, PS5, Xbox">

        <label>Preço Máximo Disposto a Pagar (R$)</label>
        <input type="number" step="0.01" name="precoMaximo" value="${itemWishlist.precoMaximo}" placeholder="Ex: 250.00">

        <button type="submit">
          ${itemWishlist.id != null ? 'Atualizar Desejo' : 'Monitorar Preço'}
        </button>
      </form>
    </div>

    <div class="card">
      <h2>Jogos na Mira</h2>
      <table>
        <tr>
          <th>#</th>
          <th>Nome do Jogo</th>
          <th>Plataforma</th>
          <th>Preço Limite</th>
          <th>Ações</th>
        </tr>
        <c:forEach var="w" items="${itensWishlist}" varStatus="status">
          <tr>
            <td>${status.index + 1}</td>
            <td style="font-weight: bold; color: #4f46e5;">${w.nome}</td>
            <td>${w.plataforma}</td>
            <td>R$ ${String.format("%.2f", w.precoMaximo)}</td>
            <td>
              <a href="wishlist?acao=editar&id=${w.id}" class="btn-action btn-edit">Editar</a> |
              <a href="wishlist?acao=excluir&id=${w.id}" class="btn-action btn-delete" onclick="return confirm('Desistir de monitorar ${w.nome}?')" style="color:red;">Remover</a>
            </td>
          </tr>
        </c:forEach>
        <c:if test="${empty itensWishlist}">
          <tr>
            <td colspan="5" style="color: gray; padding: 20px;">Sua lista de desejos está vazia. Adicione jogos acima!</td>
          </tr>
        </c:if>
      </table>
    </div>
  </div>

  <jsp:include page="/WEB-INF/pages/includes/footer.jsp" />
</div>
</body>
</html>