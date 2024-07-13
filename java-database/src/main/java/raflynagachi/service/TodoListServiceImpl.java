package raflynagachi.service;

import raflynagachi.entity.TodoList;
import raflynagachi.repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{
    
    private TodoListRepository todoListRepository;
    
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void showTodoList(){
        TodoList[] todoList = todoListRepository.getAll();
        
        System.out.println("===TODOLIST===");
        for (var todo: todoList) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
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
