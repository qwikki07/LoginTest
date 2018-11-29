package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //在对应的方法上，视图解析器可以解析return 的jsp、html页面，并且跳转到到相应页面
//若需要返回JSON、xml或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
@RequestMapping("/front/*")
public class IndexController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/addregister")
	public String register(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		if(password.equals(password2)){
			UserEntity userEntity=new UserEntity();
			userEntity.setUsername(username);
			userEntity.setPassword(password);
			userDao.save(userEntity);
			return "index";
		}
		else{
			return "login";
		}
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/addlogin")
	public String login(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserEntity userEntity =userDao.findByUsernameAndPassword(username, password);
		String str="";
		if(userEntity!=null){
			str="index";
		}else{
			str="login";
		}
		return str;
	}
	
	
	
}
