package LnT;

import java.util.Scanner;
import java.util.Vector;

import LnT.Admin;
import LnT.Main;
import LnT.superVisor;

import java.util.Random;

public class Main {
    private Scanner scanner;
    private Vector < Pegawai > pegawaiVector;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int CODE_LENGTH = 4;

    private int totalManager, totalSupervisor, totalAdmin;

    public Main() {
        scanner = new Scanner(System.in);
        pegawaiVector = new Vector < Pegawai > ();

        int nomor = 0;

        while (nomor != 5) {
            System.out.println("Pilih nomor menu dibawah:");
            System.out.println("1. Insert data karyawan");
            System.out.println("2. View data karyawan");
            System.out.println("3. Update data karyawan");
            System.out.println("4. Delete data karyawan");
            System.out.println("5. End");
            System.out.print("Nomor: ");

            try {
                nomor = scanner.nextInt();
                scanner.nextLine();

                switch (nomor) {
                case 1:
                    insertData();
                    break;
                case 2:
                    if (pegawaiVector.isEmpty()) {
                        System.out.println("Data karyawan tidak ada");
                        System.out.print("ENTER to return");
                        scanner.nextLine();
                    } else {
                        viewData();
                    }
                    break;
                case 3:
                    if (pegawaiVector.isEmpty()) {
                        System.out.println("Tidak ada data yang bisa diupdate");
                        System.out.print("ENTER to return");
                        scanner.nextLine();
                    } else {
                        updateData();
                    }
                    break;
                case 4:
                    if (pegawaiVector.isEmpty()) {
                        System.out.println("Tidak ada data yang bisa dihapus");
                        System.out.print("ENTER to return");
                        scanner.nextLine();
                    } else {
                        deleteData();
                    }
                    break;
                case 5:
                    System.out.println("==========Terima kasih===========");
                    break;
                default:
                    System.out.println("Tolong masukkan nomor yang benar");
                    System.out.print("ENTER to return");
                    scanner.nextLine();
                    break;
                }
            } catch (Exception e) {
                nomor = -1;
                scanner.nextLine();
                System.out.println("Tolong masukkan nomor yang benar");
                System.out.print("ENTER to return");
                scanner.nextLine();
            }
        }
    }

    private void insertData() {
        System.out.println("Input data karyawan");

        String code = "";
        String name = "";
        String gender = "";
        String role = "";
        double income = 0;

        while (name.length() < 3) {
            System.out.print("Input nama karyawan [>= 3]: ");
            name = scanner.nextLine();
            if (name.length() < 3) {
                System.out.println("==Nama karyawan minimal 3 huruf==");
            }
        }

        while (!gender.equalsIgnoreCase("L") && !gender.equalsIgnoreCase("P")) {
            System.out.print("Input jenis kelamin [L/P]: ");
            gender = scanner.nextLine();
            if (!gender.equalsIgnoreCase("L") && !gender.equalsIgnoreCase("P")) {
                System.out.println("==Jenis kelamin hanya bisa diisi L atau P==");
            }
        }

        while (!role.equalsIgnoreCase("Manager") && !role.equalsIgnoreCase("Supervisor") && !role.equalsIgnoreCase("Admin")) {
            System.out.print("Input role [Manager/Supervisor/Admin]: ");
            role = scanner.nextLine();
            if (!role.equalsIgnoreCase("Manager") && !role.equalsIgnoreCase("Supervisor") && !role.equalsIgnoreCase("Admin")) {
                System.out.println("==Role hanya bisa diisi Manager, Supervisor, atau Admin==");
            }
        }

        if (role.equalsIgnoreCase("Manager")) {
            jumlahManager++;
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            sb.append("-");
            for (int j = 0; j < CODE_LENGTH; j++) {
                sb.append(random.nextInt(10));
            }
            code = sb.toString();

            income = 8000000;

            if (jumlahManager % 3 == 0) {
                double bonus = 0.075 * income;
                income += bonus;

                System.out.println("Bonus sebesar 7.5% telah diberikan pada " + 3 * (jumlahManager / 3) + " karyawan Manager dengan id ");
                for (int z = 0; z < 3 * (jumlahManager / 3); z++) {
                    String temp = pegawaiVector.get(z).getKodeKaryawan();
                    System.out.print(temp + " ");
                }
                System.out.println();
            }

            Manager m = new Manager(code, name, gender, role, income);
            pegawaiVector.add(m);
            System.out.println("Berhasil menambahkan karyawan dengan id " + code);
            System.out.print("ENTER to return");
            scanner.nextLine();
        } else if (role.equalsIgnoreCase("Supervisor")) {
            jumlahSupervisor++;
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            sb.append("-");
            for (int j = 0; j < CODE_LENGTH; j++) {
                sb.append(random.nextInt(10));
            }
            code = sb.toString();

            income = 6000000;

            if (jumlahSupervisor % 3 == 0) {
                double bonus = 0.075 * income;
                income += bonus;

                System.out.println("Bonus sebesar 7.5% telah diberikan pada " + 3 * (jumlahSupervisor / 3) + " karyawan Supervisor dengan id ");
                for (int z = 0; z < (3 * (jumlahSupervisor / 3)); z++) {
                    String temp = pegawae.get(z).getKodeKaryawan();
                    System.out.print(temp + " ");
                }
                System.out.println();
            }
            superVisor s = new superVisor(code, name, gender, role, income);
            pegawae.add(s);
        } else if (role.equals("Admin")) {
            jumlahAdmin++;
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            sb.append("-");
            for (int j = 0; j < LENGTH; j++) {
                sb.append(random.nextInt(10));
            }
            code = sb.toString();

            income = 4000000;

            int jumlahAdminSebelumnya = jumlahAdmin - 1;
            if ((int) jumlahAdminSebelumnya / 3 != 0) {
                double bonus = 0.05 * gaji;
                income += bonus;

                int indexAwal = jumlahAdminSebelumnya - (3 * (jumlahAdminSebelumnya / 3));
                System.out.print("Bonus sebesar 5% telah diberikan pada dengan id ");
                for (int z = indexAwal; z < jumlahAdminSebelumnya; z++) {
                    String temp = pegawae.get(z).getKodeKaryawan();
                    System.out.print(temp + " ");
                }
                System.out.println();
            }

            Admin a = new Admin(code, name, gender, role, income; pegawae.add(a);
            }
        }
    }
    public void viewData() {
        int nomor = 1;
        int codeMaxLength = 15;
        int nameMaxLength = 15;
        int genderMaxLength = 15;
        int roleMaxLength = 13;
        int incomeMaxLength = 7;

        Collections.sort(pegawai, new Comparator < Pegawai > () {
            @Override
            public int compare(Pegawai pegawai1, Pegawai pegawai2) {
                return pegawai1.getNamaKaryawan().compareTo(pegawai2.getNamaKaryawan());
            }
        });

        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("| No | Kode Karyawan  | Nama Karyawan  | Jenis Kelamin  |    Jabatan   |    Gaji   |");
        System.out.println("------------------------------------------------------------------------------------");
        for (Pegawai pegawai2: pegawai) {
            if (pegawai2 instanceof Manager) {
                Manager x = (Manager) pegawai2;
                System.out.printf("| %2d ", nomor++);
                System.out.print("| " + String.format("%1$-" + codeMaxLength + "s", x.getKodeKaryawan()));
                System.out.print("| " + String.format("%1$-" + nameMaxLength + "s", x.getNamaKaryawan()));
                System.out.print("| " + String.format("%1$-" + genderMaxLength + "s", x.getJenisKelamin()));
                System.out.print("| " + String.format("%1$-" + roleMaxLength + "s", x.getJabatan()));
                System.out.println("| " + String.format("%1$-" + incomeMaxLength + "s", x.getGaji()) + " |");
            } else if (pegawai2 instanceof Supervisor) {
                Supervisor x = (Supervisor) pegawai2;
                System.out.printf("| %2d ", nomor++);
                System.out.print("| " + String.format("%1$-" + codeMaxLength + "s", x.getKodeKaryawan()));
                System.out.print("| " + String.format("%1$-" + nameMaxLength + "s", x.getNamaKaryawan()));
                System.out.print("| " + String.format("%1$-" + genderMaxLength + "s", x.getJenisKelamin()));
                System.out.print("| " + String.format("%1$-" + roleMaxLength + "s", x.getJabatan()));
                System.out.println("| " + String.format("%1$-" + incomeMaxLength + "s", x.getGaji()) + " |");
            } else {
                Admin x = (Admin) pegawai2;
                System.out.printf("| %2d ", nomor++);
                System.out.print("| " + String.format("%1$-" + codeMaxLength + "s", x.getKodeKaryawan()));
                System.out.print("| " + String.format("%1$-" + nameMaxLength + "s", x.getNamaKaryawan()));
                System.out.print("| " + String.format("%1$-" + genderMaxLength + "s", x.getJenisKelamin()));
                System.out.print("| " + String.format("%1$-" + roleMaxLength + "s", x.getJabatan()));
                System.out.println("| " + String.format("%1$-" + incomeMaxLength + "s", x.getGaji()) + " |");
            }
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    public void deleteData() {
        viewData();
        int pilihan;
        do {
            System.out.print("Input nomor urutan karyawan yang ingin dihapus:");
            pilihan = scan.nextInt();
        } while (pilihan < 1 || pilihan > pegawai.size());

        String temp = pegawai.get(pilihan - 1).getKodeKaryawan();
        pegawai.remove(pilihan - 1);
        System.out.println("Karyawan dengan kode " + temp + " berhasil dihapus");
        System.out.print("ENTER to return");
        scan.nextLine();
    }
}

public static void main(String[] args) {
    new Main();
}
}