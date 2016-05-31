package utils.gson;

import java.net.URL;

public class Test {
	public void properties() {
		URL url = this.getClass().getClassLoader().getResource("log4j.properties");
		System.out.println(url.getPath());
	}
}
