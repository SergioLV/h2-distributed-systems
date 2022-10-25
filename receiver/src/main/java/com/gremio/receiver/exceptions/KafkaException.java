package com.gremio.receiver.exceptions;

public class KafkaException extends Exception{

    public KafkaException(String message, Throwable cause){ super(message, cause); }

}
