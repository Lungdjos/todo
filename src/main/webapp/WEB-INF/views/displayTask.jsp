<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8">
    <title>Availabe Todos</title>
    <!-- css link bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <!-- javascript link -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
</head>
<body class="m-5">
    <div id="" class="align-items-right">
        <a href="/logout"><button type="button" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left"></i>Logout</button></a>
    </div>
    <h2 class="my-4">Availabe Todo List</h2>
    <br>
    <a href="todo/addTodo"><button type="button" class="btn btn-outline-primary">Add TODO</button></a>
    <br>

    <table class="table">
        <thead class="thead-dark">
            <tr>
              <th scope="col">No.</th>
              <th scope="col">Task</th>
              <th scope="col">Status</th>
              <th scope="col">Start Date</th>
              <th scope="col">End Date</th>
              <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tasks}" var="todos">
                <tr>
                    <td scope="row">${todos.id}</td>
                    <td>${todos.task}</td>
                    <td>
                    <c:if test="${todos.status eq false}">
                         Pending
                    </c:if>
                     <c:if test="${todos.status eq true}">
                        Completed
                     </c:if>
                    </td>
                    <td>${todos.startDate}</td>
                    <td>${todos.endDate}</td>
                    <td>
                        <a href="todo/updateTask?taskId=${todos.id}"><button type="" value="updateTodo" class="btn btn-primary btn-sm" id=""><i class="bi bi-pencil-fill"></i></button></a>
                        <a href="todo/deleteTask?taskId=${todos.id}"><button type="" value="deleteTask" class="btn btn-danger btn-sm" id=""><i class="bi bi-trash"></i></button></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>