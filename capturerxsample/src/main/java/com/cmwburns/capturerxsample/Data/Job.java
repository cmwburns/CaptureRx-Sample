package com.cmwburns.capturerxsample.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Job {
  @Id
  @Column(unique = true)
  private int id;

  @Column private String job_status;
}
