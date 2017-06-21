package com.chatbot.utils;

public enum EndpointURL {

	GET_QUERY("/search/?query=shirts&src=all");

	String resourcePath;

	private EndpointURL(String resourcePath) {

		this.resourcePath = resourcePath;
	}

	public String getResourcePath() {

		return this.resourcePath;
	}

	public String getResourcePath(String data) {

		return this.resourcePath + data;
	}

	public static void main(String[] args) {

		System.out.println(EndpointURL.GET_QUERY.getResourcePath());

		/*System.out.println("Making the full URL for Get_Query");
		System.out.println(URL.fixURL + EndpointURL.GET_QUERY.getResourcePath());*/

		String url = URL.fixURL + EndpointURL.GET_QUERY.getResourcePath();

		System.out.println(url);
	}
}
