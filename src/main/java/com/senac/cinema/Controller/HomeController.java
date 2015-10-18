package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.View.PrincipalView;

public class HomeController {

    public void index() {
        PrincipalView.titulo();
        this.menuPrincipal();
    }

    private void menuPrincipal() {
        int opcao;

        do {
            PrincipalView.menuPrincipal();
            opcao = Console.lerInteger("Informe a opção desejada: ");

            if (!PrincipalView.opcaoMenuPrincipalValida(opcao)) {
                ExceptionDefaultMessage.opcaoInvalida();
                continue;
            }
            
            this.redirectController(opcao);
        } while (opcao != PrincipalView.opcaoSairMenuPrincipal);
    }
    
    private void redirectController(int opcao){
        switch(opcao){
            case PrincipalView.opcaoCadastroFilmeMenuPrincipal:
                this.redirectController(new FilmeController());
                break;
            case PrincipalView.opcaoCadastroSalaPrincipal:
                this.redirectController(new SalaController());
                break;
            case PrincipalView.opcaoCadastroSecaoMenuPrincipal:
                this.redirectController(new SecaoController());
                break;
            case PrincipalView.opcaoVendaIngressoMenuPrincipal:
                //this.redirectController(new FilmeController());
                break;
            default:
                ExceptionDefaultMessage.opcaoInvalida();
        }
    }
    
    private void redirectController(IBaseController controller){
        controller.index();
    }
}
