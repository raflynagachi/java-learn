package raflynagachi;

import javax.sql.DataSource;

import raflynagachi.repository.TodoListRepository;
import raflynagachi.repository.TodoListRepositoryImpl;
import raflynagachi.service.TodoListService;
import raflynagachi.service.TodoListServiceImpl;
import raflynagachi.util.DatabaseUtil;
import raflynagachi.view.TodoListView;

public class TodoListV2 {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getHikariDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
