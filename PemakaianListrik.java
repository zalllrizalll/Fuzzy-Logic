public class PemakaianListrik extends Fuzzy{
    float luasRumah, tegangan, perabotan;
    static float rendah = 0, sedang = 0, tinggi = 0;

    public PemakaianListrik(){}

    public PemakaianListrik(float luasRumah, float tegangan, float perabotan){
        this.luasRumah = luasRumah;
        this.tegangan = tegangan;
        this.perabotan = perabotan;
    }

    public static void rules(float x, float y, String label){
        switch(label){
            case "rendah" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= rendah){
                    rendah = temp;
                }
                break;
            }
            case "sedang" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= sedang){
                    sedang = temp;
                }
                break;
            }
            case "tinggi" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= tinggi){
                    tinggi = temp;
                }
                break;
            }
        }
    }
    // Overloading
    public static void rules(float x, float y, float z, String label){
        switch(label){
            case "rendah" -> {
                if(x <= y && x <= z){
                    temp = x;
                } else if (y <= x && y <= z){
                    temp = y;
                } else {
                    temp = z;
                }
                // Kesimpulan Rules
                if(temp >= rendah){
                    rendah = temp;
                }
                break;
            }
            case "sedang" -> {
                if(x <= y && x <= z){
                    temp = x;
                } else if (y <= x && y <= z){
                    temp = y;
                } else {
                    temp = z;
                }
                // Kesimpulan Rules
                if(temp >= sedang){
                    sedang = temp;
                }
                break;
            }
            case "tinggi" -> {
                if(x <= y && x <= z){
                    temp = x;
                } else if (y <= x && y <= z){
                    temp = y;
                } else {
                    temp = z;
                }
                // Kesimpulan Rules
                if(temp >= tinggi){
                    tinggi = temp;
                }
                break;
            }
        }
    }
}
