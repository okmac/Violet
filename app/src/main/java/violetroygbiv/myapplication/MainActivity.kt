package violetroygbiv.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.PrintWriter

class MainActivity : AppCompatActivity() {
    private var savingsTracker: SavingsTracker = SavingsTracker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readCount()

        textView.text = "Total Savings: ${savingsTracker.savings}"
    }

    fun clearSavings(view: View) {
        savingsTracker.clearSavings()
        updateView()
    }

    fun updateSavings(view: View) {
        if(!editText.text.isNullOrBlank()) {
            var value = editText.text.toString().trim().toInt()
            savingsTracker.addToSavings(value)
            editText.text.clear()
            updateView()
        }
    }

    private fun updateView(){
        textView.text = "Total Savings: ${savingsTracker.savings}"
        persistCount()
    }

    private fun persistCount(){
        val path = filesDir
        val letDirectory = File(path, "savePersist")

        var success = true
        if (!letDirectory.exists()) {
            success = letDirectory.mkdirs()
        }
        if (success) {
            var persistFile = File(letDirectory, "count.txt");
            if(!persistFile.exists()){
                persistFile.createNewFile()
            }
            try {
                // response is the data written to file
                PrintWriter(persistFile).use { out -> out.println(savingsTracker.savings) }
            } catch (e: Exception) {
                // handle the exception
            }
        }
    }

    private fun readCount(){
        val path = filesDir

        val letDirectory = File(path, "savePersist")
        val file = File(letDirectory, "count.txt")
        if (file.exists()) {1
            try {
                // response is the data written to file
                var value = file.readText()
                savingsTracker.savings = value.trim().toInt()
            } catch (e: Exception) {
                // handle the exception
            }
        }
    }
}
