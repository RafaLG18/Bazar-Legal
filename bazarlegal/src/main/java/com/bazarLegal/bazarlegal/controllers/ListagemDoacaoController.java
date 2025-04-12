package com.bazarLegal.bazarlegal.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bazarLegal.bazarlegal.model.entidades.Lote;
import com.bazarLegal.bazarlegal.model.repositorios.RepositorioGeral;


@Controller
@RequestMapping("/ListagemDoacoes")
public class ListagemDoacaoController {

    @GetMapping
    public String principal(Model m) throws SQLException {
        List<Lote> lotes=RepositorioGeral.getCurrentInstance().readAllLote();
        m.addAttribute("lotes", lotes);
        return "lista/lista";
    }
    
}
