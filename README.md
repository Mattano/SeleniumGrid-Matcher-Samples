# SeleniumGrid-Matcher-Samples
Exemplos de matchers para Selenium Grid


Selecione o tipo de matcher 

Certifique-se de adicionar a classe do matcher no arquivo de configuracao do node

Exemplo de arquivo hubConfig.json:

```JSON
{
  "port": 4444,
  "newSessionWaitTimeout": -1,
  "servlets": [],
  "custom": {},
  "capabilityMatcher": "com.example.selenium.matcher.ExpansibleCustomMatcher",
  "throwOnCapabilityNotPresent": true,
  "cleanUpCycle": 5000,
  "browserTimeout": 300,
  "timeout": 600,
  "maxSession": 5
}

```

Gere o .jar do projeto com o comando maven

```sh
mvn package
```


Utilize o comando abaixo para inicializar o Hub com o matcher:

```sh
java -cp selenium-server-standalone-3.141.59.jar:customMatchers-1.0-SNAPSHOT.jar org.openqa.grid.selenium.GridLauncherV3 -role hub -hubConfig hubConfig.json
```
