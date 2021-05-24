package com.spring.cloud.web.config.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.spring.cloud.web.utils.DateUtils;

import java.io.IOException;
import java.time.LocalDate;

/**
 * description
 *
 * @author qinchao
 * @date 2021/4/20 14:20
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext deserializationContext)
            throws IOException {
        return DateUtils.date(p.getValueAsString());
    }
}