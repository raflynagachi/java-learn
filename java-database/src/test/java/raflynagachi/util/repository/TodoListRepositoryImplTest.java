package raflynagachi.util.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import raflynagachi.entity.TodoList;
import raflynagachi.repository.TodoListRepository;
import raflynagachi.repository.TodoListRepositoryImpl;
import raflynagachi.util.DatabaseUtil;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setup() {
        dataSource = DatabaseUtil.getHikariDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

    @Test
    void testAdd() {
        TodoList todolist = new TodoList();
        todolist.setTodo("learning java for 3 hour");
        todolist.setCreatedBy("raflynagachi");

        todoListRepository.add(todolist); // validate in DB
    }

    @Test
    void testRemove() {
        TodoList todolist = new TodoList();
        todolist.setTodo("learning java for 5 hour");
        todolist.setCreatedBy("raflynagachi");

        TodoList todolist2 = new TodoList();
        todolist2.setTodo("learning golang for 5 hours");
        todolist2.setCreatedBy("raflynagachi");

        todoListRepository.add(todolist);
        todoListRepository.add(todolist2);

        boolean actual = todoListRepository.remove(1); // true
        boolean actual2 = todoListRepository.remove(1); // false

        System.out.println("test remove: " + actual);
        System.out.println("test remove2: " + actual2);
    }

    @Test
    void testGet() {
        TodoList[] res = todoListRepository.getAll();
        for (var todo : res) {
            System.out.println(todo.getId() + " : " + todo.getTodo() + " by " + todo.getCreatedBy());
        }
    }
}
