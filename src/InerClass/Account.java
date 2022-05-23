package InerClass;

public class Account {
    private double amount;
    private final String number;
    private final String owner;

    public Account(String number, String owner) {
        this.number = number;
        this.owner = owner;
    }

    public double getAmount() {
        return amount;
    }

    public synchronized double putMoney(final double amountToPut) {
        this.amount = this.amount + amountToPut;
        final double amountToReturn = getAmount();
        return amountToReturn;
    }

    public synchronized double withdraw(final double amountToWithdraw) {
        if (amountToWithdraw > getAmount()) {
            final double amountToReturn = getAmount();
            this.amount = 0;
            return amountToReturn;
        }

        if (amountToWithdraw < 0) {
            return .0;
        }

        this.amount = this.amount - amountToWithdraw;
        return amountToWithdraw;
    }

    public class Card {
        private final String number;

        public Card(String number) {
            this.number = number;
        }

        public synchronized double withdraw(final double amountToWithdraw) {
            return Account.this.withdraw(amountToWithdraw);
        }

        public synchronized double putMoney(final double amountToPut) {
            return Account.this.putMoney(amountToPut);

        }
    }
}
