package com.gremio.salesconsumer.business;

public final class Constants {

    private Constants(){}

    public static final String KAFKA_SALES_TOPIC = "sales";
    public static final String KAFKA_NEW_MEMBERS_TOPIC = "new-members";
    public static final String KAFKA_LOCATION_TOPIC = "location";

    public static final String COUNSUMER_GROUP_ID = "sales-listener";
    public static final String PROBLEM_SALES_TABLE = "problem with SALES table";
    public static final String PROBLEM_STOCK_TABLE = "problem with STOCK table";
    public static final String PROBLEM_NEW_MEMBERS_TABLE = "problem with NEW MEMBERS table";
    public static final String PROBLEM_LOCATION_TABLE = "problem with LOCATION table";
}
