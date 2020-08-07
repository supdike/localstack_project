package io.updike.awstesting;

@ExtendWith(LocalstackDockerExtension.class)
@ActiveProfiles("local")
@LocalstackDockerProperties(services = { "s3" })
public class AwsTesterClass {
	

}
