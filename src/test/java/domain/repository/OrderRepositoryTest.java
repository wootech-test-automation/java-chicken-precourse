package domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Order;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {

    @BeforeEach
    void clear() {
        OrderRepository.deleteAll();
    }

    @Test
    @DisplayName("주문 찾기 테스트")
    void findByTableNumber() {
        // given
        Order order1 = new Order(1, "임시", 10, 10000);
        Order order2 = new Order(2, "dd", 10, 10000);
        Order order3 = new Order(2, "ee", 10, 10000);
        Order order4 = new Order(1, "rr", 10, 10000);

        // when
        OrderRepository.saveOrder(order1);
        OrderRepository.saveOrder(order2);
        OrderRepository.saveOrder(order3);
        OrderRepository.saveOrder(order4);

        // then
        assertThat(OrderRepository.findAllByTableNumber(1).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("주문 저장 테스트")
    void saveOrder() {
        // given
        Order order1 = new Order(1, "임시", 10, 10000);
        Order order2 = new Order(2, "임시", 10, 10000);
        Order order3 = new Order(3, "임시", 10, 10000);

        // when
        OrderRepository.saveOrder(order1);
        OrderRepository.saveOrder(order2);
        OrderRepository.saveOrder(order3);

        // then
        assertThat(OrderRepository.orders().size()).isEqualTo(3);

    }

    @Test
    @DisplayName("주문 중첩 저장 테스트")
    void saveSameOrder() {
        // given
        Order order1 = new Order(1, "임시", 10, 10000);
        Order order2 = new Order(1, "임시", 10, 10000);
        Order order3 = new Order(1, "임시", 10, 10000);

        // when
        OrderRepository.saveOrder(order1);
        OrderRepository.saveOrder(order2);
        OrderRepository.saveOrder(order3);
        List<Order> allByTableNumber = OrderRepository.findAllByTableNumber(1);
        Order order = allByTableNumber.get(0);

        // then
        assertThat(OrderRepository.orders().size()).isEqualTo(1);
        assertThat(order.getTotalPrice()).isEqualTo(270000);
    }

    @Test
    @DisplayName("주문 삭제 테스트")
    void removeAllByTableNumber() {
        // given
        Order order1 = new Order(1, "aa", 10, 10000);
        Order order2 = new Order(2, "bb", 10, 10000);
        Order order3 = new Order(2, "cc", 10, 10000);
        Order order4 = new Order(3, "dd", 10, 10000);
        Order order5 = new Order(3, "ee", 10, 10000);
        Order order6 = new Order(3, "ff", 10, 10000);

        // when
        OrderRepository.saveOrder(order1);
        OrderRepository.saveOrder(order2);
        OrderRepository.saveOrder(order3);
        OrderRepository.saveOrder(order4);
        OrderRepository.saveOrder(order5);
        OrderRepository.saveOrder(order6);
        OrderRepository.removeAllByTableNumber(2);

        // then
        assertThat(OrderRepository.orders().size()).isEqualTo(4);
    }
}