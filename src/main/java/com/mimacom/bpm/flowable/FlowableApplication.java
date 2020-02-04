package com.mimacom.bpm.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.mimacom.bpm.activiti","com.mimacom.bpm.controllers","com.mimacom.bpm.services"})
public class FlowableApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableApplication.class, args);
	}

}
