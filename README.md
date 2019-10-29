# spring-batch-parallel
Spring Batch parallel processing example

This application tries to demonstrate how to parallelize any spring batch process.

## Step 1 The basic tasklet batch
This is a very simple spring batch application using the Tasklet interface for every defined step.
- Step1 simulates a very simple reader task. Takes data from database to be processed into memory.
- Step2 simulates a processor. While memory data is available, takes the next item to process.
- Step3 simulates a report generator. It really does nothing but say Generating report.

We aren't going to use any chunk processing or anything else, we are trying to make the simplest batch we can do.


## Step 2 The multi-threaded tasklet batch
As we have seen, step 2 takes a lot of time for processing every item.
We are going to make the simples improvement adding a TaskExecutor. This will make that step 2 parallel running in a separate execution thread.