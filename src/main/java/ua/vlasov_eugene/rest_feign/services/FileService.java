package ua.vlasov_eugene.rest_feign.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.vlasov_eugene.rest_feign.s3.FileStorage;
import ua.vlasov_eugene.rest_feign.utils.StaticUtils;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FileService {
	private static final String CONTENT_PATH = "content/";
	private static final FastDateFormat monthFormat = FastDateFormat.getInstance("yyyy-MM");
	private final FileStorage fileStorage;
	private final StaticUtils utils;

	public void saveFile(MultipartFile file) throws IOException {
		String key = prepareKey(file.getOriginalFilename());
		fileStorage.uploadFile(key,file);
	}

	private String prepareKey(String filename){
		String UUID = utils.getRandomUUIDInString();
		Date currentTime = utils.getCurrentDate();
		String extension = utils.getExtension(filename);
		return extension + monthFormat.format(currentTime) + "/" + UUID + "." + extension;
	}

	public void deleteFile(String key) {
		fileStorage.deleteFile(key);
	}
}
