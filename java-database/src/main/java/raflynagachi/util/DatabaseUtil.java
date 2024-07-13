package raflynagachi.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static HikariDataSource hikariDataSource;

    static {
        hikariDataSource = new HikariDataSource();
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.ds.PGSimpleDataSource");
        config.setUsername("something");
        config.setPassword("something");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/todolist?serverTimezone=Asia/Jakarta");

        // pool
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60*60*1000); // 1 hour

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
