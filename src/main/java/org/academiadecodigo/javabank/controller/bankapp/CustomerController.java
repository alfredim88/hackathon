package org.academiadecodigo.javabank.controller.bankapp;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String list(org.springframework.ui.Model model){
        Customer c = new Customer();
        c.setUsername("açg");

        c.setPassword("rdgrdgjrdg");

        c.setEmail("gjiodjoidr@fposjg");

        customerService.add(c);


        model.addAttribute("customer", customerService.get(1));

        return "list";
    }

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }
}
