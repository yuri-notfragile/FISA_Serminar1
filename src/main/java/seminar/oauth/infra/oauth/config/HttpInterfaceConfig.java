package seminar.oauth.infra.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import seminar.oauth.infra.oauth.kakao.client.KakaoApiClient;

@Configuration
public class HttpInterfaceConfig {

	@Bean
	public KakaoApiClient kakaoApiClient() {
		return createHttpInterface(KakaoApiClient.class);
	}

	private <T> T createHttpInterface(Class<T> clazz) {
		WebClient webClient = WebClient.create();
		HttpServiceProxyFactory build = HttpServiceProxyFactory
			.builder(WebClientAdapter.forClient(webClient)).build();
		return build.createClient(clazz);
	}
}
