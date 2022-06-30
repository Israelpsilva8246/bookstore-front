package com.israel.springmongo.service;

import com.israel.springmongo.model.Funcionario;

import java.util.List;

public interface FuncionarioService {
    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);
}
