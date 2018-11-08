package BankAccount;

import org.junit.Test;
import java.time.LocalDateTime;
import static BankAccount.Operation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountHistoryTest {
    @Test
    public void should_create_a_deposit_history_with_all_information_for_a_deposit_operation() {
        LocalDateTime now = LocalDateTime.now();
        AccountHistory operationInformation = new AccountHistory(DEPOSIT, 10, 0, now);

        AccountHistory expectedHistory = new AccountHistory(DEPOSIT, 10, 0, now);

        assertThat(operationInformation).isEqualTo(expectedHistory);
    }

    @Test
    public void should_create_a_withdrawal_history_with_all_information_for_a_withdrawal_operation() {
        LocalDateTime now = LocalDateTime.now();
        AccountHistory operationInformation = new AccountHistory(WITHDRAWAL, 20, 0, now);

        AccountHistory expectedHistory = new AccountHistory(WITHDRAWAL, 20, 0, now);

        assertThat(operationInformation).isEqualTo(expectedHistory);
    }

    @Test
    public void should_not_add_an_operation_history_for_an_operation_failing_because_of_zero() {
        Account account = Account.of();
        long incorrectDepositMoneyAmount = -10;
        LocalDateTime operationDate = LocalDateTime.now();
        String expectedHistory = "History of your account:\nNo operation on your account.";

        account.makeADeposit(incorrectDepositMoneyAmount, operationDate);

        assertThat(account.getHistoryOfAccount()).isEqualTo(expectedHistory);
    }

    @Test
    public void should_not_add_an_operation_history_for_an_operation_failing_because_of_a_negative_number() {
        Account account = Account.of();
        long incorrectDepositMoneyAmount = -10;
        String expectedHistory = "History of your account:\nNo operation on your account.";

        account.makeAWithdrawal(incorrectDepositMoneyAmount, LocalDateTime.now());

        assertThat(account.getHistoryOfAccount()).isEqualTo(expectedHistory);
    }

    @Test
    public void should_create_and_return_an_operation_history_without_operation_when_making_no_operation() {
        Account account = Account.of();
        String expectedHistoryToString = "History of your account:\nNo operation on your account.";

        String historyToString = account.getHistoryOfAccount();

        assertThat(historyToString).isEqualTo(expectedHistoryToString);
    }

    @Test
    public void should_create_and_return_an_operation_history_for_a_correct_operation() {
        Account account = Account.of();
        long correctDepositMoneyAmount = 10;
        LocalDateTime dateOfOperation = LocalDateTime.now();
        String operationHistory = new AccountHistory(DEPOSIT, 10, 0, dateOfOperation).toString();
        String expectedHistoryToString = "History of your account:\n" + operationHistory;

        account.makeADeposit(correctDepositMoneyAmount, dateOfOperation);
        String historyToString = account.getHistoryOfAccount();

        assertThat(historyToString).isEqualTo(expectedHistoryToString);
    }

    @Test
    public void should_create_and_return_an_operation_history_for_two_correct_operation() {
        Account account = Account.of();
        long correctDepositMoneyAmount = 10;
        long correctWithdrawalMoneyAmount = 5;
        LocalDateTime dateOfOperation = LocalDateTime.now();
        String firstOperationHistory = new AccountHistory(DEPOSIT, correctDepositMoneyAmount, 0, dateOfOperation).toString();
        String secondOperationHistory = new AccountHistory(WITHDRAWAL, correctWithdrawalMoneyAmount, 10, dateOfOperation).toString();
        String expectedHistoryToString = "History of your account:\n" +
                                    firstOperationHistory +
                                    secondOperationHistory;

        account.makeADeposit(correctDepositMoneyAmount, dateOfOperation);
        account.makeAWithdrawal(correctWithdrawalMoneyAmount, dateOfOperation);
        String historyToString = account.getHistoryOfAccount();

        assertThat(historyToString).isEqualTo(expectedHistoryToString);
    }
}
