package org.backend.ridinglesson;

public record Ridinglesson(
        String id,
        String ridinginstructor,
        String ridingtype,
        String horse,
        String date,
        String time,
        RidinglessonStatus status
) {
    Ridinglesson(
            String ridinginstructor,
            String ridingtype,
            String horse,
            String date,
            String time,
            RidinglessonStatus status
    ){
        this(null, ridinginstructor, ridingtype, horse, date, time, status);
    }

    public Ridinglesson withId(String id) {
        return new Ridinglesson(id, ridinginstructor, ridingtype, horse, date, time, status);
    }
}
