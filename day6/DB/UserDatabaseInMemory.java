package day6.DB;

import day6.entity.User;

public class UserDatabaseInMemory implements UserDatabase {
    //定义数组模拟数据库功能
    private static final int MAX_SIZE = 1000;
    private static final User[] users = new User[MAX_SIZE];
    private static int index = 0;
    @Override
    public boolean addUser(User user)
    {
        if(index>=MAX_SIZE)
        {
            System.out.println("数据库已满！");
            return false;
        }
        users[index]=user;
        index++;
        user.setId(index);
        System.out.println("添加账号成功！");
        return true;
    }
    @Override
    public User getUserByName(String username)
    {
        if (username == null|| username.isEmpty()) {
            return null;
        }
        for(int i=0;i<index;i++)
        {
            User user=users[i];
            if(user!=null&&username.equals(user.getUsername()))
            {
                System.out.println("用户已存在！");
                return user;
            }
        }
        return null;
    }
}
