# Haiku Generator

A Quarkus application that generates beautiful haiku poems using OpenAI's GPT models.

## Features

- Generate haiku poems on any topic using OpenAI
- RESTful API endpoint
- Built with Quarkus and LangChain4j

## Prerequisites

- Java 17 or later
- Maven 3.8.1+
- OpenAI API key

## Configuration

Set your OpenAI API key as an environment variable:

```bash
export QUARKUS_LANGCHAIN4J_OPENAI_API_KEY=your-api-key-here
```

## Running the Application

### Development Mode

```bash
./mvnw quarkus:dev
```

The application will start on `http://localhost:8080`

### Production Mode

```bash
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
```

## Usage

Generate a haiku by making a GET request to the `/haiku` endpoint:

```bash
# Generate a haiku about nature (default topic)
curl http://localhost:8080/haiku

# Generate a haiku about a specific topic
curl "http://localhost:8080/haiku?topic=ocean"
curl "http://localhost:8080/haiku?topic=mountains"
curl "http://localhost:8080/haiku?topic=technology"
```

## Example Response

```
Waves crash on the shore
Ancient rhythm never stops
Ocean's timeless song
```

## API Endpoints

- `GET /haiku?topic={topic}` - Generate a haiku about the specified topic
  - Query Parameter: `topic` (optional, defaults to "nature")
  - Response: Plain text haiku poem

## Technology Stack

- Quarkus 3.17.5
- LangChain4j OpenAI integration
- RESTEasy Reactive
- OpenAI GPT-4o-mini model