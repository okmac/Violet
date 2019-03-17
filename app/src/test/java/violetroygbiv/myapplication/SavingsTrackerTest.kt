package violetroygbiv.myapplication

import org.junit.Assert
import org.junit.Test

class SavingsTrackerTest {
    @Test
    fun addToSavings() {
        var tracker = SavingsTracker()
        Assert.assertEquals(0, tracker.savings)
        tracker.addToSavings(3)
        Assert.assertEquals(3, tracker.savings)
        tracker.addToSavings(4)
        Assert.assertEquals(7, tracker.savings)
    }

    @Test
    fun clearSavings() {
        var tracker = SavingsTracker()
        tracker.addToSavings(3)
        Assert.assertEquals(3, tracker.savings)
        tracker.clearSavings()
        Assert.assertEquals(0, tracker.savings)
    }
}