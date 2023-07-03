public class Beasiswa extends Fuzzy{
    float ipk, gajiOrtu;
    static float kurang = 0, lumayan = 0, layak = 0;

    public Beasiswa(){}

    public Beasiswa(float ipk, float gajiOrtu){
        this.ipk = ipk;
        this.gajiOrtu = gajiOrtu;
    }
    
    public static void rules(float x, float y, String label){
        switch(label){
            case "kurang" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= kurang){
                    kurang = temp;
                }
                break;
            }
            case "lumayan" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= lumayan){
                    lumayan = temp;
                }
                break;
            }
            case "layak" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= layak){
                    layak = temp;
                }
                break;
            }
        }
    }
}
