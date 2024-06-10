public class PaymentService {
    // boolean processPayment(PaymentDetails payDtls);
    // void refundPayment(PaymentDetails payDtls);

    public boolean processPayment(PaymentDetails payDtls) {

        // check if not length 18 and if it contains alpha numeric
        if (payDtls.getCreditCardNumber().length() != 18 && payDtls.getCreditCardNumber().contains("[a-zA-Z]+")) {
            return false;
        }
        if (payDtls.getAmount() <= 0) {
            return false;
        }
        return true;
    }

    public void refundPayment(PaymentDetails payDtls) {
        System.out.println("Refund initiated for credit card number: " + payDtls.getCreditCardNumber());
    }
}
