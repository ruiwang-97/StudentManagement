package sm.domain;

/***
 * @Description: 管理员类 id,username,pword
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */
public class Manager {
    private int id;
    private String username;
    private String pword;

    public Manager() {
    }

    public Manager(int id, String username, String pword) {
        this.id = id;
        this.username = username;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pword='" + pword + '\'' +
                '}';
    }
}
