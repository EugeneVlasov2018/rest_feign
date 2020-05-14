package ua.vlasov_eugene.rest_feign.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.vlasov_eugene.rest_feign.model.User;
import ua.vlasov_eugene.rest_feign.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feignrest/")
public class UserController {
	private final UserService service;

	@GetMapping("users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
}
