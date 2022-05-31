public class UserIdsGenerator {
    private static UserIdsGenerator generator;
    private static Integer count = 0;

    private UserIdsGenerator() {

    }

    public static UserIdsGenerator getInstance() {
        if (generator == null) {
            generator = new UserIdsGenerator();
        }
        return generator;
    }

    public Integer generateId() {
        count++;
        return count;
    }
}
