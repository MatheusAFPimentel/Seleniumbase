#language: pt
@offshore
Funcionalidade:Criação de seguro novo teste
  Esquema do Cenário: Validar avanço para o step Dados do Tomador
    Dado que eu consiga fazer o login com sucesso do Salesforce
    E que eu esteja na pagina de Seleção de Produtos do Boletador <boletador>
    Quando escolho o Ramo <ramo> e o produto <produto>
    Então eu consigo avançar para o step Dados do Tomador
   # E eu fecho a aba aberta
    Exemplos:
      | ramo   | boletador          | produto                              |
      | Privado| Boletador Offshore |Garantia Offshore Peru - Setor Privado|
      | Público| Boletador Offshore |Garantia Offshore Peru - Setor Público|