/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebas.terserah.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    
    @RequestMapping("/index")
    public Map<String, Object> index(@RequestParam("nama")String nama){
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        hasil.put("jurusan", "ye");
        return hasil;
    }

}
