public class BowlingGame {

    private String StandardizedString(String str){
        String result="";
        String result1="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='|'){
                if(str.charAt(i)=='X'){
                    result+="X0";
                }
                else{
                    result+=str.charAt(i);
                }
            }
        }
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)=='-'){
                result1+="0";
            }
            else if(result.charAt(i)=='/'){
                result1+=String.valueOf(10-Integer.parseInt(String.valueOf(result.charAt(i-1))));
            }
            else {
                result1+=String.valueOf(result.charAt(i));
            }
        }
        return result1;
    }

    private int countScore(String str,int i){
        int result=0;
        if(str.charAt(i)=='X'){
            result+=10;
            if(str.charAt(i+2)=='X'){
                result+=10;
                if(str.charAt(i+4)=='X'){
                    result+=10;
                }
                else{
                    result+=Integer.parseInt(String.valueOf(str.charAt(i+4)));
                }
            }
            else{
                result=result+Integer.parseInt(String.valueOf(str.charAt(i+2)))+Integer.parseInt(String.valueOf(str.charAt(i+3)));;
            }
        }
        else{
            result=result+Integer.parseInt(String.valueOf(str.charAt(i)))+Integer.parseInt(String.valueOf(str.charAt(i+1)));
            if(result==10){
                result+=Integer.parseInt(String.valueOf(str.charAt(i+2)));
            }
        }
        if(i==9){
            if(20<str.length()){
                if(str.charAt(20)=='X'){
                    result+=10;
                }
                else{
                    result+=Integer.parseInt(String.valueOf(str.charAt(20)));
                }
            }
            if(21<str.length()){
                if(str.charAt(21)=='X'){
                    result+=10;
                }
                else{
                    result+=Integer.parseInt(String.valueOf(str.charAt(21)));
                }
            }
        }
        return result;
    }

    private int dealWtihString(String str){
        str=StandardizedString(str);
        int result=0;
        for(int i=0;i<10;i++){
           result+=countScore(str,2*i);
        }
        return result;
    }

    public int getBowlingScore(String bowlingCode) {
        return return dealWtihString(bowlingCode);
    }
}
