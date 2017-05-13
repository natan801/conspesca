package br.com.conspesca.utils;

import java.util.Random;

public class CorUtil {

	private String cor;

	public String getCor() {
		Random randCol = new Random();

		int r = randCol.nextInt(256);
		int g = randCol.nextInt(256);
		int b = randCol.nextInt(256);

		this.cor = '#' + this.tratarHexString(Integer.toHexString(r)) + this.tratarHexString(Integer.toHexString(g))
				+ this.tratarHexString(Integer.toHexString(b));
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	private String tratarHexString(String hexString) {
		String hex = null;
		if (hexString.length() == 1) {
			hex = '0' + hexString;
		} else {
			hex = hexString;
		}
		return hex;
	}

}
