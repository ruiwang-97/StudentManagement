package sm.domain;

/***
 * @Description: 学生类  id,stunumber,stuname,gender,grade,tel,email,birth
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */
public class Student {
    private int id;
    private String stunumber;//学号
    private String stuname;
    private String gender;
    private String grade;//年级
    private String tel;
    private String email;
    private String birth;

    public Student() {
    }

    public Student(int id, String stunumber, String stuname, String gender, String grade, String tel, String email, String birth) {
        this.id = id;
        this.stunumber = stunumber;
        this.stuname = stuname;
        this.gender = gender;
        this.grade = grade;
        this.tel = tel;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStunumber() {
        return stunumber;
    }

    public void setStunumber(String stunumber) {
        this.stunumber = stunumber;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return stunumber + "\t" +
                 stuname + "\t" +
                 gender + "\t" +
                 grade + "\t" +
                 tel + "\t"+
                 email + "\t" +
                 birth;

    }
}
