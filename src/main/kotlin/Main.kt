fun main() {

    /** Creating object instances */
    val singletonObjectOne = Singleton.getInstance()
    val singletonObjectTwo = Singleton.getInstance()

    /** Showing objects addresses */
    println(singletonObjectOne.toString())
    println(singletonObjectTwo.toString())

}