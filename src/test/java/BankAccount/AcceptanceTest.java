package BankAccount;

import org.junit.Test;
import java.time.LocalDateTime;
import static BankAccount.Operation.DEPOSIT;
import static BankAccount.Operation.WITHDRAWAL;
import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    public void should_add_money_to_account_balance_when_making_a_deposit() {
        Account account = Account.of();
        long initialBalance = account.getActualBalance();
        long depositMoney = 20;

        account.makeADeposit(depositMoney, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialBalance + depositMoney);
    }

    @Test
    public void should_retrieve_money_from_account_balance_when_making_a_withdrawal() {
        Account account = Account.of(30);
        long initialBalance = account.getActualBalance();
        long withdrawalMoney = 20;

        account.makeAWithdrawal(withdrawalMoney, LocalDateTime.now());

        assertThat(account.getActualBalance()).isEqualTo(initialBalance - withdrawalMoney);
    }

    @Test
    public void should_return_the_history_of_operations_on_the_account() {
        Account account = Account.of();
        long firstDepositMoney = 20;
        long secondDepositMoney = 30;
        long withdrawalMoney = 10;
        LocalDateTime firstOperationDate = LocalDateTime.now();
        LocalDateTime secondOperationDate = LocalDateTime.now();
        LocalDateTime thirdOperationDate = LocalDateTime.now();
        AccountHistory firstOperationHistory = new AccountHistory(DEPOSIT, 20, 0, firstOperationDate);
        AccountHistory secondOperationHistory = new AccountHistory(DEPOSIT, 30, 20, secondOperationDate);
        AccountHistory thirdOperationHistory = new AccountHistory(WITHDRAWAL, 10, 50, thirdOperationDate);
        String expectedHistory = "History of your account:\n" +
                                    firstOperationHistory.toString() +
                                    secondOperationHistory.toString() +
                                    thirdOperationHistory.toString();

        account.makeADeposit(firstDepositMoney, firstOperationDate);
        account.makeADeposit(secondDepositMoney, secondOperationDate);
        account.makeAWithdrawal(withdrawalMoney, thirdOperationDate);
        String historyOfAccount = account.getHistoryOfAccount();

        assertThat(historyOfAccount).isEqualTo(expectedHistory);
    }
}
