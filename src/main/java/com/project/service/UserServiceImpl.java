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

			sb.append("<!DOCTYPE html>")
			  .append("<html lang=\"en\">")
			  .append("<head>")
			  .append("<meta charset=\"UTF-8\">")
			  .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
			  .append("<title>Welcome to I-Repo</title>")
			  .append("<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap' rel='stylesheet'>")
			  .append("<style>")
			  .append("body { font-family: 'Roboto', sans-serif; background-color: #f2f6fc; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }")
			  .append(".email-container { width: 100%; max-width: 600px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); overflow: hidden; }")
			  .append(".email-header { background-color: #556ee6; text-align: center; padding: 20px; color: #ffffff; }")
			  .append(".email-header img { max-width: 100px; margin-bottom: 10px; }")
			  .append(".email-body { padding: 30px 20px; background-color: #cce4f6; text-align: left; }")
			  .append(".email-body h1 { font-size: 24px; color: #333333; margin-top: 0; }")
			  .append(".email-body p { font-size: 16px; color: #666666; line-height: 1.5; }")
			  .append(".login-info { margin: 20px 0; padding: 20px; background-color: #ffffff; border: 1px solid #dddddd; border-radius: 8px; }")
			  .append(".login-info p { margin: 0; padding: 10px 0; font-size: 14px; color: #333333; }")
			  .append(".btn { display: inline-block; padding: 10px 20px; margin-top: 20px; background-color: #556ee6; color: #ffffff; text-decoration: none; border-radius: 5px; }")
			  .append(".btn:hover { background-color: #4056c6; }")
			  .append(".email-footer { background-color: #556ee6; text-align: center; padding: 20px; font-size: 12px; color: #ffffff; }")
			  .append(".email-footer a { color: #ffffff; text-decoration: none; }")
			  .append(".email-footer p { margin: 0; }")
			  .append("</style>")
			  .append("</head>")
			  .append("<body>")
			  .append("<div class='email-container'>")
			  .append("<div class='email-header'>")
			  .append("<img src='https://example.com/logo.png' alt='I-Repo Logo'>")
			  .append("<h1>Welcome to I-Repo!</h1>")
			  .append("</div>")
			  .append("<div class='email-body'>")
			  .append(String.format("<p>Hi %s,</p>", userVO.getUsername()))
			  .append("<p>Thank you for signing up! We're excited to have you on board. You can start using I-Repo to manage your repositories and collaborate with your team today.</p>")
			  .append("<div class='login-info'>")
			  .append(String.format("<p><strong>Username:</strong> %s</p>", userVO.getUsername()))
			  .append(String.format("<p><strong>Password:</strong> %s</p>", password))
			  .append("</div>")
			  .append("<a href='https://example.com/login' class='btn'>Log In Now</a>")
			  .append("<p>Thanks for choosing I-Repo.<br>- The I-Repo Team</p>")
			  .append("</div>")
			  .append("<div class='email-footer'>")
			  .append("<p>Questions? <a href='mailto:support@irepo.com'>Contact Support</a></p>")
			  .append("<p>I-Repo, LLC - 2527 Broad Ave, Memphis, TN 38112</p>")
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