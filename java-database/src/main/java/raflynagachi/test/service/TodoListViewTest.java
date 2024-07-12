package raflynagachi.test.service;

import raflynagachi.repository.TodoListRepository;
import raflynagachi.repository.TodoListRepositoryImpl;
import raflynagachi.service.TodoListService;
import raflynagachi.service.TodoListServiceImpl;
import raflynagachi.view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        testViewTodoList();
        // testAddTodoList();
        // testRemoveTodoList();
    }

    public static void testViewTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Learn Java");
        todoListService.addTodoList("Learn Golang");

        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListView.addTodoList();

        todoListView.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListView.addTodoList();
        todoListView.removeTodoList();

        todoListView.showTodoList();
    }
}
