<%-- 
    Document   : index
    Created on : Dec 6, 2020, 3:58:31 PM
    Author     : Stefania Cavazos
--%>


<%@page import="java.util.List"%>
<%@page import="Models.Card"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //conversion implicita no ocupamos decirle como se llama 
    //conversion explicita si ocupamos 
    //aqui nosotros requerimos una casting explicito
   String title = (String)request.getAttribute("title");
   List<Card> cards = (List<Card>)request.getAttribute("cards");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/CSS.css"/>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Mainservlet">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
      <%
      if(1 == 0){
      %>
      
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="User">
      <input class="form-control mr-sm-2" type="password" placeholder="Password">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
    </form>
      <%
          }
else{
      %>
      <img style="width: 30px" src="https://cdnb.artstation.com/p/assets/images/images/032/667/143/large/yizheng-ke-2020-6-4x.jpg?1607102614"> Brenda
      <%
          }
      %>
  </div>
</nav>
        <div class="container">
        <h1>Mi primer JSP</h1>
        <h2><%= title%></h2>
        <h2>Cards</h2>
        <div class="row">
            <%
                if(cards != null){
               for(Card card : cards) {
            %>
              <div class="card col-4">
  <img src="<%= card.getUrlImage()%>" style="max-height: 400px" alt="...">
  <div class="card-body ">
    <h5 class="card-title"><%= card.getTitle()%></h5>
    <p class="card-text"><%= card.getDescription()%></p>
    <a href="<%= card.getLinkRef()%>"target="_kiki" class="btn btn-primary">Go somewhere</a>
  </div>
  </div>
            <%
                }
}
            %>
        </div>
        <div class="row">
            <%
            for(int i = 0;i < 6; i++){
            %>
        <div class="card col-4">
  <img src="https://cdna.artstation.com/p/assets/images/images/032/637/576/large/andy_na-2020030401.jpg?1607017094" class="card-img-top" alt="...">
  <div class="card-body ">
    <h5 class="card-title">Kiki Delivery</h5>
    <p class="card-text">Studios Ghibli Movie</p>
    <a href="https://www.artstation.com/artwork/KrvPxr" target="_kiki" class="btn btn-primary">Go somewhere</a>
  </div>
  </div>
        <%
            }
        %>
</div>
        <h2>For</h2>
        
        <ul>
            
            <% 
            for(int i = 0;i < 10; i++){
            %>
            <li>Categoria <%= i%></li>
            <%
                }
            %>
<!--            <li>Categoria 2</li>-->
<!--            <li>Categoria 3</li>-->
        </ul>
        </div>
    </body>
</html>
