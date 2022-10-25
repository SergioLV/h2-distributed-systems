package com.gremio.receiver.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
public class ModelMaperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Provider<LocalDateTime> localDateTimeProvider = new AbstractProvider<LocalDateTime>() {
            @Override
            protected LocalDateTime get() {
                return LocalDateTime.now();
            }
        };

        Converter<Timestamp, LocalDateTime> toTimestamp = new AbstractConverter<Timestamp, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(Timestamp source) {
                return source.toLocalDateTime();
            }
        };

        modelMapper.createTypeMap(Timestamp.class, LocalDateTime.class);
        modelMapper.addConverter(toTimestamp);
        modelMapper.getTypeMap(Timestamp.class, LocalDateTime.class).setProvider(localDateTimeProvider);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
