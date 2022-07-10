import javax.swing.*;

public class MainFrame {
    private JTextField ipk;
    private JTextField nama;
    private JTextField nim;
    private JTextField matkul;
    private JPanel panel;
    private JButton upload;
    private controllerMahasiswa control;

    public static void main(String[] args) {

    }

    public void mainframe(){

    }

    public JTextField getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.setText(nama);
    }

    public JTextField getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim.setText(nim);
    }

    public JTextField getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk.setText(ipk);
    }

    public JTextField getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul.setText(matkul);
    }

}
