# CaptureRx-Sample
Sample Spring Boot project for CaptureRx. Contains a REST API to add and retrieve a Job, or all Jobs with a unique id a status.
When a Job is created, its status is marked as IN PROGRESS in the database. It's then sent through a Kafka topic that simulates a process,
then is saved again in the database with job status DONE.

#Set Up
In application.properties, the datasource properties for url, username, and password are set by environment variables.
When running locally, either set up the variables in your environment, or replace the properties in the file.
When running, make sure your Kafka server is running. Run with gradle bootRun command.


