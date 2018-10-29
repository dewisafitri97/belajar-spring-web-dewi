package com.flashdin.belajarspringweb.controller;

import com.flashdin.belajarspringweb.entity.MataKuliah;
import com.flashdin.belajarspringweb.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mataKuliah")
public class MataKuliahController {

    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new MataKuliah());
        return "/mataKuliah/create";
    }

    @GetMapping(path = "/update/{USER_ID}")
    public String viewUpdate(Model model, @PathVariable(value = "USER_ID") int id) {
        model.addAttribute("dataSets", mataKuliahService.findById(id));
        return "/mataKuliah/update";
    }

    @PostMapping(value = "/create")
    public String save(MataKuliah param) {
        MataKuliah data = mataKuliahService.save(param);
        if (data.getUSER_ID() == 0) {
            return "redirect:/mataKuliah/create?failed";
        } else {
            return "redirect:/mataKuliah/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(MataKuliah param) {
        MataKuliah data = mataKuliahService.update(param);
        if (data.getUSER_ID() == 0) {
            return "redirect:/mataKuliah?ufailed";
        } else {
            return "redirect:/mataKuliah?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(MataKuliah param) {
        int data = mataKuliahService.delete(param);
        if (data == 0) {
            return "redirect:/mataKuliah?dfailed";
        } else {
            return "redirect:/mataKuliah?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", mataKuliahService.findAll());
        } else {
            MataKuliah mataKuliah = new MataKuliah();
            mataKuliah.setMakul(param);
            model.addAttribute("dataSets", mataKuliahService.findByName(mataKuliah));
        }
        return "/mataKuliah/list";
    }

}
