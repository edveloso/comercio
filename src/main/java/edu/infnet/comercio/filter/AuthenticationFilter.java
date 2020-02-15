package edu.infnet.comercio.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = "/*" )
public class AuthenticationFilter implements Filter {

	private static Logger logger = LogManager.getLogger(AuthenticationFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {

		// String user = (String)
		// ((HttpServletRequest)request).getSession().getAttribute("user");
		logger.debug("Anter de passar no filtro");
		HttpServletRequest req = (HttpServletRequest) request;
		String user = (String) req.getSession().getAttribute("user");
		String url = req.getRequestURI();
		if(user == null 
				&& !(
					url.contains("login.jsp")
				   || url.contains("/comercio/img")
				   || url.contains("/comercio/css")
				   || url.contains("/comercio/js")
				   || url.equals("/comercio/UserSrv")
					)
		 ) {
			((HttpServletResponse)response).sendRedirect("/comercio/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
		logger.debug("Passou no filtro");

	}

	@Override
	public void destroy() {
	}

}
