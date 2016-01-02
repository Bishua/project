package ua.bish.project.data.service.common;

import org.springframework.transaction.annotation.Transactional;
import ua.bish.project.data.repository.common.Operations;

import java.io.Serializable;


@Transactional
public abstract class AbstractService<T, PK extends Serializable>
        implements Operations<T, PK> {
}
