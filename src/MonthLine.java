public class MonthLine { 
    String monthName;
    String itemName;
    boolean isExpense;
    int quantity;
    int price;

    public MonthLine(String monthName, String itemName, boolean isExpense, int quantity, int price) {
        this.monthName = monthName;
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
    }
}
