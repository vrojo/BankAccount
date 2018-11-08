package BankAccount;

import org.junit.Test;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void should_initiate_account_balance_at_zero_when_putting_no_parameter_in_the_builder() {
        Account account = Account.of();
        long expectedInitialBalance = 0;

        long initialBalance = account.getActualBalance();

        assertThat(initialBalance).isEqualTo(expectedInitialBalance);
    }

    @Test
    public void should_initiate_account_balance_when_putting_it_as_parameter_in_the_builder() {
        long initialMoneyOnAccount = 50;
        Account account = Account.of(initialMoneyOnAccount);

        long initialBalance = account.getActualBalance();

        assertThat(initialBalance).isEqualTo(initialMoneyOnAccount);
    }

    @Test
    public void should_add_the_deposit_money_to_the_balance_when_adding_a_deposit_bigger_than_zero() {
        Account account = Account.of();
        long moneyOfDeposit = 10;

        account.makeADeposit(moneyOfDeposit, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(moneyOfDeposit);
    }

    @Test
    public void should_keep_same_balance_when_trying_to_add_deposit_of_zero() {
        long initialBalance = 10;
        Account account = Account.of(10);
        long moneyOfDeposit = 0;

        account.makeADeposit(moneyOfDeposit, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialBalance);
    }

    @Test
    public void should_keep_same_balance_and_return_an_error_when_trying_to_add_deposit_with_a_negative_number() {
        long initialBalance = 10;
        Account account = Account.of(initialBalance);
        long moneyOfDeposit = -10;

        account.makeADeposit(moneyOfDeposit, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialBalance);
    }

    @Test
    public void should_retrieve_money_from_account_balance_when_making_a_withdrawal_with_involved_money_greater_than_zero() {
        long initialMoneyOnAccount = 50;
        Account account = Account.of(initialMoneyOnAccount);
        long moneyOfWithdrawal = 20;

        account.makeAWithdrawal(moneyOfWithdrawal, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialMoneyOnAccount - moneyOfWithdrawal);
    }

    @Test
    public void should_keep_same_balance_and_return_an_error_when_making_a_withdrawal_of_zero() {
        long initialMoneyOnAccount = 50;
        Account account = Account.of(initialMoneyOnAccount);
        long moneyOfWithdrawal = 0;

        account.makeAWithdrawal(moneyOfWithdrawal, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialMoneyOnAccount);
    }

    @Test
    public void should_keep_same_balance_and_return_an_error_when_making_a_withdrawal_of_a_negative_number() {
        long initialMoneyOnAccount = 50;
        Account account = Account.of(initialMoneyOnAccount);
        long moneyOfWithdrawal = -10;

        account.makeAWithdrawal(moneyOfWithdrawal, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialMoneyOnAccount);
    }

    @Test
    public void should_keep_same_balance_and_return_an_error_when_making_a_withdrawal_greater_than_the_money_on_balance() {
        long initialMoneyOnAccount = 10;
        Account account = Account.of(initialMoneyOnAccount);
        long moneyOfWithdrawal = 20;

        account.makeAWithdrawal(moneyOfWithdrawal, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialMoneyOnAccount);
    }
}
