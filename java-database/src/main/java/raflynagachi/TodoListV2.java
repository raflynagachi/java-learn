package raflynagachi;

import raflynagachi.repository.TodoListRepository;
import raflynagachi.repository.TodoListRepositoryImpl;
import raflynagachi.service.TodoListService;
import raflynagachi.service.TodoListServiceImpl;
import raflynagachi.view.TodoListView;

public class TodoListV2 {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
