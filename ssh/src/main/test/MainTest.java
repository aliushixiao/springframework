import com.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MainTest {
    @Autowired
    HibernateTemplate hibernateTemplate;


    @Test
    public void testGet(){
        Student student = hibernateTemplate.get(Student.class, 1);
        System.out.println(student);
    }

}