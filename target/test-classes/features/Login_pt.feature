#language: pt
@login-pt @regression-pt @robot

Funcionalidade: WebDriver University - Página de login

  Contexto:
    Dado que eu acesso a página de login

  Cenário: validar login bem-sucedido
    Quando eu insiro o nome de usuário webdriver
    E eu insiro uma senha webdriver123
    Então deve ser apresentada a mensagem de login bem-sucedida

  Cenário: validar login malsucedido
    Quando eu insiro o nome de usuário "webdriver
    E eu insiro uma senha "password123"
    Então deve ser apresentada a mensagem de login sem sucesso

  Esquema do Cenário: Validar - Login bem-sucedido e mal-sucedido
    Quando eu insiro o nome de usuário <username>
    E eu insiro uma senha <senha>
    Então deve ser apresentada a mensagem de validação de login <loginValidationMessage>

    Exemplos:
      | username  | senha     | loginValidationMessage |
      | joe_blogs | password1 | validation failed   |

  Esquema do Cenário: Validar - Login bem-sucedido e mal-sucedido cint
    Quando eu insiro o nome de usuário <username>
    E eu insiro uma senha <senha>
    Então deve ser apresentada a mensagem de validação de login <loginValidationMessage>

    Exemplos:
      | username  | senha        | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |

