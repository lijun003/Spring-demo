package com.example.demo1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Data
public class BaseEntity {
    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @PrePersist
    void prePersist() {
        if (isEmpty(id)) {
            setId(UUID.randomUUID().toString());
        }

        if (null == createdDate) {
            setCreatedDate(new Date());
        }
    }

    @PreUpdate
    void preUpdate() {
        if (null == modifiedDate) {
            setModifiedDate(new Date());
        }
    }
}
