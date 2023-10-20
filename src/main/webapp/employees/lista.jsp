<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab6_20182.beans.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Employee> listaEmpleados = (ArrayList<Employee>) request.getAttribute("lista"); %>
<html>
    <head>
        <title>Empleados</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <a href="<%=request.getContextPath()%>/EmployeeServlet">
                <h1 class="link-dark">Lista de empleados</h1>
            </a>
            <a href="<%= request.getContextPath()%>">Regresar</a>
            <br>
            <a href="<%=request.getContextPath()%>/EmployeeServlet?action=crear">Agregar nuevo empleado</a>
            <br>
            <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet?action=b">
                <input type="text" class="form-control" id="floatingInput" placeholder="Búsqueda por ID" name="textoId" value="<%=request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : ""%>">
                <label for="floatingInput">Buscar Empleado</label>
            </form>
            <table class="table">
                <tr>
                    <td>#</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Email</td>
                    <td>Phone</td>
                    <td>Hire Date</td>
                    <td>Job ID</td>
                    <td>Salary</td>
                    <td>Commission</td>
                    <td>Manager_ID</td>
                    <td>Department_ID</td>
                </tr>
                <% for(Employee employee: listaEmpleados){ %>
                <tr>
                    <td><%= employee.getEmployeeId() %></td>
                    <td><%= employee.getFirstName() %></td>
                    <td><%= employee.getLastName() %></td>
                    <td><%= employee.getEmail() %></td>
                    <td><%= employee.getPhoneNumber() %></td>
                    <td><%= employee.getHireDate() %></td>
                    <td><%= employee.getJobId() %></td>
                    <td><%= employee.getSalary() %></td>
                    <td><%= employee.getCommissionPct() %></td>
                    <td><%= employee.getManagerId() %></td>
                    <td><%= employee.getDepartmentId() %></td>
                    <td><a href="<%=request.getContextPath()%>/EmployeeServlet?action=editar&id=<%= employee.getEmployeeId()%>">Editar</a></td>
                </tr>
                <% } %>
            </table>
        </div>

    </body>
</html>
