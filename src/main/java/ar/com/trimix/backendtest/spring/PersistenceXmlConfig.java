package ar.com.trimix.backendtest.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "ar.com.trimix.backendtest.persistence.dao", "ar.com.trimix.backendtest.persistence.service", "ar.com.trimix.backendtest.filter" })
@ImportResource({ "classpath:hibernate5Config.xml" })
public class PersistenceXmlConfig {

}