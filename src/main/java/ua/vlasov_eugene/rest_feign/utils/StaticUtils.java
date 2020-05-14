package ua.vlasov_eugene.rest_feign.utils;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@EqualsAndHashCode
public class StaticUtils {
	public String getRandomUUIDInString(){
		return UUID.randomUUID().toString();
	}

	public Date getCurrentDate() {
		return new Date();
	}

	public String getExtension(String filename) {
		return StringUtils.substringAfterLast(filename, ".");
	}
}
