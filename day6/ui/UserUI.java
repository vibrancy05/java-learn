package day6.ui;

import day6.Result;
import day6.service.UserService;
import day6.service.UserServiceImpl;

import java.util.Scanner;

public class UserUI implements UserCMDUI {
    private Scanner sc=new Scanner(System.in);
    private UserService userService;

    public UserUI(UserService service) {
        this.userService = service;
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void entrance(){
        while( true){
        System.out.println("欢迎来到用户管理系统");
        System.out.println("1.注册");
        System.out.println("2.登录");
        System.out.println("3.退出");
        System.out.print("请选择：");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("注册");
                registerUI();
                break;
            case 2:
                System.out.println("登录");
                loginUI();
                return;
            case 3:
                System.out.println("退出");
                return;
            default:
                System.out.println("无效的选择，请重新输入");
                entrance();
        }
        }
    }

    private void loginUI() {
        while(true){
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            Result result = userService.Login(username, password);
            if(result.getCode()==0){
                System.out.println("登录成功！");
                return;
            }
            System.out.println("登录失败"+result.getMsg());
            //询问是否重试
            System.out.println("是否重试？y/n");
            String retry = sc.next();
            if(retry.equals("n")){
                return;
            }
        }
    }

    private void registerUI() {
        while(true){
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请输入确认密码：");
            String confirmPassword = sc.next();
            if(username==null||password==null||confirmPassword==null){
                System.out.println("用户名或密码不能为空，请重新输入");
                continue;
            }
            if(!password.equals(confirmPassword)){
                System.out.println("密码不一致，请重新输入");
                continue;
            }
            Result result = userService.Register(username, password);
            if(result.getCode()==0){
                System.out.println("注册成功！");
                return;
            }
            System.out.println("注册失败"+result.getMsg());
            //询问是否重试
            System.out.println("是否重试？y/n");
            String retry = sc.next();
            if(retry.equals("n")){
                return;
            }
        }
    }
}
