public class Nasabah {
    public String nama;
    public String noRek;
    public int saldo;

    public Nasabah(String nama, String noRek, int saldo) {
        this.nama = nama;
        this.noRek = noRek;
        this.saldo = saldo;
    }

    public boolean saldoCukup(int jumlahUang) {
        if (jumlahUang < this.saldo) {
            return true;
        }
        System.out.println("Saldo tidak cukup.");
        return false;
    }

    public boolean tarikUang(int jumlahUang) {
        if (saldoCukup(jumlahUang)) {
            this.saldo -= jumlahUang;
            return true;
        }
        return false;
    }

    public void simpanUang(int jumlahUang) {
        this.saldo += jumlahUang;
    }


    
}
