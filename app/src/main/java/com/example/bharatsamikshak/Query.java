package com.example.bharatsamikshak;

public class Query {

    public static String SENT_BY_ME ="me";
    public static String SENT_BY_BHARATSAMIKSHAK = "bharatsamiksahk";


    String query;
    String queryans;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryans() {
        return queryans;
    }
    public void setQueryans(String queryans) {
        this.queryans = queryans;
    }
    public Query(String query, String queryans) {
        this.query = query;
        this.queryans = queryans;
    }


}
