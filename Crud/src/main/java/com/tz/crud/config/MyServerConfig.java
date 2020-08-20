package com.tz.crud.config;

import com.tz.crud.filter.MyFilter;
import com.tz.crud.listener.MyListener;
import com.tz.crud.servlet.MyServlet;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.websocket.servlet.JettyWebSocketServletWebServerCustomizer;
import org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }



/*    // 嵌入式Tomcat除配置文件之外的实现方式
    @Bean
    public TomcatWebSocketServletWebServerCustomizer tomcatWebSocketServletWebServerCustomizer(){
        return new TomcatWebSocketServletWebServerCustomizer(){
            @Override
            public void customize(TomcatServletWebServerFactory factory) {
                factory.setPort(8753);
            }
        };
    }*/

    /*
        @Bean
        public JettyWebSocketServletWebServerCustomizer jettyWebSocketServletWebServerCustomizer() {
            return new JettyWebSocketServletWebServerCustomizer() {
                @Override
                public void customize(JettyServletWebServerFactory factory) {
                    factory.setPort(8872);
                }
            };
        }*/
    // 不同容器通用配置
   /* @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                ((ConfigurableWebServerFactory) factory).setPort(8895);
            }
        };
    }*/


    @Component
    public class CustomizationBean implements
            WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
        @Override
        public void customize(ConfigurableServletWebServerFactory server) {
            server.setPort(9000);
        }
    }

}
