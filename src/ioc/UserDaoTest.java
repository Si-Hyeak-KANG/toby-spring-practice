package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // ApplicationContext를 구현한 클래스는 여러가지
        // 그중 @Configuration이 붙은 자바 코드를 설정 정보로 사용하려면 AnnotationConfigApplicationContext() 사용
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);

        // getBean()은 원래 Object 타입을 반환
        // java5 이상부터 제네릭 메소드 방식을 활용하여, 두번째 파라미터에 타입 지정
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("1");
        user.setName("name");
        user.setPassword("password");
        dao.add(user);

        User getUser = dao.get("1");
        System.out.println(getUser.getName());
    }
}
