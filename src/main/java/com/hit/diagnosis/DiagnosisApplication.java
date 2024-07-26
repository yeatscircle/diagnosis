package com.hit.diagnosis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@ServletComponentScan //用于扫描过滤器使其生效
@EnableTransactionManagement //开启事务支持
public class DiagnosisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnosisApplication.class, args);
    }

}
