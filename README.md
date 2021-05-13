# BitcoinPriceMonitor

Simple application to track current state and history of bitcoin related to other currencies.
Project uses api provided by CoinDesk.

Instructions:
- execute jar file -> input code of desired currency (ISO 4217 3-letter case insensitive code) -> result:
  - In case of success - current btc ratio to chosen currency, lowest ratio in the past 30 days, highest ratio in the past 30 days
  - In case of incorrect currency code - textual notification of the case
  - In case of execution error - generic textual notification
  - In case of "exit" input - stops the execution of application
  
  Application will provide information for desired currency until manually stopped by typing "exit" (case insensitive).
