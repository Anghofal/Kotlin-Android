
import javax.swing.JOptionPane
import javax.swing.JTextField


class controllerMahasiswa(pendaftaran: MainFrame) {
    var pendaftaran: MainFrame
    var list: List<mahasiswa>

    init {
        this.pendaftaran = pendaftaran
        list = sqlQuery().getAll
    }

    /*fun isiTabel() {
        list = sqlQuery().getAll
        val tMahasiswa = tabelModelMahasiswa(list)
        pendaftaran.getTabel().setModel(tMahasiswa)
        pendaftaran.Theader()
    }*/

    fun insert() {
        if (!pendaftaran.getNim().toString().trim().isEmpty()) {
            val listmhs = mahasiswa()
            listmhs.nim = pendaftaran.getNim().toString()
            listmhs.nama = pendaftaran.getNama().toString()
            listmhs.ipk = pendaftaran.getIpk().toString().toFloat()
            listmhs.matkul = pendaftaran.getMatkul().toString()
            sqlQuery().insert(listmhs)
            JOptionPane.showMessageDialog(null, "Simpan Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun update() {
        if (!pendaftaran.getNim().toString().trim().isEmpty()) {
            val listmhs = mahasiswa()
            listmhs.nim = pendaftaran.getNim().toString()
            listmhs.nama = pendaftaran.getNama().toString()
            listmhs.ipk = pendaftaran.getIpk().toString().toFloat()
            listmhs.matkul = pendaftaran.getMatkul().toString()
            sqlQuery().update(listmhs)
            JOptionPane.showMessageDialog(null, "update Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun delete() {
        if (!pendaftaran.getNim().toString().trim().isEmpty()) {
            val Mahasiswa: String = pendaftaran.getNim().toString()
            sqlQuery().delete(Mahasiswa)
            JOptionPane.showMessageDialog(null, "Delete Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun isianForm(i: Int) {
        pendaftaran.setNim(list[i].nim)
        pendaftaran.setNama(list[i].nama)
        pendaftaran.setIpk(list[i].ipk.toString())
        pendaftaran.setMatkul(list[i].matkul)
    }

    fun hapus() {
        pendaftaran.setNim("")
        pendaftaran.setNama("")
        pendaftaran.setIpk("")
        pendaftaran.setMatkul("")
    }
}