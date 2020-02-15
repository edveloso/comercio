package edu.infnet.comercio.controler;

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

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

	
	private static Logger logger = LogManager.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("<<<<<<< before any servlet");
		String user = (String) ((HttpServletRequest) request).getSession().getAttribute("user");
		String uri = (String)((HttpServletRequest) request).getRequestURI();
		if(user == null &&
			!(	uri.contains("UserSrv")
			   || uri.contains("LogoutSrv")
			   || uri.contains("login.jsp")
			   || uri.contains("logon.jsp")
			   || uri.contains("index.jsp")			   
			   || uri.contains("/comercio/js")
			   || uri.contains("/comercio/img")
			   || uri.contains("/comercio/css")
					)
				) {
			((HttpServletResponse)response).sendRedirect("/comercio/login.jsp");
//			request.getRequestDispatcher("login.jsp");
		} else

			chain.doFilter(request, response);
		logger.debug(">>>>>>> after any servlet");
		
	}

	@Override
	public void destroy() {	}

}
