import controllers.UserController;
import org.junit.jupiter.api.Test;

class ExampleTest {

    @Test
    void test(){
        System.out.println(System.getProperty("host"));
        UserController.getUsers();
//        sum("4");
    }

    void sum(String str, Object ... args) {
        System.out.println(args);
        System.out.println(str);
    }
}
