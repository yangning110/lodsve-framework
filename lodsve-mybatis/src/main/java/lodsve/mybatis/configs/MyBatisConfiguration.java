package lodsve.mybatis.configs;

import lodsve.core.autoconfigure.annotations.EnableConfigurationProperties;
import lodsve.mybatis.type.TypeHandlerScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * message-mybatis配置包扫描路径.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 16/1/19 下午10:21
 */
@Configuration
@ComponentScan("lodsve.mybatis.key")
@EnableConfigurationProperties(RdbmsProperties.class)
public class MyBatisConfiguration {
    @Bean
    public TypeHandlerScanner typeHandlerScanner() {
        return new TypeHandlerScanner();
    }
}
