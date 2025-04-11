package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazarLegal.bazarlegal.model.entidades.OrgaoDonatario;
import com.bazarLegal.bazarlegal.model.repositorios.RepositorioGeral;



@Controller
@RequestMapping("/CadastroOrgaoDonatario")
public class CadastroOrgaoDonatarioController {

    @GetMapping
    public String principal(Model m) throws SQLException {
        m.addAttribute("orgao", new OrgaoDonatario());
        return "cadastro/OrgaoDonatario";
    }
    @PostMapping
    public String cadastrar(@ModelAttribute("orgao") OrgaoDonatario orgaoDonatario) throws SQLException {
        //TODO: process POST request
        RepositorioGeral.getCurrentInstance().create(orgaoDonatario);
        return "redirect:/";
    }
    

}
