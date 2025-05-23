public class Pelanggan {
    private String nama, tAwal, tAkhir, noKursi, kode;
    private int harga, index, index2, jmlTiket, nik, noHP;

    public String[] list = new String[]{"WILANGAN", "NGAWI", "GENDINGAN", "SOLO", "KARTOSURO", "JOGJA", "MAGELANG"};

    public Pelanggan() {}

    public void setNama(String nama) {this.nama = nama;}
    public void setHarga(int harga) {this.harga = harga;}


    public int getHarga(String tAwal, String tAkhir){
        int[][] hargabis = {
                {0, 35000, 45000, 55000, 60000, 70000, 80000}, //Wilangan
                {0, 0,     25000, 30000, 40000, 45000, 60000}, //Ngawi
                {0, 0,     0,     25000, 35000, 40000, 55000}, //Gendingan
                {0, 0,     0,     0,     15000, 15000, 30000}, //Solo
                {0, 0,     0,     0,     0,     15000, 30000}, //Kartosuro
                {0, 0,     0,     0,     0,     0,     15000}, //Jogja
                {0, 0,     0,     0,     0,     0,     0    }  //Magelang
        };

        int index = -1;
        int index2 = -1;

        // Convert to uppercase to match with list
        String fromCity = tAwal.toUpperCase();
        String toCity = tAkhir.toUpperCase();

        // Find the indices
        for (int i = 0; i < list.length; i++) {
            if (fromCity.equals(list[i])) {
                index = i;
            }
            if (toCity.equals(list[i])) {
                index2 = i;
            }
        }

        // Handle errors
        if (index == -1 || index2 == -1) {
            throw new IllegalArgumentException("City not found in list");
        }

        // Check for invalid route (trying to go backwards)
        if (index > index2) {
            return 0; // Or display an error message that this route isn't available
        }

        harga = hargabis[index][index2];
        return harga;

    }

    public String checkRoute(String tAwal, String tAkhir){
        String fromCity = tAwal.toUpperCase();
        String toCity = tAkhir.toUpperCase();
        String s = "";

        for (int i = 0; i < list.length; i++) {
            if (fromCity.equals(list[i])) {
                index = i;
            }
            if (toCity.equals(list[i])) {
                index2 = i;
            }
        }

        if(index2 < index){
            s =  "Titik tujuan tidak boleh mendahului titik keberangkatan";
        }
        else if(index2 == index){
            s =  "Titik keberangkatan tidak boleh sama dengan titik tujuan";
        }
        else {s = " ";}

        return s;
    }
}