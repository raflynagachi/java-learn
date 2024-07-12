package raflynagachi.repository;

import raflynagachi.entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();
    void add(TodoList todo);
    boolean remove(Integer id);
}
