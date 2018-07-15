# jmstemplate-example
This is a basic example using jmstemplate

It uses a class (Message) as the message to send between the sender and
the receiver.

It uses a class (MessageSender) to send 10 messages to a receiver.

It uses another class (MessageReceiver) to receive the messages.

All the application does is print the messages at the console, both at the sending
and at the receiving side.

It uses two configuration classes, one for JMS and one for Jackson (we are
using json as the serialization format).

The last class is MainClass, which triggers the message sending when
the application context is ready, and stops the app when the
messages have been sent and received successfully. The reason
I put those things in a separate class is because I did not want
to bloat the jms related functionality with this "code infrastructure".

# Running the app
You can either run the app from inside your IDE by running the App.class,
or on the command line executing the two following commands:

```
$ mvn clean package
[...]
$ java -jar target/jmstemplate-example-1.0.0-SNAPSHOT.jar
```


