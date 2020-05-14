package ua.vlasov_eugene.rest_feign.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.vlasov_eugene.rest_feign.client.FeignUserClient;
import ua.vlasov_eugene.rest_feign.model.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
	private final FeignUserClient client;

	public List<User> getAllUsers() {
		return client.getUsers();
	}
}
