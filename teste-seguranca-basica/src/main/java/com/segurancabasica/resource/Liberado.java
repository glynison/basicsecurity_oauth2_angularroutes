package com.segurancabasica.resource;

import org.springframework.http.ResponseEntity;

public class Liberado {

    public ResponseEntity<?> ok() {
        return ResponseEntity.ok("Acesso liberado");
    }
    
}
