package org.backend.ridinglesson;

public record Ridinglesson(
        String id,
        String ridinginstructor,
        String ridingtype,
        String horse,
        String Date,
        String Time,
        RidinglessonStatus status
) {
    Ridinglesson(
            String ridinginstructor,
            String ridingtype,
            String horse,
            String Date,
            String Time,
            RidinglessonStatus status
    ){
        this(null, ridinginstructor, ridingtype, horse, Date, Time, status);
    }

    public Ridinglesson withId(String id) {
        return new Ridinglesson(id, ridinginstructor, ridingtype, horse, Date, Time, status);
    }
}
