package com.spring.cloud.web.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring.cloud.web.config.deserializer.LocalDateDeserializer;
import com.spring.cloud.web.config.deserializer.LocalDateTimeDeserializer;
import com.spring.cloud.web.config.serializer.LocalDateSerializer;
import com.spring.cloud.web.config.serializer.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * description ObjectMapperConfig
 *
 * @author qinchao
 * @date 2020/12/3 10:54
 */
@Configuration
public class ObjectMapperConfig {

    /**
     * 时间类型LocalDateTime、LocalDate统一序列化方式
     *
     * @return com.fasterxml.jackson.databind.ObjectMapper
     * @author qinchao
     * @date 2020/12/3 11:37
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return init();
    }

    @Bean
    public ObjectMapper redisObjectMapper() {
        ObjectMapper objectMapper = init();
        /**
         * redis反序列化时需要加上ObjectMapper.DefaultTyping.NON_FINAL
         * 否则会报java.util.LinkedHashMap cannot be cast to x.x.X
         * */
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }

    public ObjectMapper init() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

}
