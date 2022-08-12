package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {



    @RequestMapping("/")
    public String dispIndexPage(Model m){
        System.out.println("Index Page running...");
        return "index";
    }

    @RequestMapping("/map1")
    public String disHomePage(){
        System.out.println("Home Page running...");
        return "homePage";
    }

    @RequestMapping("/map2")
    public String disWorkPage(){
        System.out.println("Work Page running...");
        return "workPage";
    }

}
