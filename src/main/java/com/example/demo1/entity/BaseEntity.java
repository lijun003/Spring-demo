package com.example.demo1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    private ID id;

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
        if (null == createdDate) {
            setCreatedDate(new Date());
        }
    }

    @PreUpdate
    @PreRemove
    void preUpdate() {
        if (null == modifiedDate) {
            setModifiedDate(new Date());
        }
    }
}
