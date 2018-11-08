package BankAccount;

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

    public void makeADeposit(long involvedMoney) {
        if (involvedMoney <= 0){
            throw new IllegalArgumentException();
        }
        this.balance += involvedMoney;
    }

    public long getActualBalance() {
        return balance;
    }
}
