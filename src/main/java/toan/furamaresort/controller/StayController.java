package toan.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import toan.furamaresort.model.Stay;
import toan.furamaresort.service.StayService;

@Controller
@RequestMapping(path = "/admin/stay")
public class StayController {

    @Autowired
    private StayService stayService;

    @GetMapping(path = "")
    public String getStayList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Stay> stays = stayService.getAllStays(pageable);
        model.addAttribute("stays", stays);
        return "stay/stay-list";
    }

    @GetMapping(path = "/create")
    public String getFormCreateStay() {
        return "stay/stay-create";
    }

    @PostMapping(path = "/create")
    public String createNewStay(Stay stay, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "stay/stay-create";
        }
        stayService.save(stay);
        redirectAttributes.addFlashAttribute("message", "Add new stay successfully!");
        return "redirect:/admin/stay";
    }
}
