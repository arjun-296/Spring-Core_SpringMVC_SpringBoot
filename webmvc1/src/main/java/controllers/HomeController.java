package controllers;

import model.Bike;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.BikeRepository;

import java.util.List;

@Controller
public class HomeController {

    BikeRepository bikerepo;

    public HomeController() {

        bikerepo= new BikeRepository();
    }

    @RequestMapping("/")
    public String Homepage(Model m){
        List<Bike> bikedata= bikerepo.getAllBikes();
        m.addAttribute("AllBikes", bikedata);
        return "index";
    }

    @PostMapping("/reqSendBikes")
    public String addBike(@RequestParam("bike_id")String a, @RequestParam("bike_name")String b,
                          @RequestParam("bike_engine_capacity")String c, @RequestParam("Top_speed")String d,
                          @RequestParam("Price")String e){

        Bike bk = new Bike(Integer.parseInt(a),b,c,Integer.parseInt(d),Double.parseDouble(e));
        bikerepo.addBikes(bk);
        return "redirect:/";
    }
    @RequestMapping("/reqDeleteBikes")
    public String deleteBike(@RequestParam("bike_id")String a){
        bikerepo.deleteBikes(Integer.parseInt(a));
        return "redirect:/";
    }

    @RequestMapping("/reqEditPage")
    public String editBikedetails(@RequestParam("bike_id")String a,Model m){
        Bike bk = bikerepo.getbikebyId(Integer.parseInt(a));
        m.addAttribute("book", bk);
        return "editPage";
    }

    @RequestMapping("/reqUpdateBikeRecords")
    public String updateBookData(@RequestParam("bike_id")String a, @RequestParam("bike_name")String b,
                                 @RequestParam("bike_engine_capacity")String c, @RequestParam("Top_speed")String d,
                                 @RequestParam("Price")String e){
        Bike bk = new Bike(Integer.parseInt(a),b,c,Integer.parseInt(d),Double.parseDouble(e));
        bikerepo.updateRecord(bk);
        return "redirect:/";
    }




}
