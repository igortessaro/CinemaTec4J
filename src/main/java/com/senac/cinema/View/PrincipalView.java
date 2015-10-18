package com.senac.cinema.View;

public final class PrincipalView {
    public static final int opcaoCadastroFilmeMenuPrincipal = 1;
    public static final int opcaoCadastroSalaPrincipal = 2;
    public static final int opcaoCadastroSecaoMenuPrincipal = 3;
    public static final int opcaoVendaIngressoMenuPrincipal = 4;
    public static final int opcaoSairMenuPrincipal = 5;
    
    public static void titulo(){
        System.out.println("");
        System.out.println("");
        
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("            ..::Cinema Tec::..");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        
        System.out.println("");
    }
    
    public static void menuPrincipal(){
        System.out.println("");
        System.out.println("");
        System.out.println(" >> Menu Principal << ");
        System.out.println("");
        System.out.println(String.format("%s - Cadastro de filmes.", opcaoCadastroFilmeMenuPrincipal));
        System.out.println(String.format("%s - Cadastro de salas.", opcaoCadastroSalaPrincipal));
        System.out.println(String.format("%s - Cadastro de seções.", opcaoCadastroSecaoMenuPrincipal));
        System.out.println(String.format("%s - Venda de ingressos.", opcaoVendaIngressoMenuPrincipal));
        System.out.println(String.format("%s - Sair", opcaoSairMenuPrincipal));
        System.out.println("");
        //System.out.println("Informe a opção desejada: ");
    }
    
    public static  boolean opcaoMenuPrincipalValida(int opcao){
        return opcao == opcaoCadastroFilmeMenuPrincipal
                || opcao == opcaoCadastroSalaPrincipal
                || opcao == opcaoCadastroSecaoMenuPrincipal
                || opcao == opcaoSairMenuPrincipal
                || opcao == opcaoVendaIngressoMenuPrincipal;
    }
}
