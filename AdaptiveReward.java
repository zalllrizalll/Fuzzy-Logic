public class AdaptiveReward extends Fuzzy{
    float eksplorasiLevel, eksplorasiTime;
    static float poor = 0, average = 0, awesome = 0;

    public AdaptiveReward(){}

    public AdaptiveReward(float eksplorasiLevel, float eksplorasiTime){
        this.eksplorasiLevel = eksplorasiLevel;
        this.eksplorasiTime = eksplorasiTime;
    }

    public static void rules(float x, float y,  String label){
        switch(label){
            case "poor" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= poor){
                    poor = temp;
                }
                break;
            }
            case "average" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= average){
                    average = temp;
                }
                break;
            }
            case "awesome" -> {
                if(x <= y){
                    temp = x;
                } else{
                    temp = y;
                }
                // Kesimpulan Rules
                if(temp >= awesome){
                    awesome = temp;
                }
                break;
            }
        }
    }
}
