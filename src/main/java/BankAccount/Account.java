package BankAccount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import static BankAccount.Operation.*;
import static java.util.stream.Collectors.joining;

public class Account {
    private long balance;
    private ArrayList<AccountHistory> accountHistory;

    private Account(long initialBalance) {
        balance = initialBalance;
        this.accountHistory = new ArrayList<>();
    }

    public static Account of() {
        return new Account(0);
    }

    public static Account of(long initialBalance) {
        return new Account(initialBalance);
    }

    private String makeAnOperation(Operation operationType, long involvedMoney, LocalDateTime dateOfTheOperation) {
        long balanceBeforeOperation = this.getActualBalance();
        try {
            this.balance = operationType.operate(this, involvedMoney);
            this.accountHistory.add(new AccountHistory(operationType, involvedMoney, balanceBeforeOperation, dateOfTheOperation));
            return "Operation completed successfully.";
        } catch (IllegalArgumentException e) {
            return "Operation failed...\nYou can not make this operation with a negative or null amount...";
        } catch (UnsupportedOperationException e) {
            return "Operation failed...\nYou can not have a negative balance !";
        }
    }

    public long getActualBalance() {
        return balance;
    }

    public void makeADeposit(long depositMoney, LocalDateTime dateOfTheOperation) {
        this.makeAnOperation(DEPOSIT, depositMoney, dateOfTheOperation);
    }

    public void makeAWithdrawal(long withdrawalMoney, LocalDateTime dateOfTheOperation) {
        this.makeAnOperation(WITHDRAWAL, withdrawalMoney, dateOfTheOperation);
    }

    public String getHistoryOfAccount() {
        if (this.accountHistory.size() == 0) {
            return "History of your account:\nNo operation on your account.";
        }
        return "History of your account:\n" +
                accountHistory.stream().map(AccountHistory::toString).collect(joining());
    }
}
