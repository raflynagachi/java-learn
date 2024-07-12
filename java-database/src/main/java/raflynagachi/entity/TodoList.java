package raflynagachi.entity;

public class TodoList {
    private String todo;

    public TodoList() {
    }

    public TodoList(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return this.todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
