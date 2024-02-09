package seminar.oauth.presentation;

import org.springframework.core.convert.converter.Converter;

import seminar.oauth.domain.OauthServerType;
public class OauthServerTypeConverter implements Converter<String, OauthServerType> {

	@Override
	public OauthServerType convert(String source) {
		return OauthServerType.fromName(source);
	}
}