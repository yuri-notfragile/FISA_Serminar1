package seminar.oauth.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import seminar.oauth.presentation.OauthServerTypeConverter;

@Configuration
@RequiredArgsConstructor
public class Webconfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000")
			.allowedMethods(
				HttpMethod.GET.name(),
				HttpMethod.POST.name(),
				HttpMethod.PUT.name(),
				HttpMethod.DELETE.name(),
				HttpMethod.PATCH.name()
			)
			.allowCredentials(true)
			.exposedHeaders("*");
	}
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new OauthServerTypeConverter());
	}
}
