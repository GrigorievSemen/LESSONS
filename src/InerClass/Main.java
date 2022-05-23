package InerClass;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("123456789", "Bob");
        Account.Card card = account.new Card("1111 2222 3333 4444");
        System.out.println(account.getAmount());

        card.putMoney(1000);
        System.out.println(account.getAmount());

        card.withdraw(500);
        System.out.println(account.getAmount());

    }
}
