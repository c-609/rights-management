package cn.team.config;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.team.bean.RespBean;
import cn.team.bean.ResultBean;
import cn.team.common.UserUtils;
import cn.team.exception.AuthenticationAccessDeniedHandler;
import cn.team.service.UserService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;

	@Autowired
	private UrlAccessDecisionManager urlAccessDecisionManager;
	@Autowired
    CustomMetadataSource metadataSource;
	@Autowired
    AuthenticationAccessDeniedHandler deniedHandler;
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());

	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**","/favicon.ico","/login_p","/user","/login");
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        	.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
	            @Override
	            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
	                o.setSecurityMetadataSource(metadataSource);
	                o.setAccessDecisionManager(urlAccessDecisionManager);
	                return o;
	            }
        	})
        		//.antMatchers("/register", "/doRegister", "/login", "/doLogin").permitAll() //允许直接访问的
        		//.anyRequest().authenticated() //其他的都得通过验证

        		.and()
                .formLogin()  //使用表单登录页面
                .loginPage("/login")   //登录url
                .loginProcessingUrl("/doLogin")   //登录提交url
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        AuthenticationException e) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        ResultBean resultBean = new ResultBean("LOGIN FAIL");
                        resultBean.setCode(ResultBean.CHECK_FAIL);
//                        if (e instanceof BadCredentialsException ||
//                                e instanceof UsernameNotFoundException) {
//                            respBean = RespBean.error("账户名或者密码输入错误!");
//                        } else if (e instanceof LockedException) {
//                            respBean = RespBean.error("账户被锁定，请联系管理员!");
//                        } else if (e instanceof CredentialsExpiredException) {
//                            respBean = RespBean.error("密码过期，请联系管理员!");
//                        } else if (e instanceof AccountExpiredException) {
//                            respBean = RespBean.error("账户过期，请联系管理员!");
//                        } else if (e instanceof DisabledException) {
//                            respBean = RespBean.error("账户被禁用，请联系管理员!");
//                        } else {
//                            respBean = RespBean.error("登录失败!");
//                        }
                        
                        resp.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(resultBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication auth) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
//                        List<Object> list = new ArrayList<>();
//                        list.add("登陆成功");
//                        list.add(UserUtils.getCurrentUser());
//                        ResultBean<Object> respBean = new ResultBean<Object>(list);
//           
                        
                        RespBean respBean = RespBean.ok("登录成功!", UserUtils.getCurrentUser());
                        resp.sendRedirect("/user");
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = resp.getWriter();
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
                    }
                })
                .permitAll()
        		//.httpBasic()     //security提供的登录页面
                .and()
        		.logout()
        		.logoutUrl("/logout")
//                .logoutSuccessHandler(new LogoutSuccessHandler() {
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = resp.getWriter();
//                        out.write(om.writeValueAsString(new ResultBean<String>("注销成功")));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()        
                .and()
                .csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);

    }
}