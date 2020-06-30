package toan.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import toan.furamaresort.model.Contract;
import toan.furamaresort.model.Customer;
import toan.furamaresort.model.Stay;
import toan.furamaresort.service.ContractService;
import toan.furamaresort.service.CustomerService;
import toan.furamaresort.service.StayService;

@Controller
@RequestMapping(path = "/admin/contract")
public class ContractController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StayService stayService;

    @Autowired
    private ContractService contractService;

    @GetMapping(path = "")
    public String getAllContract(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("contracts", contractService.getAllContracts(pageable));
        return "contract/contract-list";
    }

    @GetMapping(path = "/create")
    public String getFromCreateContract() {
        return "contract/contract-create";
    }

    @PostMapping(path = "/create")
    public String createNewContract(Contract contract, BindingResult bindingResult,
            @RequestParam("stayId") Integer stayId,
            @RequestParam("customerId") Integer customerId,
            RedirectAttributes redirectAttributes) {
        Stay stay = stayService.findById(stayId);
        if (stay == null) {
            return "400-bad-request";
        }
        contract.setStay(stay);
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return "400-bad-request";
        }
        contract.setCustomer(customer);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Delete contract successfully!");
        return "redirect:/admin/contract";
    }
}