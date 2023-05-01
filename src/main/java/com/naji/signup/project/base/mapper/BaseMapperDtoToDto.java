package com.naji.signup.project.base.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface BaseMapperDtoToDto<D extends Serializable, T extends Serializable> {

    D convertFirstDtoToSecondDto(T dto);

    T convertSecondDtoToFirstDto(D dto);

    List<D> convertListFirstDtoToSecondDtoList(List<T> dtoList);

    List<T> convertListSecondDtoToFirstList(List<D> dtoList);

    Set<D> convertSetFirstDtoToSecondDtoSet(Set<T> dtoSet);

    Set<T> convertSetSecondDtoToFirstSet(Set<D> dtoSet);
}
