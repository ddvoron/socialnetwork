package controller;

import com.voronovich.pojo.User;
import com.voronovich.service.UserService;
import hash.Sha256;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/user")
public class LoginController {

    private static final int TIME_SESSION = 10000;
    private static final String STATIC_SALT = ResourceBundle.getBundle("staticValue").getString("staticValue");
    private static final String MESSAGE_CORRECTION = "Проверьте корректность ввода логина и пароля";
    private static final String MESSAGE_BLACKLISTED = "Ваш профиль заблокирован за несоблюдение правил сайта, " +
            "за дополнительной информацией обратитесь к администратору.";

    @Autowired
    private UserService userService;

    /**
     * Method returns view with login form
     *
     * @param model
     * @return view
     */
    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String showLogForm(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        return "signIn";
    }

    /**
     * Method authenticates the user
     *
     * @param user userEntity form data
     * @param request
     * @return view
     */
    @RequestMapping(value = "/logging", method = RequestMethod.POST)
    public String logIn(@ModelAttribute("userForm") User user,
                        HttpServletRequest request) {
        User userNew = userService.getByEmail(user.getEmail());
        if (userNew != null) {
            String salt = userService.getByEmail(user.getEmail()).getSalt();
            String password1 = Sha256.sha256(user.getPassword() + salt + STATIC_SALT);
            if (userService.getByEmailAndPassword(user.getEmail(), password1) == null) {
                request.setAttribute("message", MESSAGE_CORRECTION);
                return "signIn";
            } else if (StringUtils.equals(userService.getByEmailAndPassword(user.getEmail(), password1).getBlackList(), "true")) {
                request.setAttribute("message", MESSAGE_BLACKLISTED);
                return "signIn";
            } else {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(TIME_SESSION);
                session.setAttribute("user", userNew);
                request.setAttribute("message", "Добро пожаловать, " + userNew.getName());
                return "redirect:../home";
            }
        } else {
            request.setAttribute("message", MESSAGE_CORRECTION);
            return "signIn";
        }
    }
}
