package com.israel.springmongo.service.impl;

import com.israel.springmongo.model.Funcionario;
import com.israel.springmongo.repository.FuncionarioRepository;
import com.israel.springmongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe!"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe =
                this.funcionarioRepository
                        .findById(funcionario.getChefe().getCodigo())
                        .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));

        funcionario.setChefe(chefe);

        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate) {

        return this.funcionarioRepository.obterFuncionarioPorRangeDeIdade(de, ate);
    }
}
