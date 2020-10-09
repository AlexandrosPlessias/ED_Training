package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.controller") // Look at controller package scan for components.
public class WebConfig implements WebMvcConfigurer {

    //Configure a JSP view resolver.
    /*
    configured to look for files by wrapping view names with a specific prefix
    and suffix (for example: a view name of "home" will be resolved
    as WEB-INF/views/home.jsp).
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        /*
        JSTL’s formatting tags need a to properly format locale-specific values such Locale as dates and money.
        And its message tags can use a Spring message source and a to properly choose messages to render in HTML.
        By resolving JstlView, the JSTL Locale tags will be given the and any message source configured in Spring.
         */
        //resolver.setViewClass(JstlView.class);
        return resolver;
    }

    //Configure static content handling.
    /*
    By calling enable() on the given DefaultServletHandlerConfigurer, you’re
    asking DispatcherServlet to forward requests for static resources to the
    servlet container’s default servlet and not to try to handle them itself.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
