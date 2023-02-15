public class User {
    public Double DEFAULT_START_WALLET_BALANCE = 50000.0;
    public double wallet;
    String name;
    public User(String name)
    {
        this.name = name;
        this.wallet=DEFAULT_START_WALLET_BALANCE;
    }
}