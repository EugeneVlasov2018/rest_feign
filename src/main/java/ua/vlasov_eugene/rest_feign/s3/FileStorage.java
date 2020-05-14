package ua.vlasov_eugene.rest_feign.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class FileStorage {
	@Value("${aws.s3.bucket}")
	private String bucket;
	private final AmazonS3 s3;

	public void uploadFile(String key, MultipartFile file){
		try {
			uploadFile(key, file.getInputStream(), file.getSize(), file.getContentType());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void uploadFile(String key, InputStream file, long size, String contentType) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(contentType);
		metadata.setContentLength(size);

		PutObjectRequest request = new PutObjectRequest(bucket,key,file,metadata);
		request.setCannedAcl(CannedAccessControlList.PublicRead);
		s3.putObject(request);
	}

	public void deleteFile(String key){
		s3.deleteObject(new DeleteObjectRequest(bucket,key));
	}
}
