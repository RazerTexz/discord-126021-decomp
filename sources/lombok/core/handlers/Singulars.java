package lombok.core.handlers;

import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/handlers/Singulars.SCL.lombok */
public class Singulars {
    private static final List<String> SINGULAR_STORE = new ArrayList();

    static {
        try {
            InputStream in = Singulars.class.getResourceAsStream("singulars.txt");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(in, Constants.ENCODING));
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    String line2 = line.trim();
                    if (!line2.startsWith("#") && !line2.isEmpty()) {
                        if (line2.endsWith(" =")) {
                            SINGULAR_STORE.add(line2.substring(0, line2.length() - 2));
                            SINGULAR_STORE.add("");
                        } else {
                            int idx = line2.indexOf(" = ");
                            SINGULAR_STORE.add(line2.substring(0, idx));
                            SINGULAR_STORE.add(line2.substring(idx + 3));
                        }
                    }
                }
            } finally {
                try {
                    in.close();
                } catch (Throwable unused) {
                }
            }
        } catch (IOException unused2) {
            SINGULAR_STORE.clear();
        }
    }

    public static String autoSingularize(String in) {
        int inLen = in.length();
        for (int i = 0; i < SINGULAR_STORE.size(); i += 2) {
            String lastPart = SINGULAR_STORE.get(i);
            boolean wholeWord = Character.isUpperCase(lastPart.charAt(0));
            int endingOnly = lastPart.charAt(0) == '-' ? 1 : 0;
            int len = lastPart.length();
            if (inLen >= len && in.regionMatches(true, (inLen - len) + endingOnly, lastPart, endingOnly, len - endingOnly) && (!wholeWord || inLen == len || Character.isUpperCase(in.charAt(inLen - len)))) {
                String replacement = SINGULAR_STORE.get(i + 1);
                if (replacement.equals("!")) {
                    return null;
                }
                boolean capitalizeFirst = !replacement.isEmpty() && Character.isUpperCase(in.charAt((inLen - len) + endingOnly));
                String pre = in.substring(0, (inLen - len) + endingOnly);
                String post = capitalizeFirst ? String.valueOf(Character.toUpperCase(replacement.charAt(0))) + replacement.substring(1) : replacement;
                return String.valueOf(pre) + post;
            }
        }
        return null;
    }
}
