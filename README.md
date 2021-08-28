# ms-envia-email-hexagonal
Micro serviço de envio de E-mail com Arquitetura Hexagonal desenvolvido a partir da aula sobre Arquitetura Hexagonal apresentado pela Michelli Brito.
Link da Aula : https://www.youtube.com/watch?v=UmdOjbyYOX0

## Sobre a arquitetura
A arquitetura Hexagonal é um tipo de arquitetura de Software que permite a melhor organização e distriuição das responsabilidades e desacoplamento  de cada cada e funcionalidade  presente no projeto,  além de permitir melhor manuntebilidade e escabilidade do Software.
Basicamente a arquitetura é dividida em 3 camadas : Aplication Domain , Ports e Adapter .
### Application Domain 
Na camada de Aplication Domain , Domínio de Aplicação , estão localizados as classes referentes as regras de negócio envolvidos  no Software, isto é , as entidades de domínio , os casos de usos e regras instriseca as regras do negócio;

### Ports
Os Ports, são responsável por ser a interface ou porta de acesso para acessar as operações e regras presentas na camada de Application Domain ou porta de saída no qual precisam de outros recursos externos.

### Adapter
Já os Adapter são "quem" implementa as portas para ter acesso aos serviços das regras do application domain, os adapters podem ser do tipo inbound ou outbound: inbound são adaptadores que solicitam determinados acessos ao application domain , enquanto que os outbounds são àqueles no qual as regras solicitam acesso aos recursos externo.  

![alt tag](https://uploads-ssl.webflow.com/5eebed4f86986c7148161d11/5f4fe4418bbe242216f77452_hexagonal-architecture-v3.png)

## Pré requisitos
  - Postgres instalado e configurado
  - Java 11
  - Apache Maven 3.6.3
  
  - Fazer a configuração do arquivo de propriedades application.properties com os dados necessários de e-mail e banco de dados
## Execução

Com o maven instalado execute o comando :
```bash
        mvn install
```
Ao finalizar a instalação entre na pasta target e execute o comando:
```bash
       java -jar  ms-envio-email-0.0.1-SNAPSHOT.jar
```
