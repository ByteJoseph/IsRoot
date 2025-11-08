package app.ByteJoseph.isroot

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.scottyab.rootbeer.RootBeer
import java.util.Timer
import java.util.TimerTask
import androidx.activity.addCallback

class MainActivity : AppCompatActivity() {
    private lateinit var textview1: TextView
    private lateinit var timer: Timer
    private lateinit var progbar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rootBeer = RootBeer(this)
        textview1 = findViewById(R.id.textview1)
        progbar = findViewById(R.id.progressBar)

        timer = Timer()
        val timertask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    progbar.visibility = View.GONE
                if (rootBeer.isRooted) {
                    textview1.text =
                        "⚠️  Root Access Detected\nSome apps may not work correctly on rooted devices."
                } else {
                    textview1.text = "✅  Secure Device\nNo root access detected."
                }
                timer.cancel()
            }
        }
        }
        onBackPressedDispatcher.addCallback(this){
                finish()
        }
        timer.schedule(timertask,6000)
    }

}