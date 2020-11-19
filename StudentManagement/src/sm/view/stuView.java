package sm.view;

import org.junit.Test;
import sm.dao.StuDao;
import sm.domain.Student;
import sm.service.managerService;
import sm.service.studentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/***
 * @Description:
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */
public class stuView {
    //登陆界面显示
    managerService ms = new managerService();
    studentService ss = new studentService();

    public static void main(String[] args) {
        new stuView().login();
    }

    /**
     * 登录界面显示
     */
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();

        if(ms.login(username, password)){
            System.out.println("登录成功！");
            System.out.println();
        showMainMenu();
        }else{
            System.out.println("登录失败！");
        }

    }

    /**
     * 功能：显示主菜单
     */
    private void showMainMenu() {
        boolean loopFlag = true;
        char key = 0;

        do {
            init();
            key = TSUtility.readMenuSelection();
            System.out.println();

            switch (key) {
                case '1':
                    System.out.println("当前学生人数为：" + ss.nums());
                    System.out.println();
                    break;
                case '2':
                    listStudents();
                    break;
                case '3':
                    queryByStuNumber();
                    break;
                case '4':
                    queryByStuName();
                    break;
                case '5':
                    deleteByStuName();
                    break;
                case '6':
                    changeGrade();
                    break;
                case '7':
                    addStudent();
                    break;
                case '8':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    private void addStudent() {
        System.out.println("===================添加操作================");
        System.out.print("请输入学生序号：");
        int id = TSUtility.readInt();
        System.out.print("请输入学生学号：");
        String stuNumber = TSUtility.readString();
        System.out.print("请输入学生姓名：");
        String stuName = TSUtility.readString();
        System.out.print("请输入学生性别：");
        String gender = TSUtility.readString();
        System.out.print("请输入学生年级：");
        String grade = TSUtility.readString();
        System.out.print("请输入学生电话：");
        String tel = TSUtility.readString();
        System.out.print("请输入学生邮箱：");
        String email = TSUtility.readString();
        System.out.print("请输入学生出生日期:");
        String birth = TSUtility.readString();

        if (ss.addStu(id,stuNumber, stuName, gender, grade, tel, email, birth) > 0) {
            System.out.print("确认是否添加(Y/N)：");
            char yn = TSUtility.readConfirmSelection();
            if (yn == 'N')
                return;
            System.out.println("添加成功");
        } else
            System.out.println("添加失败，请重新操作！");
    }


    private void changeGrade() {
        System.out.println("===================修改操作================");
        System.out.print("请输入学生学号：");
        String s = TSUtility.readString();
        System.out.print("请输入修改后的年级：");
        String newGrade = TSUtility.readString();
        if (ss.changeStu(s,newGrade) > 0) {
            System.out.print("确认是否修改(Y/N)：");
            char yn = TSUtility.readConfirmSelection();
            if (yn == 'N')
                return;
            System.out.println("修改成功");
        } else
            System.out.println("修改失败，请重新操作！");
    }


    private void deleteByStuName() {
        System.out.println("===================删除操作================");
        System.out.print("请输入学生学号：");
        String s = TSUtility.readString();
        System.out.print("确认是否删除(Y/N)：");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N')
            return;
        else if(yn == 'Y') {
            if (ss.deleteStu(s) > 0) {
                System.out.println("删除成功");
            }
            else
                System.out.println("输入信息错误，请重新操作！");
        }else
            System.out.println("删除失败，请重新操作！");
    }

    private void queryByStuName() {
        System.out.println("===================查询操作================");
        System.out.print("请输入学生姓名：");
        String s = TSUtility.readString();
        Student s1 = ss.queryByStuName(s);
        if (s1 != null) {
            System.out.println("学号\t姓名\t性别\t年级\t电话\t邮箱\t出生日期");
            System.out.println(s1);
        } else
            System.out.println("查询失败，请重新操作");

    }

    private void queryByStuNumber() {
        System.out.println("===================查询操作================");
        System.out.print("请输入学生学号：");
        String s = TSUtility.readString();
        String s1 = ss.queryByStuNumber(s);
        if (s1 != null) {
            System.out.println(s1);
        } else {
            System.out.println("查询失败,请重新操作");
        }
    }

    private void init() {
        System.out.println("===================请选择操作键================");
        System.out.println("1、统计学生人数");
        System.out.println("2、查看学生名单");
        System.out.println("3、按学号查询学生姓名");
        System.out.println("4、按姓名查询学生信息");
        System.out.println("5、删除学生记录");
        System.out.println("6、修改学生年级");
        System.out.println("7、添加学生");
        System.out.println("8、退出");
        System.out.println();
    }


    public void listStudents() {
        System.out.println("-------------------------------学生列表-----------------------------");
        List<Student> allStudents = ss.getAllStudents();
        if (allStudents.size() == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("学号\t姓名\t性别\t年级\t电话\t邮箱\t出生日期");
        }

        for (Student e : allStudents) {
            System.out.println(e.getStunumber() + "\t" + e.getStuname()  + "\t" + e.getGender() + "\t"
            + e.getGrade() + "\t" + e.getTel() + "\t" + e.getEmail() + "\t" + e.getBirth());
        }
        System.out.println();
    }
}

