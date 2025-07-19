package day6.service;

import day6.DB.UserDatabase;
import day6.Result;
import day6.entity.User;

public class UserServiceImpl implements UserService {
    private UserDatabase UserDB;
    public UserServiceImpl(UserDatabase userDatabase){
        this.UserDB = userDatabase;
    }
    @Override
    public Result Register(String username, String password)
    {
        //1.1校验用户名
        if(isEmptyString( username)){
            return Result.fail("用户名不能为空");
        }
        //1.2校验密码
        if(isEmptyString( password)){
            return Result.fail("密码不能为空");
        }
        //2.校验用户名是否存在
        User user = UserDB.getUserByName(username);
        if(user != null){
            return Result.fail("用户名已存在");
        }
        //3.保存用户
        user =new User(username, password);
        UserDB.addUser(user);
        return Result.ok();
    }
    @Override
    public Result Login(String username, String password)
    {
        if(isEmptyString( username)){
            return Result.fail("用户名不能为空");
        }
        if(isEmptyString( password)){
            return Result.fail("密码不能为空");
        }
        User user = UserDB.getUserByName(username);
        if(user == null){
            return Result.fail("用户不存在");
        }
        if(!user.getPassword().equals(password)){
            return Result.fail("密码错误");
        }
        return Result.ok(user);
    }
    private boolean isEmptyString(String str){
        return str == null || str.equals("");
    }
}
