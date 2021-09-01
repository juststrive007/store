package cn.study.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {


    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

    @Test
    public void md5() {
        String passwd = "1111";
        String md5passwd = DigestUtils.md5DigestAsHex(passwd.getBytes(StandardCharsets.UTF_8));
        System.err.println(md5passwd);
    }
}
