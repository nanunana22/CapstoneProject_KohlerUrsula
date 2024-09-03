package org.backend.ridinglesson;

public record NewRidinglesson(
        String ridinginstructor,
        String ridingtype,
        String horse,
        String Date,
        String Time,
        RidinglessonStatus status

) {
}
