package cn.avengers.crud.test;


import cn.avengers.crud.bean.Department;
import cn.avengers.crud.bean.Employee;
import cn.avengers.crud.dao.DepartmentMapper;
import cn.avengers.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐Spring项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直取autowried要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试DepartmentMapper 和 EmployeeMapper
     */
    @Test
    public void testCRUD(){
        /*
        这段代码已经被Spring的Junit测试代替了
        //1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		*/

        //1.插入几个部门
        //departmentMapper.insertSelective(new Department(null,"大数据平台室"));
        //departmentMapper.insertSelective(new Department(null,"大数据应用室"));
        //departmentMapper.insertSelective(new Department(null,"大数据产品室"));
        //departmentMapper.insertSelective(new Department(null,"大数据创新室"));

        //2.批量插入多个员工，批量，使用可以执行批量操作的sqlSession.
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 4; i <1000 ; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@163.com",new Random().nextInt(4)+1));
        }
        System.out.println("批量完成");


    }






}
