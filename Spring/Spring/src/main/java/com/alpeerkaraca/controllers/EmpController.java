package com.alpeerkaraca.controllers;

import com.alpeerkaraca.spring.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alpeerkaraca.dao.EmpDao;


@Controller
public class EmpController {
    final
    EmpDao dao;

    public EmpController(EmpDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/empForm")
    public String showForm(Model model) {
        model.addAttribute("command", new Emp());
        return "empForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmp(@ModelAttribute("emp") Emp emp) {
        dao.saveEmp(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping("/viewemp")
    public String viewEmp(Model model) {
        model.addAttribute("list",  dao.getEmployees());
        return "viewemp";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSaveEmp(@ModelAttribute("emp") Emp emp) {
        dao.updateEmp(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping(value = "deleteemp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable int id) {
        dao.deleteEmp(id);
        return "redirect:/viewemp";
    }


}
