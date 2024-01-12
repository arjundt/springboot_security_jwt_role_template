package in.cdac.epramaan.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import in.cdac.epramaan.util.URIConstants;
import lombok.RequiredArgsConstructor;

@Configuration
//@EnableWebSecurity(debug = true)
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	
	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers(URIConstants.FORWARD_SLASH + URIConstants.ADMIN 
//				+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR).hasAuthority(Roles.ADMIN)
//		.requestMatchers(URIConstants.FORWARD_SLASH + URIConstants.USER 
//				+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR).hasAuthority(Roles.USER)
//		.requestMatchers(URIConstants.FORWARD_SLASH + URIConstants.FIDUCIARY 
//				+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR).hasAuthority(Roles.FIDUCIARY)
//		.requestMatchers(URIConstants.FORWARD_SLASH + URIConstants.DATA_PRINCIPLE
//				+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR).hasAuthority(Roles.DATA_PRINCIPLE)
		.requestMatchers(
				URIConstants.FORWARD_SLASH + URIConstants.SECURITY_OPEN_URL 
					+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR,
				URIConstants.FORWARD_SLASH + "swagger-ui" 
						+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR,
//				URIConstants.FORWARD_SLASH + "swagger-resources" 
//						+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR,
				URIConstants.FORWARD_SLASH + "v3/api-docs" 
						+ URIConstants.FORWARD_SLASH + URIConstants.STAR_STAR
			)
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	// Provides internationalization of messages
    /**
     * Message source.
     *
     * @return the resource bundle message source
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames(new String[]{
		"labels",
		"ui-messages",
		"email-messages",
		"mobile-messages",
		"system-error-messages",
		"field-error-messages"});
        return source;
    }

}
