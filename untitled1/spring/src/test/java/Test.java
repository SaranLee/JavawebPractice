import demo.controller.StudentController;
import demo.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("spring-config.xml");
        Student stu1 = (Student) container.getBean("stu1");
        Student stu2 = (Student) container.getBean("stu2");
        System.out.println(stu1);
        System.out.println(stu2);

        Student stu5 = (Student) container.getBean("stu5");
        System.out.println(stu5.getMap().get(1));
        System.out.println(stu5.getMap().get(2));
        System.out.println(stu5.getMap().get(3));

        Student prop = (Student) container.getBean("prop");
        System.out.println("prop.driver = " + prop.getName());

        StudentController controller = (StudentController) container.getBean(StudentController.class);
        System.out.println(controller.getService());
    }
}
