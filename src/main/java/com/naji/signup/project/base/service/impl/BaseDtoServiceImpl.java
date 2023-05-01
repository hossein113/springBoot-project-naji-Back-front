package com.naji.signup.project.base.service.impl;


import com.naji.signup.project.base.doamain.BaseEntity;
import com.naji.signup.project.base.dto.BaseDto;
import com.naji.signup.project.base.mapper.BaseMapperEntityToDto;
import com.naji.signup.project.base.repository.BaseRepository;
import com.naji.signup.project.base.service.BaseDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BaseDtoServiceImpl<D extends BaseDto<ID>,
        E extends BaseEntity<ID>,
        ID extends Serializable,
        M extends BaseMapperEntityToDto<E, D, ID>,
        R extends BaseRepository<E, ID>>
        implements BaseDtoService<D, ID> {

    protected final R repository;
    protected final M mapper;

    @Override
    @Transactional
    public D save(D d) throws SQLIntegrityConstraintViolationException {
        E e = mapper.convertDtoToEntity(d);
        return mapper.convertEntityToDto(repository.save(e));
    }

    @Override
    @Transactional
    public List<D> saveAll(List<D> d) throws SQLIntegrityConstraintViolationException {
        List<E> setE = mapper.convertListDtoToEntity(d);
        return mapper.convertListEntityToDto(repository.saveAll(setE));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<D> findById(ID id) {
        return repository.findById(id).map(mapper::convertEntityToDto);
    }

    @Override
    public List<D> findAll() {
        return mapper.convertListEntityToDto(repository.findAll());
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::convertEntityToDto);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }
}
