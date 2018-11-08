package BankAccount;

import org.junit.Test;

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

        account.makeADeposit(moneyOfDeposit);

        assertThat(account.getActualBalance()).isEqualTo(moneyOfDeposit);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_keep_same_balance_and_return_an_error_when_trying_to_add_deposit_of_zero_or_negative_number() {
        Account account = Account.of();
        long moneyOfDeposit = 0;

        account.makeADeposit(moneyOfDeposit);
    }
}
