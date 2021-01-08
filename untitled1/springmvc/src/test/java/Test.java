import demo.domain.User;

public class Test {
    @org.junit.Test
    public void t1(){
        User user = new User();
        System.out.println(user.getRoleCount());

        System.out.println(user.getRoles());
    }
}
