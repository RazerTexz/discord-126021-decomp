package p007b.p225i.p226a.p288f.p313h.p323j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.j.j0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3523j0 {

    /* JADX INFO: renamed from: a */
    public final Map<String, String> f9746a;

    /* JADX INFO: renamed from: b */
    public final List<?> f9747b;

    /* JADX INFO: renamed from: c */
    public final long f9748c;

    /* JADX INFO: renamed from: d */
    public final long f9749d;

    /* JADX INFO: renamed from: e */
    public final int f9750e;

    /* JADX INFO: renamed from: f */
    public final boolean f9751f;

    /* JADX INFO: renamed from: g */
    public final String f9752g;

    public C3523j0(C3506d c3506d, Map<String, String> map, long j, boolean z2, long j2, int i) {
        String strM4461a;
        String strM4461a2;
        Objects.requireNonNull(map, "null reference");
        this.f9749d = j;
        this.f9751f = z2;
        this.f9748c = j2;
        this.f9750e = i;
        this.f9747b = Collections.emptyList();
        TextUtils.isEmpty(null);
        this.f9752g = null;
        HashMap map2 = new HashMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if ((key != null ? key.toString().startsWith("&") : false) && (strM4461a2 = m4461a(c3506d, next.getKey())) != null) {
                map2.put(strM4461a2, m4462b(c3506d, next.getValue()));
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key2 = entry.getKey();
            if (!(key2 == null ? false : key2.toString().startsWith("&")) && (strM4461a = m4461a(c3506d, entry.getKey())) != null) {
                map2.put(strM4461a, m4462b(c3506d, entry.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.f9752g)) {
            String str = this.f9752g;
            if (str != null && !map2.containsKey("_v")) {
                map2.put("_v", str);
            }
            if (this.f9752g.equals("ma4.0.0") || this.f9752g.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.f9746a = Collections.unmodifiableMap(map2);
    }

    /* JADX INFO: renamed from: a */
    public static String m4461a(C3506d c3506d, Object obj) {
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
            c3506d.m4433f("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: renamed from: b */
    public static String m4462b(C3506d c3506d, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, 8192);
        c3506d.m4433f("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    public final String toString() {
        StringBuilder sbM833U = C1643a.m833U("ht=");
        sbM833U.append(this.f9749d);
        if (this.f9748c != 0) {
            sbM833U.append(", dbId=");
            sbM833U.append(this.f9748c);
        }
        if (this.f9750e != 0) {
            sbM833U.append(", appUID=");
            sbM833U.append(this.f9750e);
        }
        ArrayList arrayList = new ArrayList(this.f9746a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            sbM833U.append(", ");
            sbM833U.append(str);
            sbM833U.append("=");
            sbM833U.append(this.f9746a.get(str));
        }
        return sbM833U.toString();
    }
}
