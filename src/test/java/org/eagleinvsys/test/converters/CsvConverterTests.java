package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCsvCollection;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvConverterTests {

    // TODO: implement JUnit 5 tests for CsvConverter

    public static ByteArrayOutputStream outputStream;
    public static CsvConverter csvConverter;

    @BeforeAll
    public static void init(){

        csvConverter = new CsvConverter();
        outputStream = new ByteArrayOutputStream();

    }

    @Test
    @DisplayName("Arguments are not null")
    public void convertNormalTest(){

        Map<String, String> record1 = new HashMap<>();
        Map<String, String> record2 = new HashMap<>();

        record1.put("H1", "e11");
        record1.put("H2", "e12");

        record2.put("H1", "e21");
        record2.put("H2", "e22");

        List<Map<String, String>> list = new ArrayList<>();

        list.add(record1);
        list.add(record2);

        ConvertibleCollection convertibleCollection = new ConvertibleCsvCollection(list);

        csvConverter.convert(convertibleCollection, outputStream);

        String csv = outputStream.toString();
        String expected = "H1,H2" + "\n" +
                          "e11,e12" + "\n" +
                          "e21,e22";

        assertEquals(expected, csv);

    }

    @Test
    @DisplayName("OutputStream is null")
    public void convertOutNullTest() {

        ConvertibleCollection convertibleCollection = new ConvertibleCsvCollection();

        assertThrows(
                NullPointerException.class,
                () -> csvConverter.convert(convertibleCollection, null)
        );

    }

    @Test
    @DisplayName("Collection is null")
    public void convertCollectionNullTest() {

        assertThrows(
                NullPointerException.class,
                () -> csvConverter.convert(null, outputStream)
        );

    }

}