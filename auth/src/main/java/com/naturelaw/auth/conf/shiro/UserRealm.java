package com.naturelaw.auth.conf.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * description:UserRealm
 *
 * @author Administrator
 * @date 2021/7/19 17:03
 */
public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		if (!"andy".equals(username)) {
			throw new UnknownAccountException("账户不存在!");
		}
		return new SimpleAuthenticationInfo(username, "andy", getName());
	}
}
