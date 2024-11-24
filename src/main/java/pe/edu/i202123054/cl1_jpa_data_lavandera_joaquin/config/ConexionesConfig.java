package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(4 * 60 * 1000); // 4 minutos en milisegundos
        config.setConnectionTimeout(45 * 1000); // 45 segundos en milisegundos

        config.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        config.setUsername(System.getenv("DB_WORLD_USER"));
        config.setPassword(System.getenv("DB_WORLD_PASS"));
        config.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        return new HikariDataSource(config);
    }
}
