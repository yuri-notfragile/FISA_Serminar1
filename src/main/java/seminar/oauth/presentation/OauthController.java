package seminar.oauth.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seminar.oauth.domain.OauthServerType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import seminar.oauth.application.OauthService;

@RequiredArgsConstructor
@RequestMapping("/oauth")
@RestController
public class OauthController {

	private final OauthService oauthService;

	@SneakyThrows
	@GetMapping("/{oauthServerType}")
	ResponseEntity<Void> redirectAuthCodeRequestUrl(
		@PathVariable OauthServerType oauthServerType,
		HttpServletResponse response
	) {
		String redirectUrl = oauthService.getAuthCodeRequestUrl(oauthServerType);
		response.sendRedirect(redirectUrl);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/login/{oauthServerType}")
	ResponseEntity<Long> login(
		@PathVariable OauthServerType oauthServerType,
		@RequestParam("code") String code
	) {
		Long login = oauthService.login(oauthServerType, code);
		return ResponseEntity.ok(login);

	}

}
