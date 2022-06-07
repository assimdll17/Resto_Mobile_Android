package ma.enset.model;



public class Commande {

    private Long id_cmd;
    private int quantity;
    private String customerName;
    private String customerAddress;
    private double totalPrice;

    private  String nomplat;
    private  double prixplat;


    public Commande() {
    }

    public Commande(Long id_cmd, int quantity, String customerName, String customerAddress, double totalPrice, String nomplat, double prixplat) {
        this.id_cmd = id_cmd;
        this.quantity = quantity;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.totalPrice = totalPrice;
        this.nomplat = nomplat;
        this.prixplat = prixplat;
    }

    public Long getId_cmd() {
        return id_cmd;
    }

    public void setId_cmd(Long id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNomplat() {
        return nomplat;
    }

    public void setNomplat(String nomplat) {
        this.nomplat = nomplat;
    }

    public double getPrixplat() {
        return prixplat;
    }

    public void setPrixplat(double prixplat) {
        this.prixplat = prixplat;
    }
}
