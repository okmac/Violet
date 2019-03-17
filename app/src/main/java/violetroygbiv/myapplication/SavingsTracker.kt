package violetroygbiv.myapplication

class SavingsTracker {
    var savings: Int = 0

    fun addToSavings(value: Int) {
        savings += value
    }

    fun clearSavings(){
        savings = 0
    }
}