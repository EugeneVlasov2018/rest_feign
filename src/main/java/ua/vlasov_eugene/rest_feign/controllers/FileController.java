package ua.vlasov_eugene.rest_feign.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.vlasov_eugene.rest_feign.services.FileService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
	private final FileService fileService;

	@PostMapping()
	public String uploadFile(MultipartFile file) throws IOException {
		fileService.saveFile(file);
		return "File was successfuly saved";
	}

	@DeleteMapping()
	public String deleteFile(String key){
		fileService.deleteFile(key);
		return "File was deleted successfuly";
	}
}
