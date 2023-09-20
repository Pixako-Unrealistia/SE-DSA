package code;
public enum Coins {
    PENNY(1), NICKEL(5), DIME(10);
    private Coins(int val) {
        this.val = val;
    }
    private int val;
    public int value() {
        return val;
    }
}