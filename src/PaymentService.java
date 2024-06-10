public interface PaymentService {
    boolean processPayment(PaymentDetails payDtls);
    void refundPayment(PaymentDetails payDtls);
}
