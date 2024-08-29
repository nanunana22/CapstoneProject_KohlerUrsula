package org.backend.Ridinglesson;

import org.backend.horses.Horse;

public record Ridinglesson(
        String id,
        String ridinginstructor,
        String ridingtype,
        Horse horse,
        String Date,
        String Time
) {
}
