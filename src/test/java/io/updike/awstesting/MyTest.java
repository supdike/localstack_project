package io.updike.awstesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.amazonaws.services.s3.AmazonS3;

import cloud.localstack.TestUtils;
import cloud.localstack.docker.LocalstackDockerExtension;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;

@ExtendWith(LocalstackDockerExtension.class)
@LocalstackDockerProperties(services = { "s3" })
public class MyTest {

	
	@Test
	  public void testLocalS3API() {
	    AmazonS3 s3 = TestUtils.getClientS3();
	    s3.createBucket("thisismybucketname");
	    S3Wrapper wrapper = new S3Wrapper();
	    wrapper.setAmazonS3(s3);
	    MyS3Service myService = new MyS3Service(wrapper);
	    myService.listBuckets();
	  }
}
