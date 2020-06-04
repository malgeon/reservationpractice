package io.korconut.reservationpractice.envi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
	@PropertySource( value = "file:C:/Users/N/eclipse-workspace/environment/src/main/resource/projectcconfig.properties", ignoreResourceNotFound = true)
})
 
public class GlobalPropertySource {
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	    
	@Value("${spring.datasource.url}")
	private String url;
	    
    @Value("${spring.datasource.username}")
    private String username;
	    
    @Value("${spring.datasource.password}")
    private String password;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GlobalPropertySource [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}

}
