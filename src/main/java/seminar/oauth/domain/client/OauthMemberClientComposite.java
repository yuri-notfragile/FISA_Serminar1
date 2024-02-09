package seminar.oauth.domain.client;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import seminar.oauth.domain.OauthMember;
import seminar.oauth.domain.OauthServerType;
import seminar.oauth.infra.oauth.kakao.client.OauthMemberClient;

@Component
public class OauthMemberClientComposite {
	private final Map<OauthServerType, OauthMemberClient> mapping;

	public OauthMemberClientComposite(Set<OauthMemberClient> clients) {
		mapping = clients.stream()
			.collect(toMap(
				OauthMemberClient::supportServer,
				identity()
			));
	}

	public OauthMember fetch(OauthServerType oauthServerType, String authcode) {
		return getClient(oauthServerType).fetch(authcode);
	}

	private OauthMemberClient getClient(OauthServerType oauthServerType) {
		return Optional.ofNullable(mapping.get(oauthServerType))
			.orElseThrow(() -> new RuntimeException("지원하지 않는 소셜 로그인 타입인니다."));
	}

}
