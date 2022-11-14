package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.testUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest extends testUtil {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구매 시 금액이 정상적인 경우")
    @Test
    void validLottoAmount() {
        Customer customer = new Customer();

        input("1000");
        customer.inputAmount();

        assertThat(customer.getAmount()).isEqualTo(1000);
    }

    @DisplayName("예외: 로또 구매 시 금액이 int가 아닌 경우")
    @Test
    void invalidLottoAmount() {
        Customer customer = new Customer();

        input("1000ㅇ");
        customer.inputAmount();

        assertThat(output()).contains(ERROR_MESSAGE);
    }
}
