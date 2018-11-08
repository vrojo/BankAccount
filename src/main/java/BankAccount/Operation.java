package BankAccount;

public enum Operation {
    DEPOSIT {
        public long operate(Account account, long depositMoney) {
            if (depositMoney <= 0)
                throw new IllegalArgumentException();
            return account.getActualBalance() + depositMoney;
        }
    }, WITHDRAWAL {
        public long operate(Account account, long withdrawalMoney) {
            if (withdrawalMoney <= 0)
                throw new IllegalArgumentException();
            else if (account.getActualBalance() - withdrawalMoney < 0)
                throw new UnsupportedOperationException();
            return account.getActualBalance() - withdrawalMoney;
        }
    };

    public abstract long operate(Account accountBalance, long involvedMoney);
}
