package cn.team;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("cn.team.mapper")
@EnableCaching
public class RMApplication {

	public static void main(String[] args) {
		SpringApplication.run(RMApplication.class, args);
	}
}
