package com.example.springerrorhandling.core.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Project title: spring-error-handling
 *
 * @author johnadeshola
 * Date: 11/23/21
 * Time: 5:57 PM
 */
public class ModelMapperUtils {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <S, D> D map(final S entity, Class<D> outClazz) {
        return modelMapper.map(entity, outClazz);
    }

    public static <S, D> List<D> mapAll(final Collection<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> Set<D> mapAll(final Set<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toSet());
    }

    public static <S, D> List<D> mapAll(final List<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> List<D> mapAll(final Page<S> entityList, Class<D> outClazz) {
        return entityList.stream().map(entity -> map(entity, outClazz)).collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

}
