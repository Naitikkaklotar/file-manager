package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.LoginDAO;
import com.project.DAO.UserDAO;
import com.project.model.LoginVO;
import com.project.model.UserVO;
import com.project.utils.Basemethods;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public List<UserVO> findAll() {
		return this.userDAO.findAll();
	}

	@Override
	public void deleteUser(int id) {
		List<UserVO> ls = this.userDAO.findById(id);
		UserVO userVO = ls.get(0);

		userVO.setStatus(false);
		this.userDAO.saveUser(userVO);
	}

	@Override
	public void saveUser(UserVO userVO) {

		System.out.println(userVO.getUsername());

		if (userVO.getId() > 0) {

			List<LoginVO> ls = this.loginDAO.findById(userVO.getLoginVO().getId());
			LoginVO loginVO = ls.get(0);
			userVO.setUsername(loginVO.getUsername());

		} else {

			LoginVO loginVO = new LoginVO();

			loginVO.setEnabled("1");
			loginVO.setUsername(userVO.getUsername());
			
			String password = "password";
			loginVO.setPassword(password);
			
			
			
			loginVO.setPassword("password");
			loginVO.setRole("ROLE_USER");

			this.loginDAO.save(loginVO);

			userVO.setLoginVO(loginVO);

			// SEND MAIL TO USER
			
			String subject = "Welcome to I-Repo";
			StringBuilder sb = new StringBuilder();
	        sb.append("<html>")
	          .append("<head>")
	          .append("<style>")
	          .append("body { font-family: Arial, sans-serif; }")
	          .append(".container { width: 80%; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; background-color: #f9f9f9; }")
	          .append(".header { text-align: center; padding: 10px 0; }")
	          .append(".content { margin: 20px 0; }")
	          .append(".footer { text-align: center; font-size: 12px; color: #777; margin-top: 20px; }")
	          .append("</style>")
	          .append("</head>")
	          .append("<body>")
	          .append("<div class='container'>")
	          .append("<div class='header'>")
	          .append("<h1>Welcome to I-Repo</h1>")
	          .append("</div>")
	          .append("<div class='content'>")
	          .append(String.format("<p>Hello %s,</p>", userVO.getUsername()))
	          .append("<p>You have been successfully registered in I-Repo.</p>")
	          .append(String.format("<p><strong>Username:</strong> %s</p>", userVO.getUsername()))
	          .append(String.format("<p><strong>Password:</strong> %s</p>", password))
	          .append("</div>")
	          .append("<div class='footer'>")
	          .append("<p>&copy; 2024 I-Repo. All rights reserved.</p>")
	          .append("</div>")
	          .append("</div>")
	          .append("</body>")
	          .append("</html>");

	        String message = sb.toString();
			
			
			
			
			
			
			/*String message = String.format("Hello %s,\n\nYou have been successfully registered in I-Repo.\n\nUsername: %s\nPassword: %s\n",
			        userVO.getUsername(), userVO.getUsername(), password);*/
			
			
			
			Basemethods.sendMail(subject, message, userVO.getEmail());
			
			/*Basemethods.sendMail("Welcome to I-Repo", "You have been successfully register in i-repo.",
					userVO.getEmail());*/
		}

		this.userDAO.saveUser(userVO);

	}

	@Override
	public List<UserVO> findById(int id) {
		return this.userDAO.findById(id);
	}

}