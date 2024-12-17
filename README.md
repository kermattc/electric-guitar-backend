# Overview
- Full stack web app to find electric guitar data. What was supposed to be a java/spring boot backend project somehow turned into a full stack app deployed on AWS.

- I developed the backend using Java and Spring Boot, which grabs data from a PostgreSQL database. To ensure fast queries, I used JPA queries to find data rather than getting all the data and having the backend do the finding.
- As for the frontend I used Angular and TypeScript. The frontend is finicky as it doesn't work on different screen sizes and more because I didn't intend on developing this into a full stack app.


## Tech Stack
- Frontend: Angular, TypeScript, Angular Material
- Backend: Java, Spring Boot, JPA Query
- Database: PostgreSQL

- Deployment (all AWS):
  - Frontend: S3 for static web hosting, CloudFront
  - Backend: ECS, API Gateway
  - Database: RDS


## Bugs / known issues
- spaces are removed by accident in the backend (ie: typing in "Jimi Hendrix" won't return the legend himself)
- adaptive screen sizes
- consistency with cards

I figured I had too many projects that revolve around baseball so here's one about another hobby of mine - guitar! 
