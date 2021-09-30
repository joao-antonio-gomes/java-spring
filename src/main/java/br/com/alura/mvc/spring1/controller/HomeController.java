package br.com.alura.mvc.spring1.controller;

import br.com.alura.mvc.spring1.model.Pedido;
import br.com.alura.mvc.spring1.model.StatusPedido;
import br.com.alura.mvc.spring1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller @RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public String home(Model model) {
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", "home");

        return "home";
    }

    @GetMapping("/{status}")
    public String aguardando(@PathVariable("status") String status, Model model) {
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);

        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(Model model) {
        model.addAttribute("status", "home");
        return "redirect:/home";
    }
}
