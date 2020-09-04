package com.tz;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogswitchApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        logger.trace("trace Hello World");
        logger.debug("debug Hello World");
        logger.info("info Hello World");
        logger.warn("warn Hello World");
        logger.error("error Hello World");
    }
/*
应用层面向日志抽象层编程
-----------------------------
SLF4JAPI.jar是日志抽象
logback-classic.jar
logback-core.jar
是这个日志抽象的实现
-----------------------------
SLF4JAPI.jar绑定log4j.jar
log4j.jar是日志实现,较早出现
需要一个额外的适配层：slf4j-log4j2.jar：slf4j-log4j2.jar实现了SLF4JAPI.jar的方法，在方法中调用log4j.jar中的API
-----------------------------
SLF4JAPI.jar绑定java.util.logging
需要一个额外的适配层：slf4j-jdk14.jar:slf4j-jdk14.jar实现了SLF4JAPI.jar的方法，在方法中调用java.util.logging中的API
-----------------------------
SLF4JAPI.jar绑定简单的日志实现
slf4j-simple.jar:
-----------------------------
-----------------------------
框架日志实现层的替换
commons-logging.jar 替换为 LogBack：
移除：commons-logging.jar -->引入：jcl-over-slf4j.jar
jcl-over-slf4j.jar："偷天换日包",jcl-over-slf4j.jar中有和 commons-logging.jar 相同的类和方法、路径，唯一不同的是这些和 CommonsLoggingAPI 相同的类和方法实际
调用的是slf4j-api.jar中的API，而对这个抽象层的调用最后又会调用daologback-classic.jar、logback-core.jar的实现上
同理 log4j也可以替换为 LogBack...

程序中面向 slf4j.jar 抽象层编程，适配层用 slf4j-log4j2.jar ，因此这个抽象层的实现是 log4j.jar
此时引入的第三方代码可能是用 commons-logging.jar 日志实现的
此时需要移除 commons-logging.jar ，引入 jcl-over-slf4j.jar： jcl-over-slf4j.jar 中有和 commons-logging.jar 相同的类和方法、路径，当这些方法调用的是 slf4j.jar 抽象层
的方法，因此这个操作完成了第三方代码面向 slf4j.jar 抽象层的编程
后续的适配层 jar 不需要变动，最后还是使用 log4j.jar 的日志实现


统一都用 slf4j.jar 做不同日志框架层之间的转换
*/
/*
框架自带的日志的配置文件：
    E:\MvnRepo\org\springframework\boot\spring-boot\2.3.3.RELEASE\spring-boot-2.3.3.RELEASE.jar!
    \org\springframework\boot\logging\logback\base.xml
*/
/*
console-appender.xml：控制台的日志格式
file-appender.xml:文件的日志格式
实现自己的日志配置文件：参考 Spring Boot 参考手册的日志章节

注意 logback.xml 和 logback-spring.xml 的区别
*/

}
