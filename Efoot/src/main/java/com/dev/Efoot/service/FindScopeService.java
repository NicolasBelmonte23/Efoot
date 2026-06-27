package com.dev.Efoot.service;

import com.dev.Efoot.entity.Scope;
import com.dev.Efoot.exception.ResourceNotFoundException;
import com.dev.Efoot.repository.ScopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindScopeService {

    private final ScopeRepository scopeRepository;

    public Scope findById(Long id){
        return scopeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Scope not found id:" + id));
    }
}
