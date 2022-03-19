package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {

        if (collectionToConvert == null)
            throw new NullPointerException("Collection is null!");

        if (outputStream == null)
            throw new NullPointerException("Output stream is null!");

        StringBuilder csv = new StringBuilder();

        for (String header : collectionToConvert.getHeaders())
            csv.append(header).append(',');

        csv.deleteCharAt(csv.length() - 1);
        csv.append("\n");

        for (ConvertibleMessage convertibleMessage : collectionToConvert.getRecords()){

            for (String header : collectionToConvert.getHeaders())
                csv.append(convertibleMessage.getElement(header)).append(',');

            csv.deleteCharAt(csv.length() - 1);
            csv.append("\n");

        }

        csv.deleteCharAt(csv.length() - 1);

        try {
            outputStream.write(csv.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}