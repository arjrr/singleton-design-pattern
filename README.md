## Singleton (_Design Pattern_)

Exemplo de implementação do padrão de projeto _Singleton_.

Linguagem: Kotlin

## Definição

Segundo Freeman e Freeman (2004):

"**O padrão Singleton:** Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela."

## Estratégia

Para possibilitar a criação de uma única instância de uma classe, a estratégia do padrão Singleton consiste,
inicialmente, em tornar o construtor da classe privado. Dessa forma, garantimos que a classe não pode ser instanciada.
Em seguida, criamos uma variável estática, cujo propósito é armazenar uma instância da classe, e fornecemos um método
estático para obtenção dessa variável (FREEMAN e FREEMAN, 2004).

## Implementação

**Singleton**

```kotlin
class Singleton private constructor() {

    companion object {
        private lateinit var singletonInstance: Singleton
        fun getInstance(): Singleton {
            if (!::singletonInstance.isInitialized) {
                singletonInstance = Singleton()
            }
            return singletonInstance
        }
    }

}
```

**Main**

```kotlin
fun main() {

    /** Creating object instances */
    val singletonObjectOne = Singleton.getInstance()
    val singletonObjectTwo = Singleton.getInstance()

    /** Showing objects addresses */
    println(singletonObjectOne.toString())
    println(singletonObjectTwo.toString())

}
```

## Inicialização lazy

No exemplo acima a variável `singletonInstance` é inicializada de forma lazy, ou seja, apenas quando o método
estático `getInstance()` é chamado.

## Object declarations

Em Kotlin o padrão Singleton pode ser criado facilmente por meio da palavra
reservada `object` ([Object declarations](https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview)). Exemplo:

**KotlinSingleton**

```kotlin
object KotlinSingleton {
}
```

**Main**

```kotlin
fun main() {

    /** Creating object instances */
    val singletonObjectOne = Singleton.getInstance()
    val singletonObjectTwo = Singleton.getInstance()

    /** Showing objects addresses */
    println(singletonObjectOne.toString())
    println(singletonObjectTwo.toString())

    /** [KotlinSingleton] object instances */
    val kotlinSingletonOne = KotlinSingleton
    val kotlinSingletonTwo = KotlinSingleton

    /** Showing objects addresses */
    println(kotlinSingletonOne.toString())
    println(kotlinSingletonTwo.toString())

}
```


