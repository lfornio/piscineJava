public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "PRINT ARRAY INFO" + ANSI_RESET);
        UsersArrayList arrUsers = new UsersArrayList();
        System.out.println(arrUsers.toString());

        System.out.println(ANSI_BLUE + "ADD USERS" + ANSI_RESET);
        for (int i = 0; i < 15; i++) {
            arrUsers.addUser(new User("AAAA_" + i, 1000 * i));
        }
        for (int i = 0; i < arrUsers.getCountUsers(); i++) {
            System.out.println(arrUsers.getUserByIndex(i).toString());
        }

        System.out.println(ANSI_BLUE + "PRINT ARRAY INFO" + ANSI_RESET);
        System.out.println(arrUsers.toString());

        System.out.println(ANSI_BLUE + "PRINT COUNT USERS" + ANSI_RESET);
        System.out.println(arrUsers.getCountUsers());

        System.out.println(ANSI_BLUE + "GET BY INDEX" + ANSI_RESET);
        User a = arrUsers.getUserByIndex(4);
        if (a != null) {
            System.out.println(a.toString());
        }
        User b = arrUsers.getUserByIndex(19);
        if (b != null) {
            System.out.println(a.toString());
        }
        System.out.println(ANSI_BLUE + "GET BY ID" + ANSI_RESET);
        System.out.println(arrUsers.getUserById(1).toString());
        System.out.println(arrUsers.getUserById(14).toString());
        System.out.println(arrUsers.getUserById(29).toString());

    }
}
