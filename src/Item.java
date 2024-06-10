public class Item {
    private String productId;
    private int quantity;

    public Item(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


}