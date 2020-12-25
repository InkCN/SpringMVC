package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    //使用 Spring MVC 所提供的 ModelAndView 对象回显数据
//    @RequestMapping("/a")
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        ModelAndView mav = new ModelAndView("test3");
//        mav.addObject("message", "Hello Spring MVC");
//        return mav;
//    }

    // Spring MVC 回显数据方法二（常用）
    @RequestMapping("/function02")
    public String handleRequest(Model model) throws Exception {
        model.addAttribute("message", "Hello Spring MVC");
        return "test3";
    }

    //使用Servlet 原生的 API回显数据
//    @RequestMapping("/value")
//    public ModelAndView handleRequest(HttpServletRequest request,
//                                      HttpServletResponse response) {
//        request.setAttribute("message","成功！");
//        return new ModelAndView("test3");
//    }

//    @RequestMapping("/param")
//    public ModelAndView getParam(HttpServletRequest request,
//                                 HttpServletResponse response) {
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//
//        System.out.println(userName);
//        System.out.println(password);
//        return null;
//    }

    //我们可以把方法定义的形参名字设置成和前台传入参数名一样的方法，来获取到数据（同名匹配规则）
    //会和前台产生很强的耦合，这是我们不希望的
//    @RequestMapping("/param")
//    public ModelAndView getParam(String userName,
//                                 String password) {
//        System.out.println("很强的耦合"+userName);
//        System.out.println("很强的耦合"+password);
//        return null;
//    }

    /**
     *     作用：将请求参数绑定到你控制器的方法参数上（是SpringMVC中接收普通参数的注解）
     *     语法：@RequestParam(value="参数名",required="true/false",defaultValue="")
     *     value：参数名
     *     required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错
     *     defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
     */
    @RequestMapping("/param")
    public ModelAndView getParam(@RequestParam("userName")String name,
                                 @RequestParam("password")String secret) {
        System.out.println("@RequestParam"+name);
        System.out.println("@RequestParam"+secret);
        return null;
    }

    //客户端跳转---方法一
    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/function02");
        return mav;
    }

    //客户端跳转---方法二
    @RequestMapping("/jump02")
    public String jump02() {
        return "redirect: ./function02";
    }
}
