// nama paket model dalam projek affirmations
package id.graceannafitrisinaga.affirmations.model

//mengimport anotasi resource drawable
import androidx.annotation.DrawableRes
//mengimport anotasi resource string
import androidx.annotation.StringRes

//Class data Affirmations dengan satu properti yang ditentukan.
data class Affirmation(
    //menggunakan anotasi @StringRes pada variabel properti ID resource string untuk menambahkan dukungan teks di class Affirmation
    @StringRes val stringResourceId: Int,
    //menggunakan anotasi @DrawableRes pada variabel properti ID resource image untuk menambahkan dukungan gambar di class Affirmation
    @DrawableRes val imageResourceId: Int
) {

}