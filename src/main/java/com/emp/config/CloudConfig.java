package com.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudConfig {
	private String cloud_name="ddgdjm804";
	private String cloud_api_key="591143637871252";
	private String cloud_api_secret="ZgDZYzXJVDz83Gz2lcSMLRIANJI";

    @Bean
    Cloudinary cloudinary() {
		return new Cloudinary(
				ObjectUtils.asMap("cloud_name",cloud_name,"api_key",cloud_api_key,"api_secret",cloud_api_secret)
				);
	}
}