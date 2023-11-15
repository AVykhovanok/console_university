package com.oles.consoleuniversity.service;

import com.oles.consoleuniversity.model.Lector;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface LectorService {
    List<Lector> getLectorByTemplate(String template);
}
