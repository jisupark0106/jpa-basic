package jpa.basic.shop.domain;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private String createdUser;
    private String modifiedUser;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
