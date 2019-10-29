package es.aitorcuesta.springbatch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.aitorcuesta.springbatch.beans.InputDataBaseItem;
import es.aitorcuesta.springbatch.beans.MemoryBean;

@Component
public class Step2Tasklet implements Tasklet {

	private static final Logger logger = Logger.getLogger(Step2Tasklet.class);

	@Autowired
	private MemoryBean memoryBean;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		for (InputDataBaseItem item : memoryBean.getItems()) {
			logger.info("Step2Tasklet -  Processing... " + item.toString());
			Thread.sleep(2000);
			logger.info("Step2Tasklet -  " + item.toString() + " ...processed");
		}
		return RepeatStatus.FINISHED;
	}

}
