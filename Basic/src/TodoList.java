public class TodoList {
    public static String[] data = new String[3];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        addTodoList("mantap");
        addTodoList("jiwa");
        addTodoList("barudak");
        addTodoList("cihuy");
        testViewTodoList();
    }

    public static void showTodoList() {
        System.out.println("===TODOLIST===");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + 1 + ". " + data[i]);
            }
        }
        System.out.println("==============");
    }

    public static void testShowTodoList() {
        data[0] = "mantap";
        data[1] = "jiwa";
        showTodoList();
    }

    public static void addTodoList(String newTodo) {
        boolean isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                data[i] = newTodo;
                break;
            }
        }
        if (isFull) {
            var tmp = data;
            data = new String[data.length * 2];
            System.arraycopy(tmp, 0, data, 0, tmp.length);
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    data[i] = newTodo;
                    break;
                }
            }
        }
    }

    public static void testAddTodoLits() {
        addTodoList("mantap");
        addTodoList("jiwa");
        addTodoList("barudak");
        addTodoList("IT");
        showTodoList();
    }

    public static boolean removeTodoList(int number) {
        number -= 1;
        if (number >= data.length) {
            return false;
        } else if (data[number] == null) {
            return false;
        }
        data[number] = null;
        for (int i = number; i < data.length; i++) {
            if (i == data.length - 1) {
                break;
            }
            data[i] = data[i + 1];
        }
        return true;
    }

    public static void testRemoveTodoList() {
        addTodoList("mantap");
        addTodoList("jiwa");
        addTodoList("barudak");
        var ok = removeTodoList(20);
        System.out.println("is removed: " + ok);
        ok = removeTodoList(3);
        System.out.println("is removed: " + ok);
        ok = removeTodoList(3);
        System.out.println("is removed: " + ok);
        showTodoList();
    }

    public static String input(String placeholder) {
        System.out.print(placeholder + ": ");
        return scanner.nextLine();
    }

    public static void testInput() {
        String name = input("what is your name");
        System.out.println("your name is " + name);
    }

    public static void viewShowTodoList() {
        boolean run = true;
        while (run) {
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. add todo");
            System.out.println("2. remove todo");
            System.out.println("3. quit");

            var command = input("Command: ");
            switch (command) {
                case "1" -> viewAddTodoList();
                case "2" -> viewRemoveTodoList();
                case "3" -> run = false;
                default -> System.out.println("invalid command");
            }
        }
    }

    public static void testViewTodoList() {
        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        System.out.println("Add todo");
        var todo = input("input todo");
        if (todo.equals("x")) {
            System.out.println("abort add todo");
            // FAILED TO ADD
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        viewShowTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("Remove todo");
        var numberStr = input("removed todo number");

        if (numberStr.equals("x")) {
            System.out.println("abort remove data");
            // FAILED TO REMOVE
        } else {
            int number = Integer.parseInt(numberStr);
            if (removeTodoList(number)) {
                System.out.println("todo successfully removed");
            } else {
                System.out.println("failed to remove todo");
            }
        }
    }

    public static void testViewRemoveTodoList() {
        viewShowTodoList();
        viewRemoveTodoList();
    }

}
