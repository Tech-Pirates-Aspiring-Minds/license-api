package com.kg.licence.model;

public class SessionDetail {

	private boolean valid;
	private long usedTokens;
	private long actualTokens;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public long getUsedTokens() {
		return usedTokens;
	}

	public void setUsedTokens(long usedTokens) {
		this.usedTokens = usedTokens;
	}

	public long getActualTokens() {
		return actualTokens;
	}

	public void setActualTokens(long actualTokens) {
		this.actualTokens = actualTokens;
	}

}
