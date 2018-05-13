package com.shsxt.xmjf.web.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by lp on 2018/4/9.
 */
@Controller
public class ImageController {
    @Resource
    private Producer producer;


    @RequestMapping("image")
    public  void getImage(HttpServletRequest request, HttpServletResponse response){
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // 获取图片验证码文本内容
        String code= producer.createText();
        // 将code 存入session
        request.getSession().setAttribute("image",code);
        System.out.println("图片验证码:"+code);
        BufferedImage bufferedImage= producer.createImage(code);
        try {
            ServletOutputStream sos= response.getOutputStream();
            ImageIO.write(bufferedImage,"jpg",sos);
            sos.flush();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
