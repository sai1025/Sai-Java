package com.emp.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudImageService {

	@Autowired
	Cloudinary cloudinary;
	
	public String uploadImage(MultipartFile file) {
		
		try {
			byte[] data=new byte[file.getInputStream().available()];
			file.getInputStream().read(data);
			
			String fileName=UUID.randomUUID().toString();
			if(cloudinary==null)
			{
				System.out.println("cloudinary is null");
			}
			cloudinary.uploader().upload(data, ObjectUtils.asMap("public_id",fileName
											));
			
			return cloudinary.url().transformation(
					new Transformation<>().width(400).height(400).crop("fill")).generate(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
