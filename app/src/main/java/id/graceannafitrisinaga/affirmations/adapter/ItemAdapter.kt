// nama paket adapter dalam projek affirmations
package id.graceannafitrisinaga.affirmations.adapter

// mengimport content dari jenis Context agar dapat menggunakan instance objek Context
import android.content.Context
// mengimport view layout inflater agar dapat menginstance LayoutInflater
import android.view.LayoutInflater
// mengimport komponen view seperti TextView dan ImageView dari jenis View
import android.view.View
// mengimport komponen viewGroup seperti LinearLayout dan ScrollView yang digunakan dari jenis View
import android.view.ViewGroup
//Mengimport widget ImageView untuk memanggil dan menampilkan Widget yang menggunakan ImageView dengan menampilkan gambar tersebut.
import android.widget.ImageView
//Mengimport widget TextView untuk memanggil dan menampilkan Widget yang menggunakan TextView dengan menampilkan teks dalam daftar afirmasi.
import android.widget.TextView
//Mengimport widget RecycleView untuk memanggil dan menampilkan Widget yang menggunakan RecyclerView agar tampilan layar daftar afirmasi dapat di scroll.
import androidx.recyclerview.widget.RecyclerView
//mengimport Resource yang ada di file strings.xml untuk menampilkan teks afirmasi di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.affirmations.R
//mengimport model affirmations agar teks yang ada dalam Affirmation dapat digunakan pada projek affirmations di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.affirmations.model.Affirmation

/** TODO 1 : Menambahkan parameter ke konstruktor ItemAdapter untuk meneruskan daftar afirmasi ke adaptor
 * Adapter for the [RecyclerView] in ['MainActivity']. Displays [Affirmation] data object.
 */
// nama class ItemAdapter sesuai dengan nama file
class ItemAdapter(
    //Menggunakan parameter val yaitu context dari jenis Context karena ItemAdapter memerlukan informasi tentang cara menyelesaikan resource string.
    //Informasi tersebut disimpan dalam instance objek Context yang dapat diteruskan ke instance ItemAdapter.
    private val context: Context,
    //Menggunakan parameter val yaitu dataset jenis List<Affirmation> dengan hak akses private karena dataset hanya akan digunakan dalam class ini.
    private val dataset: List<Affirmation>
    //Memperluas ItemAdapter dari class abstrak RecyclerView.Adapter.
    //ItemAdapter.ItemViewHolder sebagai jenis holder tampilan.
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //class bertingkat dengan nama class ItemViewHolder
    //Dalam parameter class ini, ditambahkan val view dengan hak akses private dari jenis View sebagai parameter ke konstruktor subclass ItemViewHolder dari RecyclerView.
    //Kemudian ViewHolder akan meneruskan parameter view ke dalam konstruktor superclass dari RecyclerView.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //properti textView dalam val yang bernama TextView untuk menampilkan tampilan resource dengan ID item_title yang ada dalam file list_item.xml
        val textView: TextView = view.findViewById(R.id.item_title)
        //properti imageView dalam val yang bernama ImageView untuk menampilkan tampilan resource dengan ID item_image yang ada dalam file list_item.xml
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /** TODO 2 : Mengimplementasikan onCreateViewHolder() oleh pengelola tata letak untuk membuat holder tampilan baru untuk RecyclerView
     * Create new views (invoked by the layout manager)
     */
    //method onCreateViewHolder() menggunakan Parameter parent sebagai kelompok tampilan tempat ditampilkannya item daftar baru sebagai turunan,
    //dan menggunakan parameter viewType untuk menampilkan jenis tampilan item dalam RecyclerView yang sama.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        //Mendapatkan instance LayoutInflater dari konteks parent) agar inflater tata letak mengetahui cara meng-inflate tata letak XML menjadi hierarki objek tampilan.
        val adapterLayout = LayoutInflater.from(parent.context)
                //Meng-inflate tampilan item daftar untuk meneruskan ID resource tata letak XML R.layout.list_item dan kelompok tampilan parent.
            //Argumen boolean ketiga adalah attachToRoot false, karena RecyclerView menambahkan item ini ke hierarki tampilan saat waktu tersebut.
            .inflate(R.layout.list_item, parent, false)

        //Menampilkan instance ItemViewHolder baru yang tampilan root-nya adalah adapterLayout dalam onCreateViewHolder(),
        return ItemViewHolder(adapterLayout)
    }

    /**TODO 3 : Mengimplementasikan onBindViewHolder() untuk mengganti isi tampilan item daftar ketika dilakukan scroll
     * Replace the contents of a view (invoked by the layout manager)
     */
    //Metode onBindViewHolder() dipanggil oleh pengelola tata letak untuk mengganti isi tampilan item daftar.
    //Method ini akan menemukan objek Affirmation yang tepat dari set dataItemViewHolder berdasarkan posisi.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //val item untuk mendapatkan item pada position yang ditentukan dalam dataset onBindViewHolder(),
        val item = dataset[position]
        //menemukan ID resource string dalam instance objek Affirmation dengan memanggil item.stringResourceId.
        //memanggil context.resources.getString() dan memasukkan ID resource string agar dapat memperbarui holder tampilan untuk menampilkan string afirmasi.
        holder.textView.text =  context.resources.getString(item.stringResourceId)
        //memanggil setImageResource() dan memasukkan ID resource image agar dapat memperbarui holder tampilan untuk menampilkan image/gambar item afirmasi.
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**TODO 4 : Mengimplementasikan metode getItemCount()
     * Return the size of your dataset (invoked by the layout manager)
     */
    //Metode getItemCount() akan menampilkan ukuran set data. Dimana data tersebut berada di properti dataset yang diberikan ke
    //konstruktor ItemAdapter, dan mendapatkan ukurannya dengan fungsi size.
    override fun getItemCount(): Int {
        return dataset.size
    }
}