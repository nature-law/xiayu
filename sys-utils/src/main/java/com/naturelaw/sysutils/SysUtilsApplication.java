package com.naturelaw.sysutils;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLeafServer
@SpringBootApplication
public class SysUtilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SysUtilsApplication.class, args);
	}
}
