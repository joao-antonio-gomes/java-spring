package br.com.alura.mvc.spring1.repository;

import br.com.alura.mvc.spring1.model.Pedido;
import br.com.alura.mvc.spring1.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido aguardando);
}
