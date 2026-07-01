package b.i.a.f.h.j;

import android.text.TextUtils;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public final Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f1421b;
    public final long c;
    public final long d;
    public final int e;
    public final boolean f;
    public final String g;

    public j0(d dVar, Map<String, String> map, long j, boolean z2, long j2, int i) {
        String strA;
        String strA2;
        Objects.requireNonNull(map, "null reference");
        this.d = j;
        this.f = z2;
        this.c = j2;
        this.e = i;
        this.f1421b = Collections.emptyList();
        TextUtils.isEmpty(null);
        this.g = null;
        HashMap map2 = new HashMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if ((key != null ? key.toString().startsWith("&") : false) && (strA2 = a(dVar, next.getKey())) != null) {
                map2.put(strA2, b(dVar, next.getValue()));
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key2 = entry.getKey();
            if (!(key2 == null ? false : key2.toString().startsWith("&")) && (strA = a(dVar, entry.getKey())) != null) {
                map2.put(strA, b(dVar, entry.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            String str = this.g;
            if (str != null && !map2.containsKey("_v")) {
                map2.put("_v", str);
            }
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.a = Collections.unmodifiableMap(map2);
    }

    public static String a(d dVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        if (string.startsWith("&")) {
            string = string.substring(1);
        }
        int length = string.length();
        if (length > 256) {
            string = string.substring(0, 256);
            dVar.f("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public static String b(d dVar, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, 8192);
        dVar.f("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    public final String toString() {
        StringBuilder sbU = outline.U("ht=");
        sbU.append(this.d);
        if (this.c != 0) {
            sbU.append(", dbId=");
            sbU.append(this.c);
        }
        if (this.e != 0) {
            sbU.append(", appUID=");
            sbU.append(this.e);
        }
        ArrayList arrayList = new ArrayList(this.a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            sbU.append(", ");
            sbU.append(str);
            sbU.append("=");
            sbU.append(this.a.get(str));
        }
        return sbU.toString();
    }
}
