package controller;

import com.voronovich.pojo.User;
import com.voronovich.service.RoleService;
import com.voronovich.service.UserService;
import hash.RandomSalt;
import hash.Sha256;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final int DEFAULT_USER_ID = 0;
    private static final int DEFAULT_ROLE_ID = 1;
    private static final int LENGTH_RANDOM_NUMBER = 20;
    private static final String BLOCK_VALUE = "false";
    private static final String STATIC_SALT = ResourceBundle.getBundle("staticValue").getString("staticValue");
    private static final String MESSAGE_REGISTRATION_FAIL = "Ошибка регистрации";
    private static final String MESSAGE_DATA_CORRECTION = "Введите корректные данные";
    private static final String MESSAGE_REGISTRATION_SUCCESS = "Регистрация прошла успешно";

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String showSignUpPage(Map<String, Object> model) {
        User userForm = new User();
        model.put("userForm", userForm);
        return "signUp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userForm") User user,
                          BindingResult result,
                          @RequestParam String PasswordRepeat,
                          HttpServletRequest request) {
        if (result.hasErrors()) {
            request.setAttribute("message", MESSAGE_REGISTRATION_FAIL);
            return "signUp";
        }
        if (!StringUtils.equals(user.getPassword(), PasswordRepeat)) {
            request.setAttribute("message", MESSAGE_REGISTRATION_FAIL);
            return "signUp";
        }
        if (userService.getByEmail(user.getEmail()) != null) {
            request.setAttribute("message", MESSAGE_DATA_CORRECTION);
            return "signUp";
        }
        fillModel(user);
        userService.saveOrUpdate(user);
        request.setAttribute("message", MESSAGE_REGISTRATION_SUCCESS);
        return "redirect:../user/signIn";
    }

    /**
     * Method prepares filled form of Entity
     *
     * @param user - User
     * @return UserEntity
     */
    public User fillModel(User user) {

        String password = user.getPassword();
        String salt = RandomSalt.csRandomAlphaNumericString(LENGTH_RANDOM_NUMBER);
        String password1 = Sha256.sha256(password + salt + STATIC_SALT);

        user.setRole(roleService.get(DEFAULT_ROLE_ID));
        user.setBlackList(BLOCK_VALUE);
        user.setIdUser(DEFAULT_USER_ID);
        user.setSalt(salt);
        user.setPassword(password1);
        return user;
    }
}
