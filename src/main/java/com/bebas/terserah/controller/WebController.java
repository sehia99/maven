/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebas.terserah.controller;

import com.bebas.terserah.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jonathansr
 */
@Controller
public class WebController {
    @Autowired
    private MahasiswaRepo mhsRepo;
    
    @RequestMapping("/datamhs")
    public void datamhs(Model model) {
        model.addAttribute("datamhs", mhsRepo.findAll());
    }
}
