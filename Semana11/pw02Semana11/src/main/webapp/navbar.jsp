<%-- 
    Document   : navbar
    Created on : 20/11/2020, 07:37:36 PM
    Author     : magoc
--%>

<%@page import="java.util.List"%>
<%@page import="com.pw.pw02semana11.models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Category> categories = (List<Category>)request.getAttribute("Categories");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">My Page</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="MainPageController">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AddNewsController">Agregar Noticia</a>
            </li>
            <%
                for (Category category : categories) {
            %>
            <li class="nav-item">
                <a class="nav-link" href="#"><%= category.getName()%></a>
            </li>
            <%
                }
            %>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>