FROM openjdk:11

COPY target/BitcoinPriceMonitor.jar /

CMD ["java", "-jar", "BitcoinPriceMonitor.jar"]