# BitcoinPriceMonitor

  Simple application to track current and historical exchange ratio of bitcoin to other desired currency.
  Project uses api provided by CoinDesk.

  Instructions:  
  execute jar file (BitcoinPriceMonitor.jar) or run docker container (docker run -ti --rm puwkafatushka/bitcoinpricemonitor:latest java -jar                       BitcoinPriceMonitor.jar) ->  
    input code of desired currency (ISO 4217 3-letter case-insensitive code) ->  
    result:    
    - In case of success - current btc ratio to chosen currency, the lowest ratio in the past 30 days, the highest ratio in the past 30 days  
    - In case of incorrect currency code - textual notification of the case  
    - In case of execution error - generic textual notification  
    - In case of "exit" input - stops the execution of application  
    
  Application will provide information for desired currency until manually stopped by typing "exit" (case-insensitive).  
