# Overview
- Full stack web app to find electric guitar data. What was supposed to be a java/spring boot backend project somehow turned into a full stack app deployed on AWS and Azure.

- I developed the backend using Java and Spring Boot, which grabs data from a PostgreSQL database. To ensure fast queries, I used JPA queries to find data rather than getting all the data and having the backend do the finding.
- As for the frontend I used Angular and TypeScript. The frontend is finicky as it doesn't work on different screen sizes and more because I didn't intend on developing this into a full stack app.
- For deployment or anything DevOps related, I initially did everything on AWS but eventually migrated the backend to Azure function app (I initially used ECS and got charged some $$$). 


## Tech Stack
- Frontend: Angular, TypeScript, Angular Material
- Backend: Java, Spring Boot, JPA Query
- Database: PostgreSQL
- CI/CD: Gitlab (Frontend), GitHub Actions + Workflow (Backend)
- IaC: Terraform

- Deployment:
  - Frontend: S3 for static web hosting, CloudFront, CI/CD via Gitlab
  - Backend: Azure Function (pulls docker image on ghcr) (Also, I initially used AWS ECS and API Gateway but ended up getting charged $$$ for that)
  - Database: RDS


## Bugs / known issues
- ~~spaces are removed by accident in the backend (ie: typing in "Jimi Hendrix" won't return the legend himself)~~
- adaptive screen sizes
- ~~consistency with cards~~
- weird bug when starting a search with a new keyword that includes any of the characters in (class="highlight"), then it will add that into the text and highlight itself

## Additional Features
- add a function where you can include rows with all keywords (search via OR)

The gitlab repo is stored separately as I just copied this project and created a new repo there as things were starting to get messy here.
The odd combination of technologies isn't due to any reason in particular, I was just exploring different technologies and kept applying them onto this project.
I figured I had too many projects that revolve around baseball so here's one about another hobby of mine - guitar! 
