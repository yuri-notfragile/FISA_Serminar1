package seminar.oauth.application;

import org.springframework.stereotype.Service;

import seminar.oauth.domain.OauthMember;
import seminar.oauth.domain.OauthMemberRepository;
import seminar.oauth.domain.OauthServerType;
import seminar.oauth.domain.authcode.AuthCodeRequestUrlProviderComposite;
import lombok.RequiredArgsConstructor;
import seminar.oauth.domain.client.OauthMemberClientComposite;
import seminar.oauth.infra.oauth.kakao.client.OauthMemberClient;

@Service
@RequiredArgsConstructor
public class OauthService {

	private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;

	private final OauthMemberClientComposite oauthMemberClientComposite;

	private final OauthMemberRepository oauthMemberRepository;

	public String getAuthCodeRequestUrl(OauthServerType oauthServerType) {
		return authCodeRequestUrlProviderComposite.provide(oauthServerType);
	}

	public Long login(OauthServerType oauthServerType, String authCode) {
		OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType, authCode);
		OauthMember saved = oauthMemberRepository.findByOauthId(oauthMember.oauthId())
			.orElseGet(() -> oauthMemberRepository.save(oauthMember));
		return saved.id();
	}
}