package io.updike.awstesting;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;

@Component
public class TestTest {
	
	@Value("${aws.local.endpoint:#{null}}") 
	String awsEndpoint;
	
	private static final Regions region = Regions.US_EAST_1;
	private String bucketName = "io.updike.mybucket";
	
	//@PostConstruct
	public void ttest() {
		AmazonS3ClientBuilder s3 = AmazonS3ClientBuilder.standard();
		
		//if (awsEndpoint != null) {
			s3.setEndpointConfiguration(new EndpointConfiguration("http://127.0.0.1:4566",region.toString()));
		//}
		//Let's list buckets
		AmazonS3 ss3 = s3.build();
		for (Bucket b : ss3.listBuckets()) {
				System.out.println("BUCKET NAME ==> " + b.getName());
		}
		//create a new bucket
		//System.out.println("Creating new bucket");
		//ss3.createBucket(bucketName);
		
		//add an item in a bucket
		System.out.println("Storing data in new bucket");
		ss3.putObject(bucketName, "newContent", "myContent");
		
		//get item from bucket
		//System.out.println("Retrieving data from new bucket");
		//S3Object obj= ss3.getObject(bucketName, "newContent");
		//StringBuffer sb = new StringBuffer();
		//try (InputStream is = ss3.getObject(bucketName, "newContent").getObjectContent()) {
        //    sb.append(StreamUtils.copyToString(is, StandardCharsets.UTF_8));
        //} catch (IOException ioe) {
        //	System.out.println("OOF");
        //}
		//System.out.println("Is this my data? " + sb.toString());
		//delete item in bucket
		//System.out.println("Deleting data in new bucket");
		//ss3.deleteObject(bucketName, "newContent");
		//delete bucket
		//System.out.println("Deleting new bucket");
		//ss3.deleteBucket(bucketName);
				
	}

}
