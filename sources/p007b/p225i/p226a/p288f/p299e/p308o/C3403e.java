package p007b.p225i.p226a.p288f.p299e.p308o;

import androidx.annotation.RecentlyNonNull;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.f.e.o.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3403e {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.HashMap] */
    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public static Map<String, String> m4188a(@RecentlyNonNull URI uri, @RecentlyNonNull String str) {
        String strDecode;
        ?? EmptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            EmptyMap = new HashMap();
            Scanner scanner = new Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                String[] strArrSplit = scanner.next().split("=");
                int length = strArrSplit.length;
                if (length == 0 || length > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                try {
                    String strDecode2 = URLDecoder.decode(strArrSplit[0], str);
                    if (length == 2) {
                        try {
                            strDecode = URLDecoder.decode(strArrSplit[1], str);
                        } catch (UnsupportedEncodingException e) {
                            throw new IllegalArgumentException(e);
                        }
                    } else {
                        strDecode = null;
                    }
                    EmptyMap.put(strDecode2, strDecode);
                } catch (UnsupportedEncodingException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
        }
        return EmptyMap;
    }
}
