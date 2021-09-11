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