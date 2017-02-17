# evernote_career_path
project to practise according to requirement in evernote NOTE:"career path"


start eureka
docker run -d --name=eureka -p 8888:8080 evernote/eureka

start account server
docker run -d --name=account-service --env-file=./environment  -p 2222:2222 evernote/account-service