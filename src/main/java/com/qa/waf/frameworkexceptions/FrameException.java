package com.qa.waf.frameworkexceptions;

public class FrameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameException(String msg) {
		
		super(msg);
		printStackTrace();
	}

}
