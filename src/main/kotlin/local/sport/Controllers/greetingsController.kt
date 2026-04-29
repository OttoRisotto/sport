package local.sport.Controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class greetingsController {
    @GetMapping("/greetings")
    @ResponseBody
    fun greetings(name: String): String{
        return "Hallo $name"
    }
}
