package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        //加载mybatis的配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        //释放资源
        session.close();
        in.close();

    }

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run2() throws Exception{
        Account account = new Account();
        account.setName("小红");
        account.setMoney(400d);
        //加载mybatis的配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //释放资源
        session.close();
        in.close();

    }
}
