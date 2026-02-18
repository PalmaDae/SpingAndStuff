import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserService service = context.getBean(UserService.class);

        User user = new User(1L, "Dams");

        service.addUser(user);
        service.getUser(1L);
        service.updateUser(1L, "Smad");
        service.deleteUser(user);
    }
}
