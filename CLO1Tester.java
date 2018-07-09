abstract class AbstractGameShopItem {
    //common attributes
    protected String itemId;
    protected String itemName;
    protected double costPrice;

    //constructor
    public AbstractGameShopItem(String itemId, String itemName, double costPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.costPrice = costPrice;
    }

    //abstract method for calculating selling price
    public abstract double calcSellingPrice();

    //abstract method for calculating GST 
    public abstract double calcGST();

    //override default toString() from java.lang.Object
    public String toString() {
        return itemId + " " + itemName + " Selling Price:AED "+String.format("%.2f",calcSellingPrice())
                                       + " GST included:AED " + String.format("%.2f",calcGST());
    }
}

class GameItem extends AbstractGameShopItem {
    //specific attributes for GameItem
    private String title;
    private String rating;
    private String version;
    private String publisher;
    private String genre;

    public GameItem(String itemId, String itemName, double costPrice, 
        String title, String rating, String version, String publisher, String genre) {
        super(itemId, itemName, costPrice);
        this.title = title;
        this.rating = rating;
        this.version = version;
        this.publisher = publisher;
        this.genre = genre;
    }

    //override calcGST() as 10% of cost price
    public double calcGST() {
        return costPrice * 0.10;
    }

    //override calcSellingPrice()
    public double calcSellingPrice() {
        double profitMargin = costPrice * 0.05;
        return costPrice + calcGST() + profitMargin;
    }

    public String toString() {
        return "Game Item \n" + super.toString() + "\n---------------------------";
    }
}

//subclass for cansole and laptop item
class ConsoleLaptopItem extends AbstractGameShopItem {
    //specific attributes for Console and ldaptops
    private String cpu;
    private String gpu;
    private int ram;
    private String storage;

    //constructor
    public ConsoleLaptopItem(String itemId, String itemName, double costPrice,
        String cpu, String gpu, int ram, String storage) {
        super(itemId, itemName, costPrice);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;        
    }

    //override calcGST() as 30% of cost price
    public double calcGST() {
        return costPrice * 0.30;
    }

    //override calcSellingPrice()
    public double calcSellingPrice() {
        double profitMargin = costPrice * 0.20;
        return costPrice + calcGST() + profitMargin;
    }

    public String toString() {
        return "Console/Laptop Item \n" + super.toString() + "\n---------------------------";
    }
}

public class CLO1Tester {
    public static void printGameShopItem(AbstractGameShopItem gameShopItem) {
        System.out.println(gameShopItem);//toString() called implicitly
    }

    public static void main(String args[]) {
        AbstractGameShopItem gameItem1 = new GameItem("GM101", "Console Warrior 2", 100.00, 
                                                    "Console Warrior 2", "Everyone", "12.0 Standard", "Geeks Inc.", "Adventure");
        
        AbstractGameShopItem atariVCS = new ConsoleLaptopItem("CL09", "Atari VCS", 200, 
                                        "Bristol Ridge A10", "Radeon R7", 4, "32 GB eMMC plus external options");
        
        //print the objects
        printGameShopItem(gameItem1);
        printGameShopItem(atariVCS);
    }
}