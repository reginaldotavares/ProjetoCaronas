<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body class = templatemo-bg-image-2>
    <div class="row media-object">
        
        <c:forEach items="${caronas}" var="carona">
            <div class="col-sm-3 modal-header">
                <a href="AbrirCarona?id=${carona.id}">
                </a><legend> De ${carona.origem} para ${carona.destino}</legend>
            </div>

        </c:forEach>       
    </div>
