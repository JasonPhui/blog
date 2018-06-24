package cn.ph.blog.core.configurer;

import cn.ph.blog.core.interceptor.Interceptor1;
import cn.ph.blog.core.ret.RetCode;
import cn.ph.blog.core.ret.RetResult;
import cn.ph.blog.core.ret.ServiceException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过继承WebMvcConfigurationSupport类可以修改spingboot中的默认配置
 */
@Configuration
public class Webfigurer extends WebMvcConfigurationSupport {

    private static final Logger logger = LoggerFactory.getLogger(Webfigurer.class);
    /**
     * 自定义消息转换器
     * 增加fastjson消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        FastJsonHttpMessageConverter4 converter4 = new FastJsonHttpMessageConverter4();
        converter4.setSupportedMediaTypes(getSupportedMediaType());
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                //String null -> ""
                SerializerFeature.WriteNullListAsEmpty,
                //Number null -> 0
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                //禁止循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter4.setFastJsonConfig(config);
        converter4.setDefaultCharset(Charset.forName("utf-8"));
        converters.add(converter4);
    }

    /**
     * 配置支持转换的消息格式
     * @return
     */
    private List<MediaType> getSupportedMediaType(){
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }

    /**
     * 添加自定义异常
     */
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers){
        exceptionResolvers.add(getHandlerExceptionResolver());
    }

    /**
     * 创建自定义异常及异常处理
     */
    private HandlerExceptionResolver getHandlerExceptionResolver(){
        HandlerExceptionResolver handlerExceptionResolver = new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
                RetResult<Object> result = getResultByHandleException(httpServletRequest, o, e);
                responseResult(httpServletResponse, result);
                return new ModelAndView();
            }
        };
        return handlerExceptionResolver;
    }

    /**
     * 根据异常类型确定返回数据
     */
    private RetResult<Object> getResultByHandleException(HttpServletRequest request, Object handler, Exception e){
        String message;
        RetResult<Object> result = new RetResult<Object>();
        // 业务失败的异常，如“账号或密码错误”
        if (e instanceof ServiceException) {
            result.setCode(RetCode.FAIL).setMsg(e.getMessage()).setData(null);
        } else if (e instanceof NoHandlerFoundException) {
            result.setCode(RetCode.NOT_FOUND).setMsg("接口 [" + request.getRequestURI() + "] 不存在");
        } else if (e instanceof UnauthorizedException) {
            result.setCode(RetCode.UNAUTHEN).setMsg("用户没有访问权限").setData(null);
        }else if (e instanceof UnauthenticatedException) {
            result.setCode(RetCode.UNAUTHEN).setMsg("用户未登录").setData(null);
        }else if (e instanceof ServletException) {
            result.setCode(RetCode.FAIL).setMsg(e.getMessage());
        } else {
            result.setCode(RetCode.INTERNAL_SERVER_ERROR).setMsg("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(), handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod()
                        .getName(), e.getMessage());
            } else {
                message = e.getMessage();
            }
            // 将异常信息写入日志
            logger.error(message);
        }

        return result;
    }

    /**
     * 响应结果
     */
    private void responseResult(HttpServletResponse response, RetResult<Object> result){
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.setStatus(200);
        try{
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException e){
            //将异常写入日志
            logger.error(e.getMessage());
        }
    }

    /**
     * 在继承WebMvcConfigurationSupport之后，静态文件映射会有问题，所以需要重新指定静态资源路径
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/favicon.ico");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new Interceptor1()).addPathPatterns("/userInfo/selectAll");
        super.addInterceptors(registry);
    }
}
