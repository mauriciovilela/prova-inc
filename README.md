<h1><a id="Prova_Zup_0"></a>Prova Zup</h1>
<p>Pré requisitos e ferramentas para rodar o ambiente:</p>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>Plugin</th>
<th>README</th>
</tr>
</thead>
<tbody>
<tr>
<td>Java JDK</td>
<td>&gt;= 8</td>
</tr>
<tr>
<td>Node e npm</td>
<td>node &gt;= 8</td>
</tr>
<tr>
<td>Apache maven</td>
<td>&gt;= 3</td>
</tr>
<tr>
<td>Eclipse</td>
<td>Spring Tool Suite (STS</td>
</tr>
<tr>
<td>Banco de dados</td>
<td>H2 (memória)</td>
</tr>
<tr>
<td>Visual studio code</td>
<td></td>
</tr>
<tr>
<td>Postman</td>
<td></td>
</tr>
</tbody>
</table>
<h3><a id="Arquitetura_e_bibliotecas_13"></a>Arquitetura e bibliotecas</h3>
<ul>
<li>Spring Java</li>
<li>Spring boot (servidor de aplicativo)</li>
<li>Mapstruct (Parse automatico dos DTO’s, front =&gt; back)</li>
<li>Cache de consultas (Spring)</li>
<li>Flyway (Versionamento de scripts)</li>
</ul>
<h3><a id="Insumos_21"></a>Insumos</h3>
<p>Projeto no POSTMAN:<br>
<a href="https://raw.githubusercontent.com/mauriciovilela/prova-inc/master/Prova.postman_collection.json">https://raw.githubusercontent.com/mauriciovilela/prova-inc/master/Prova.postman_collection.json</a><br>
<a href="https://nodesource.com/products/nsolid"><img src="https://image.ibb.co/kQLHMy/image.png" alt="N|Solid"></a></p>
<h3><a id="Entidades_26"></a>Entidades</h3>
<ul>
<li>Cliente, Produto e Pedido</li>
</ul>
<h3><a id="Instalao_30"></a>Instalação</h3>
<p>Instalar as bibliotecas e dependências e rodar o projeto executando os testes.</p>
<pre><code class="language-sh">$ npm install
$ mvn install
$ mvn spring-boot:run
</code></pre>
<p>Gerar pacote para produção …</p>
<pre><code class="language-sh">$ ng build --prod
</code></pre>
<h3><a id="Projeto_rodando_46"></a>Projeto rodando</h3>
<p><a href="https://nodesource.com/products/nsolid"><img src="https://image.ibb.co/j0CWgy/image.png" alt="N|Solid"></a></p>
