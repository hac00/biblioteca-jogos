<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jogos.css?v=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <title>Minha Biblioteca de Jogos</title>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="/WEB-INF/pages/includes/header.jsp" />

    <c:choose>
        <c:when test="${param.msg == 'salvo'}">
            <div class="msg">Jogo adicionado à coleção!</div>
        </c:when>
        <c:when test="${param.msg == 'excluido'}">
            <div class="msg">Jogo removido da coleção!</div>
        </c:when>
        <c:when test="${param.msg == 'editado'}">
            <div class="msg">Dados do jogo atualizados!</div>
        </c:when>
    </c:choose>

    <div class="container">
        <div class="card">
            <h2>${jogo.id != null ? 'Editar Jogo' : 'Adicionar Jogo'}</h2>
            <form action="jogo" method="post">
                <input type="hidden" name="id" value="${jogo.id}">

                <label>Nome do Jogo</label>
                <input type="text" name="nome" value="${jogo.nome}" required>

                <label>Gênero</label>
                <input type="text" name="genero" value="${jogo.genero}">

                <label>Plataforma</label>
                <input type="text" name="plataforma" value="${jogo.plataforma}">

                <label>Horas Jogadas</label>
                <input type="number" step="0.1" name="horas" value="${jogo.horas}">

                <label>Nota (0 a 10)</label>
                <input type="number" name="nota" min="0" max="10" value="${jogo.nota}">

                <label>URL da Capa (Link de Imagem)</label>
                <input type="text" name="capa" value="${jogo.capa}" placeholder="http://...">

                <div class="checkbox-container">
                    <input type="checkbox" id="jogando" name="jogando" ${jogo.jogando ? 'checked' : ''}>
                    <label for="jogando" style="display:inline;">Estou jogando atualmente</label>
                </div>

                <button type="submit">
                    ${jogo.id != null ? 'Atualizar Dados' : 'Salvar na Coleção'}
                </button>
            </form>
        </div>

        <div class="card">
            <h2>Meus Jogos</h2>
            <table>
                <tr>
                    <th>#</th>
                    <th>Capa</th>
                    <th>Nome</th>
                    <th>Gênero</th>
                    <th>Plataforma</th>
                    <th>Horas</th>
                    <th>Nota</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="j" items="${jogos}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty j.capa}">
                                    <img src="${j.capa}" alt="Capa" class="game-cover">
                                </c:when>
                                <c:otherwise>
                                    <span style="font-size:11px; color:gray;">Sem capa</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td style="font-weight: bold;">${j.nome}</td>
                        <td>${j.genero}</td>
                        <td>${j.plataforma}</td>
                        <td>${j.horas}h</td>
                        <td>${j.nota}/10</td>
                        <td>
                            <c:choose>
                                <c:when test="${j.jogando}">
                                    <span style="background:#d4edda; color:#155724; padding:2px 6px; border-radius:4px; font-size:12px;">Jogando</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="background:#e2e3e5; color:#383d41; padding:2px 6px; border-radius:4px; font-size:12px;">Backlog</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="jogo?acao=editar&id=${j.id}">Editar</a> |
                            <a href="jogo?acao=excluir&id=${j.id}" onclick="return confirm('Tem certeza que deseja remover ${j.nome}?')" style="color:red;">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <jsp:include page="/WEB-INF/pages/includes/footer.jsp" />
</div>
</body>
</html>