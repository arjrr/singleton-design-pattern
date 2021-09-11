## Decorator (_Design Pattern_)
Exemplo de implementação do padrão de projeto _Singleton_.

Linguagem: Kotlin

## Definição

Segundo Freeman e Freeman (2004):

"**O padrão Decorator:** Anexa responsabilidades adicionais a um objeto dinamicamente. Os decoradores fornecem uma alternativa flexível de subclasse para estender a funcionalidade."

"...padrão de projeto estrutural que permite que você acople novos comportamentos para objetos ao colocá-los dentro de invólucros de objetos que contém os comportamentos." (REFACTORINGGURU, 2021)

<img width="600" alt="Screen Shot 2021-04-16 at 16 15 41" src="https://user-images.githubusercontent.com/5003410/126981567-17621016-1199-410f-9f8c-4be15b0a6a34.png">
<sup>Fonte: https://refactoring.guru/pt-br/design-patterns/decorator</sup>

## O princípio Aberto-Fechado

O princípio de projeto Aberto-Fechado, ou Open-Closed, diz que "As classes devem estar abertas para extensão, mas fechadas para modificação". Este é o princípio "O" do SOLID (popularizado por Robert C. Martin).

De acordo com Freeman e Freeman (2004): "Nosso objetivo é permitir que as classes sejam facilmente estendidas para incorporar um novo comportamento sem modificar o código existente. O que conseguimos se fizermos isso? Projetos que são resistentes a mudanças e suficientemente flexíveis para assumir novos recursos para atender aos requisitos que mudam".

## Decorator na prática

Como podemos descrever o padrão Decorator na prática:

> "Os decoradores têm o mesmo supertipo que os objetos que eles decoram"

> "Você pode usar um ou mais decoradores para englobar um objeto"

> "Uma vez que o decorador tem o mesmo supertipo que o objeto decorado, podemos passar um objeto decorado no lugar do objeto original (englobado)"

> "O decorador adiciona seu próprio comportamento antes e/ou depois de delegar para o objeto que ele decora o resto do trabalho"

> "Os objetos podem ser decorados a qualquer momento, então podemos decorar os objetos de maneira dinâmica no tempo de execução com quantos decoradores desejarmos"

## Implementação

Inserindo condimentos em uma bebida dinamicamente:

**Beverage (Component)**

```kotlin
abstract class Beverage {
    open var description: String = "Unknown Beverage"
    abstract fun cost(): Double
}
```

**CondimentDecorator (Decorator)**

```kotlin
abstract class CondimentDecorator : Beverage() {
    abstract override var description: String
}
```

**EspressoCoffee (Concrete Component)**

```kotlin
class EspressoCoffee : Beverage() {
    init {
        description = "Espresso Coffee"
    }

    override fun cost(): Double {
        return 2.50
    }
}
```

**Whip (Concrete Decorator)**

```kotlin
class Whip(
    private val beverage: Beverage
) : CondimentDecorator() {

    override var description: String
        get() = beverage.description + " + Whip"
        set(value) {}

    override fun cost(): Double {
        return .25 + beverage.cost()
    }

}
```

**Main**

```kotlin
fun main() {

    /** Creating a coffee (Concrete Component) */
    var beverage: Beverage
    beverage = EspressoCoffee()

    /** Decorating the coffee with condiment (Decorator) */
    beverage = Whip(beverage)
    beverage = Whip(beverage)
    beverage = Whip(beverage)

    /** Showing beverage with condiment */
    println("Beverage: ${beverage.description} \nCost: ${beverage.cost()}")

}
```
