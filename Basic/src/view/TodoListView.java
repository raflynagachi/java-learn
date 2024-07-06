package view;

import service.TodoListService;
import util.Input;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        boolean run = true;
        while (run) {
            todoListService.showTodoList();

            System.out.println("MENU");
            System.out.println("1. add todo");
            System.out.println("2. remove todo");
            System.out.println("3. quit");

            var command = Input.input("Command: ");
            switch (command) {
                case "1" -> addTodoList();
                case "2" -> removeTodoList();
                case "3" -> run = false;
                default -> System.out.println("invalid command");
            }
        }
    };

    public void addTodoList(){
        System.out.println("Add todo");
        var todo = Input.input("input todo");
        if (todo.equals("x")) {
            System.out.println("abort add todo");
            // FAILED TO ADD
        } else {
            todoListService.addTodoList(todo);
        }
    };

    public void removeTodoList(){
        System.out.println("Remove todo");
        var numberStr = Input.input("removed todo number");

        if (numberStr.equals("x")) {
            System.out.println("abort remove data");
            // FAILED TO REMOVE
        } else {
            int number = Integer.parseInt(numberStr);
            todoListService.removeTodoList(number);
        }
    };

}
