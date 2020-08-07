package io.updike.awstesting;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.model.Bucket;

@Component
public class MyS3Service {
	
	private S3Wrapper s3Wrapper;
	
	@Autowired
	public MyS3Service(S3Wrapper s3Wrapper) {
		this.s3Wrapper = s3Wrapper;
	}

	@PostConstruct
	public void listBuckets() {
		for (Bucket b : s3Wrapper.getAmazonS3().listBuckets()) {
			System.out.println("Bucket Name ====>>>>>>   " + b.getName());
		}
	}
}
