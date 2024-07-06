package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testShowTodoList();
        testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListRepository.add(new TodoList("Learning Java part 1"));
        todoListRepository.add(new TodoList("Learning Java part 2"));
        todoListRepository.add(new TodoList("Learning Java part 3"));

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Going to town");
        todoListService.addTodoList("Buy PS5");
        todoListService.addTodoList("Play RDR2 all day");
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Going to town");
        todoListService.addTodoList("Buy PS5");
        todoListService.addTodoList("Play RDR2 all day");
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
    }
}
