package rzeznik.grzegorz.exotic_farm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRegistrationValidationService validationService;

    @GetMapping("/registration")
    public String registrationFrom(Model model) {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        model.addAttribute("registrationData", dto);
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String registrationEffect(UserRegistrationDTO dto, Model model) {
        Map<String, String> exceptionMap = validationService.validateUser(dto);
        if (!exceptionMap.isEmpty()) {
            model.addAllAttributes(exceptionMap);
            model.addAttribute("registrationData", dto);
            return "registrationPage";
        }
        try{
            userService.registerUser(dto);
        }catch (EmailAlreadyExistsException e){
            model.addAttribute("emailAlreadyExists", e.getMessage());
            model.addAttribute("registrationData", dto);
            return "registrationPage";
        }
        model.addAttribute("email", dto.getEmail());
        return "welcomePage";
    }

}
