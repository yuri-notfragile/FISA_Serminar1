package seminar.oauth.domain.authcode;

import seminar.oauth.domain.OauthServerType;

public interface AuthCodeRequestUrlProvider {
	OauthServerType supportServer();

	String provide();
}
