public class PaymentDetails {
    private String creditCardNumber;
    private int amount;
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentDetails(String creditCardNumber, int amount) {
        this.creditCardNumber = creditCardNumber;
        this.amount = amount;
    }
}