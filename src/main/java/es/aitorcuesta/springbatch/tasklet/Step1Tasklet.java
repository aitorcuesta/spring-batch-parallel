package es.aitorcuesta.springbatch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.aitorcuesta.springbatch.beans.DataBaseBean;
import es.aitorcuesta.springbatch.beans.InputDataBaseItem;
import es.aitorcuesta.springbatch.beans.MemoryBean;

@Component
public class Step1Tasklet implements Tasklet {

	private static final Logger logger = Logger.getLogger(Step1Tasklet.class);

	@Autowired
	private DataBaseBean dataBaseBean;

	@Autowired
	private MemoryBean memoryBean;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		logger.info("Step1Tasklet - Getting data from database into memory");
		InputDataBaseItem item = dataBaseBean.getNext();
		while (null != item) {
			memoryBean.getItems().add(item);
			item = dataBaseBean.getNext();
		}
		logger.info("Step1Tasklet - Done");
		return RepeatStatus.FINISHED;
	}

	public void setDataBaseBean(DataBaseBean dataBaseBean) {
		this.dataBaseBean = dataBaseBean;
	}

	public void setMemoryBean(MemoryBean memoryBean) {
		this.memoryBean = memoryBean;
	}

}
