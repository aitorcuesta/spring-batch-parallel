package es.aitorcuesta.springbatch;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.aitorcuesta.springbatch.beans.DataBaseBean;
import es.aitorcuesta.springbatch.beans.InputDataBaseItem;
import es.aitorcuesta.springbatch.beans.MemoryBean;

public class App {
	
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-parallel-appContext.xml");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("aitorcuestaSpringBatchJob");

		DataBaseBean dataBaseBean = (DataBaseBean) context.getBean("dataBaseBean");
		MemoryBean memoryBean = (MemoryBean) context.getBean("memoryBean");

		for (int i = 0; i < 10; i++) {
			InputDataBaseItem input = new InputDataBaseItem();
			input.setId((long) i);
			input.setName("Nombre" + i);
			dataBaseBean.getItems().add(input);
		}
		
		logger.info("----------- BEFORE JOB ---------");
		logger.info("DataBaseBean stores " + dataBaseBean.getElements() + " items");
		logger.info("MemoryBean stores " + memoryBean.getElements() + " items");
		logger.info("----------- BEFORE JOB ---------");

		try {
			logger.info("----------- STARTING JOB ---------");
			long start = System.nanoTime();
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			logger.info("Exit Status : " + execution.getStatus());
			logger.info("Time elapsed: " + TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS) + " seconds");

		} catch (Exception e) {
			logger.error(e, e);
		}

		System.out.println("----------- AFTER JOB ---------");
		logger.info("DataBaseBean stores " + dataBaseBean.getElements() + " items");
		logger.info("MemoryBean stores " + memoryBean.getElements() + " items");
		System.out.println("----------- AFTER JOB ---------");

	}

}
