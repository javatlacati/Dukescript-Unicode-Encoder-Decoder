package og.javapro.netbeans.unicodeencodedecoder;

import og.javapro.netbeans.unicodeencodedecoder.js.PlatformServices;

public class BrowserMain {
    private BrowserMain() {
    }

    public static void main(String... args) throws Exception {
        Main.onPageLoad(new HTML5Services());
    }

    private static final class HTML5Services extends PlatformServices {
        // default behavior is enough for now
    }
}
