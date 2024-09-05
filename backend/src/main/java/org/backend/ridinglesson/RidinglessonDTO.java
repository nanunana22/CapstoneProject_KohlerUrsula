package org.backend.ridinglesson;

public record RidinglessonDTO(
        String ridinginstructor,
        String ridingtype,
        String horse,
        String date,
        String time,
        RidinglessonStatus status
) {
}
