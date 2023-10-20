<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar nuevo empleado</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mt-3">Nuevo empleado</h1>
        <a href="<%=request.getContextPath()%>/EmployeeServlet">Regresar</a>
        <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet">
            <label>First Name:</label>
            <input type="text" class="form-control" name="firstName">
            <label>Last Name:</label>
            <input type="text" class="form-control" name="lastName">
            <label>Email:</label>
            <input type="text" class="form-control" name="email">
            <label>Phone Number:</label>
            <input type="text" class="form-control" name="phoneNumber">
            <label>Hire date:</label>
            <input type="text" class="form-control" name="hireDate">
            <label>Job ID:</label>
            <input type="text" class="form-control" name="jobId">
            <label>Salary:</label>
            <input type="text" class="form-control" name="salary">
            <label>Commission PCT:</label>
            <input type="text" class="form-control" name="commissionPct">
            <label>Manager ID:</label>
            <input type="text" class="form-control" name="managerId">
            <label>Department ID:</label>
            <input type="text" class="form-control" name="departmentId">
            <button type="submit">Guardar</button>
        </form>
    </div>
</body>
</html>
