package com.example.demo.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.demo.mapper*")
public class MybatisPlusConfig {

	@Autowired
    Environment env;
	
	@Autowired
	private MybatisProperties properties;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	@Autowired(required = false)
	private Interceptor[] interceptors;

	@Autowired(required = false)
	private DatabaseIdProvider databaseIdProvider;

    @Resource
    private DataSource dataSource;



	/*@Bean
	@ConditionalOnMissingBean
    public DataSource dataSource() throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new Driver());
        dataSource.setUrl("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }*/
	
	/**
	 *	 mybatis-plus分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
//		page.setOptimizeType(optimizeType);//分页count优化，需要的话请自行指定
		return page;
	}
	/**
	 * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
	 * 配置文件和mybatis-boot的配置文件同步
	 * @return
	 */
	@Bean
	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
		mybatisPlus.setDataSource(dataSource);
		mybatisPlus.setVfs(SpringBootVFS.class);
		if (StringUtils.hasText(this.properties.getConfigLocation())) {
			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
		}
		mybatisPlus.setConfiguration(properties.getConfiguration());
		if (!ObjectUtils.isEmpty(this.interceptors)) {
			mybatisPlus.setPlugins(this.interceptors);
		}
		// MP 全局配置，更多内容进入类看注释
		GlobalConfiguration globalConfig = new GlobalConfiguration();
		globalConfig.setDbType(DBType.MYSQL.name());//数据库类型
		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
		globalConfig.setIdType(1);
		//MP 属性下划线 转 驼峰 , 如果原生配置 mc.setMapUnderscoreToCamelCase(true) 开启，该配置可以无。
		globalConfig.setDbColumnUnderline(true);
		mybatisPlus.setGlobalConfig(globalConfig);
		MybatisConfiguration mc = new MybatisConfiguration();
		// 对于完全自定义的mapper需要加此项配置，才能实现下划线转驼峰
		mc.setMapUnderscoreToCamelCase(true);
		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		mybatisPlus.setConfiguration(mc);
		if (this.databaseIdProvider != null) {
			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
		}
		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
			mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
		}
		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
		}
		if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
			mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
		}
//		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
//
//		String mapperLocation = dbMapper;
//		List<org.springframework.core.io.Resource> resources = new ArrayList();
//		try {
//			org.springframework.core.io.Resource[] mappers = resourceResolver.getResources(mapperLocation);
//			resources.addAll(Arrays.asList(mappers));
//		} catch (IOException var8) {
//			;
//		}
//		mybatisPlus.setMapperLocations((org.springframework.core.io.Resource[])resources.toArray(new org.springframework.core.io.Resource[resources.size()]));
		return mybatisPlus;
	}
//	@Bean(name = "masterSqlSessionFactory")
//	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBeanMaster() {
//		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//		mybatisPlus.setDataSource(atomikosDataSourceBeanMaster);
//		mybatisPlus.setVfs(SpringBootVFS.class);
//		if (StringUtils.hasText(this.properties.getConfigLocation())) {
//			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
//		}
//		mybatisPlus.setConfiguration(properties.getConfiguration());
//		if (!ObjectUtils.isEmpty(this.interceptors)) {
//			mybatisPlus.setPlugins(this.interceptors);
//		}
//		// MP 全局配置，更多内容进入类看注释
//		GlobalConfiguration globalConfig = new GlobalConfiguration();
//		globalConfig.setDbType(DBType.MYSQL.name());//数据库类型
//		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
//		globalConfig.setIdType(3);
//		//MP 属性下划线 转 驼峰 , 如果原生配置 mc.setMapUnderscoreToCamelCase(true) 开启，该配置可以无。
//		globalConfig.setDbColumnUnderline(true);
//		mybatisPlus.setGlobalConfig(globalConfig);
//		MybatisConfiguration mc = new MybatisConfiguration();
//		// 对于完全自定义的mapper需要加此项配置，才能实现下划线转驼峰
//		mc.setMapUnderscoreToCamelCase(true);
//		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//		mybatisPlus.setConfiguration(mc);
//		if (this.databaseIdProvider != null) {
//			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//		}
//		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
//			mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//		}
//		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//		}
//		if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
//			mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//		}
//		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
//
//		String mapperLocation = db1Mapper;
//		List<org.springframework.core.io.Resource> resources = new ArrayList();
//		try {
//			org.springframework.core.io.Resource[] mappers = resourceResolver.getResources(mapperLocation);
//			resources.addAll(Arrays.asList(mappers));
//		} catch (IOException var8) {
//			;
//		}
//		mybatisPlus.setMapperLocations((org.springframework.core.io.Resource[])resources.toArray(new org.springframework.core.io.Resource[resources.size()]));
//		return mybatisPlus;
//	}
//	@Bean(name = "slaveSqlSessionFactory")
//	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBeanSlave() {
//		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//		mybatisPlus.setDataSource(atomikosDataSourceBeanSlave);
//		mybatisPlus.setVfs(SpringBootVFS.class);
//		if (StringUtils.hasText(this.properties.getConfigLocation())) {
//			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
//		}
//		mybatisPlus.setConfiguration(properties.getConfiguration());
//		if (!ObjectUtils.isEmpty(this.interceptors)) {
//			mybatisPlus.setPlugins(this.interceptors);
//		}
//		// MP 全局配置，更多内容进入类看注释
//		GlobalConfiguration globalConfig = new GlobalConfiguration();
//		globalConfig.setDbType(DBType.MYSQL.name());//数据库类型
//		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
//		globalConfig.setIdType(3);
//		//MP 属性下划线 转 驼峰 , 如果原生配置 mc.setMapUnderscoreToCamelCase(true) 开启，该配置可以无。
//		globalConfig.setDbColumnUnderline(true);
//		mybatisPlus.setGlobalConfig(globalConfig);
//		MybatisConfiguration mc = new MybatisConfiguration();
//		// 对于完全自定义的mapper需要加此项配置，才能实现下划线转驼峰
//		mc.setMapUnderscoreToCamelCase(true);
//		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//		mybatisPlus.setConfiguration(mc);
//		if (this.databaseIdProvider != null) {
//			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//		}
//		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
//			mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//		}
//		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
//			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//		}
//		if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
//			mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//		}
//		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
//
//		String mapperLocation = db2Mapper;
//		List<org.springframework.core.io.Resource> resources = new ArrayList();
//		try {
//			org.springframework.core.io.Resource[] mappers = resourceResolver.getResources(mapperLocation);
//			resources.addAll(Arrays.asList(mappers));
//		} catch (IOException var8) {
//			;
//		}
//		mybatisPlus.setMapperLocations((org.springframework.core.io.Resource[])resources.toArray(new org.springframework.core.io.Resource[resources.size()]));
//
//		return mybatisPlus;
//	}


}
