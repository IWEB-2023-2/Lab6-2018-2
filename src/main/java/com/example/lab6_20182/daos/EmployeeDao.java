package com.example.lab6_20182.daos;

import com.example.lab6_20182.beans.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {
    public ArrayList<Employee> listar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "select * from employees";

        ArrayList<Employee> lista = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){

            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getString(6).split(" ")[0].split("-")[2]+"/"+rs.getString(6).split(" ")[0].split("-")[1]+"/"+rs.getString(6).split(" ")[0].split("-")[0]);
                employee.setJobId(rs.getString(7));
                employee.setSalary(rs.getFloat(8));
                employee.setCommissionPct(rs.getFloat(9));
                employee.setManagerId(rs.getInt(10));
                employee.setDepartmentId(rs.getInt(11));

                lista.add(employee);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crear(Employee employee){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "insert into employees(first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values(?,?,?,?,?,?,?,?,?,?)";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,employee.getFirstName());
            pstmt.setString(2,employee.getLastName());
            pstmt.setString(3,employee.getEmail());
            pstmt.setString(4,employee.getPhoneNumber());
            pstmt.setString(5,employee.getHireDate());
            pstmt.setString(6,employee.getJobId());
            pstmt.setFloat(7,employee.getSalary());
            pstmt.setFloat(8,employee.getCommissionPct());
            pstmt.setInt(9,employee.getManagerId());
            pstmt.setInt(10,employee.getDepartmentId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(Employee employee){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "update employees set first_name=?,last_name=?,email=?,phone_number=?,hire_date=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id=?";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,employee.getFirstName());
            pstmt.setString(2,employee.getLastName());
            pstmt.setString(3,employee.getEmail());
            pstmt.setString(4,employee.getPhoneNumber());
            pstmt.setString(5,employee.getHireDate());
            pstmt.setString(6,employee.getJobId());
            pstmt.setFloat(7,employee.getSalary());
            pstmt.setFloat(8,employee.getCommissionPct());
            pstmt.setInt(9,employee.getManagerId());
            pstmt.setInt(10,employee.getDepartmentId());
            pstmt.setInt(11,employee.getEmployeeId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(int employeeId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "delete from employees where employee_id = ?";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1,employeeId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee buscar(int employeeId){
        Employee employee = new Employee();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "select * from employees where employee_id = ?";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1,employeeId);

            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    employee.setEmployeeId(rs.getInt(1));
                    employee.setFirstName(rs.getString(2));
                    employee.setLastName(rs.getString(3));
                    employee.setEmail(rs.getString(4));
                    employee.setPhoneNumber(rs.getString(5));
                    employee.setHireDate(rs.getString(6));
                    employee.setJobId(rs.getString(7));
                    employee.setSalary(rs.getFloat(8));
                    employee.setCommissionPct(rs.getFloat(9));
                    employee.setManagerId(rs.getInt(10));
                    employee.setDepartmentId(rs.getInt(11));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
