# Kafka With SpringBoot
Sanket Mohalkar

# Apache Kafka Overview

Apache Kafka is an open-source distributed event streaming platform used for building real-time data pipelines and streaming applications. It is designed to handle high-throughput, fault-tolerant, and scalable messaging.

## Key Terminology

- **Producer:** A client application that publishes (writes) records to Kafka topics.
- **Consumer:** A client application that subscribes to (reads) records from Kafka topics.
- **Topic:** A category or feed name to which records are sent by producers. Topics are partitioned for parallel processing.
- **Partition:** A single log within a topic where records are stored. Partitions enable scalability and fault-tolerance.
- **Broker:** A Kafka server that stores records and serves client requests. A Kafka cluster comprises multiple brokers.
- **Cluster:** A group of Kafka brokers working together to manage data and provide redundancy.
- **Zookeeper:** A centralized service for maintaining configuration information, naming, providing distributed synchronization, and group services within a Kafka cluster.
- **Offset:** A unique identifier assigned to each record within a partition, used by consumers to track their position.

## Kafka Architecture

Kafka's architecture is built around the following key components:

1. **Producers:** Producers send records to Kafka topics. Each record consists of a key, value, and optional headers. The key can be used to determine the partition to which the record will be sent.

2. **Topics and Partitions:** Topics are divided into partitions, which are the fundamental units of parallelism and scalability in Kafka. Each partition is an ordered, immutable sequence of records.

3. **Brokers:** Brokers are the Kafka servers that store data and serve client requests. Each broker hosts one or more partitions of a topic. Brokers communicate with each other to ensure data replication and fault tolerance.

4. **Consumers:** Consumers read records from Kafka topics. They can be organized into consumer groups, where each consumer in the group processes data from different partitions, enabling parallel data processing.

5. **Zookeeper:** Kafka relies on Zookeeper to manage the cluster metadata, including broker information, partition assignments, and configuration settings. Zookeeper ensures the coordination and synchronization of the Kafka cluster.


In this architecture:
- Producers publish records to brokers.
- Brokers store records in partitions and manage replication.
- Consumers read records from brokers, optionally as part of a consumer group.
- Zookeeper maintains the metadata and ensures coordination among brokers.


![alt text](kafkaArc.png)


## Delivery Guarantees

Kafka provides three types of message delivery guarantees:
- **At Most Once:** Messages are delivered zero or one time.
- **At Least Once:** Messages are delivered one or more times.
- **Exactly Once:** Messages are delivered exactly once.