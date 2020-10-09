package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@ComponentScan(basePackages = {"spittr"}, excludeFilters = {@ComponentScan.Filter (type = FilterType.ANNOTATION, value= EnableWebMvc.class)})
public class RootConfig {
    /*
    The only significant thing to note in RootConfig is that it’s annotated
    with @ComponentScan. There will be plenty of opportunities throughout
    this book to flesh out RootConfig with non-web components.
     */
}
