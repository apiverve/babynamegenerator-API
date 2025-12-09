// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     BabyNameGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.babynamegenerator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static BabyNameGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(BabyNameGeneratorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(BabyNameGeneratorData.class);
        writer = mapper.writerFor(BabyNameGeneratorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// BabyNameGeneratorData.java

package com.apiverve.babynamegenerator.data;

import com.fasterxml.jackson.annotation.*;

public class BabyNameGeneratorData {
    private long count;
    private Name[] names;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("names")
    public Name[] getNames() { return names; }
    @JsonProperty("names")
    public void setNames(Name[] value) { this.names = value; }
}

// Name.java

package com.apiverve.babynamegenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Name {
    private String firstName;
    private String middleName;
    private String fullName;

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    @JsonProperty("firstName")
    public void setFirstName(String value) { this.firstName = value; }

    @JsonProperty("middleName")
    public String getMiddleName() { return middleName; }
    @JsonProperty("middleName")
    public void setMiddleName(String value) { this.middleName = value; }

    @JsonProperty("fullName")
    public String getFullName() { return fullName; }
    @JsonProperty("fullName")
    public void setFullName(String value) { this.fullName = value; }
}