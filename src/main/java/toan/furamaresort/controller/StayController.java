package toan.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toan.furamaresort.service.StayService;

@Controller
@RequestMapping(path = "/admin/stay")
public class StayController {

    @Autowired
    private StayService stayService;

    @GetMapping(path = "")
    public String getStayList() {
        return "stay/stay_list";
    }

    @GetMapping(path = "/create")
    public String getFormCreateStay() {
        return "stay/stay_create";
    }
}
