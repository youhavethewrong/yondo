package info.youhavethewrong.yondo.util;

import io.dropwizard.auth.*;
import io.dropwizard.auth.basic.BasicCredentials;

import com.google.common.base.Optional;

public class SimpleAuthenticator implements Authenticator<BasicCredentials, String> {

    public Optional<String> authenticate(BasicCredentials cred) throws AuthenticationException {
	if ("awesomesauce".equals(cred.getPassword()) && "billy".equals(cred.getUsername())) {
	    return Optional.of(cred.getUsername());
	}
	return Optional.absent();
    }

}
