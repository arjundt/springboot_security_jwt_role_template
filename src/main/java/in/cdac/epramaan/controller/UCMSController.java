package in.cdac.epramaan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

//deny access to any method without explicit authorization
@PreAuthorize("denyAll")
@RestController
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:email-messages.properties"),
        @PropertySource(value = "classpath:mobile-messages.properties"),
        @PropertySource(value = "classpath:ui-messages.properties"),
        @PropertySource(value = "classpath:labels.properties"),
        @PropertySource(value = "classpath:system-error-messages.properties"),
        @PropertySource(value = "classpath:field-error-messages.properties")})
public class UCMSController {
	
	/** The environment. */
    @Autowired
    Environment environment;

}
