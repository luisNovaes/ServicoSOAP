/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacao.service;

import com.aplicacao.beans.Pessoa;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author luis.silva
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PessoaService {

    @WebMethod
    public boolean addPessoa(Pessoa p);

    @WebMethod
    public boolean deletePessoa(int id);

    @WebMethod
    public Pessoa getPessoa(int id);

    @WebMethod
    public Pessoa[] getAllPessoas();

}
