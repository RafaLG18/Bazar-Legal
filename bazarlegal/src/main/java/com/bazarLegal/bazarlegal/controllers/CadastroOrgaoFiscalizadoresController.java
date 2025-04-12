package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazarLegal.bazarlegal.model.entidades.OrgaoFiscalizador;
import com.bazarLegal.bazarlegal.model.repositorios.RepositorioGeral;

@Controller
@RequestMapping("/CadastroOrgaoFiscalizador")
public class CadastroOrgaoFiscalizadoresController {

    @GetMapping
    public String principal(Model m) throws SQLException {
        m.addAttribute("orgao", new OrgaoFiscalizador());
        return "cadastro/OrgaoFiscalizador";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("orgao") OrgaoFiscalizador orgaoFiscalizador) throws SQLException {
        //TODO: process POST request
        RepositorioGeral.getCurrentInstance().create(orgaoFiscalizador);
        return "redirect:/";
    }

}
