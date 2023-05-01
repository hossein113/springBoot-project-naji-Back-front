package com.naji.signup.project.base.mapper;


import com.naji.signup.project.base.doamain.BaseEntity;
import com.naji.signup.project.base.dto.BaseDto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface BaseMapperEntityToDto<E extends BaseEntity<ID>, D extends BaseDto<ID>, ID extends Serializable> {

    E convertDtoToEntity(D d);

    D convertEntityToDto(E e);

    List<E> convertListDtoToEntity(List<D> dtoList);

    List<D> convertListEntityToDto(List<E> entityList);

    Set<E> convertSetDtoToEntity(Set<D> dtoSet);

    Set<D> convertSetEntityToDto(Set<E> entitySet);

}
