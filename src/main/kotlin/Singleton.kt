class Singleton private constructor() {

    companion object {
        private var singletonInstance: Singleton? = null
        fun getInstance(): Singleton? {
            if (singletonInstance == null) {
                singletonInstance = Singleton()
            }
            return singletonInstance
        }
    }

}