import java.util.List;
public class OrderProcessor {
    private PaymentService paySrv;
    private InventoryService invSrv;
    private Item item;
    public OrderProcessor(PaymentService paySrv, InventoryService invSrv, Item item) {
        this.paySrv = paySrv;
        this.invSrv = invSrv;
        this.item = item;
    }
    boolean processOrder(PaymentDetails payDtls, List<Item> items){
        // Code to process the order
        boolean paymentSuccess = paySrv.processPayment(payDtls);
        if (!paymentSuccess) {
            return false;
        }
        boolean inventorySuccess = invSrv.updateInventory(items);
        if (!inventorySuccess) {
            paySrv.refundPayment(payDtls);
            return false;
        }
        return true;
//        if(paySrv.processPayment(payDtls) && !items.isEmpty()){
//            invSrv.updateInventory(items);
//            return true;
//        }
//        else{
//            return false;
//        }
    }
public static void main(String[] args) {
    }
}