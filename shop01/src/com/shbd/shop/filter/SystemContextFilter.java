package com.shbd.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shbd.shop.model.SystemContext;

public class SystemContextFilter implements Filter {
	int pageSize;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			int pageOffset = 0;
//			int pageIndex = 1;
			int pageSize = 15;
			try {
				pageOffset = Integer.parseInt(request.getParameter("pager.offset"));
//				pageIndex = Integer.parseInt(request.getParameter("pageIndex")) ;
			}catch (NumberFormatException e) {
				// TODO: handle exception
			}
			SystemContext.setPageOffset(pageOffset);
//			SystemContext.setPageIndex(pageIndex);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(request, response);			
		}finally {
			SystemContext.removerPageOffset();
//			SystemContext.removerPageIndex();
			SystemContext.removerPageSize();
		}
				
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		}catch (NumberFormatException e) {
			pageSize = 15;
		}		
	}

}
