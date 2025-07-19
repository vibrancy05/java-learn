package day6;

import day6.DB.UserDatabase;
import day6.DB.UserDatabaseInMemory;
import day6.entity.User;
import day6.service.UserService;
import day6.service.UserServiceImpl;
import day6.ui.UserCMDUI;
import day6.ui.UserUI;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("程序启动！");
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUser(new user("admin","123456"));
        User user=userDatabase.getUserByName("admin");
        if(user==null){
            System.out.println("用户不存在！");
            return;
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println("程序结束！");
        System.out.println("-----------------------------");
        System.out.println("用户登录测试：");
        UserService userService = new UserService();
        Result r=userService.Register("vibrancy","123456");
        System.out.println(r.getMsg());
        if(r.getCode()==0){
            System.out.println("注册成功！");
        }
        Result result = userService.Login("vibrancy","123456");
        if(result.getCode()==0){
            System.out.println("登录成功！");
            //获取用户名
            User u=(User)result.getData();
            System.out.println("用户名："+u.getUsername());
            System.out.println("用户ID："+u.getId());
        }*/
        UserDatabase db = new UserDatabaseInMemory();
        UserService service = new UserServiceImpl(db);
        UserUI userUI = new UserUI(service);
        userUI.entrance();
        System.out.println("程序结束！");
    }
}
