package com.qd.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.qd.utils.R;
import com.qd.utils.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by chenlongbo on 2017/4/16.
 */
@Controller
@RequestMapping("/mana/home")
public class LoginCtrl extends BaseController{

    @Autowired
    private Producer producer;

    /**
     * 验证码
     * @param response
     * @throws IOException
     */
    @RequestMapping("/captcha.jpg")
    public  void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");

        String tect = producer.createText();
        BufferedImage image = producer.createImage(tect);
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY,tect);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpeg",out);

    }

    /**
     * 登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R login (String username, String password, String captcha){

        //String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        //if(!captcha.equalsIgnoreCase(kaptcha)){
        //	return R.error("验证码不正确");
        //}

        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
        } catch (UnknownAccountException e) {
           return  R.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
           return  R.error(e.getMessage());
        }catch (AuthenticationException e){
           return  R.error("账户验证失败");
        }
        return R.ok();

    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "logout" ,method = RequestMethod.POST)
    public String logout(){
        ShiroUtils.logout();

        return  "/views/login/login";
    }
}
