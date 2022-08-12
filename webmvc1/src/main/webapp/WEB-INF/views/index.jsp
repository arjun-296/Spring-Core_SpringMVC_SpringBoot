<%@ page isELIgnored = "false" %>

<html>

<head>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>

<body>

<form action="reqSendBikes" method="POST">
    Bike ID <input type="text" name="bike_id"/>
    <br/> Bike Name<input type="text" name="bike_name"/>
    <br/> Engine Capacity <input type="text" name="bike_engine_capacity"/>
    <br/> Top Speed <input type="text" name="Top_speed"/>
    <br/> Price(lacs) <input type="text" name="Price"/>
    <br/> <input type="submit" value="Add new Bike"/>
</form>

<hr/>

<table border="1">
    <thead>
        <th>Bike ID</th>
        <th>Bike Name</th>
        <th>Engine Capacity</th>
        <th>Top Speed</th>
        <th>Price(lacs)</th>
        <th>Options</th>
    </thead>

    <tbody>
        <c:forEach items="${AllBikes}" var="b">

            <tr>
                <td>${b.bike_id}</td>
                <td>${b.bike_name}</td>
                <td>${b.bike_engine_capacity}</td>
                <td>${b.bike_top_speed}</td>
                <td>${b.bike_price}</td>
                <td>
                    <a href="reqDeleteBikes?bike_id=${b.bike_id}">Delete</a>
                    /
                    <a href="reqEditPage?bike_id=${b.bike_id}">Edit Bike<a>
                </td>
            </tr>

        </c:forEach>
    </tbody>

</table>

</body>
</html>



