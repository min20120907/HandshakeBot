# HandshakeBot
A bot that one can use it to compare the price of handshake beverage of same item
## Usage
  Query the beverage and the toppings start to search, it would list three different handshake drink retailers, Coco, ching-shin fu-chuan, and comebuy.
  All the information are stored inside database file HandshakeBot.db.
## Prerequirements
- Java JDK > 11
- SQLite java connector
- Handshake database
- MariaDB/MySQL (Optional)
## Installation
### For SQLite
``` 
cd src/min20120907
javac -cp sqlite-jdbc-3.8.9.1.jar MainWindow.java
java -cp .:sqlite-jdbc-3.8.9.1.jar MainWindow
```
