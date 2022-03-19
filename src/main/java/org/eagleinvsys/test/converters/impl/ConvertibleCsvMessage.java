package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConvertibleCsvMessage implements ConvertibleMessage {

    private Map<String, String> record;

    public ConvertibleCsvMessage(){
        record = new HashMap<>();
    }

    public ConvertibleCsvMessage(Map<String, String> record){
        this.record = record;
    }

    @Override
    public String getElement(String elementId) {
        return record.get(elementId);
    }
}
