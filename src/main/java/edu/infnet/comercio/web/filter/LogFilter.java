package edu.infnet.comercio.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebFilter("/*")
public class LogFilter implements Filter {

	private static Logger logger = LogManager.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Requisicao chegando ");
		chain.doFilter(request, response);
		logger.info("Requisicao finalizou o processamento");
		
	}

	@Override
	public void destroy() {	}

}
