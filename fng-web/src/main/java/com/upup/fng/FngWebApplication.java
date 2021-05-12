package com.upup.fng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("mappers")
@ServletComponentScan
public class FngWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FngWebApplication.class, args);
    }

}
