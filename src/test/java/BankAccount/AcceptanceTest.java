package BankAccount;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    public void should_add_money_to_account_balance_when_making_a_deposit() {
        Account account = Account.of();
        long initialBalance = account.getActualBalance();
        long depositMoney = 20;

        account.makeADeposit(depositMoney);

        assertThat(account.getActualBalance()).isEqualTo(initialBalance + depositMoney);
    }

    @Test
    public void should_retrieve_money_from_account_balance_when_making_a_withdrawal() {
        Account account = Account.of(30);
        long initialBalance = account.getActualBalance();
        long withdrawalMoney = 20;

        account.makeAWithdrawal(withdrawalMoney);

        assertThat(account.getActualBalance()).isEqualTo(initialBalance - withdrawalMoney);
    }
}
