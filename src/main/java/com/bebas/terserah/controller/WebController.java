/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebas.terserah.controller;

import com.bebas.terserah.entity.Mahasiswa;
import com.bebas.terserah.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value ="/tambah", method = RequestMethod.GET)
    public void addData(@ModelAttribute("mhs") Mahasiswa mhs, BindingResult bind){}
    
    @RequestMapping(value = "/tambah", method = RequestMethod.POST)
    public void addDataProcessing(@ModelAttribute("mhs") Mahasiswa mhs, BindingResult bind){
        System.out.println(mhs.getNim());
        System.out.println(mhs.getNama());
        System.out.println(mhs.getJurusan());
        // proses simpan data
        mhsRepo.save(mhs);
    }
}