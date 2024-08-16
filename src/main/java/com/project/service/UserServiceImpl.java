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
			sb.append("<html>").append("<head>")
					.append("<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap' rel='stylesheet'>")
					.append("<style>")
					.append("body { font-family: 'Roboto', sans-serif; background-color: #f2f6fc; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }")
					.append(".email-container { width: 100%; max-width: 600px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); overflow: hidden; }")
					.append(".email-header { background-color: #007bff; text-align: center; padding: 20px; }")
					.append(".email-header img { max-width: 100px; }")
					.append(".email-body { padding: 20px; background-color: #cce4f6; }")
					.append(".email-body h1 { font-size: 24px; color: #333333; margin-top: 0; }")
					.append(".email-body p { font-size: 16px; color: #666666; line-height: 1.5; }")
					.append(".email-body .login-info { margin: 20px 0; }")
					.append(".email-body .login-info p { margin: 0; padding: 10px 0; font-size: 14px; color: #333333; }")
					.append(".email-body .login-info strong { color: #333333; }")
					.append(".email-footer { text-align: center; padding: 20px; font-size: 12px; color: #999999; }")
					.append(".email-footer a { color: #007bff; text-decoration: none; }")
					.append(".btn { display: inline-block; padding: 10px 20px; margin-top: 20px; background-color: #28a745; color: #ffffff; text-decoration: none; border-radius: 5px; }")
					.append(".btn:hover { background-color: #218838; }").append("</style>").append("</head>")
					.append("<body>").append("<div class='email-container'>").append("<div class='email-header'>")
					.append("<img src='https://via.placeholder.com/100' alt='I-Repo Logo'>").append("</div>")
					.append("<div class='email-body'>").append("<h1>Welcome to I-Repo!</h1>")
					.append("<p>Hi " + userVO.getUsername() + ",</p>")
					.append("<p>You can start using I-Repo to manage your repositories and collaborate with your team today.</p>")
					.append("<p><strong>Username:</strong> " + userVO.getUsername() + "</p>")
					.append("<p><strong>Password:</strong> " + password + "</p>")
					.append("<a href='#' class='btn' style='background-color: #007bff;'>Free Class</a>")
					.append("</div>").append("<div class='email-footer'>")
					.append("<p>&copy; 2024 I-Repo. All rights reserved.</p>")
					.append("<p>Questions? <a href='mailto:support@irepo.com'>Contact Support</a></p>")
					.append("<p>123 I-Repo Street, Suite 100, San Francisco, CA 94107</p>").append("</div>")
					.append("</div>").append("</body>").append("</html>");
			String message = sb.toString();

			Basemethods.sendMail(subject, message, userVO.getEmail());

		}

		this.userDAO.saveUser(userVO);

	}

	@Override
	public List<UserVO> findById(int id) {
		return this.userDAO.findById(id);
	}

	@Override
	public boolean checkUsername(String username) {
		List<UserVO> userList = this.userDAO.checkUsername(username);
		return userList.size() > 0;
	}

}