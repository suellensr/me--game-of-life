# Jogo da Vida de Conway

## Descrição

Este projeto é uma implementação do **Jogo da Vida de Conway** utilizando **Java** e **JavaFX**. O Jogo da Vida é um autômato celular que simula a evolução de células em uma grade bidimensional com base em regras simples. O projeto oferece uma interface gráfica interativa para visualizar a evolução das células, além de controles para iniciar, pausar e configurar a simulação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para a lógica do jogo.
- **JavaFX**: Biblioteca para criar a interface gráfica do usuário, incluindo elementos como `Canvas`, `Button`, `Label`, e `TextField`.

## Estrutura do Projeto

### GameOfLife

- **Responsabilidade**: Gerencia a lógica do jogo, incluindo a inicialização do tabuleiro, a atualização das células e a renderização no canvas.
- **Principais Métodos**:
  - `initializerBoard()`: Inicializa o tabuleiro com células aleatoriamente vivas e mortas.
  - `nextGeneration()`: Atualiza o estado do tabuleiro para a próxima geração com base nas regras do jogo.
  - `draw()`: Desenha a grade de células no canvas usando `GraphicsContext`.

### ScreenConfig

- **Responsabilidade**: Fornece uma interface para o usuário configurar o jogo antes de iniciar.
- **Principais Funcionalidades**:
  - Campos de texto para entrada de número de linhas, colunas e células vivas.
  - Validação das entradas e redirecionamento para a tela do jogo.

### ScreenGame

- **Responsabilidade**: Gerencia a tela de jogo onde a simulação é exibida e controlada.
- **Principais Funcionalidades**:
  - **Canvas**: Exibe o tabuleiro do Jogo da Vida.
  - **Botões**: Controles para resetar, avançar um passo, iniciar e parar a simulação.
  - **`AnimationTimer`**: Atualiza a visualização do jogo a cada 0.5 segundos enquanto o jogo está em execução.

## Funcionalidades

- **Tela de Configuração**: Permite ao usuário definir o número de linhas, colunas e células vivas, e iniciar o jogo.
- **Tela de Jogo**: Exibe o tabuleiro e inclui botões para:
  - **Resetar** o tabuleiro.
  - **Avançar um passo** na simulação.
  - **Iniciar** a execução contínua do jogo.
  - **Parar** a execução contínua.

## Como Executar

1. Clone o repositório: `git clone <url-do-repositorio>`
2. Navegue até o diretório do projeto.
3. Compile e execute a aplicação com um IDE compatível ou usando a linha de comando.

## Considerações Finais

Este projeto demonstra a aplicação de conceitos de programação orientada a objetos em Java e a criação de interfaces gráficas interativas com JavaFX. Ele oferece uma visualização clara e interativa da dinâmica do Jogo da Vida, proporcionando uma compreensão prática de autômatos celulares e simulações.

