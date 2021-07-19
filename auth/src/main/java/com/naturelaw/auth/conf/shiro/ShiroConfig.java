package com.naturelaw.auth.conf.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description: shiro 配置
 *
 * @author Administrator
 * @date 2021/7/19 17:06
 */
@Configuration
public class ShiroConfig {
	/**
	 * Description: 一、ShiroFilterFactoryBean
	 * 过滤器工厂，Shiro 的基本运行机制是开发者定制规则，Shiro 去执行，具体的执行操作
	 * 是由 ShiroFilterFactoryBean 创建的一个个 Filter 对象来完成。
	 * @date 20.7.16 09:22
	 */
	@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		/*ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全框架
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		//添加shiro内置过滤器
        *//*一共分两类过滤器：
        认证过滤器：
        anon: 无需认证就可以访问
        authc: 认证可以访问
        authcBasic：需要通过HTTPBasic认证才可以可以访问
        user: 必须被shiro记录过才可以访问，比如：记住我
        授权过滤器：（权限是基于登录的，登录通过，才可能有权限）
        perms:  必须拥有某个资源的权限时才可以访问（资源可是页面）
        role:  必须拥有某个角色权限时才可以访问
        port：请求的借口必须是指定值才可以访问
        rest：请求必须基于restful:post,put,get,delete才可以访问
        ssl：必须是安全的URL请求，基于HTTPS协议才可以访问
         *//*
		//拦截+权限
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		//对登录资源请求进行授权，正常的情况下，没有授权会跳出未授权页面

		//anon无需认证就可以访问的页面（首页）
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/unauthorized", "authc");
		//拥有add资源权限即可访问页面
		filterChainDefinitionMap.put("/user/add", "perms[add]");
		//拥有update资源权限即可访问页面
		filterChainDefinitionMap.put("/user/update", "perms[update]");

		//拥有admin角色权限即可访问页面
		filterChainDefinitionMap.put("/user/admin", "roles[admin]");
		//拥有root角色权限即可访问页面
		filterChainDefinitionMap.put("/user/root", "roles[root]");

		//登录就能访问/user/*下所有页面  （权限越大放后面，以防止大权限泄露给后面的请求）
		filterChainDefinitionMap.put("/user/*", "authc");

		//过滤器会拦截以上请求做权限资源判断
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		//设置未登录页面（未登录则跳到未登录页面）
		shiroFilterFactoryBean.setLoginUrl("/tologin");
		//设置为授权页面（未授权则跳到未授权页面）
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");*/

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizedurl");
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/doLogin", "anon");
		map.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}

	/**
	 * Description: 二、DefaultWebSecurityManager（SecurityManager是 Shiro 的核心部分，负责安全认证和授权。其子类：
	 * DefaultWebSecurityManager是安全管理器，开发者自定义的 Realm 需要注入到 DefaultWebSecurityManager 进行管理才能生效。
	 * 通过@Qualifier注解找到IOC容器中对应的userRealm对象
	 * @date 20.7.16 09:22
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDeafaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联自定义的Realm(可以配置多个，至少配置一个)
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	/**
	 * Description: 三、创建Realm对象(通过自定义类：开发者自定义的模块，根据项目的需求，验证和授权的逻辑全部写在 Realm 中。）
	 * 通过@Bean注解把UserRealm对象交给IOC容器管理（用name="userRealm"对其进行标识）
	 * @date 20.7.16 09:22
	 */
	@Bean(name = "userRealm")
	public UserRealm getUserRealm() {
		return new UserRealm();
	}
}
