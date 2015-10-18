package com.senac.cinema.Core;

public class ExceptionDefaultMessage {
    public  static void opcaoInvalida(){
        messageError("Opção inválida!");
    }
    
    public static void messageError(String message){
        Console.imprimir(String.format("[ERRO] - %s", message));
    }
}
