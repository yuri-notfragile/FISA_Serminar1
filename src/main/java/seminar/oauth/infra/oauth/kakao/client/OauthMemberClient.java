package seminar.oauth.infra.oauth.kakao.client;

import seminar.oauth.domain.OauthMember;
import seminar.oauth.domain.OauthServerType;

public interface OauthMemberClient {

	OauthServerType supportServer();

	OauthMember fetch(String code);
}
