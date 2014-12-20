<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/><br/>
<c:if test="${usuarioLogado}">
    Voce esta logado como ${usuarioLogado.email}<br/><br/>
</c:if>

<form action="novaEmpresa" method="POST">
   Nome: <input type="text" name="nome" /><br/>
    <input type="submit" value="Enviar" />
</form>

<form action="login" method="POST">
    E-mail: <input type="email"  name="email" /><br/>
	Senha: <input type="password"  name="senha" /><br/>
    <input type="submit" value="Enviar" />
</form>

<form action="logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>