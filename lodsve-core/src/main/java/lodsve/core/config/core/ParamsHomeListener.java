package lodsve.core.config.core;

import lodsve.core.config.ini.IniLoader;
import lodsve.core.config.properties.ConfigurationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static lodsve.core.config.core.ParamsHome.PARAMS_HOME_NAME;

/**
 * 读取web.xml中设置的context-param[paramsHome].
 * 初始化配置文件的路径.<br/>
 * 配置文件加载顺序：<br/>
 * 环境变量 &gt; 容器启动参数 &gt; web.xml中配置<br/>
 * <ol>
 * <li>
 * web.xml中配置
 * <ul>
 * <li>
 * 配置context-param
 * <pre>
 *  &lt;context-param&gt;
 *     &lt;param-name&gt;paramsHome&lt;/param-name&gt;
 *     &lt;param-value&gt;your params home&lt;/param-value&gt;
 *  &lt;/context-param&gt;
 * </pre>
 * </li>
 * <li>
 * 配置listener[应该配置在web.xml中的所有listener之前，优先加载]
 * <pre>
 *  &lt;listener&gt;
 *      &lt;listener-class&gt;message.config.core.ParamsHomeListener&lt;/listener-class&gt;
 *  &lt;/listener&gt;
 * </pre>
 * </li>
 * </ul>
 * </li>
 * <li>
 * 容器启动参数<br/>
 * {@code -params.home=your params home }
 * </li>
 * <li>
 * 环境变量<br/>
 * 系统环境变量设置{@code PARAMS_HOME=you params home }
 * </li>
 * </ol>
 * 如果在classpath下,可以加上前缀classpath:you params home<br/>
 * 如果在文件系统中,可加前缀system:或者不加也行
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0
 * @createTime 2015-1-5 10:00
 */
public class ParamsHomeListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ParamsHomeListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ParamsHome.cleanParamsRoot();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String paramsHome = servletContextEvent.getServletContext().getInitParameter(PARAMS_HOME_NAME);
        logger.debug("get init parameter '{}' from web.xml is '{}'", PARAMS_HOME_NAME, paramsHome);

        ParamsHome.getParamsRoot();

        try {
            ConfigurationLoader.init();
            IniLoader.init();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
