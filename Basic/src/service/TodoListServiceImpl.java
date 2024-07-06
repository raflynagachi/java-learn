package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{
    
    private TodoListRepository todoListRepository;
    
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void showTodoList(){
        TodoList[] todoList = todoListRepository.getAll();
        
        System.out.println("===TODOLIST===");
        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] != null) {
                System.out.println(i + 1 + ". " + todoList[i].getTodo());
            }
        }
        System.out.println("==============");
    }

    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    public void removeTodoList(Integer id) {
        boolean ok = todoListRepository.remove(id);
        if (ok) {
            System.out.println("success remove todolist: "+id);
        } else {
            System.out.println("failed remove todolist: "+id);
        }
    };
}
