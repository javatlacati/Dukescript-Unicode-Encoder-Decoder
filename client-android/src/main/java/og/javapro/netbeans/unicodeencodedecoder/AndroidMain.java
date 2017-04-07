package og.javapro.netbeans.unicodeencodedecoder;

import android.app.Activity;
import android.content.SharedPreferences;
import og.javapro.netbeans.unicodeencodedecoder.js.PlatformServices;

public class AndroidMain extends Activity {
    private AndroidMain() {
    }

    public static void main(android.content.Context context) throws Exception {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(AndroidMain.class.getPackage().getName(), 0);
        DataModel.onPageLoad(new AndroidServices(prefs));
    }

    private static final class AndroidServices extends PlatformServices {
        private final SharedPreferences prefs;

        AndroidServices(SharedPreferences prefs) {
            this.prefs = prefs;
        }
    }
}
