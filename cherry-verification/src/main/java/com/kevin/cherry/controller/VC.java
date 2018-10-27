package com.kevin.cherry.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 验证码相关工具类
 * @author kevin
 *
 */
public class VC {
	
	public static final String VER_CODE_KEY = "vbaiduc";

	/**
	 * 获取图片流
	 * @param vc 字符串类型的验证码
	 * @param width 图片的宽
	 * @param height 图片的高
	 * @param interLine 干扰线的数量
	 * @return
	 */
	public static BufferedImage generateImageCode(String vc, int width, int height, int interLine) {
		BufferedImage bim = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bim.getGraphics();
		// 画背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 画干扰线
		Random r = new Random();
		if (interLine > 0) {
			int x = 0, y = 0, x1 = width, y1 = 0;
			for (int i = 0; i < interLine; i++) {
				g.setColor(getRandomColor());
				y = r.nextInt(height);
				y1 = r.nextInt(height);

				g.drawLine(x, y, x1, y1);
			}
		}
		// 写验证码
		// 字体大小为图片高度的80%
		int fsize = (int) (height * 0.8);
		g.setFont(new Font("Default", Font.PLAIN, fsize));

		int fx = height - fsize;
		int fy = fsize;
		// 写验证码字符
		for (int i = 0; i < vc.length(); i++) {
			fy =(int) ((Math.random() * 0.3 + 0.6) * height);// 每个字符高低随机
			g.setColor(getRandomColor());
			g.drawString(vc.charAt(i) + "", fx, fy);
			fx += fsize * 0.9;
		}

		g.dispose();
		return bim;
	}

	/**
	 * 获取指定长度的纯数字验证码
	 * @param length
	 * @return
	 */
	public static String generateTextCode(int length) {
		int i = 0;
		Random r = new Random();
		StringBuffer code = new StringBuffer();
		while (i < length) {
			int t = r.nextInt(10);
			code.append(t);
			i++;
		}
		return code.toString();
	}

	private static Color getRandomColor() {
		Random r = new Random();
		Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		return c;
	}

}
