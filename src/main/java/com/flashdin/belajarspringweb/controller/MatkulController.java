package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.dao.MatkulDAO;
import com.flashdin.belajarspringweb.entity.Matkul;
import com.flashdin.belajarspringweb.entity.Profile;
import com.flashdin.belajarspringweb.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matkul")
public class MatkulController {

    @Autowired
    private MatkulService matkulService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Matkul());
        return "/matkul/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", matkulService.findById(id));
        return "/matkul/update";
    }

    @PostMapping(value = "/create")
    public String save(Matkul param) {
        Matkul data = matkulService.save(param);
        if (data.getId() == 0) {
            return "redirect:/matkul/create?failed";
        } else {
            return "redirect:/matkul/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Matkul param) {
        Matkul data = matkulService.update(param);
        if (data.getId() == 0) {
            return "redirect:/matkul?ufailed";
        } else {
            return "redirect:/matkul?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Matkul param) {
        int data = matkulService.delete(param);
        if (data == 0) {
            return "redirect:/matkul?dfailed";
        } else {
            return "redirect:/matkul?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", matkulService.findAll());
        } else {
            Matkul matkul = new Matkul();
            matkul.setMakul(param);
            model.addAttribute("dataSets", matkulService.findByName(matkul));
        }
        return "/matkul/list";
    }

}
