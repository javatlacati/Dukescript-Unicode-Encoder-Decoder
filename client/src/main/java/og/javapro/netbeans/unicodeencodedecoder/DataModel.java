package og.javapro.netbeans.unicodeencodedecoder;

import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;
import og.javapro.netbeans.unicodeencodedecoder.js.PlatformServices;

import java.util.Arrays;

@Model(className = "UnicodeEncDec", targetId = "", instance = true, properties = {
        @Property(name = "decoded", type = String.class)
        ,
        @Property(name = "encoded", type = String.class)
})
final class DataModel {

    private PlatformServices services;

    @ModelOperation
    void initServices(UnicodeEncDec model, PlatformServices services) {
        this.services = services;
    }

    @Function
    public void decode(UnicodeEncDec model) {
//        model.setDecoded(Stream.of(model.getEncoded().replaceAll("\\\\[u]([\\da-f]{4})", "$1 ").split(" ")).map(
//                (codePoint) -> {
//                    try {
//                        return String.valueOf((char) (Integer.valueOf(codePoint, 16).intValue()));
//                    } catch (Exception e) {
//                        return "";
//                    }
//                }
//        ).collect(Collectors.joining("")));
        String[] decoded = model.getEncoded().replaceAll("\\\\u([\\da-f]{4})", "$1 ").split(" ");
        for (int i = 0; i < decoded.length; i++) {
            String codepoint = decoded[i];
//            System.out.println("codepoint"+codepoint);
            try {
                decoded[i] = String.valueOf((char) (Integer.valueOf(codepoint, 16).intValue()));
//                System.out.println("decoded[i]="+decoded[i]);
            } catch (Exception e) {
                decoded[i] = "";
            }
        }

        model.setDecoded(String.join("", decoded));
    }

    @Function
    public void encode(UnicodeEncDec model) {
//        String encoded=Stream.of(model.getDecoded().split("")).map(
//                (character)
//                -> {
//                    try {
//                        return String.format("\\u%04x", character.codePointAt(0));
//                    } catch (Exception e) {
//                        return "";
//                    }
//                }
//        ).collect(Collectors.joining(""));

        String[] encoded = model.getDecoded().split("");
//        System.out.println(Arrays.toString(encoded));
        for (int i = 0; i < encoded.length; i++) {
            String cad = encoded[i];
//            System.out.println(cad);
            if (!cad.isEmpty()) {
                encoded[i] = String.format("\\u%04x", cad.codePointAt(0));
//                System.out.println(encoded[i]);
            }

        }
//        System.out.println("unido:"+String.join("", encoded));
        model.setEncoded(String.join("", encoded));
    }

    private static UnicodeEncDec pageModel;

    /**
     * Called when the page is ready.
     */
    static void onPageLoad(PlatformServices services) throws Exception {
        pageModel = new UnicodeEncDec("df", "d");
        pageModel.initServices(services);
        pageModel.applyBindings();
    }
}
