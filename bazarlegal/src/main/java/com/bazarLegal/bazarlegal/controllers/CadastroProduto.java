package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazarLegal.bazarlegal.model.entidades.Produto;
import com.bazarLegal.bazarlegal.model.repositorios.RepositorioGeral;


@Controller
@RequestMapping("/CadastroProduto")
public class CadastroProduto {
    @GetMapping
    public String principal(Model m) throws SQLException {
        m.addAttribute("produto", new Produto());
       
        return "cadastro/Produto";
    }

    @PostMapping
    public String cadastro(@ModelAttribute("produto") Produto produto) throws SQLException {
        //TODO: process POST request
        RepositorioGeral.getCurrentInstance().create(produto);
        return "redirect:/";
    }
    
    
}
