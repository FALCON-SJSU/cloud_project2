package com.cloud.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AmazonClientService {
	
	private AmazonS3 s3client;
	private String awsS3Bucket;
	private String endpointUrl;

	private static final String SUFFIX = "/";
	
	@Autowired
	public AmazonClientService(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3Bucket,
			String endpointUrl) {
		this.s3client = AmazonS3ClientBuilder.standard().withCredentials(awsCredentialsProvider)
				.withRegion(awsRegion.getName()).build();
		this.awsS3Bucket = awsS3Bucket;
		this.endpointUrl = endpointUrl;
	}
	
public String uploadFiletoS3(MultipartFile multipartFile) {
		
		String folderName = "cloud";
		createFolder(awsS3Bucket, folderName, s3client);
		try {
			File s3File = convertMultiPartToFile(multipartFile);

			// String keyName = userName +"_"+s3File.getName();
			String keyName = folderName + "/" + s3File.getName();
			// s3client.putObject(awsS3Bucket, keyName, s3File);
			s3client.putObject(new PutObjectRequest(awsS3Bucket, keyName, s3File)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			
			return endpointUrl + "/" + awsS3Bucket + "/" +keyName;
			
		} catch (Exception e) {

			throw new RuntimeException("FAIL!");
		}

	}




public static void createFolder(String awsS3Bucket, String folderName, AmazonS3 s3client) {
	// create meta-data for your folder and set content-length to 0
	ObjectMetadata metadata = new ObjectMetadata();
	metadata.setContentLength(0);
	// create empty content
	InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
	// create a PutObjectRequest passing the folder name suffixed by /
	PutObjectRequest putObjectRequest = new PutObjectRequest(awsS3Bucket, folderName + SUFFIX, emptyContent,
			metadata);
	// send request to S3 to create folder
	s3client.putObject(putObjectRequest);
}


public File convertMultiPartToFile(MultipartFile file) throws IOException {
	File convFile = new File(file.getOriginalFilename());
	FileOutputStream fos = new FileOutputStream(convFile);
	fos.write(file.getBytes());
	fos.close();
	return convFile;
}
	

}










