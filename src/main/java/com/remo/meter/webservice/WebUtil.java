package com.remo.meter.webservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.remo.meter.service.RepositoryService;

public class WebUtil {
	static final Logger logger = LogManager.getLogger(WebUtil.class);

	@Autowired
	private RepositoryService repositoryService;

	public void processReturn(HttpServletResponse response, int httpServletResponseCode, String contentType,
			String message) {
		try {
			if (httpServletResponseCode > 0) {
				response.setStatus(httpServletResponseCode);
			}

			if (contentType != null && contentType.length() > 0) {
				response.setContentType(contentType);
			}
			PrintWriter out = response.getWriter();
			out.print(message);
			out.flush();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}
}
