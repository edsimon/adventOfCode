import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dec1 {

    final static String captcha2 = "51629928149116951271942527619459642429126871269715586365184693792592845695881362" + "442815621846833142385842261347196216575642383775685651975452498575976374755971125797736122835767829357" + "269883975444475289883531339981574856251995832992791186165478421635548931999556629749983629598594389937" + "361522337527123112891474527318449891524148839376167679991438526545998392374314655546517788649197996246" + "591888839666423369324398396941268256179962878956929437455457567736821972414253678964912175858299134553" + "763988885811376373851851118443985422338686876418913396454372194116978627478177565899132933175967994334" + "221757853264351961529642439648766945145372811311474821717782687495346643543612916529537915722634578675" + "689993574733678516174548793372152723939411872151719584918667681423288741317558732721414487689824857124" + "851712179676624881736661433391515479698361217428123784616512911498845318884474511979864331485787152775" + "783126529884683332786378134155938123845832278619237948745567156375712353425346356342171613864161191568" + "624734341712665531737863931416846134561342726278662468949848559994233681399572514516935594261667281279" + "217455686643615837593898873872125366477258457738455869647754623218931228726243945214156452232998713969" + "228198478351369185753833553755344891981954533212548312887892549233436156219262167299386847956668856475" + "222611178448661978958831817174599525364588683387266544724124532993564388389244752428664229695535424947" + "881511651731583217992549481874847816431766947165446486711192467696116216284123247347439473979396862497" + "439791649566723333739724193376551377724191635916699438492386974146817465335354114761664539391769458181" + "119397731198175255455149962921987339149342688388653621945584835442646156299528416232396177364458181563" + "377976263474533956519679872484772278166694862623163163214437187315487257561563632296535325464218689712" + "742335261887943149913841887235611662481873323244564918879331882974878934981329521867349729113416439573" + "966566725544336638329966997368952818826438637359142414978447369848731531667663716531797264891611675522" + "4598519934598889627918883283534261513179931798591959489372165295";

    final static String captcha = "51629928149116951271942527619459642429126871269715586365184693792592845695881362" + "442815621846833142385842261347196216575642383775685651975452498575976374755971125797736122835767829357" + "269883975444475289883531339981574856251995832992791186165478421635548931999556629749983629598594389937" + "361522337527123112891474527318449891524148839376167679991438526545998392374314655546517788649197996246" + "591888839666423369324398396941268256179962878956929437455457567736821972414253678964912175858299134553" + "763988885811376373851851118443985422338686876418913396454372194116978627478177565899132933175967994334" + "221757853264351961529642439648766945145372811311474821717782687495346643543612916529537915722634578675" + "689993574733678516174548793372152723939411872151719584918667681423288741317558732721414487689824857124" + "851712179676624881736661433391515479698361217428123784616512911498845318884474511979864331485787152775" + "783126529884683332786378134155938123845832278619237948745567156375712353425346356342171613864161191568" + "624734341712665531737863931416846134561342726278662468949848559994233681399572514516935594261667281279" + "217455686643615837593898873872125366477258457738455869647754623218931228726243945214156452232998713969" + "228198478351369185753833553755344891981954533212548312887892549233436156219262167299386847956668856475" + "222611178448661978958831817174599525364588683387266544724124532993564388389244752428664229695535424947" + "881511651731583217992549481874847816431766947165446486711192467696116216284123247347439473979396862497" + "439791649566723333739724193376551377724191635916699438492386974146817465335354114761664539391769458181" + "119397731198175255455149962921987339149342688388653621945584835442646156299528416232396177364458181563" + "377976263474533956519679872484772278166694862623163163214437187315487257561563632296535325464218689712" + "742335261887943149913841887235611662481873323244564918879331882974878934981329521867349729113416439573" + "966566725544336638329966997368952818826438637359142414978447369848731531667663716531797264891611675522" + "4598519934598889627918883283534261513179931798591959489372165295";

    final static String testCap1 = "5162992814911695";
    final static String testCap2 = "112233";
    final static String testCap3 = "1234";
    final static String testCap4 = "91212129";
    static File url;
    static String input;


    public static void main(String[] args) {
        // Jump with one index


        int sum = sumOfArray(toIntArray(captcha), 1);
        System.out.println(sum);

        // Jump with limit index
        System.out.println();
        int limit = captcha2.length() / 2;
        sum = sumOfArray(toIntArray(captcha2), limit);
        System.out.println(sum);

    }



    static int sumOfArray(int[] intArray, int from){
        int sum = 0;
        for (int i = 0; i < intArray.length; i++){
            if(intArray[(i+from)%intArray.length]==intArray[i]){
                sum = sum + intArray[i%intArray.length];
            }
        }
        return sum;
    }

    static int[] toIntArray(String str){
        int[] intArray = new int[str.length()];
        String[] temp = str.split("");
        for (int i = 0; i < temp.length; i++){
            intArray[i] = Integer.parseInt(temp[i]);
        }
        return intArray;
    }
}
