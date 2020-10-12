package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
//@WebAppConfiguration("WebContent")
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
        //resolver.setExposeContextBeansAsAttributes(true);

        //JSTL’s formatting tags need a to properly format locale-specific values such Locale as dates and money.
        //And its message tags can use a Spring message source and a to properly choose messages to render in HTML.
        //By resolving JstlView, the JSTL Locale tags will be given the and any message source configured in Spring.
        //
        resolver.setViewClass(JstlView.class);
        return resolver;
    }


    /*
    Suppose you want to add a common header and footer to all pages in the application. The naive way to do this is to
    visit every JSP template and add the HTML for the header and footer. But that approach doesn’t scale well with
    regard to maintenance. There’s an initial cost of adding those elements to each and every page, and any future
    changes will incur a similar cost. A better approach is to use a layout engine such as Apache Tiles to define a
    common page layout that will be applied to all pages.
     */

    /*
     @Bean
     public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
     	tiles.setDefinitions(new String[] {"/WEB-INF/layout/tiles.xml"});
     	tiles.setCheckRefresh(true);
     	return tiles;
     }

     @Bean
     public ViewResolver viewResolver() {
        return new TilesViewResolver();
     }
 */

    //Configure static content handling.
    /*
    By calling enable() on the given DefaultServletHandlerConfigurer, you’re
    asking DispatcherServlet to forward requests for static resources to the
    servlet container’s default servlet and not to try to handle them itself.

    //Theme Leaf.
    @Bean
    public ViewResolver viewResolver( SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
