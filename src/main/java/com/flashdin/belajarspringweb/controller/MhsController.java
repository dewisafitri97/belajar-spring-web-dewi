package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.Mhs;
import com.flashdin.belajarspringweb.entity.Profile;
import com.flashdin.belajarspringweb.service.MhsService;
import com.flashdin.belajarspringweb.service.ProfileSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mhs")
public class MhsController {

    @Autowired
    private MhsService mhsService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new Mhs());
        return "/mhs/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", mhsService.findById(id));
        return "/mhs/update";
    }

    @PostMapping(value = "/create")
    public String save(Mhs param) {
        Mhs data = mhsService.save(param);
        if (data.getId() == 0) {
            return "redirect:/mhs/create?failed";
        } else {
            return "redirect:/mhs/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(Mhs param) {
        Mhs data = mhsService.update(param);
        if (data.getId() == 0) {
            return "redirect:/mhs?ufailed";
        } else {
            return "redirect:/mhs?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(Mhs param) {
        int data = mhsService.delete(param);
        if (data == 0) {
            return "redirect:/mhs?dfailed";
        } else {
            return "redirect:/mhs?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mhsService.findAll());
        } else {
            Mhs mhs = new Mhs();
            mhs.setName(param);
            model.addAttribute("dataSets", mhsService.findByName(mhs));
        }
        return "/mhs/list";
    }

}
