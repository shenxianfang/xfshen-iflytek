package com.iflytek;

import com.iflytek.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springweb1ApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源：com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        //获得数据库连接：HikariProxyConnection@1641931089 wrapping com.mysql.cj.jdbc.ConnectionImpl@b25b095
        System.out.println(connection);
        //关闭
        connection.close();
    }

}
