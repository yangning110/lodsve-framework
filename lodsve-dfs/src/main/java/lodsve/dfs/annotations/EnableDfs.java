package lodsve.dfs.annotations;

import lodsve.dfs.enums.DfsType;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用fs.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version 1.0 2017-12-4-0004 10:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(DfsConfigurationSelector.class)
public @interface EnableDfs {

    /**
     * 指定使用的文件系统类型{@link lodsve.dfs.enums.DfsType}，默认为FAST_DFS
     *
     * @return 类型
     */
    DfsType value() default DfsType.FAST_DFS;
}