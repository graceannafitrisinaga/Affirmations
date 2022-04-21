//nama paket dan nama projek
package id.graceannafitrisinaga.affirmations

//mengimport ActionBar/Toolbar dan Material Design untuk mendesign activity di Android Studio
import androidx.appcompat.app.AppCompatActivity
// mengimport os bundle untuk membaca data dengan berbagai tipe data
import android.os.Bundle
//Mengimport widget RecycleView untuk memanggil dan menampilkan Widget yang menggunakan RecyclerView agar tampilan layar daftar afirmasi dapat di scroll.
import androidx.recyclerview.widget.RecyclerView
//mengimport class ItemAdapter yang ada dalam adapter pada projek affirmations
import id.graceannafitrisinaga.affirmations.adapter.ItemAdapter
//mengimport class Datasource yang ada dalam data pada projek affirmations
import id.graceannafitrisinaga.affirmations.data.Datasource

// Class Activity yang mengextend AppCompatActivity
class MainActivity : AppCompatActivity() {
    // class MainActivity menyiapkan instance class binding dalam metode onCreate() agar dapat digunakan dengan suatu aktivitas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Memanggil metode loadAffirmations() yang ada dalam instance Datasource oleh val yang bernama myDataset dan menyimpan daftar afirmasi yang ditampilkan.
        val myDataset = Datasource().loadAffirmations()

        //Variabel recyclerView ini menggunakan findViewById() untuk menemukan referensi ke RecyclerView dalam tata letak.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //instance ItemAdapter baru dibuat untuk memberi tahu recyclerView agar menggunakan class ItemAdapter baru.
        //objek ItemAdapter dimasukan ke properti adapter dari recyclerView.
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // parameter setHasFixedSize dari RecyclerView adalah true karena ukuran tata letak RecyclerView tetap dalam tata letak aktivitas.
        // perubahan dalam isi tidak mengubah ukuran tata letak RecyclerView.
        recyclerView.setHasFixedSize(true)
    }
}