# spring-batch-parallel
Spring Batch parallel processing example

This application tries to demonstrate how to parallelize any spring batch process.

## Step 1 The basic tasklet batch
This is a very simple spring batch application using the Tasklet interface for every defined step.
- Step1 simulates a very simple reader task. Takes data from database to be processed into memory.
- Step2 simulates a processor. While memory data is available, takes the next item to process.
- Step3 simulates a report generator. It really does nothing but say Generating report.

We aren't going to use any chunk processing or anything else, we are trying to make the simplest batch we can do.
