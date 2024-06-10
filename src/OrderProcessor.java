public class OrderProcessor {
    private PaymentService paySrv;
    private InventoryService invSrv;
    private Item Item;

    public OrderProcessor(PaymentService paySrv, InventoryService invSrv) {
        this.paySrv = paySrv;
        this.invSrv = invSrv;
        boolean processOrder(paySrv PaymentDetails payDtls, List<Item> items){
            // Code to process the order
        }
    }
}