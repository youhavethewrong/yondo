package info.youhavethewrong.yondo.util;

import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class SimpleAuthenticator implements
		Authenticator<BasicCredentials, String> {

	public Optional<String> authenticate(BasicCredentials cred)
			throws AuthenticationException {
		if ("awesomesauce".equals(cred.getPassword())
				&& "billy".equals(cred.getUsername())) {
			return Optional.of(cred.getUsername());
		}
		return Optional.absent();
	}

}
