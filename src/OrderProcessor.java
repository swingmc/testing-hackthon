import java.util.List;
public class OrderProcessor {
    private PaymentService paySrv;
    private InventoryService invSrv;
    public OrderProcessor(PaymentService paySrv, InventoryService invSrv) {
        this.paySrv = paySrv;
        this.invSrv = invSrv;
    }
    boolean processOrder(PaymentDetails payDtls, List<Item> items){
        // Code to process the order
        if(){
            return true;
        }
        else{
            return false;
        }
    }
}