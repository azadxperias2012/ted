package com.azadxperias.ted;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TedApplication implements CommandLineRunner {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	public static void main(String[] args) {
		SpringApplication.run(TedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        if (jobExecution != null) {
			System.out.println("JobExecution: " + jobExecution.getStatus());
			System.out.println("Batch is Running...");
			while (jobExecution.isRunning()) {
				System.out.println("...");
			}
			System.out.println(jobExecution.getStatus());
			jobExecution.stop();
		}
	}
}

//public class TedApplication {
//
//	public static void main(String[] args) {
//		System.out.println("Covert to date");
//
//		String date = "1151367060";
//		System.out.println(new Date(Long.valueOf(date) * 1000L));
//
//	}
//}
