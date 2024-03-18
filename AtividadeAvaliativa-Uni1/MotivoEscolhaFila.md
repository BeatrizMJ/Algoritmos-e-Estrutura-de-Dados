### Sistema de Gerenciamento de Tarefas

Neste projeto, optei por utilizar uma **fila** ("queue" em inglês) como a estrutura de dados principal para armazenar e gerenciar as tarefas da equipe de desenvolvimento de software. Essa escolha foi feita com base em diversas considerações:

📋 **Ordem de Chegada**: A fila mantém a ordem de chegada das tarefas, garantindo que a primeira tarefa adicionada seja a primeira a ser realizada. Isso é crucial para lidar com tarefas em uma ordem específica, conforme exigido pelo sistema.

🗑️ **Remoção Eficiente**: Quando uma tarefa é concluída, ela é removida da frente da fila. As filas oferecem uma operação de remoção eficiente para o elemento na frente da fila (primeiro a entrar, primeiro a sair), atendendo ao requisito de remoção eficiente de tarefas concluídas.

👁️ **Visualização da Próxima Tarefa**: Como as filas mantêm a ordem de chegada, a próxima tarefa a ser realizada está sempre no início da fila. Isso possibilita a visualização rápida da próxima tarefa, sem a necessidade de percorrer toda a lista de tarefas.

🚀 **Escalabilidade**: As filas são estruturas de dados escaláveis, capazes de lidar com um grande número de tarefas de forma eficiente. Adicionar ou remover uma tarefa é uma operação de tempo constante \( O(1) \), independentemente do tamanho da fila.

Portanto, a fila se destaca como a escolha mais adequada para este sistema de gerenciamento de tarefas. Ela atende a todos os requisitos funcionais e não funcionais especificados, proporcionando eficiência e escalabilidade para a equipe de desenvolvimento.
