package sm.service;

import sm.dao.StuDao;
import sm.domain.Student;

import java.util.Date;
import java.util.List;

/***
 * @Description: 此类用于
 * 2、统计学生人数
 * 3、返回学生列表
 * 4、按学号查询学生
 * 5、按姓名查询学生
 * 6、修改学生
 * 7、删除学生
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */
public class studentService {
    StuDao dao = new StuDao();

    //返回学生人数
    public int nums(){
        Long longnums = (Long) dao.scalar("select count(*) from stu");
        int nums = longnums.intValue();
        return nums ;
    }
    //返回学生列表
    public List<Student> getAllStudents(){
        List<Student> students = dao.queryMulti("select * from stu",Student.class);
        return students;
    }
    //3、按学号查询学生姓名
    public String queryByStuNumber(String stunumber){
        return (String) dao.scalar("select stuname from stu where stunumber = ?", stunumber);

    }
    //4、按姓名查询学生信息
    public Student queryByStuName(String stuName){
        return dao.querySingle("select * from stu where stuname like ?", Student.class, "%"+stuName+"%");

    }
    //5.删除学生记录
    public int deleteStu(String stunumber){
        return dao.update("delete from stu where stunumber = ?", stunumber);
    }
    //6.修改学生年级
    public int changeStu(String stunumber,String newGrade){
       return dao.update("update stu set grade = ? where stunumber = ?",newGrade,stunumber);
    }
    //7.添加学生
    public int addStu(int id, String stunumber, String stuname, String gender, String grade, String tel, String email, String birth){
       return dao.update(
                "insert into stu values(?,?,?,?,?,?,?,?)",id,stunumber,stuname,gender,grade,tel,email,birth);

    }

}
