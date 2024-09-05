package org.backend.ridinglesson;

public record RidinglessonDTO(
        String id,
        String ridinginstructor,
        String ridingtype,
        String horse,
        String date,
        String time,
        RidinglessonStatus status
) {
}
