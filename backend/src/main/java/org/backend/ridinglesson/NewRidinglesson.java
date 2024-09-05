package org.backend.ridinglesson;

public record NewRidinglesson(
        String ridinginstructor,
        String ridingtype,
        String horse,
        String date,
        String time,
        RidinglessonStatus status

) {
}
