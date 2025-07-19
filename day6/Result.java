package day6;

public class Result {
    private int code;
    private String msg;
    private Object data;
    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final String OK_MSG = "ok";
    public Result(int code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static Result ok(Object data){
        return new Result(OK, OK_MSG, data);
    }
    //方法的重载
    public static Result ok(){
        return new Result(OK, OK_MSG, null);
    }
    public static Result fail(String msg){
        return new Result( FAIL, msg, null);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
