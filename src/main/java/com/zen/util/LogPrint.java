package com.zen.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Classe para gerar Logs (Console e File) com padrões pré-definidos.
 */
public class LogPrint {

	private static final Logger logger = LogManager.getLogger();

	public LogPrint() {
		super();
	}

	public void get(String msg, String type) {
		System.out.println(System.lineSeparator() + "===========>>");
		if (type.equals("info")) {
			logger.info(msg + System.lineSeparator());
		}
		if (type.equals("warn")) {
			logger.warn(msg + System.lineSeparator());
		}
		if (type.equals("error")) {
			logger.error(msg + System.lineSeparator());
		}
	}

}
