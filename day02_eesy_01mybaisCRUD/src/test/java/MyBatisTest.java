import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author ：X H
 * @version :
 * @date ：Created in 2020/3/5 13:39
 * @description：
 * @modified By：
 */
public class MyBatisTest {
    private  InputStream in;
    private  SqlSession sqlSession;
    private  IUserDao userDao;

    @Before  //用于在测试方法完成之前
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.创建dao代理对象
        userDao=sqlSession.getMapper(IUserDao.class);
    }

    @After  //用于在测试方法完成之后
    public void destroy() throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        //5.使用代理对象进行操作
        List<User> users=userDao.findAll();
        for(User i:users)
        {
            System.out.println(i);
        }

    }

    //测试保存操作
    @Test
    public void testSave() {
        User user=new User();
        user.setUserId(100);
        user.setUserAddress("浙江台州");
        user.setUserSex('男');
        user.setUserName("lxh");
        user.setUserBirthday(new Date());

        //使用dao对象调用方法
        userDao.saveUser(user);


    }

    //用于更新用户操作
    @Test
    public void testUpdate(){
        User user=new User();
        user.setUserId(100);
        user.setUserAddress("浙江杭州");
        user.setUserSex('男');
        user.setUserName("lrw");
        user.setUserBirthday(new Date());



        //使用dao对象调用方法
        userDao.updateUser(user);
    }

    //根据id删除用户操作
    @Test
    public void testDelete(){

        //使用dao对象调用方法
        userDao.deleteUser(26);
    }

    //根据用户id查找用户操作
    @Test
    public void findById(){

        //使用dao对象调用方法
        User user = userDao.findById(25);
        System.out.println(user.toString());
    }

    //根据用户名称查找用户操作
    @Test
    public void findByUserName(){

        //使用dao对象调用方法
        List<User> users = userDao.findByUserName("%小明%");
        for(User user:users)
        {
            System.out.println(user);
        }
    }



    //根据QueryVo的条件查询用户
    @Test
    public void findByQueryVo(){

        User u1 = new User();
        u1.setUserName("%三丰%");
        QueryVo vo = new QueryVo();
        vo.setUser(u1);
        //使用dao对象调用方法
        User user = userDao.findByQueryVo(vo);
        System.out.println(user);
    }
}
