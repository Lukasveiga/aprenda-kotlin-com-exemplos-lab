package desafio

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(private val nome: String, private val nivel: Nivel, private val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(emailJaCadastrado(usuario)) {
            return println("Email (${usuario.email}) já cadastrado")
        }

        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso!")
    }

    private fun emailJaCadastrado(usuario: Usuario): Boolean {
        return this.inscritos.any {it.email == usuario.email};
    }

    fun mostrarInfoFormacao() {
        val info = StringBuilder("Nome: $nome\nNível: $nivel\nNª Alunos Matriculados: ${this.inscritos.size}\nConteúdos Educacionais:\n")
        conteudos.forEach {c -> info.append("- ${c.nome}\n")}

        println(info.toString())
    }
}

fun main() {
    val usuario1 = Usuario("Usuario 1", "usuario1@email.com")
    val usuario2 = Usuario("Usuario 2", "usuario2@email.com")

    val listContEduc = mutableListOf(
        ConteudoEducacional("Cont 1"),
        ConteudoEducacional("Cont 2"),
        ConteudoEducacional("Cont 3")
    )

    val form = Formacao("Form 1", Nivel.BASICO, listContEduc)
    form.mostrarInfoFormacao()

    form.matricular(usuario1)
    form.matricular(usuario1)
    form.matricular(usuario2)

    form.mostrarInfoFormacao()
}
