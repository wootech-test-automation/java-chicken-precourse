package domain.order;

import domain.category.Category;
import domain.menu.Menu;
import domain.quantity.Quantity;
import exception.InvalidInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 주문을_등록한_상품들에_대한_결과를_반환할_수_있습니다() {
        var orders = new Orders();
        orders.addOrder(new Order(new Quantity(1), new Menu(1, "후라이드", Category.CHICKEN, 16000)));
        orders.addOrder(new Order(new Quantity(1), new Menu(2, "콜라", Category.BEVERAGE, 1000)));
        var actual = orders.result().split("\n");
        Assertions.assertThat(actual[0]).isEqualTo("후라이드 1 16000");
    }

    @Test
    void 최종_결제_금액을_반환할_수_있습니다() {
        var orders = new Orders();
        orders.addOrder(new Order(new Quantity(1), new Menu(1, "후라이드", Category.CHICKEN, 16000)));
        orders.addOrder(new Order(new Quantity(1), new Menu(2, "콜라", Category.BEVERAGE, 1000)));
        var money = orders.calculateAll();
        Assertions.assertThat(money.result()).isEqualTo("17000원");
    }

    @Test
    void 전체_수량이_99개를_넘기는_경우_추가할_수_없는_오류를_반환합니다() {
        var orders = new Orders();
        orders.addOrder(new Order(new Quantity(60), new Menu(1, "1", Category.CHICKEN, 1)));
        Assertions.assertThatThrownBy(() -> {
            orders.addOrder(new Order(new Quantity(60), new Menu(1, "1", Category.CHICKEN, 1)));
        }).isInstanceOf(InvalidInputException.class);
    }

    @Test
    void 같은_상품을_등록하면_상품의_가격과_수량이추가된다() {
        var orders = new Orders();
        orders.addOrder(new Order(new Quantity(1), new Menu(1, "1", Category.CHICKEN, 10000)));
        orders.addOrder(new Order(new Quantity(1), new Menu(1, "1", Category.CHICKEN, 10000)));
        orders.addOrder(new Order(new Quantity(1), new Menu(1, "1", Category.CHICKEN, 10000)));
        Assertions.assertThat(orders.calculateAll().result()).isEqualTo("30000원");
    }
}