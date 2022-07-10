import java.sql.Connection
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

// membuat koneksi dengan data base mySQL
object koneksi {
    // membuat variabel untuk pengecekan nanti
    var conect: Connection? = null
    //membuat fungsi bernama connection untuk konek ke database
    val connection: Connection?
        get() {
            // ketika di run pertama kali maka akan konek ke database karena conect masih null
            if (conect == null) {
                val data = MysqlDataSource()
                data.setDatabaseName("db_mahasiswa")
                data.setUser("root")
                data.setPassword("")
                try {
                    // disini variabel conect sudah tidak null lagi kecuali jika eror
                    conect = data.getConnection()
                    println("Berhasil Konek")
                } catch (e: Exception) {
                    println("Gagal Konek$e")
                }
            }
            // jadi ketika variabel conect sudah tidak null maka kita tidak perlu melakukan koneksi berualnf-ulang ke database
            return conect
        }

    @JvmStatic
    fun main(args: Array<String>) {
        //memanggil fungsi database
        connection
    }
}