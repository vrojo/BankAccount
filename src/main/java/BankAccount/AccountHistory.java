package BankAccount;

import java.time.LocalDateTime;
import java.util.Objects;
import static BankAccount.Operation.DEPOSIT;

public class AccountHistory {
    private final Operation operationType;
    private final long involvedMoney;
    private final long accountBalance;
    private final LocalDateTime dateOfOperation;
    private String format = "\t Withdrawal money: ";

    public AccountHistory(Operation operationType, long involvedMoney, long accountActualBalance, LocalDateTime dateOfOperation) {
        this.operationType = operationType;
        this.involvedMoney = involvedMoney;
        this.accountBalance = accountActualBalance;
        this.dateOfOperation = dateOfOperation;
        if (operationType == DEPOSIT)
            this.format = "\t\t Deposit money: ";
    }

    @Override
    public String toString() {
        return  "Operation: " + operationType.name().toLowerCase() +
                format + involvedMoney +
                "\t\t Balance before operation: " + accountBalance +
                "\t\t date of the operation: " + dateOfOperation +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHistory that = (AccountHistory) o;
        return involvedMoney == that.involvedMoney &&
                accountBalance == that.accountBalance &&
                operationType == that.operationType &&
                Objects.equals(dateOfOperation, that.dateOfOperation) &&
                Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, involvedMoney, accountBalance, dateOfOperation, format);
    }
}
