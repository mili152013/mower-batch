package com.mowitnow.mower.application.infrastructure.config;

import com.mowitnow.mower.application.domain.model.Mower;
import com.mowitnow.mower.application.domain.services.MowerService;
import com.mowitnow.mower.application.infrastructure.processor.MowerProcessor;
import com.mowitnow.mower.application.infrastructure.reader.MowerInputReader;
import com.mowitnow.mower.application.infrastructure.writer.MowerOutputWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Value("${mower.input.file.path}")
    private String inputFilePath;

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
            .<Mower, Mower>chunk(1, transactionManager)
            .reader(new MowerInputReader(inputFilePath))
            .processor(new MowerProcessor(new MowerService()))
            .writer(new MowerOutputWriter())
            .build();
    }

    @Bean
    public Job processMowerJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("processMowerJob", jobRepository)
            .start(step)
            .build();
    }
}
