package com.kr.cground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CgroundPaymentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgroundPaymentAppApplication.class, args);
    }

}
