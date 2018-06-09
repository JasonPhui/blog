package cn.ph.blog.core.configurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过继承WebMvcConfigurationSupport类可以修改spingboot中的默认配置
 */
public class Webfigurer extends WebMvcConfigurationSupport {

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
        supportedMediaTypes.add(MediaType.ALL);
        return supportedMediaTypes;
    }
}
