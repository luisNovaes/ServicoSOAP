/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacao.service;

import javax.xml.ws.Endpoint;

/**
 *
 * @author luis.silva
 */
public class SOAPPublisher {

    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8888/ws/person", new PessoaServicoImpl());

    }

}
