/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacao.service;

import com.aplicacao.beans.Pessoa;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author luis.silva
 */
public class SOAPPublisherClient {

    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8888/ws/person?wsdl");
        // verifique acima o URL no navegador, você deve ver o arquivo WSDL

        // criando QName usando targetNamespace e name
        QName qname = new QName("http://service.aplicacao.com/",
                "PessoaServicoImplService");

        Service service = Service.create(wsdlURL, qname);

        // Precisamos passar os beans de interface e modelo para o cliente
        PessoaService ps = service.getPort(PessoaService.class);

        Pessoa p1 = new Pessoa();
        p1.setNome("Luis Novaes");
        p1.setId(1);
        p1.setIdade(45);

        Pessoa p2 = new Pessoa();
        p2.setNome("Luana Novaes");
        p2.setId(2);
        p2.setIdade(18);

        //Adicionando pessoa
        System.out.println("Adicionando Pessoa Status " + ps.addPessoa(p1));
        System.out.println("Adicionando Pessoa Status " + ps.addPessoa(p2));

        //buscando pessoa
        System.out.println(ps.getPessoa(1));

        //buscando todas as pessoas
        System.out.println(Arrays.asList(ps.getAllPessoas()));

        //deletando pessoas
        System.out.println("Delete Pessoa Status " + ps.deletePessoa(2));

        //Buscando todas as pessoas (Atualização)
        System.out.println(Arrays.asList(ps.getAllPessoas()));
    }

}
