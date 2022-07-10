
import javax.swing.JOptionPane


class guiHelper(maingui: mainGui) {
    var maingui: mainGui
    var list: List<mahasiswa>

    init {
        this.maingui = maingui
        list = sqlQuery.getAll
    }

    fun isiTabel() {
        list = sqlQuery.getAll
        val tMahasiswa = tabelModelMahasiswa(list)
        maingui.getTabel().setModel(tMahasiswa)
        maingui.Theader()
    }

    fun insert() {
        if (!maingui.nim.trim().isEmpty()) {
            val Mahasiswa = mahasiswa()
            Mahasiswa.setNik(maingui.getNIK())
            Mahasiswa.nama = maingui.getNama()
            Mahasiswa.setUmur(maingui.getUmur())
            Mahasiswa.setAlamat(maingui.getAlamat())
            sqlQuery.insert(Mahasiswa)
            JOptionPane.showMessageDialog(null, "Simpan Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun update() {
        if (!maingui.getNIK().trim().isEmpty()) {
            val Mahasiswa = mahasiswa()
            Mahasiswa.setNik(maingui.getNIK())
            Mahasiswa.nama = maingui.getNama()
            Mahasiswa.setUmur(maingui.getUmur())
            Mahasiswa.setAlamat(maingui.getAlamat())
            sqlQuery.update(Mahasiswa)
            JOptionPane.showMessageDialog(null, "update Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun delete() {
        if (!maingui.getNIK().trim().isEmpty()) {
            val Mahasiswa: String = maingui.getNIK()
            sqlQuery.delete(Mahasiswa)
            JOptionPane.showMessageDialog(null, "Delete Sukses")
        } else {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong")
        }
    }

    fun isianForm(i: Int) {
        maingui.setNIK(list[i].getNik())
        maingui.setNama(list[i].nama)
        maingui.setUmur(list[i].getUmur())
        maingui.setAlamat(list[i].getAlamat())
    }

    fun hapus() {
        maingui.setNIK("")
        maingui.setNama("")
        maingui.setUmur(0)
        maingui.setAlamat("")
    }
}