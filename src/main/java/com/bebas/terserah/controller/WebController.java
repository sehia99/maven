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
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/hapus")
    public String hapusData(@RequestParam("nim") String nim){
        mhsRepo.delete(nim);
        return "redirect:datamhs";
    }
    
    @RequestMapping(value = "/ubah", method = RequestMethod.GET)
    public void getubahdata(@RequestParam("nim") String nim, Model model){
        Mahasiswa data = mhsRepo.findOne(nim);
        model.addAttribute("mhs", data);
    }
    
    @RequestMapping(value = "/ubah", method = RequestMethod.POST)
    public String saveubahdata(@ModelAttribute("mhs") Mahasiswa mhs, BindingResult result){
        System.out.println("nim : " + mhs.getNim());
        System.out.println("nama : " + mhs.getNama());
        System.out.println("jurusan : " + mhs.getJurusan());
        mhsRepo.save(mhs);
        return "redirect:datamhs";
    }
    
}