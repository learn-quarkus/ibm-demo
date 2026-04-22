# IBM Demo - Quarkus AI Projects

Collection of Quarkus applications demonstrating LangChain4j integration with OpenAI.

## Prerequisites
- Java 21
- Maven
- Docker (for PostgreSQL dev containers)
- OpenAI API key

## Setup

Set your OpenAI API key:
```bash
export QUARKUS_LANGCHAIN4J_OPENAI_API_KEY=your-api-key-here
```

## Projects

### hello-quarkus
Basic Quarkus REST application (no AI, no database).
```bash
cd hello-quarkus
./mvnw quarkus:dev
```
Runs on: http://localhost:8080

### hello-quarkus-ai
Simple Quarkus + LangChain4j OpenAI integration.
```bash
cd hello-quarkus-ai
./mvnw quarkus:dev
```
Runs on: http://localhost:8080

### hello-world
Quarkus + LangChain4j + PostgreSQL.
```bash
cd hello-world
./mvnw quarkus:dev
```
Runs on: http://localhost:8081

### haiku-generator
Haiku generation using Quarkus + LangChain4j + PostgreSQL.
```bash
cd haiku-generator
./mvnw quarkus:dev
```
Runs on: http://localhost:8080

### ai-quarkus
Poem generation and rating system with Quarkus + LangChain4j + PostgreSQL (Red Hat Quarkus platform).
```bash
cd ai-quarkus
./mvnw quarkus:dev
```
Runs on: http://localhost:8082

## Notes
- PostgreSQL containers start automatically via Quarkus Dev Services
- All projects use Java 21
- Projects with databases automatically create schemas on startup


Disclaimer: the README is written with Claude. A lot of Quarkus code was written with Bob Shell