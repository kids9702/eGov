package app.mvc.members;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringAutoAppConfig;

public class MemberConfig {
	private static ApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoAppConfig.class);
	
	public static ApplicationContext getApplicationContext() {
    	return ac;
    }
}
