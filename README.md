# delight-simple-log-log4j

A bridge from Log4J to [delight-simple-log](https://github.com/javadelight/delight-simple-log).

# Usage

Simply provide an instance of `Log4JBridge` to the Log class. 


```
delight.simplelog.Log.setListener(new Log4JBridge());
```

Then configure Log4j as you would usually do. See [Java Logging - The Ultimate, Simple Guide](https://maxrohde.com/2018/01/25/java-logging-the-ultimate-easy-guide/).