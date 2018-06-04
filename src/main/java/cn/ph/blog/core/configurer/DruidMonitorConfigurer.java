package cn.ph.blog.core.configurer;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Druid监控配置
 */
@Configuration
public class DruidMonitorConfigurer {
    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        /** 初始化参数设置，initParams**/
        // 白名单
        bean.addInitParameter("allow", "127.0.0.1");
        //IP黑名单(存在共同时，deny优先于allow)
        //bean.addInitParameter("deny", "****")
        //登录查看信息的账号密码
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "123456");
        //是否能够重置数据
        bean.addInitParameter("resetEnable", "false");
        return bean;
    }

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        bean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}

