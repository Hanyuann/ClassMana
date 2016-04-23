package cn.classroom.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.classroom.dao.UserDao;
import cn.classroom.dao.impl.UserDaoImpl;
import cn.classroom.utils.WebUtils;

public class UpdateUserForm {
	private String id;
	private String username;
	private String oldpassword;
	private String password;
	private String password2;
	private String type;
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean validate() {
		boolean isOK = true;

		if (this.oldpassword == null || this.oldpassword.trim().equals("")) {
			isOK = false;
			errors.put("oldpassword", "旧密码不能为空！");
		} else {
			UserDao dao = new UserDaoImpl();
			String np = WebUtils.md5(this.oldpassword);
			if (dao.findUser(username, np, type) == null) {
				isOK = false;
				errors.put("oldpassword", "密码错误！");
			}
		}

		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "确认密码不能为空！");
		} else {
			if (!this.password.matches("[A-Za-z0-9]{3,8}")) {
				isOK = false;
				errors.put("password", "密码必须是3-8位数字或字母!");
			}
		}

		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空！");
		} else {
			if (!this.password.equals(this.password2)) {
				isOK = false;
				errors.put("password2", "两次密码必须一致!");
			}
		}

		return isOK;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
}
