package seminar.oauth.infra.oauth.kakao;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.RequiredArgsConstructor;
import seminar.oauth.domain.OauthMember;
import seminar.oauth.domain.OauthServerType;
import seminar.oauth.infra.oauth.kakao.client.KakaoApiClient;
import seminar.oauth.infra.oauth.kakao.client.OauthMemberClient;
import seminar.oauth.infra.oauth.kakao.dto.KakaoMemberResponse;
import seminar.oauth.infra.oauth.kakao.dto.KakaoToken;

@Component
@RequiredArgsConstructor
public class KakaoMemberClient implements OauthMemberClient {

	private final KakaoApiClient kakaoApiClient;
	private final KakaoOauthConfig kakaoOauthConfig;

	@Override
	public OauthServerType supportServer() {
		return OauthServerType.KAKAO;
	}

	@Override
	public OauthMember fetch(String authCode) {
		KakaoToken tokenInfo = kakaoApiClient.fetchToken(tokenRequestParams(authCode));
		KakaoMemberResponse kakaoMemberResponse =
			kakaoApiClient.fetchMember("Bearer " + tokenInfo.accessToken());
		return kakaoMemberResponse.toDomain();
	}

	private MultiValueMap<String, String> tokenRequestParams(String authCode) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", kakaoOauthConfig.clientId());
		params.add("redirect_uri", kakaoOauthConfig.redirectUri());
		params.add("code", authCode);
		params.add("client_secret", kakaoOauthConfig.clientSecret());
		return params;
	}
}
