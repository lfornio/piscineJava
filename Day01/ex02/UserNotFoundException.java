public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("User not found: " + id);
    }
}

