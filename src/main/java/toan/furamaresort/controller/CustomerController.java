package toan.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import toan.furamaresort.model.Customer;
import toan.furamaresort.model.CustomerType;
import toan.furamaresort.model.Gender;
import toan.furamaresort.service.CustomerService;
import toan.furamaresort.service.CustomerTypeService;
import toan.furamaresort.service.GenderService;

@Controller
@RequestMapping(path = "/admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private GenderService genderService;

    @ModelAttribute(name = "customerTypes")
    public Iterable<CustomerType> getAllCustomerTypes() {
        return customerTypeService.getAllCustomerTypes();
    }

    @ModelAttribute(name = "genders")
    public Iterable<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }

    @GetMapping(path = "")
    public String getAllActiveCustomers(@PageableDefault(size = 3) Pageable pageable,
            @RequestParam(name = "customerCode", required = false) String customerCode,
            @RequestParam(name = "customerPhone", required = false) String customerPhone,
            Model model) {
        model.addAttribute("customers",
                customerService.findCustomers(customerCode, customerPhone, pageable));
        if (customerCode != null) {
            model.addAttribute("customerCode", customerCode);
        }
        if (customerCode != null) {
            model.addAttribute("customerPhone", customerPhone);
        }
        return "customer/customer-list";
    }

    @GetMapping(path = "/create")
    public String getFormCreateNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customer-create";
    }

    @PostMapping(path = "/create")
    public String saveNewCustomer(@RequestParam(name = "genderId") Integer genderId,
            @RequestParam(name = "customerTypeId") Integer customerTypeId,
            @Validated @ModelAttribute(name = "customer") Customer customer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/customer-create";
        }
        customer.setGender(genderService.getGenderById(genderId));
        customer.setCustomerType(customerTypeService.getCustomerTypeById(customerTypeId));
        customerService.save(customer);
        return "redirect:/admin/customer";
    }

    @GetMapping(path = "/{id}/update")
    public String getFormUpdateCustomer(@PathVariable(name = "id") Integer id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "400";
        }
        model.addAttribute("customer", customer);
        return "customer/customer-update";
    }

    @PostMapping(path = "/{id}/update")
    public String saveNewCustomer(@PathVariable(name = "id") Integer id,
            @RequestParam(name = "genderId") Integer genderId,
            @RequestParam(name = "customerTypeId") Integer customerTypeId,
            @Validated @ModelAttribute(name = "customer") Customer customer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/customer-update";
        }
        customer.setId(id);
        customer.setGender(genderService.getGenderById(genderId));
        customer.setCustomerType(customerTypeService.getCustomerTypeById(customerTypeId));
        customerService.save(customer);
        return "redirect:/admin/customer";
    }
}
