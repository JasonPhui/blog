package cn.ph.blog.core.ret;

public class RetResponse {

    private final static String SUCCESS="success";

    public static <T> RetResult<T> makeOKRsp(){
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeOKRsp(T data){
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> makeErrRsp(){
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg){
        return new RetResult<T>().setCode(code).setMsg(SUCCESS).setMsg(msg);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data){
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
