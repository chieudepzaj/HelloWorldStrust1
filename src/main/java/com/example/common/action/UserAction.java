package com.example.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.example.common.model.User;
import com.example.common.model.UserDto;
import com.example.common.service.UserService;

public class UserAction extends MappingDispatchAction {

	public ActionForward loginUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = (HttpSession) request.getAttribute("loggin");
		if (session != null) {
			System.out.println("ok");
		}
		return mapping.findForward("loginUser");
	}

	public ActionForward loginUserpro(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		String login = (String) session.getAttribute("loggin");
		if (login == null) {
			User user = (User) form;
			UserService userService = new UserService();
			int result = userService.login(user.getUsername(), user.getPassword());
			if (result <= 0) {
				request.setAttribute("message", "Username or password wrong");
				System.out.println("Something wrong! Cannot login user");
			} else {
				request.setAttribute("message", "Login user successfully!");
				System.out.println("Login user successfully!");
				session.setAttribute("loggin", user.getUsername());
				return mapping.findForward("loginsuccess");
			}

		}

		response.sendRedirect("/HelloWorldStrust1/common/list-user.html");
		return null;

	}

	public ActionForward logoutUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = (HttpSession) request.getSession(true);

		session.removeAttribute("loggin");

		return mapping.findForward("logoutUser");
	}

	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("addUser");
	}

	public ActionForward addUserpro(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int i;
		User user = (User) form;
		UserService userService = new UserService();
		UserDto userDto = new UserDto(user.getUsername(), Integer.valueOf(user.getAge()), user.getEmail(),
				user.getAddress(), user.getPassword());
//		UserDto users = userService.getUserByUsername(user.getUsername());
//		if(users!= null) {
//			i = 6;
//		}else {
		i = checkInput(userDto);
		// }
		switch (i) {
		case 1:
			request.setAttribute("message", "Username is requite and username has at least 6 characters");
			break;
		case 2:
			request.setAttribute("message", "Age is requite and greater than 0");
			break;
		case 3:
			request.setAttribute("message", "Email is requite");
			break;
		case 4:
			request.setAttribute("message", "Address is requite");
			break;
		case 5:
			request.setAttribute("message", "Password is requite and password has at least 6 characters");
			break;
		case 6:
			request.setAttribute("message", "Username has already existed");
			break;
		default:
			break;
		}
		if (i == 0) {
			int result = userService.addUser(userDto);
			if (result <= 0) {
				request.setAttribute("message", "Something wrong! Cannot add user");
				System.out.println("Something wrong! Cannot add user");
			} else {
				request.setAttribute("message", "Add new user successfully!");
				System.out.println("Add new user successfully!");
			}
		}
		return mapping.findForward("addUserpro");
	}

	public ActionForward listUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService userService = new UserService();
		List<UserDto> list = userService.getListUsers();
		request.setAttribute("list", list);

		return mapping.findForward("listUser");
	}

	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		String login = (String) session.getAttribute("loggin");
		if (login != null) {
			String username = request.getParameter("username");
			UserService userService = new UserService();
			int result = userService.deleteUser(username);
			if (result <= 0) {
				request.setAttribute("message", "Something wrong! Cannot delete user");
			} else {
				request.setAttribute("message", "Delete user sucessfully!");
			}
			userService = new UserService();
			List<UserDto> list = userService.getListUsers();
			request.setAttribute("list", list);

			return mapping.findForward("deleteUser");
		} else {
			response.sendRedirect("/HelloWorldStrust1/common/login-user.html");
			return null;
		}
	}

	public ActionForward editUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		UserService userService = new UserService();
		UserDto user = userService.getUserByUsername(username);
		request.setAttribute("user", user);

		return mapping.findForward("editUser");
	}

	public ActionForward editUserpro(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int i;
		User user = (User) form;
		UserService userService = new UserService();
		UserDto userDto = new UserDto(user.getUsername(), Integer.valueOf(user.getAge()), user.getEmail(),
				user.getAddress(), user.getPassword());
		i = checkInput(userDto);
		switch (i) {
		case 1:
			request.setAttribute("message", "Username is requite and username has at least 6 characters");
			break;
		case 2:
			request.setAttribute("message", "Age is requite and greater than 0");
			break;
		case 3:
			request.setAttribute("message", "Email is requite");
			break;
		case 4:
			request.setAttribute("message", "Address is requite");
			break;
		case 5:
			request.setAttribute("message", "Password is requite and password has at least 6 characters");
			break;
		default:
			break;
		}
		if (i == 0) {
			int result = userService.updateUser(userDto);
			if (result <= 0) {
				request.setAttribute("message", "Something wrong! Cannot update user");
				System.out.println("Something wrong! Cannot update user");
			} else {
				request.setAttribute("message", "Update user successfully!");
				System.out.println("Update user successfully!");
			}
			userService = new UserService();
			List<UserDto> list = userService.getListUsers();
			request.setAttribute("list", list);
		}
		return mapping.findForward("editUserpro");
	}

	private int checkInput(UserDto userDto) {
		int i = 0;
		// TODO Auto-generated method stub
		if (userDto.getUsername() == null || userDto.getUsername().length() < 6) {
			return i = 1;
		}
		if (String.valueOf(userDto.getAge()) == null || userDto.getAge() <= 0) {
			return i = 2;
		}
		if (userDto.getEmail() == null) {
			return i = 3;
		}
		if (userDto.getAddress() == null) {
			return i = 4;
		}
		if (userDto.getPassword() == null || userDto.getPassword().length() < 6) {
			return i = 5;
		}
		return i;

	}

}
