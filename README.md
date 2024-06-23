# Hello World Quarkus Project

Projeto baseado em Quarkus. 

<br >

# Executar a aplicação localmente (in dev mode):

Executando com live coding:
```shell script
./mvnw compile quarkus:dev
```

<br >

# URL para teste (cURL):
```shell script
curl --location --request GET 'http://<DNS-DO-SERVICO>/hello'
```

## Exemplo:
# Testando a aplicação:
```shell script
curl --location --request POST 'http://localhost:8080/hello'
```

<br >

### IMPORTANTE: Para o profile de dev (quarkus:dev) e default a porta utilizada para essa aplicação é 8080, se aplicado no cluster o manifesto kubernetes e a porta 80.

<br >
<br >

# Para executar em Cluster com Service Mesh:

## Build da Imagem Docker
```
mvn package
docker build -f src/main/docker/Dockerfile.jvm -t <SEU-DOCKERHUB-ID>/hello-world-quarkus:1.0.0 .
docker push <SEU-DOCKERHUB-ID>/hello-world-quarkus:1.0.0
```

## Aplicar os manifestos presentes em "src/main/kubernetes" para o deploy ocorrer:
### Importante:
- Necessário uma Infra com o Service Mesh
- Alterar a imagem existente no arquivo 02.deployament.yaml
- Se ambiente de execução AWS deve ter acesso nas tabelas do DynamoDB
- Link do terraform para criação da infra: https://github.com/ailtonmsj/aws-new-stack
```
...
containers:
      - image: <SEU-DOCKERHUB-ID>/useradd-jvm:1.0.0
        name: useradd-jvm
...
```

### Executar:
```
kubectl apply -f src/main/kubernetes
```

<br >

# Códigos de Resposta

### 200 - OK

<br />

### Health Checks / Ready

/q/health/live - The application is up and running.

/q/health/ready - The application is ready to serve requests.

/q/health - Accumulating all health check procedures in the application.


### SmallRye Health

Monitor your application's health using SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)
