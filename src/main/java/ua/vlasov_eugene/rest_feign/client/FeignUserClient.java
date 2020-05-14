package ua.vlasov_eugene.rest_feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ua.vlasov_eugene.rest_feign.model.User;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface FeignUserClient {
	@GetMapping("/users")
	public List<User> getUsers();
	
}
