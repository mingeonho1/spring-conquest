package springConquest.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springConquest.core.discount.FixDiscountPolicy;
import springConquest.core.member.Grade;
import springConquest.core.member.Member;
import springConquest.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}