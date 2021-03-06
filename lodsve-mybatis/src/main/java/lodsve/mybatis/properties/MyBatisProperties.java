/*
 * Copyright (C) 2018  Sun.Hao
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package lodsve.mybatis.properties;

import lodsve.core.properties.relaxedbind.annotations.ConfigurationProperties;
import lodsve.core.properties.relaxedbind.annotations.Required;

/**
 * mybatis 配置.
 *
 * @author <a href="mailto:sunhao.java@gmail.com">sunhao(sunhao.java@gmail.com)</a>
 * @date 2018-2-8-0008 16:47
 */
@ConfigurationProperties(prefix = "lodsve.mybatis", locations = "${params.root}/framework/mybatis.properties")
public class MyBatisProperties {
    /**
     * MySQL主键自增长时，缓存的key个数
     */
    private int keyCacheSize = 10;
    /**
     * mybatis mapper文件
     */
    private String[] mapperLocations = new String[]{"classpath*:/META-INF/mybatis/**/*Mapper.xml"};
    /**
     * mybatis 配置文件
     */
    private String configLocation = "classpath:/META-INF/mybatis/mybatis.xml";
    /**
     * 含有{@link org.springframework.stereotype.Repository }注解的dao类所在的包路径,可以多个
     */
    @Required
    private String[] basePackages;
    /**
     * 枚举类型所在包路径,可以多个
     */
    @Required
    private String[] enumsLocations;
    /**
     * 是否支持事务
     */
    private boolean supportTransaction = false;
    /**
     * flyway的脚本文件所在路径
     */
    private String[] migration = new String[]{"classpath:META-INF/flyway"};

    public int getKeyCacheSize() {
        return keyCacheSize;
    }

    public void setKeyCacheSize(int keyCacheSize) {
        this.keyCacheSize = keyCacheSize;
    }

    public String[] getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String[] getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String[] basePackages) {
        this.basePackages = basePackages;
    }

    public String[] getEnumsLocations() {
        return enumsLocations;
    }

    public void setEnumsLocations(String[] enumsLocations) {
        this.enumsLocations = enumsLocations;
    }

    public boolean isSupportTransaction() {
        return supportTransaction;
    }

    public void setSupportTransaction(boolean supportTransaction) {
        this.supportTransaction = supportTransaction;
    }

    public String[] getMigration() {
        return migration;
    }

    public void setMigration(String[] migration) {
        this.migration = migration;
    }
}
