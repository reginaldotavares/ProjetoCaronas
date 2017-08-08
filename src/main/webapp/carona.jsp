
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/><!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="utf-8">
    <title>Vai pra onde?</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 90%;
        width: 100%;
      }

    </style>
  </head>
  <body>
    <ul id="slide-out" class="side-nav">
      <li><a href="#" class="button-collapse2 show-on-large">Cadastrar carona</a></li>
      <li><a href="#" data-activates="slide-out3" class="button-collapse3 show-on-large">Pedir carona</a></li>
      <li><a href="#" class="button-collapse3 show-on-large">Minhas Caronas</a></li>
    </ul>


    

    <ul id="slide-out3" class="side-nav">
      <div class="row">
        <form class="" action="ListarCaronas" method="post">
          <div class="row">
            <div class="input-field col s12">
              <input id="origem" type="text" name="origem" value="">
              <label for="origem">Origem</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input id="destino" type="text" name="destino" value="">
              <label for="destino">Destino</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
             <input id="calendario" type="text" class="datepicker" name="calendario">
             <label for="calendario">Data da viagem</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <input class="btn" type="submit" name="" value="Pesquisar">
            </div>
          </div>
        </form>
      </div>
    </ul>


    <nav>
      <div class="nav-wrapper indigo darken-4">
        <a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
        <a href="#" class="brand-logo">Vai pra onde? <tag:usuarioLogado/></a>
      </div>
    </nav>
    
    <div class="container">
    	<div class="row">
        <div class="col s12 m6">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
 
              <p name ="origem">Origem: ${pesquisa.origem}</p>
              <p name ="destino">Destino: ${pesquisa.destino}</p>
              <p name ="telefone">Telefone: ${pesquisa.telefone}</p>
              <p name ="ajudaCusto">Ajuda de custo: ${pesquisa.ajuda}</p>
              <p name ="horaChegada">Hora de chegada ao destino: ${pesquisa.calculaHoraChegada()}</p>
            </div>
            <div class="card-action">
              <input class="btn-flat" type="submit" value="excluir">
              <input class="btn-flat" type="submit" value="editar">
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="js/map.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAuSd81wSdpuOefFfjLlmb8bKZULEd1OwY&callback=initMap">
    </script>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
  </body>
</html>

<%--<body class = templatemo-bg-image-2>
    <div class="container-fluid" >
        <div class="titulo">${pesquisa.nome}</div>
    </div>
    
    <div class="container">
        <div id="description">
            <h3>Descrição</h3>
            <fieldset>                
                <strong>Nome: ${pesquisa.nome}</strong><br>
                Origem:${pesquisa.origem}<br>        
            
                Destino ${pesquisa.destino}<br>
                
                Distância: ${pesquisa.distancia}<br>
                
                Data: ${pesquisa.data}<br>
                
                Hora ${pesquisa.horasaida}<br>
                
                Ajuda de custo ${pesquisa.ajudadecusto}<br>
            </fieldset>          

        </div>
   
    </div>
            
    <c:if test="${convidado.id != sessionScope.usuario.id}">
            <div id="amizade">
                <h2>Recomendações</h2>
                
                
                <a href="#" role="button" class="btn" data-toggle="modal">Recomendar</a>
 
                
            </div>
            <div class="col-sm-8">
		<div class="form-group">
			<label class="control-label">Rate This</label>
			<div class="rating-container rating-lg rating-animate"><div class="clear-rating clear-rating-active" title="Clear"><i class="glyphicon glyphicon-minus-sign"></i></div><div class="rating"><span class="empty-stars"><span class="star"><i class="glyphicon glyphicon-star-empty"></i></span><span class="star"><i class="glyphicon glyphicon-star-empty"></i></span><span class="star"><i class="glyphicon glyphicon-star-empty"></i></span><span class="star"><i class="glyphicon glyphicon-star-empty"></i></span><span class="star"><i class="glyphicon glyphicon-star-empty"></i></span></span><span style="width: 0%;" class="filled-stars"><span class="star"><i class="glyphicon glyphicon-star"></i></span><span class="star"><i class="glyphicon glyphicon-star"></i></span><span class="star"><i class="glyphicon glyphicon-star"></i></span><span class="star"><i class="glyphicon glyphicon-star"></i></span><span class="star"><i class="glyphicon glyphicon-star"></i></span></span></div><div class="caption"><span class="label label-default">Not Rated</span></div><input id="w15" class="hide" name="rating_21" data-krajee-rating="rating_7fae0bbe" type="text"></div>		</div>
	</div>
            
            
    </c:if>--%>