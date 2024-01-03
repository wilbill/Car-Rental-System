package com.carRentalSystem.domain;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class AuditData {
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
