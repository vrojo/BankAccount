package BankAccount;

import static BankAccount.Operation.*;

public class Account {
    private long balance;

    public Account(long initialBalance) {
        balance = initialBalance;
    }

    public static Account of() {
        return new Account(0);
    }

    public static Account of(long initialBalance) {
        return new Account(initialBalance);
    }

    private void makeAnOperation(Operation operationType, long involvedMoney) {
        this.balance = operationType.operate(this, involvedMoney);
    }

    public long getActualBalance() {
        return balance;
    }

    public void makeADeposit(long depositMoney) {
        this.makeAnOperation(DEPOSIT, depositMoney);
    }

    public void makeAWithdrawal(long withdrawalMoney) {
        this.makeAnOperation(WITHDRAWAL, withdrawalMoney);
    }
}
