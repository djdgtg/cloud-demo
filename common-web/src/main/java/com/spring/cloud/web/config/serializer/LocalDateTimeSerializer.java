package com.spring.cloud.web.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.spring.cloud.web.utils.DateUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Description
 *
 * @author qinchao
 * @date 2021/4/20 14:18
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(DateUtils.datetimeString(value));
    }
}