package com.kevin.cherry.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vc")
public class VerificationCodeController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void get(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setHeader("Cache-Control", "no-cache");
		String vc = VC.generateTextCode(4);
		System.out.println("vc = " + vc);
		req.getSession().setAttribute(VC.VER_CODE_KEY, vc);
		res.setContentType("image/jpeg");
		BufferedImage bim = VC.generateImageCode(vc, 90, 30, 3);
		ImageIO.write(bim, "JPEG", res.getOutputStream());
	}
	
	@RequestMapping(value = "/vali", method = RequestMethod.POST)
	public String validate(HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "vc") String vc) {
		String code = (String)req.getSession().getAttribute(VC.VER_CODE_KEY);
		System.out.println("code = " + code);
		
		return vc.equals(code) + "";
	}
}
