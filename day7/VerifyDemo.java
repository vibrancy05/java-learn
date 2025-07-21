package day7;

public class VerifyDemo {
    public static void main(String[] args) {
        testEquals("ABc");
        testIsEmpty("");
        testIsEmpty(" ");//无法正确判断
        testIsBlank(" ");
        testContains("asby");
        testContains("ashby");
        testEndswith("ashby@qq.com");
        testStartsWith("123456");
        testMatches("123456");
    }
    public static void testEquals(String code){
        final String s="ABC";
        if(s.equalsIgnoreCase(code)){
            System.out.println("验证成功");
        }
        else{
            System.out.println("验证失败");
        }
    }
    public static void testIsEmpty(String username){
        if(username.isEmpty()||username==null) {
            System.out.println("用户名不能为空");
        }
        else{
            System.out.println("用户名合法");
        }
    }
    public static void testIsBlank(String username){
        if(username.isBlank()||username==null) {
            System.out.println("用户名不能为空");
        }
        else{
            System.out.println("用户名合法");
        }
    }
    public static void testContains(String username){
        if(username.contains("sb")){
            System.out.println("包含敏感词");
        }
        else{
            System.out.println("用户名合法");
        }
    }
    public static void testEndswith(String username){
        if(username.endsWith("@qq.com")){
            System.out.println("邮箱合法");
        }
        else{
            System.out.println("邮箱不合法");
        }
    }
    public static void testStartsWith(String username){
        if(username.startsWith("1")){
            System.out.println("输入数字合法");
        }
        else{
            System.out.println("输入数字不合法");
        }
    }
    public static void testMatches(String username){
        if(username.matches("[a-zA-Z0-9]{6,}")){
            System.out.println("用户名合法");
        }
        else{
            System.out.println("用户名不合法");
        }
    }
}

