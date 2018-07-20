/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacao.service;

import com.aplicacao.beans.Pessoa;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.jws.WebService;

/**
 *
 * @author luis.silva
 */
@WebService(endpointInterface = "com.aplicacao.service.PessoaService")
public class PessoaServicoImpl implements PessoaService {

    private static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();

    @Override
    public boolean addPessoa(Pessoa p) {
        if (pessoas.get(p.getId()) != null) {
            return false;
        } else {
            pessoas.put(p.getId(), p);
            return true;
        }
    }

    @Override
    public boolean deletePessoa(int id) {
        if (pessoas.get(id) == null) {
            return false;
        } else {
            pessoas.remove(id);
            return true;
        }
    }

    @Override
    public Pessoa getPessoa(int id) {
        return pessoas.get(id);
    }

    @Override
    public Pessoa[] getAllPessoas() {
        Set<Integer> ids = pessoas.keySet();
        Pessoa[] p = new Pessoa[ids.size()];
        int i = 0;
        for (Integer id : ids) {
            p[i] = pessoas.get(id);
            i++;
        }
        return p;
    }
}
