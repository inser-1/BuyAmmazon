package com.oaec.web.servlet;

import com.oaec.domain.User;
import com.oaec.service.UserService;
import com.oaec.service.UserServiceImp.UserServiceImp;
import com.oaec.utils.UUIDUtils;
import com.oaec.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * 跳转到注册页面
     * */

    public String registView(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        return "register.jsp";
    }
    /**
     * 用户注册
     */
    public String registe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();
        Class aClass = user.getClass();
        try {
            BeanUtils.populate(user, parameterMap);
            user.setUid(UUIDUtils.getId());
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImp();
        try {
            userService.registe(user);
        } catch (Exception e) {
            /**
             * 失败提示
             */
            req.setAttribute("msg", "注册失败");
        }
        /**
         * 成功跳转
         */
        return "reg-result.jsp";
    }

    public String loginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "login.jsp";
    }

    /**
     *用户登录
     */
    public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        User user1 = null;
        try {
            BeanUtils.populate(user,req.getParameterMap());
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImp();
        try {
            //登录成功
            user1 = userService.login(user);
            req.getSession().setAttribute("login",user1);
            resp.sendRedirect("/index.jsp");
            return null;
        } catch (Exception e) {
            //失败
            String s = e.getMessage();
            System.out.println(s);
            req.setAttribute("msg",s);
            return  "login.jsp";
        }
    }

    public String exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/index.jsp");
        return null;
    }
}

