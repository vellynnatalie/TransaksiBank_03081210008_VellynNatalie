import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int pilihan = 0;
        String mengulang = "y";

        ArrayList<Nasabah> semuaNasabah = new ArrayList<Nasabah>();
        semuaNasabah.add(new Nasabah("Susi", "0213456", 400000));
        semuaNasabah.add(new Nasabah("Budi", "0314865", 100000));

        ArrayList<String> mutasi = new ArrayList<String>();

        do {
            bersihkanLayar();
            pilihan = menu(keyboard);
            bersihkanLayar();
            if (pilihan == 1) {
                boolean adaNasabah = false;
                System.out.print("Masukkan no. rekening = ");
                String noRekMasuk = keyboard.next();
                for (Nasabah nasabah : semuaNasabah) {
                    if (nasabah.noRek.equalsIgnoreCase(noRekMasuk)) {
                        adaNasabah = true;
                        System.out.print("Jumlah nominal yang akan ditarik = ");
                        int jumlahUang = keyboard.nextInt();
                                
                        if (nasabah.tarikUang(jumlahUang)) {
                            System.out.print("Masukkan nomor rekening yang dituju = ");
                            String noRekTujuan= keyboard.next();
                            mutasi.add("Transaksi sebesar Rp " + jumlahUang + " ke no rekening " + noRekTujuan + " berhasil.");
                            System.out.println("Saldo Anda sekarang = Rp " + nasabah.saldo);
                                    
                            for (Nasabah nasabahTujuan : semuaNasabah) {
                                nasabahTujuan.simpanUang(jumlahUang);
                                System.out.println("Transaksi berhasil");
                            }      
                        }
                        break;
                    }
                    if (!adaNasabah) {
                        System.out.println("Nasabah tidak ditemukan.");
                    }
                }
            }
                        

            else if (pilihan == 2) {
                bersihkanLayar();
                System.out.println("==============================");
                System.out.println("Mutasi");
                System.out.println("==============================");
                for (String mtsi : mutasi) {
                    System.out.println(mtsi);   
                }
            }

            else if (pilihan == 3) {
                System.out.println("Sampai Jumpa");
                break;
            }

            else {
                System.out.println("Maaf, pilihan tidak dapat dipilih.");
            }

                
            System.out.print("Apakah ingin kembali ke menu [y/n] = ");
            mengulang = keyboard.next();
            bersihkanLayar();
        } while (mengulang.equalsIgnoreCase("y"));
    }

    public static void bersihkanLayar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int menu(Scanner keyboard) {
        int pilihan;
        System.out.println("==============================");
        System.out.println("Transfer Bank");
        System.out.println("==============================");
        System.out.println("1. Transfer");
        System.out.println("2. Cek Mutasi");
        System.out.println("3. Keluar");
        System.out.print("Masukkan pilihan (1-3) = ");
        pilihan = keyboard.nextInt();
        return pilihan;
    }
}
