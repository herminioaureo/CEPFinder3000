# CEPFinder3000
Projeto de estudo para criar app no Android que faça uma consulta de CEP via serviço REST.
A aplicação foi construída em linguagem Java, utilizando o Android Studio e Gradle para fazer o gerenciamento de builds e dependências. O consumo do serviço REST ficou a cargo da API Retrofit. Ao pesquisar por um CEP válido, a aplicação utiliza o "intent" do Android para abrir aquele endereço associado ao CEP no aplicativo Google Maps, ou qualquer outro aplicativo de mapas que esteja instalado no dispositivo.

O serviço utilizado para buscar os endereços foi o https://viacep.com.br/ws/
