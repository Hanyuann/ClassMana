package cn.classroom.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import sun.misc.BASE64Encoder;

public class WebUtils {
	// 把request域中的对象封装到javabean中
	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {

		try {
			// 1.创建要封装数据的bean
			T bean = beanClass.newInstance();
			// 2.把request中的数据整到bean中
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			request.setCharacterEncoding("UTF-8");
			String s_checkcode = (String) request.getSession().getAttribute(
					"checkcode");
			BeanUtils.setProperty(bean, "s_checkcode", s_checkcode);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 产生全世界唯一的ID
	public static String generateID() {
		return UUID.randomUUID().toString();
	}

	// 复制一个bean到另一个bean
	public static void copyBean(Object src, Object dest) {
		// private String username;
		// private String password;
		// private String password2;
		// private String checkcode;
		// private Map<String, String> errors = new HashMap<String, String>();
		// private String s_checkcode;
		//
		// private String id;
		// private String username;
		// private String password;
		// private String type;

		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// md5加密方法
	public static String md5(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
