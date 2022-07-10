import java.sql.*

// class ini berfungsi perintah-perintah sql untuk mengedit database
    class sqlQuery {
    companion object {
        //membuat variabel connection yang nantinya digunakan untuk memanggil fungsi connection dari class koneksi
        var connection: Connection?

        //memasukkan masing-masing perintah mysql ke variabel yang berbeda
        val queryMysql = "select * from mahasiswa"
        val queryInsert = "insert into mahasiswa (nik,nama,umur,alamat) values(?,?,?,?)"
        val queryUpdate = "update mahasiswa set nik=?,nama,=?,umur=?,alamat=? where nik=?"
        val queryDelete = "delete from mahasiswa where nik=?"

        init {
            // memanggil fungsi connection dari class koneksi
            connection = koneksi.connection
        }


        // membuat fungsi insert database
        fun insert(m: mahasiswa) {
            // membuat fungsi bernama statement yang berfungsi untuk konek ke database dan menjalankan perintah mysql
            var statement: PreparedStatement = connection!!.prepareStatement(queryInsert)
            try {
                // melakukan proses bind ke perintah mysql kita sesuai dengan item di list mahasiswa
                statement.setString(1, m.nama)
                statement.setString(2, m.nim)
                statement.setString(3, m.ipk.toString())
                statement.setString(4, m.matkul)
                // melakukan proses execute ke perintah my sql kita
                statement.executeUpdate()
                println(" Berhasil Input")
                // jika gagal print eror nya ke terminal
            } catch (e: SQLException) {
                println("Gagal Menginputkan data $e")
            } finally {
                try {
                    //jika berhasil maka reset binding nya
                    statement!!.close()
                } catch (e: SQLException) {
                    println("Gagal Menginputkan data $e")
                }
            }
        }

        fun update(m: mahasiswa) {
            var statement: PreparedStatement = connection!!.prepareStatement(queryUpdate)
            try {
                statement.setString(1, m.nim)
                statement.setString(2, m.nama)
                statement.setString(3, m.nim)
                statement.setString(4, m.ipk.toString())
                statement.setString(5, m.matkul)
                statement.executeUpdate()
                println(" Berhasil Update")
            } catch (e: SQLException) {
                println("Gagal Mengupdate data $e")
            } finally {
                try {
                    statement!!.close()
                } catch (e: SQLException) {
                    println("Gagal Mengupdate data $e")
                }
            }
        }

        fun delete(m: String) {
            var statement: PreparedStatement = connection!!.prepareStatement(queryDelete)
            try {
                statement.setString(1, m)
                statement.executeUpdate()
                println(" Berhasil Di Delete")
            } catch (e: SQLException) {
                println("Gagal men delete data $e")
            } finally {
                try {
                    statement!!.close()
                } catch (e: SQLException) {
                    println("Gagal men delete data $e")
                }
            }
        }


        val getAll: List<mahasiswa>
            get() {
                var list: List<mahasiswa>? = null
                try {
                    list = ArrayList()
                    // membuat fungsi bernama statement yang berfungsi untuk konek ke database dan menjalankan perintah mysql
                    val statement: Statement = connection!!.createStatement()
                    // sebuah fungsi yang berguna untuk menyesuaikan select mysql dengan item di array list
                    val resultSet: ResultSet = statement.executeQuery(queryMysql)
                    while (resultSet.next()) {
                        val Mahasiswa = mahasiswa()
                        Mahasiswa.nama = resultSet.getString("nama")
                        Mahasiswa.nim = resultSet.getString("nim")
                        Mahasiswa.ipk = resultSet.getInt("ipk")
                        Mahasiswa.matkul = resultSet.getString("matkul")
                        list.add(Mahasiswa)
                    }
                } catch (e: SQLException) {
                    println("Eror memasukkan array list $e")
                }
                return list!!
            }

    }
}