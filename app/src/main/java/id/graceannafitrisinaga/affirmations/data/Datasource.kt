//nama paket data dalam projek affirmations
package id.graceannafitrisinaga.affirmations.data

//mengimport Resource yang ada di file strings.xml untuk menampilkan teks afirmasi pada projek affirmations di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.affirmations.R
//mengimport model affirmations agar teks yang ada dalam Affirmation dapat digunakan pada projek affirmations di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.affirmations.model.Affirmation

// Datasource sebagai nama class
class Datasource {
    // Fungsi loadAffirmations() untuk menampilkan daftar Affirmations dan mengisinya dengan instance Affirmation untuk setiap string resource.
    // List<Affirmation> sebagai jenis nilai yang ditampilkan fungsi loadAffirmations()
    fun loadAffirmations(): List<Affirmation> {
        //Lalu digunakan perintah return untuk memanggil listOf<Affirmation>() untuk membuat List item afirmasi sebagai Affirmation
        return listOf<Affirmation>(
            //Affirmation yang dibuat ini akan meneruskan R.string.affirmation1 - R.string.affirmation10 sebagai ID resource textview
            //dan meneruskan R.drawable.image1 - R.drawable.image10 sebagai ID resource imageview yang digunakan dalam projek ini.
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }
}