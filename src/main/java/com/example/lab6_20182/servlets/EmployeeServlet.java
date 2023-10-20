package com.example.lab6_20182.servlets;

import com.example.lab6_20182.beans.Employee;
import com.example.lab6_20182.daos.EmployeeDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        EmployeeDao employeeDao = new EmployeeDao();

        switch (action){
            case "listar" -> {
                request.setAttribute("lista",employeeDao.listar());
                request.getRequestDispatcher("employees/lista.jsp").forward(request,response);
            }
            case "crear" -> request.getRequestDispatcher("employees/crear.jsp").forward(request,response);
            case "editar" -> {
                Employee employee = employeeDao.buscar(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("employee",employee);
                request.getRequestDispatcher("employees/editar.jsp").forward(request,response);
            }
            case "borrar" -> {
                employeeDao.borrar(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        EmployeeDao employeeDao = new EmployeeDao();
        String action = request.getParameter("action") == null ? "c" : request.getParameter("action");

        switch (action){
            case "c" ->{
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
                String hireDate = request.getParameter("hireDate");
                String jobId = request.getParameter("jobId");
                String salary = request.getParameter("salary");
                String commissionPct = request.getParameter("commissionPct");
                String managerId = request.getParameter("managerId");
                String departmentId = request.getParameter("departmentId");

                boolean isAllValid = true;

                if(firstName.length() > 20 || lastName.length() > 25 || email.length() > 25 || phoneNumber.length() > 25 || jobId.length() > 10){
                    isAllValid = false;
                }

                if(isAllValid){
                    Employee employee = new Employee();
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setEmail(email);
                    employee.setPhoneNumber(phoneNumber);
                    employee.setHireDate(hireDate);
                    employee.setJobId(jobId);
                    employee.setSalary(Float.parseFloat(salary));
                    employee.setCommissionPct(Float.parseFloat(commissionPct));
                    employee.setManagerId(Integer.parseInt(managerId));
                    employee.setDepartmentId(Integer.parseInt(departmentId));

                    employeeDao.crear(employee);
                    response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                }else{
                    request.getRequestDispatcher("employees/crear.jsp").forward(request,response);
                }
            }
            case "e" ->{
                String employeeId1 = request.getParameter("id");
                String firstName1 = request.getParameter("firstName");
                String lastName1 = request.getParameter("lastName");
                String email1 = request.getParameter("email");
                String phoneNumber1 = request.getParameter("phoneNumber");
                String hireDate1 = request.getParameter("hireDate");
                String jobId1 = request.getParameter("jobId");
                String salary1 = request.getParameter("salary");
                String commissionPct1 = request.getParameter("commissionPct");
                String managerId1 = request.getParameter("managerId");
                String departmentId1 = request.getParameter("departmentId");

                boolean isAllValid1 = true;

                if(firstName1.length() > 20 || lastName1.length() > 25 || email1.length() > 25 || phoneNumber1.length() > 25 || jobId1.length() > 10 || employeeId1.equals(managerId1)){
                    isAllValid1 = false;
                }

                if(isAllValid1){
                    Employee employee1 = new Employee();
                    employee1.setEmployeeId(Integer.parseInt(employeeId1));
                    employee1.setFirstName(firstName1);
                    employee1.setLastName(lastName1);
                    employee1.setEmail(email1);
                    employee1.setPhoneNumber(phoneNumber1);
                    employee1.setHireDate(hireDate1);
                    employee1.setJobId(jobId1);
                    employee1.setSalary(Float.parseFloat(salary1));
                    employee1.setCommissionPct(Float.parseFloat(commissionPct1));
                    employee1.setManagerId(Integer.parseInt(managerId1));
                    employee1.setDepartmentId(Integer.parseInt(departmentId1));

                    employeeDao.editar(employee1);
                    response.sendRedirect(request.getContextPath()+"/EmployeeServlet");
                }else{
                    request.setAttribute("employee",employeeDao.buscar(Integer.parseInt(employeeId1)));
                    request.getRequestDispatcher("employees/editar.jsp").forward(request,response);
                }
            }
            case "b" ->{
                int textoId = Integer.parseInt(request.getParameter("textoId"));
                ArrayList<Employee> lista = new ArrayList<>();
                lista.add(employeeDao.buscar(textoId));

                request.setAttribute("lista",lista);
                request.setAttribute("busqueda",textoId);
                request.getRequestDispatcher("employees/lista.jsp").forward(request,response);
            }
        }
    }
}