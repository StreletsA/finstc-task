package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConvertibleCsvCollection implements ConvertibleCollection {

    private List<String> headers;
    private List<ConvertibleMessage> records;

    public ConvertibleCsvCollection(){
        this.headers = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    public ConvertibleCsvCollection(List<Map<String, String>> collectionToConvert){
        this();

        if (collectionToConvert.isEmpty()) return;

        for (Map<String, String> row : collectionToConvert){

            if (headers.isEmpty())
                headers.addAll(row.keySet());

            records.add(new ConvertibleCsvMessage(row));

        }

    }

    @Override
    public Collection<String> getHeaders() {
        return this.headers;
    }

    @Override
    public Iterable<ConvertibleMessage> getRecords() {
        return this.records;
    }
}
