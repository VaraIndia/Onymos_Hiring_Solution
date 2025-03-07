**Stock Trading Engine**
This project is a simple stock trading engine implemented in Java. It allows you to add buy and sell orders for stocks and match them based on predefined criteria without using maps, dictionaries, or any complex data structures.

**Features**
Supports up to 1,024 tickers (stocks).
Can handle up to 100,000 orders.
Matches orders based on price and availability with O(n) time complexity.
Uses synchronized methods to prevent race conditions without locks or atomic variables.

**Installation**
1.Install Java Development Kit (JDK):

Make sure you have Java 8 or higher installed.
To verify, run in terminal
  java -version

2.Install Visual Studio Code:

3.Install Java Extension Pack for VS Code:

    Go to Extensions (Ctrl+Shift+X).
    Search for Java Extension Pack and install it.

# Clone and Setup Project

1.Clone the repository:git clone https://github.com/VaraIndia/Onymos_Hiring_Solution.git

2.Navigate to the project directory: cd stock-trading-engine

3.Open in VS Code:code .


#  How to Run the Code
1.Compile the code:javac StockTradingEngine.java
2.Run the program:java StockTradingEngine
3.Expected Output:Finished generating random orders.
                  Order matching completed.
# Key Components Explained
Order Class:
Stores order details like type (Buy/Sell), ticker, quantity, and price.

addOrder Method:
Adds new orders to the order book with thread safety.

matchOrder Method:
Matches buy and sell orders based on price and availability with O(n) complexity.

simulateOrders Method:
Generates random orders to test the system.

# Testing the Code
To test the code, you can:

Uncomment the print statements in addOrder and matchOrder methods to see detailed outputs.
Run the program multiple times to observe random order generation and matching.
