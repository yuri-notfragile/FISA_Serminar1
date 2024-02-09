package seminar.oauth.infra.oauth.kakao.authcode;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import seminar.oauth.domain.OauthServerType;
import seminar.oauth.domain.authcode.AuthCodeRequestUrlProvider;
import seminar.oauth.infra.oauth.kakao.KakaoOauthConfig;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakaoAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

	private final KakaoOauthConfig kakaoOauthConfig;

	@Override
	public OauthServerType supportServer() {
		return OauthServerType.KAKAO;
	}

	@Override
	public String provide() {
		return UriComponentsBuilder
			.fromUriString("https://kauth.kakao.com/oauth/authorize")
			.queryParam("response_type", "code")
			.queryParam("client_id", kakaoOauthConfig.clientId())
			.queryParam("redirect_uri", kakaoOauthConfig.redirectUri())
			.queryParam("scope", String.join(",", kakaoOauthConfig.scope()))
			.toUriString();
	}
}
