package og.javapro.netbeans.unicodeencodedecoder;

import net.java.html.boot.BrowserBuilder;
import og.javapro.netbeans.unicodeencodedecoder.js.PlatformServices;

public final class Main {
    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad(PlatformServices services) throws Exception {
        DataModel.onPageLoad(services);
    }

    public static void onPageLoad() throws Exception {
        DataModel.onPageLoad(new DesktopServices());
    }

    private static final class DesktopServices extends PlatformServices {
    }
}
