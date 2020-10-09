package spittr.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// DispatcherServlet & ContextLoaderListener.
// Alterantive to classical web.xml file.
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /*
    The first method, getServletMappings(), identifies one or more paths that
    DispatcherServlet will be mapped to. In this case, it’s mapped to /,
    indicating that it will be the application’s default servlet. It will handle
    all requests coming into the application.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    /*
    With the getServletConfigClasses() method in listing 5.1, you’ve asked that
    DispatcherServlet load its application context with beans defined in the
    WebConfig configuration class (using Java configuration).
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }


}
