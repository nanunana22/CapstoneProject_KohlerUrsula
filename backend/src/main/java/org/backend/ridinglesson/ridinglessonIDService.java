package org.backend.ridinglesson;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ridinglessonIDService {
    public String randomId(){
        return UUID.randomUUID().toString();
    }
}
