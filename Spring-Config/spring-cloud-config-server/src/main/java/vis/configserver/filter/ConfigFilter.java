//package vis.configserver.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//@Component
//public class ConfigFilter extends GenericFilterBean {
//	private static Logger logger = LoggerFactory.getLogger(ConfigFilter.class);
//	@Value("${accepted.url}")
//	private String acceptedUrl;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//		String url=httpServletRequest.getRemoteHost().toString();
//		logger.info("sender remote host-->"+url);
//		logger.info("sender request url-->"+httpServletRequest.getRequestURL());
//		
////		if (url.contains(acceptedUrl)) {
//			
//			chain.doFilter(request, response);
////		}
//
//	}
//}
