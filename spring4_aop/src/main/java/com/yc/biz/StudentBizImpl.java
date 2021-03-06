package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-04 14:45
 */
@Service
public class StudentBizImpl implements StudentBiz{

    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public StudentBizImpl(){}

    //@Inject  //javax中的依赖注入 ，如果有多个对象，（比如这里有StudentDaoJpaImpl 和StudentDaoMybatisImpl对象）
    //因为有多个对象可以注入，所以这里必须用@Named("studentDaoJpaImpl"),如只有一个对象，则不需要写
    //@Autowired  //org.springframework
    //@Qualifier("studentDaoJpaImpl")  //如果有多个对象，（比如这里有StudentDaoJpaImpl 和StudentDaoMybatisImpl对象）
    //因为有多个对象可以注入，如只有一个对象，则不需要写
    @Resource(name="studentDaoJpaImpl")
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public int add(String name){
        System.out.println("add业务层======");
        System.out.println("用户是否重名");
        int result=studentDao.add(name);
        System.out.println("业务层结束=====");
        return result;
    }

    public void update(String name){
        System.out.println("update业务层=====");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("业务操作结束");
    }

    public void find(String name){
        System.out.println("find业务层=====");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("业务操作结束");
    }
}
