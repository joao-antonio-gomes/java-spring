package br.com.alura.mvc.spring1.controller;

import br.com.alura.mvc.spring1.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.spring1.model.Pedido;
import br.com.alura.mvc.spring1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {

        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "home";
    }
}
