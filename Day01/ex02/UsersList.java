public interface UsersList {
    public void addUser(User user);

    public User getUserById(Integer id);

    public User getUserByIndex(int index);

    public Integer getCountUsers();
}
