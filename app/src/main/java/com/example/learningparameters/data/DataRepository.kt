package com.example.learningparameters.data

val userDefault = User(
    userId = "Aluno",
    name = "Aluno DS",
    avatarUrl = null,
    age = 17,
    score = 80,
    turma = "3° AMS",
    registerDate = "28/03/2025",
    email = "aluno@etec.sp.gov.br",
    bio = "Sou aluno/a de Desenvolvimento de Sistemas na ETEC Zona Leste que está criando um aplicativo com passagem de parâmetros no JetPackCompose."

)

val Maria = User(
    userId = "Maria Eduarda",
    name = "Maria Eduarda Monteiro Viana",
    avatarUrl = null,
    age = 18,
    score = 95,
    turma = "3° AMS",
    registerDate = "14/02/2007",
    email = "maria.viana57@etec.sp.gov.br",
    bio = "Sou aluna de Desenvolvimento de Sistemas na ETEC Zona Leste que está criando um aplicativo com passagem de parâmetros no JetPackCompose."

)

fun getUserData(userName: String): User {
    return if (userName == "Maria Eduarda") {
        Maria
    } else {
        userDefault
    }
}