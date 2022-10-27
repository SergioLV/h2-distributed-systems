package com.gremio.receiver.business;

public final class Constants {

    private Constants(){}

    public static final String KAFKA_SALES_TOPIC = "sales";
    public static final String KAFKA_NEW_MEMBERS_TOPIC = "new-members";
    public static final String KAFKA_LOCATION_TOPIC = "location";
    public static final String KAFKA_STOCKS_TOPIC = "stocks";

    public static final String PROBLEM_SALES_TOPIC = "problem with SALES topic";
    public static final String PROBLEM_NEW_MEMBERS_TOPIC = "problem with NEW MEMBERS topic";
    public static final String PROBLEM_LOCATION_TOPIC = "problem with LOCATION topic";

    public static final String PROBLEM_SALES_TABLE = "problem with SALES table";
    public static final String PROBLEM_NEW_MEMBERS_TABLE = "problem with NEW MEMBERS table";
    public static final String PROBLEM_LOCATION_TABLE = "problem with LOCATION table";
}
