package es.aitorcuesta.springbatch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Step3Tasklet implements Tasklet {
	
	private static final Logger logger = Logger.getLogger(Step3Tasklet.class);

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		logger.info("Step3Tasklet - Generating report...");
		return RepeatStatus.FINISHED;
	}
}
