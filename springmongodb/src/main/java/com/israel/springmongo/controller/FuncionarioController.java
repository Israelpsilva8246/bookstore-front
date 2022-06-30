package com.israel.springmongo.controller;

import com.israel.springmongo.model.Funcionario;
import com.israel.springmongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.criar(funcionario);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate) {
        return  this.funcionarioService.obterFuncionarioPorRangeDeIdade(de, ate);
    }
}
