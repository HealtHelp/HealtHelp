package com.api.healthelp.boot;


import com.api.healthelp.controller.SecurityController;
import com.api.healthelp.controller.UserController;
import com.api.healthelp.controller.impl.SecurityControllerImpl;
import com.api.healthelp.controller.impl.UserControllerImpl;
import com.api.healthelp.dao.UserDao;
import com.api.healthelp.dao.impl.UserDaoImpl;
import com.api.healthelp.dao.mapper.UserMapper;
import com.api.healthelp.security.JwtGenerator;
import com.api.healthelp.security.JwtValidator;
import com.api.healthelp.service.UserService;
import com.api.healthelp.service.impl.UserServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;



@Configuration
public class ApiConfig {

    //properties
    @Bean
    public Properties properties(){
        return new Properties();
    }

    //database
    @Bean
    @ConditionalOnProperty(name="db.enabled")
    public BasicDataSource driverManagerDataSource(final Properties properties){
        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName(properties.getDbDriver());
        connectionPool.setUrl(properties.getDbUrl());
        connectionPool.setUsername(properties.getDbUsername());
        connectionPool.setPassword(properties.getDbPassword());
        return connectionPool;

    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final BasicDataSource driverManagerDataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("static/config.xml"));
        sqlSessionFactory.setDataSource(driverManagerDataSource);
        return sqlSessionFactory;
    }



    @Bean
    public MapperFactoryBean<UserMapper> userMapper(final SqlSessionFactory sqlSessionFactory1){
        final MapperFactoryBean<UserMapper> mfb = new MapperFactoryBean<>();
        mfb.setMapperInterface(UserMapper.class);
        mfb.setSqlSessionFactory(sqlSessionFactory1);
        return mfb;
    }


    //dao
    @Bean
    public UserDao userDao( final UserMapper userMapper1){
        return new UserDaoImpl(userMapper1);
    }
    //services
    @Bean
    public UserService userService(final UserDao userDao){
        return new UserServiceImpl(userDao);
    }
    //controllers
    @Bean
    public SecurityController securityController(JwtGenerator jwtGenerator,UserDao userDao){return new SecurityControllerImpl(jwtGenerator,userDao);
    }
    @Bean
    public UserController userController(final UserService userService){
        return new UserControllerImpl(userService);
    }

    //jwt
    @Bean
    public JwtValidator jwtValidator(Properties properties){return new JwtValidator(properties);}
    @Bean
    public JwtGenerator jwtGenerator(Properties properties){return new JwtGenerator(properties);}
}
