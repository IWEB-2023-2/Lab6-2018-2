<%@ page import="com.example.lab6_20182.beans.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Employee employee = (Employee) request.getAttribute("employee"); %>
<html>
<head>
    <title>Editar empleado</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mt-3">Editar empleado</h1>
        <a href="<%=request.getContextPath()%>/EmployeeServlet">Regresar</a>
        <a onclick="return confirm('¿Está seguro de borrar?')" href="<%=request.getContextPath()%>/EmployeeServlet?action=borrar&id=<%=employee.getEmployeeId()%>">Borrar</a>
        <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet?action=e&id=<%=employee.getEmployeeId()%>">
            <label>First Name:</label>
            <input type="text" class="form-control" name="firstName" value="<%=employee.getFirstName()%>">
            <label>Last Name:</label>
            <input type="text" class="form-control" name="lastName" value="<%=employee.getLastName()%>">
            <label>Email:</label>
            <input type="text" class="form-control" name="email" value="<%=employee.getEmail()%>">
            <label>Phone Number:</label>
            <input type="text" class="form-control" name="phoneNumber" value="<%=employee.getPhoneNumber()%>">
            <label>Hire date:</label>
            <input type="text" class="form-control" name="hireDate" value="<%=employee.getHireDate()%>">
            <label>Job ID:</label>
            <input type="text" class="form-control" name="jobId" value="<%=employee.getJobId()%>">
            <label>Salary:</label>
            <input type="text" class="form-control" name="salary" value="<%=employee.getSalary()%>">
            <label>Commission PCT:</label>
            <input type="text" class="form-control" name="commissionPct" value="<%=employee.getCommissionPct()%>">
            <label>Manager ID:</label>
            <input type="text" class="form-control" name="managerId" value="<%=employee.getManagerId()%>">
            <label>Department ID:</label>
            <input type="text" class="form-control" name="departmentId" value="<%=employee.getDepartmentId()%>">
            <button type="submit">Actualizar</button>
        </form>
    </div>
</body>
</html>
