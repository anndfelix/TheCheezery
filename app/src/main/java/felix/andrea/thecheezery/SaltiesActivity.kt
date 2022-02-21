package felix.andrea.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class SaltiesActivity : AppCompatActivity() {

    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salties)
        agregaProductos()

        var listviewSalties: ListView = findViewById(R.id.listviewSalties) as ListView
        var adaptador: SaltiesActivity.AdaptadorProductos =
            SaltiesActivity.AdaptadorProductos(this, salties)
        listviewSalties.adapter = adaptador
    }

        fun agregaProductos(){

            salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6))
            salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5))
            salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4))
            salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6))
            salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7))

        }

        private class AdaptadorProductos: BaseAdapter {
            var productos: ArrayList<Product>
            var contexto: Context? = null

            constructor(contexto: Context, productos: ArrayList<Product>){
                this.contexto = contexto
                this.productos = productos
            }

            override fun getCount(): Int {
                return productos.size
            }

            override fun getItem(p0: Int): Any {
                return productos[p0]
            }

            override fun getItemId(p0: Int): Long {
                return p0.toLong()
            }

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                var prod = productos[p0]
                var inflador = LayoutInflater.from(contexto)
                var vista = inflador.inflate(R.layout.producto_view, null)

                var imagen = vista.findViewById(R.id.producto_img) as ImageView
                var nombre = vista.findViewById(R.id.producto_nombre) as TextView
                var descripcion = vista.findViewById(R.id.producto_desc) as TextView
                var precio = vista.findViewById(R.id.producto_precio) as TextView

                imagen.setImageResource(prod.image)
                nombre.setText(prod.name)
                descripcion.setText(prod.description)
                precio.setText("$${prod.price}")

                return vista
            }

        }


    }