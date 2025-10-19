# 🐶 API Automation Dogs

Automação de testes de API para listagem de “doguinhos”.  
Este projeto usa Java, Maven, JUnit 5, RestAssured e Allure para geração de relatórios.

---

## 🏷️ Badges

[![CI/CD](https://github.com/franvareira/api-automation-dogs/actions/workflows/ci.yml/badge.svg)](https://github.com/franvareira/api-automation-dogs/actions)  
[![Allure Report](https://img.shields.io/badge/Allure-Report-ED1C24?logo=allure&logoColor=white)](https://franvareira.github.io/api-automation-dogs/)  
![Java 23](https://img.shields.io/badge/Java-23-blue)  
![Maven](https://img.shields.io/badge/Maven-3.x-orange)

> ⚠️ O link do Allure Report só funcionará após o primeiro merge para `main` (quando o GitHub Pages estiver configurado).

---

## 🧱 Tecnologias & versões

- **Java**: 23  
- **Maven**: conforme especificado no `pom.xml`  
- **JUnit 5**  
- **RestAssured**  
- **Allure Report / Allure Maven Plugin**  
- **GitHub Actions** para CI/CD  
- **peaceiris/actions-gh-pages** para publicar relatório no GitHub Pages

---

## 📂 Estrutura de diretórios

```
api-automation-dogs/
├── .github/
│   └── workflows/
│       └── ci.yml              # pipeline de CI/CD (GitHub Actions)
├── src/
│   └── test/
│       ├── java/
│       │   ├── scenarios/      # definições de casos de teste
│       │   ├── services/       # classes que fazem as chamadas via RestAssured
│       │   └── utils/          # classes utilitárias/helper
├── pom.xml                      # arquivo de build do Maven
└── README.md                    # documentação do projeto
```

**O que cada pasta representa:**

- `scenarios/`: localização dos testes “de alto nível” — conjuntos de verificações de API  
- `services/`: classes que encapsulam chamadas HTTP (GET, POST, etc.) usando RestAssured  
- `utils/`: ferramentas auxiliares, helpers, configurações comuns  
- `.github/workflows/ci.yml`: definição de workflow para GitHub Actions (testes, geração e publicação de relatório)

---

## 🧪 Execução local

### Pré-requisitos

- Java 23 instalado e configurado no `PATH`  
- Maven instalado  
- (Opcional) Allure CLI instalado (ver abaixo)

### Passos para rodar os testes localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/franvareira/api-automation-dogs.git
   cd api-automation-dogs
   git checkout develop
   ```

2. Executar testes com Maven:

   ```bash
   mvn clean
   mvn -Dtest=RunnerAllTest test
   ```

3. Gerar relatório Allure:

   ```bash
   mvn io.qameta.allure:allure-maven:2.15.0:report
   ```

4. (Opcional) Servir o relatório localmente, se você tiver o Allure CLI instalado:

   ```bash
   allure serve target/allure-results
   ```

   Ou:

   ```bash
   mvn io.qameta.allure:allure-maven:2.15.0:serve
   ```

---

## 📦 Instalar o Allure localmente

Para gerar e visualizar relatórios localmente, você pode instalar o **Allure CLI**:

### Via Homebrew (macOS / Linux)

```bash
brew install allure
```

### Via download direto

1. Vá até o repositório oficial do Allure e baixe o pacote binário. [LINK](https://allurereport.org/docs/install-for-windows/)  
2. Extraia para uma pasta no seu sistema (ex: `/usr/local/bin` ou algo no PATH).  
3. Adicione o executável `allure` ao seu PATH.

### Verificar instalação

```bash
allure --version
```

(se retornar versão válida, está correto)

### Usar o Allure para gerar/visualizar relatórios

- `allure generate target/allure-results --clean -o target/allure-report`  
- `allure serve target/allure-results` (gera + abre relatório automaticamente)

---

## 🧭 Fluxo no GitHub Actions / CI

1. **Push ou pull request** para a branch `develop` → dispara a pipeline para executar testes  
2. **Merge/Push para `master`** → executa testes +, em seguida, publica relatório no **GitHub Pages**  
3. **Execução manual**: via botão “Run workflow” definido com `workflow_dispatch`

O `ci.yml` será algo como:

```yml
# [exemplo simplificado]
on:
  push:
    branches: [ develop, master ]
  pull_request:
    branches: [ develop, master ]
  workflow_dispatch:

jobs:
  test:
    # … etapas de checkout, build, testes, upload de artefatos
  deploy-report:
    needs: test
    if: ${{ success() && github.ref == 'refs/heads/main' }}
    # etapas de download e publicação via peaceiris/actions-gh-pages
```

Após o primeiro merge para a `main`, o GitHub Pages deve estar configurado para usar a branch `gh-pages` como origem.  
Então o relatório ficará disponível em:

```
https://franvareira.github.io/api-automation-dogs/
```


