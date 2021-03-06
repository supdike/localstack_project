package io.updike.awstesting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class Config {

	private static final Regions region = Regions.US_EAST_1;

	//This is where you would centrally control all of the AWS service information, like endpoints, etc.  
	//Here I hard-coded the endpoint, but ideally it would be a property set by the appropriate environment-based
	//property file.
	
	@Bean
	public S3Wrapper s3Client() {
		AmazonS3ClientBuilder s3 = AmazonS3ClientBuilder.standard();
		s3.setEndpointConfiguration(new EndpointConfiguration("http://127.0.0.1:4566", region.toString()));
		S3Wrapper wrapper = new S3Wrapper();
		wrapper.setAmazonS3(s3.build());
		return wrapper;
	}
}
