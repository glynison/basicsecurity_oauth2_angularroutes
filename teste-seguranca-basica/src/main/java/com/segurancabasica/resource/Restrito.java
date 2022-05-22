package com.segurancabasica.resource;

import org.springframework.http.ResponseEntity;

public class Restrito {
    public ResponseEntity<?> ok() {
        return ResponseEntity.ok("Acesso restrito! Apenas com autenticação.");
    }
    
}
