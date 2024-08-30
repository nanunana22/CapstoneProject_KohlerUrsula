package org.backend.ridinglesson;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class RidinglessonIDService {

    public static String randomId(){
        return UUID.randomUUID().toString();
    }
}
