package og.javapro.netbeans.unicodeencodedecoder;

import og.javapro.netbeans.unicodeencodedecoder.js.PlatformServices;
import org.netbeans.api.htmlui.OpenHTMLRegistration;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbPreferences;

public class NbMain {
    private NbMain() {
    }
    
    @ActionID(
        category = "Games",
        id = "og.javapro.netbeans.unicodeencodedecoder.OpenPage"
    )
    @OpenHTMLRegistration(
        url="index.html",
        displayName = "Open Your Page",
        iconBase = "og/javapro/netbeans/unicodeencodedecoder/icon.png"
    )
    @ActionReferences({
        @ActionReference(path = "Menu/Window"),
        @ActionReference(path = "Toolbars/Games")
    })
    public static void onPageLoad() throws Exception {
        Main.onPageLoad(new NbServices());
    }

    private static class NbServices extends PlatformServices {
        public NbServices() {
        }

    }
}
