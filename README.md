# Desafio cassinos

### Enunciado

Nos cassinos da Romênia, apostadores serão colocados em um grande círculo, voltados para dentro. Alguém é escolhido arbitrariamente como número 1, e os outros são numerados no sentido horário até N (os quais estarão à esquerda do 1°). Partindo do 1° e movendo-se no sentido horário, um funcionário do cassino conta k posições e retira um apostador, enquanto outro funcionário começa a partir de N e se move no sentido anti-horário, contando m posições e retirando outro apostador. Os dois que são escolhidos são então removidos do círculo e se ambos os funcionários escolherem a mesma pessoa, ela (ele) ganha um brinde exclusivo do cassino. Cada funcionário, em seguida, começa a contar novamente com a pessoa próxima disponível e o processo continua até que não reste ninguém, os últimos selecionados são os ganhadores. Note-se que os dois apostadores deixam o anel ao mesmo tempo, por isso é possível que um funcionário conte a pessoa já selecionado pelo outro funcionário.

#### Entrada

Escreva um programa que leia sucessivamente três números (N, k e m; k, m > 0, 0 < N < 20) e determina a ordem no qual os apostadores são retirados do círculo. Cada conjunto de três números estará em uma linha distinta e o final da entrada de dados é sinalizado por três zeros (0 0 0).

#### Saida

Para cada conjunto de três números de entrada, imprima uma linha de números especificando a ordem na qual as pessoas são escolhidas. Liste o par escolhido partindo da pessoa escolhida pelo contador do sentido horário. Os pares sucessivos são separados por vírgula (mas não deverá haver vírgula após o último escolhido).

### Implementaçao

Codigo fonte:

Circle: Classe define informações do circulo ou lista circular.

**atrubutos:** 
 - *start* - referencia do circulo
 - *CLOCKWISE - Sentido ou direção de percurso, neste caso sentido horário*
 - *ANTICLOCKWISE - Sentido ou direção de percurso, neste caso sentido anti-horário*

**métodos:**
 - *Node fill(int size)* - preenchimento do circulo
 - *int count()* - conta os elementos do circulo
 - *void delete(Node selected)* - remove o elemento selecionado
 - *Node select(Node start, int n, int direction)* - seleciona um elemento do circulo, seguindo as condições do enumciado
 - *Node nextPosition(Node selected1, Node selected2)* - retorna a proxima posição no sentido horário
 - *Node prevPosition(Node selected1, Node selected2)* - retorna a proxima posição no sentido anti-horário

Node: Classe define um nó, ou no caso o jogador.

**atrubutos:**
 - *id* - identificador ou numero do jogador
 - *prev* - ligação com o jogador anterior no sentido anti-horário
 - *next* -  ligação com o proximo no sentido horário

LuckyPlayer: Classe pricipal para sorteio do jogador.
 - *main* - metodo pricipal que inicia o fluxo do sorteio
