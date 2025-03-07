class Order {
    String orderType;    
    int tickerIndex;        
    int quantity;          
    double price;           

    // Constructor to initialize an order
    public Order(String orderType, int tickerIndex, int quantity, double price) {
        this.orderType = orderType;
        this.tickerIndex = tickerIndex;
        this.quantity = quantity;
        this.price = price;
    }
}

// Define the main StockTradingEngine class
public class StockTradingEngine {
    private static final int MAX_TICKERS = 1024;      
    private static final int MAX_ORDERS = 100000;    
    private static Order[] orderBook = new Order[MAX_ORDERS]; 
    private static int orderCount = 0;  

    // Synchronized method to add a new order to the order book
    public static synchronized void addOrder(String orderType, String tickerSymbol, int quantity, double price) {
        if (orderCount >= MAX_ORDERS) return; 
        int tickerIndex = Math.abs(tickerSymbol.hashCode()) % MAX_TICKERS; 
        orderBook[orderCount++] = new Order(orderType, tickerIndex, quantity, price);  
        // Printing the added order for testing , you uncomment it if you wanted to  print it 
       // System.out.println("Added Order -> Type: " + orderType + ", Ticker: " + tickerSymbol + ", Quantity: " + quantity + ", Price: " + price);
    }

    // Synchronized method to match buy and sell orders
    public static synchronized void matchOrder() {
        for (int i = 0; i < orderCount; i++) {
            Order buyOrder = orderBook[i];
            if (buyOrder != null && "Buy".equals(buyOrder.orderType)) {
                for (int j = 0; j < orderCount; j++) {
                    Order sellOrder = orderBook[j];
                    if (sellOrder != null && "Sell".equals(sellOrder.orderType) && buyOrder.tickerIndex == sellOrder.tickerIndex) {
                        if (buyOrder.price >= sellOrder.price) {
                            int matchedQuantity = Math.min(buyOrder.quantity, sellOrder.quantity);
                            // Print matched order details
                        //System.out.println("Matched " + matchedQuantity + " shares of TICK" + (buyOrder.tickerIndex + 1) +
                        //" at $" + sellOrder.price + " between Buy and Sell orders.");

                            buyOrder.quantity -= matchedQuantity;
                            sellOrder.quantity -= matchedQuantity;
                            if (buyOrder.quantity == 0) break;  
                        }
                    }
                }
            }
        }
    }

    // Method to generate random orders for testing
    public static void simulateOrders() {
        for (int i = 0; i < 1000; i++) {  
            String orderType = Math.random() < 0.5 ? "Buy" : "Sell";  
            String tickerSymbol = "TICK" + ((int) (Math.random() * MAX_TICKERS) + 1);  
            int quantity = (int) (Math.random() * 100) + 1;  
            double price = 10 + (500 - 10) * Math.random(); 
            addOrder(orderType, tickerSymbol, quantity, price); 
        }
        System.out.println("Finished generating random orders.");
    }

  
    public static void main(String[] args) {
        simulateOrders();  
        matchOrder();     
        System.out.println("Order matching completed.");
    }
}

