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