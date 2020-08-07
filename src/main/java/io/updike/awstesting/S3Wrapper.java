package io.updike.awstesting;

import com.amazonaws.services.s3.AmazonS3;

public class S3Wrapper {
	
	private AmazonS3 amazonS3;

	public AmazonS3 getAmazonS3() {
		return amazonS3;
	}

	public void setAmazonS3(AmazonS3 amazonS3) {
		this.amazonS3 = amazonS3;
	}
	
	

}
