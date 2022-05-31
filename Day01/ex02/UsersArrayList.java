public class UsersArrayList implements UsersList {
    private User[] arrayUsers;
    private static Integer countUsers;
    private static Integer sizeArray;

    public UsersArrayList() {
        sizeArray = 10;
        arrayUsers = new User[sizeArray];
        countUsers = 0;
    }

    @Override
    public void addUser(User user) {
        if (countUsers == sizeArray) {
            User[] tmp = new User[sizeArray];
            for (int i = 0; i < sizeArray; i++) {
                tmp[i] = arrayUsers[i];
            }
            arrayUsers = new User[2 * sizeArray];
            for (int i = 0; i < sizeArray; i++) {
                arrayUsers[i] = tmp[i];
            }
            sizeArray *= 2;
        }
        for (int i = 0; i < sizeArray; i++) {
            if (arrayUsers[i] == null) {
                arrayUsers[i] = user;
                countUsers++;
                break;
            }
        }
    }

    @Override
    public User getUserById(Integer id) {

        for (int i = 0; i < countUsers; i++) {
            if (arrayUsers[i].getId() == id) {
                return arrayUsers[i];
            }
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public User getUserByIndex(int index) {
        if (index >= 0 && index < sizeArray && arrayUsers[index] != null) {
            return arrayUsers[index];
        }
        return null;
    }

    @Override
    public Integer getCountUsers() {
        return countUsers;
    }

    @Override
    public String toString() {
        return "UsersArrayList{" +
                "countUser=" + countUsers +
                ", sizeArray=" + sizeArray +
                '}';
    }
}
