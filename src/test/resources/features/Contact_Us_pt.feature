#language: pt
@contact-us-pt @regression-pt

Funcionalidade: Entrada de dados na url webdriveruniversity.com  utilizando o formulário da página Contact us

  Contexto:
    Dado que eu acessei a página Contact us

  Cenário: Validar envio bem-sucedido - dados exclusivos
    Quando eu insiro um nome exclusivo
    E eu insiro um sobrenome único
    E eu insiro um endereço de e-mail exclusivo
    E eu insiro um comentário único
    E eu clico no botão enviar
    Entao devo receber uma mensagem de envio de contato bem-sucedida

  Cenario: Validar o envio bem-sucedido - dados específicos
    Quando eu insiro um nome específico karen
    E eu insiro um sobrenome específico Blossom
    E eu insiro um endereco de e-mail específico karen_blossom123@mail.com
    E eu insiro um comentário específico "Como você está hoje?"
    E eu clico no botão enviar
    Então devo receber uma mensagem de envio de contato bem-sucedida