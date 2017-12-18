package com.example.demo.config;

import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by WANGYJ on 2017/8/16.
 */
@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;

//    @Value("${spring.datasource1.url}")
//    private String dbUrl1;
//
//    @Value("${spring.datasource1.username}")
//    private String username1;
//
//    @Value("${spring.datasource1.password}")
//    private String password1;
//
//    @Value("${spring.datasource2.url}")
//    private String dbUrl2;
//
//    @Value("${spring.datasource2.username}")
//    private String username2;
//
//    @Value("${spring.datasource2.password}")
//    private String password2;

//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.dbcp2.initialSize}")
//    private int initialSize;
//
//    @Value("${spring.datasource.dbcp2.minIdle}")
//    private int minIdle;
//
//    @Value("${spring.datasource.dbcp2.maxActive}")
//    private int maxActive;
//
//    @Value("${spring.datasource.dbcp2.maxWait}")
//    private int maxWait;
//
//    @Value("${spring.datasource.dbcp2.timeBetweenEvictionRunsMillis}")
//    private int timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.dbcp2.minEvictableIdleTimeMillis}")
//    private int minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.dbcp2.testWhileIdle}")
//    private boolean testWhileIdle;
//
//    @Value("${spring.datasource.dbcp2.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${spring.datasource.dbcp2.testOnReturn}")
//    private boolean testOnReturn;
//
//    @Value("${spring.datasource.dbcp2.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//
//    @Value("${spring.datasource.filters}")
//    private String filters;
//    在其他文件中定义监控账号，因此此处删除处理
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings("/druid/*");
//        reg.addInitParameter("loginUsername", "druid");
//        reg.addInitParameter("loginPassword", "jiajian123456");
//        return reg;
//    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        return filterRegistrationBean;
    }
    

//    @Bean(name = "single")
//    @Primary
//    public DataSource druidDataSource(){
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(this.username);
//        datasource.setPassword(this.password);
//        datasource.setDriverClassName(driverClassName);
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            logger.error("druid configuration initialization filter", e);
//        }
//        return datasource;
//    }

//    @Bean(name = "xaDataSourceM")
//    public DataSource druidxaDataSourceM(){
//        DruidXADataSource datasource = new DruidXADataSource();
//
//        datasource.setUrl(this.dbUrl1);
//        datasource.setUsername(this.username1);
//        datasource.setPassword(this.password1);
//        datasource.setDriverClassName(driverClassName);
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            logger.error("druid configuration initialization filter", e);
//        }
//        return datasource;
//    }
//    @Bean(name = "xaDataSourceS")
//    public DataSource druidxaDataSourceS(){
//        DruidXADataSource datasource = new DruidXADataSource();
//
//        datasource.setUrl(this.dbUrl2);
//        datasource.setUsername(this.username2);
//        datasource.setPassword(this.password2);
//        datasource.setDriverClassName(driverClassName);
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            logger.error("druid configuration initialization filter", e);
//        }
//        return datasource;
//    }

}