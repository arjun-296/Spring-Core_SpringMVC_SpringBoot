<%@ page isELIgnored = "false" %>

<html>

<head>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
<h1>EDIT BOOK PAGE</h1>
<form action="reqUpdateBikeRecords" method="POST">
    Bike ID <input type="text" name="bike_id"/>
    <br/> Bike Name<input type="text" name="bike_name"/>
    <br/> Engine Capacity <input type="text" name="bike_engine_capacity"/>
    <br/> Top Speed <input type="text" name="Top_speed"/>
    <br/> Price(lacs) <input type="text" name="Price"/>
    <br/> <input type="submit" value="Update Bike Record"/>
</form>
</body>
</html>



