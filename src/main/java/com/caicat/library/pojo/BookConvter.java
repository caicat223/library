package com.caicat.library.pojo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BookConvter {
    public static BookConvter INSTANCE= Mappers.getMapper(BookConvter.class);


}
