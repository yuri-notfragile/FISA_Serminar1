package seminar.oauth.domain;

import static jakarta.persistence.EnumType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthId {

	@Column (nullable = false, name = "oauth_server_id")
	private String oauthServerId;

	@Enumerated(STRING)
	@Column(nullable = false, name = "oauth_server")
	private OauthServerType oauthServerType;

	public String oauthServerId() {
		return oauthServerId;
	}

	public OauthServerType oauthServer() {
		return oauthServerType;
	}
}
