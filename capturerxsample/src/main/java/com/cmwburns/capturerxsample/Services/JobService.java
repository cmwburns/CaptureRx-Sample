package com.cmwburns.capturerxsample.Services;

import com.cmwburns.capturerxsample.Data.JobRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class JobService {
    private JobRepository jobRepository;
}
