package felix.andrea.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold : Button = findViewById(R.id.cold_drinks) as Button
        var btnSweets: Button = findViewById(R.id.sweets) as Button
        var btnSalties: Button = findViewById(R.id.salties) as Button
        var btnHotDrinks: Button = findViewById(R.id.hot_driks) as Button

        btnCold.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this, SweetsActivity::class.java)
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, SaltiesActivity::class.java)
            startActivity(intent)
        }

        btnHotDrinks.setOnClickListener {
            var intent: Intent = Intent(this, HotDrinksActivity::class.java)
            startActivity(intent)
        }

    }
}