package com.cmwburns.capturerxsample.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@Data
@Entity
public class Job {
    @Column(unique=true)
    private int job_id;
    @Column
    private String job_status;
}
