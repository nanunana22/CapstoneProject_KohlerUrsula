package org.backend.ridinglesson;

import java.math.BigDecimal;

public record Ridinglesson(
        String id,
        String ridinginstructor,
        String ridingtype,
        String horse,
        String Date,
        String Time
) {
}
