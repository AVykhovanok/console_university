package com.oles.consoleuniversity.service.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.model.Lector;
import com.oles.consoleuniversity.repository.LectorRepository;
import com.oles.consoleuniversity.service.LectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LectorServiceImpl implements LectorService {
    private static final String LECTOR_BY_TEMPLATE_EXCEPTION = "There is no lectors by template -> %s";
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<Lector> getLectorByTemplate(String template) {
        List<Lector> lectorByTemplate = lectorRepository.getLectorByTemplate(template);
        if (lectorByTemplate.isEmpty()) {
            throw new NotExistException(String.format(LECTOR_BY_TEMPLATE_EXCEPTION, template));
        }
        return lectorByTemplate;
    }
}
