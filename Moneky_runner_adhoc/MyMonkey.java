import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Random;

public class MyMonkey {


    public static final String ADB_ROOT = "C:/Users/forerogo/AppData/Local/Android/sdk/platform-tools/";
    public static final String ADB_INPUT = ADB_ROOT + "adb shell input ";
    public static final String TELNET_TOKEN = "6IsoDAHPLT//j/ZV";
    public static final String EMULATOR_PORT = "5554";

    private static BufferedWriter connectToTelnet() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process telnet = rt.exec("telnet localhost "+EMULATOR_PORT);
        return new BufferedWriter(new OutputStreamWriter(telnet.getOutputStream()));
    }

    public static void rotate() throws IOException {
        BufferedWriter out = connectToTelnet();
        out.write("auth "+TELNET_TOKEN+"\n");
        out.write("rotate\n");
        out.write("quit\n");
        out.flush();
    }

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        try {
            Random random = new Random(12345);

            int i = 0;
            int finalRange = 10;
            if(args.length > 0){
                try {  
                    finalRange = Integer.parseInt(args[0]);  
                } catch (NumberFormatException e) {  
                    throw e;
                }  
            }
            while(i < finalRange) {
                int funcToRun = random.nextInt(3);
                System.out.println(functionsToRun.funcToRun);
                switch(functionsToRun.funcToRun){
                    case tap:
                        int x = random.nextInt(1080);
                        int y = random.nextInt(1920);

                        rt.exec(ADB_INPUT + "tap " + x + " " + y);
                        i++;
                        Thread.sleep(1000);
                    break;
                    case text:
                        rt.exec(ADB_INPUT + "text " + " 'Paris' ");
                        i++;
                        Thread.sleep(1000);
                    break;
                    case swipe:
                        int x0 = random.nextInt(1080);
                        int y0 = random.nextInt(1920);
                        
                        int x1 = random.nextInt(1080);
                        int y1 = random.nextInt(1920);
                        
                        rt.exec(ADB_INPUT + "swipe " + x0 + " " + y0 + " " + x1 + " " + y1);
                        i++;
                        Thread.sleep(1000);
                    break;
                    case rotate:
                        int randDegrees = random.nextInt(3);
                        Main.rotate();
                    break;
                }
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum functionsToRun{
        tap, text, swipe, rotate, keyevent, rotate, network speed, sensor set
    }

    public enum connectionType{
        gsm, hscsd, gprs, edge, umts, hsdpa,, lte, evdo, full
    }

    public enum rotateDegrees{
        90, 180, 270
    }
}