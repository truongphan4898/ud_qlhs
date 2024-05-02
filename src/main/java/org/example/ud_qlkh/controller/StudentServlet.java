package org.example.ud_qlkh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ud_qlkh.model.Student;
import org.example.ud_qlkh.service.StudentService;
import org.example.ud_qlkh.service.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet (name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
            default:
                break;

        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            studentService.remove(id);
            try {
                response.sendRedirect("/student");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        double mark = Double.parseDouble(request.getParameter("mark"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setDob(dob);
            student.setAddress(address);
            student.setMark(mark);
            studentService.update(id,student);
            request.setAttribute("customer", student);
            request.setAttribute("massage", "Student information was update");
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }private void createStudent(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String address= request.getParameter("address");
        double mark = Double.parseDouble(request.getParameter("mark"));
        int id =(int) (Math.random()*1000);
        Student student= new Student(id,firstName,lastName,dob,address,mark);
        studentService.save(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("massage","New student was created");
        try{
            dispatcher.forward(request,response);
        }
        catch (ServletException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showUpdateForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            case "view":
                viewStudent(req,resp);
                break;
            default:
                listStudent(req,resp);
                break;
        }

    }
    private void viewStudent(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("sudent/view.jsp");
        }try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void showDeleteForm (HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("student",student);
            dispatcher = request.getRequestDispatcher("student/delete.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showUpdateForm(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if(student == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("student",student);
            dispatcher = request.getRequestDispatcher("student/edit.jsp");
        }try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void listStudent(HttpServletRequest request,HttpServletResponse response){
        List<Student> students = studentService.findAll();
        request.setAttribute("studdent", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}