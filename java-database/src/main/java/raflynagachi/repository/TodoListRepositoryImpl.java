package raflynagachi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import raflynagachi.entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TodoList[] getAll() {
        String sql = "SELECT id, todo, created_at, created_by FROM todolist";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(sql);
                ResultSet resultSet = prepStmt.executeQuery()) {

            List<TodoList> list = new ArrayList<>();
            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));
                todoList.setCreatedAt(resultSet.getString("created_at"));
                todoList.setCreatedBy(resultSet.getString("created_by"));

                list.add(todoList);
            }

            return list.toArray(new TodoList[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(TodoList todo) {
        String sql = "INSERT INTO todolist (todo, created_by) VALUES(?,?)";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            prepStmt.setString(1, todo.getTodo());
            prepStmt.setString(2, "SYSTEM");
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExist(Integer id) {
        String sql = "SELECT id FROM todolist WHERE id=?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            prepStmt.setInt(1, id);
            try (ResultSet resultSet = prepStmt.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
                return false;
            } catch (SQLException e) {
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(Integer id) {
        if (!isExist(id)) {
            return false;
        }

        String sql = "DELETE FROM todolist WHERE id=?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
