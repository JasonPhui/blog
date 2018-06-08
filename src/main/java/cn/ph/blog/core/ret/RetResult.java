package cn.ph.blog.core.ret;

/**
 * 返回对象实体
 * @param <T>
 */
public class RetResult<T> {

    //状态码
    private int code;

    //提示信息
    private String msg;

    //返回的数据
    private T data;

    public RetResult<T> setCode(RetCode retCode){
        this.code = retCode.code;
        return this;
    }

    public int getCode(){
        return code;
    }

    public RetResult<T> setCode(int code){
        this.code = code;
        return this;
    }

    public String getMsg(){
        return msg;
    }

    public RetResult<T> setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public T getData(){
        return data;
    }

    public RetResult<T> setData(T data){
        this.data = data;
        return this;
    }
}
