import java.util.List;
public class OrderProcessor {
    private PaymentService paySrv;
    private InventoryService invSrv;
    private Item Item;
    public OrderProcessor(PaymentService paySrv, InventoryService invSrv) {
        this.paySrv = paySrv;
        this.invSrv = invSrv;
    }
    boolean processOrder(PaymentDetails payDtls, List<Item> items){
        // Code to process the order
        boolean paymentSuccess = paySrv.processPayment(payDtls);
        boolean itemListOK = items.contains(Item.getProductId());
        if(paymentSuccess){
            invSrv.updateInventory(items);
//            return true;
        }
        else if(itemListOK){
            return true;
        }
        else if(!itemListOK){
            paySrv.refundPayment(payDtls);
            return false;
        }
        else if(!paymentSuccess){
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
}