import java.util.List;

public class Test {
    private static void runInterfaceBasedTests() {
        System.out.println("Running Interface-based tests...");

        testInterfaceCase("Happy path", "123456789012345612", 100, "1234abcd", 1, true);
        testInterfaceCase("invalid ccnum (ccnum < 18 digits)", "1234567890123456", 100, "1234abcd", 1, false);
        testInterfaceCase("invalid ccnum (ccnum > 18 digits", "12345678901234561234", 100, "1234abcd", 1, false);
        testInterfaceCase("invalid ccnum (ccnum has alphabet chars)", "1234567890123456ab", 100, "1234abcd", 1, false);
        testInterfaceCase("invalid ccnum (ccnum has special chdrs)", "1234567890123456@#", 100, "1234abcd", 1, false);
        testInterfaceCase("invalid amount (amount < 0)", "123456789012345612", -100, "1234abcd", 1, false);
        testInterfaceCase("invalid productId (productId < 8 chars)", "123456789012345612", 100, "1234abc", 1, false);
        testInterfaceCase("invalid productId (productId > chars", "123456789012345612", 100, "1234abcd12", 1, false);
        testInterfaceCase("invalid productId (productId has special chars)", "123456789012345612", 100, "1234ab@#d", 1, false);
        testInterfaceCase("invalid quantity (quantity < 0)", "123456789012345612", 100, "1234abcd", -1, false);
        testInterfaceCase("invalid quantity (quantity =  0)", "123456789012345612", 100, "1234abcd", 0, false);
    }

    private static void testInterfaceCase(String description, String ccnum, int amount, String productid, int quantity, boolean expectedOutput) {
        PaymentService mockPaymentService = new MockPaymentService(true);
        InventoryService mockInventoryService = new MockInventoryService(true);
        OrderProcessor orderProcessor = new OrderProcessor(mockPaymentService, mockInventoryService);

        PaymentDetails paymentDetails = new PaymentDetails(ccnum, amount);
        List<Item> items = List.of(new Item(productid, quantity));

        boolean result = orderProcessor.processOrder(paymentDetails, items);
        System.out.println(description + ": " + (result == expectedOutput ? "PASSED" : "FAILED"));
    }
    private static void runMetamorphicTests() {
        System.out.println("Running Metamorphic Tests...");


    }

    static class MockPaymentService extends PaymentService {
        private boolean shouldSucceed;

        MockPaymentService(boolean shouldSucceed) {
            this.shouldSucceed = shouldSucceed;
        }

        @Override
        public boolean processPayment(PaymentDetails payDtls) {
            return shouldSucceed;
        }

        @Override
        public void refundPayment(PaymentDetails payDtls) {
        }
    }

    static class MockInventoryService implements InventoryService {
        private boolean shouldSucceed;

        MockInventoryService(boolean shouldSucceed) {
            this.shouldSucceed = shouldSucceed;
        }

        @Override
        public boolean updateInventory(List<Item> items) {
            return shouldSucceed;
        }
    }

    public static void main(String[] args) {
        runInterfaceBasedTests();
        runMetamorphicTests();
    }
}
