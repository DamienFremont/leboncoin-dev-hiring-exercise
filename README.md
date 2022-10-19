LE BON COIN - DEV HIRING EXERCISE
=================================

Base sur les specs [SPECS.md](SPECS.md)

---

## Requirements

- Install Java 11
- Configure JAVA_HOME

---

## Getting Started

```bash
.\mvnw clean package
```

## Usage

### 1. Start API server

Dev Env
```bash
.\mvnw spring-boot:run 
```

Prod Env
```bash
.\mvnw spring-boot:run "-Dspring-boot.run.profiles=prod"
```

### 2. Call API Server

- using the postman collection at [./postman](./postman)
- PROD: using a new jwt token at https://jwt.io/ (see application-prod.xml)


---

## Resources

GitLab

### Java Spring template project

This project is based on a GitLab [Project Template](https://docs.gitlab.com/ee/gitlab-basics/create-project.html).

Improvements can be proposed in the [original project](https://gitlab.com/gitlab-org/project-templates/spring).

### CI/CD with Auto DevOps

This template is compatible with [Auto DevOps](https://docs.gitlab.com/ee/topics/autodevops/).

If Auto DevOps is not already enabled for this project, you can [turn it on](https://docs.gitlab.com/ee/topics/autodevops/#enabling-auto-devops) in the project settings.

---

## Support

See [./docs](docs))

![alt text](docs/Diapositive1.PNG)

![alt text](docs/Diapositive2.PNG)

![alt text](docs/Diapositive3.PNG)

![alt text](docs/Diapositive4.PNG)

![alt text](docs/Diapositive5.PNG)

![alt text](docs/Diapositive6.PNG)
