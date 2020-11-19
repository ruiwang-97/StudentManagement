package sm.service;

import sm.dao.ManagerDao;

/***
 * @Description: 提供管理员登录的方法
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */
public class managerService {
    ManagerDao dao = new ManagerDao();

//登录验证
    public boolean login(String username,String password){

        Long count =  (Long)dao.scalar("select count(*) from manager where username=? and pword=?", username,password);
        return count > 0;
    }


}
