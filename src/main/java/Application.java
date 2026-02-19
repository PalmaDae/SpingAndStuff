import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");

        UserService service = context.getBean(UserService.class);

        User dams = new User("Dams");
        service.addUser(dams);
        User fakeDams = service.getUser(1L);
        service.updateUser(1L, "FakeDams");
        service.deleteUser(fakeDams);
    }
}
