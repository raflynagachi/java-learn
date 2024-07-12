package raflynagachi.repository;

import raflynagachi.entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    private TodoList[] todoList = new TodoList[10];

    public TodoList[] getAll() {
        return this.todoList;
    }

    public void add(TodoList todo) {
        boolean isFull = true;
        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                isFull = false;
                todoList[i] = todo;
                break;
            }
        }
        if (isFull) {
            var tmp = todoList;
            todoList = new TodoList[todoList.length * 2];
            System.arraycopy(tmp, 0, todoList, 0, tmp.length);
            for (int i = 0; i < todoList.length; i++) {
                if (todoList[i] == null) {
                    todoList[i] = todo;
                    break;
                }
            }
        }
    }

    public boolean remove(Integer id) {
        id -= 1;
        if (id >= todoList.length) {
            return false;
        } else if (todoList[id] == null) {
            return false;
        }
        todoList[id] = null;
        for (int i = id; i < todoList.length; i++) {
            if (i == todoList.length - 1) {
                break;
            }
            todoList[i] = todoList[i + 1];
        }
        return true;
    }
    
}
