package pl.jpaspring.jpaspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("html")
public class TemplateControllers {

    @RequestMapping(value = {"/add"})
    @ResponseBody
    public ModelAndView addNewCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
