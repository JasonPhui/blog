package cn.ph.blog.core.ret;

import java.io.Serializable;

/**
 * 业务类异常
 */
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID=1213855733822029552L;

    public ServiceException(){

    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }

}
