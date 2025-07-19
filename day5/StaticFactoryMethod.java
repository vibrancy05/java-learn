package day5;

public class StaticFactoryMethod {
    public static void main(String[] args)
    {
    }
    public static StuResult queryStudentById(int id)
    {
        //1.查询失败，null代表空
        if(id<0){
        return StuResult.fail("id cannot be less than 0");
        }
        //2.查询成功，返回结果
        Student student = new Student("小明",id,"男",18);
        return StuResult.ok(student);
    }
    public static StuResult deleteById(int id){
        if(id<0){
            //1.删除失败，null代表空
        return StuResult.fail("id cannot be less than 0");
        }
        //2.删除成功，没有结果
        return StuResult.ok();
    }
}
