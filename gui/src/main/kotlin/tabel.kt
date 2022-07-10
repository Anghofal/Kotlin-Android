
import javax.swing.table.AbstractTableModel

//membuat sebuah tabel abstrak menggunakan librari java berdasarkan list mahasiswa
class tabelModelMahasiswa(list: List<mahasiswa>) : AbstractTableModel() {
    // membuat variabel untuk menampung data mahasiswa
    var list: List<mahasiswa>

    init {
        // sebuah konstruktor untuk mendapatkan list dari luar
        this.list = list
    }


    override fun getRowCount(): Int {
        return list.size
    }


    override fun getColumnName(column: Int): String {
        val header = arrayOf("NAMA", "NIM", "IPK", "MATKUL")
        return header[column]
    }

    override fun getColumnCount(): Int {
        return 4
    }

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any? {
        return when (columnIndex) {
            0 -> list[rowIndex].nama
            1 -> list[rowIndex].nim
            2 -> list[rowIndex].ipk
            3 -> list[rowIndex].matkul
            else -> null
        }
    }
}