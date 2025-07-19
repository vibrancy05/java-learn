package day5;

public class StuResult {
    private int code;
    private String msg;
    private Object data;
    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final String OK_MSG = "ok";
    public StuResult(int code, String msg, Object data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static StuResult ok(Object data){
        return new StuResult(OK, OK_MSG, data);
    }
    //方法的重载
    public static StuResult ok(){
        return new StuResult(OK, OK_MSG, null);
    }
    public static StuResult fail(String msg){
        return new StuResult( FAIL, msg, null);
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
