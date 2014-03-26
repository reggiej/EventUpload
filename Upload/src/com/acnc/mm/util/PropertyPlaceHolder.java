package com.acnc.mm.util;






import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PropertyPlaceHolder {
	
	
	public static PropertyPlaceholderConfigurer properties(){
		
		  PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		
		  Resource[] resources = new ClassPathResource[ ]
		
		    { new ClassPathResource( "application.properties" ) };
		
		  ppc.setLocations( resources );
		
		  ppc.setIgnoreUnresolvablePlaceholders( true );
		
		  return ppc;
		
		}


}
