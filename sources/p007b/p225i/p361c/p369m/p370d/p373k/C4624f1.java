package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.f1 */
/* JADX INFO: compiled from: UserMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4624f1 {

    /* JADX INFO: renamed from: a */
    public String f12290a = null;

    /* JADX INFO: renamed from: b */
    public final ConcurrentHashMap<String, String> f12291b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b */
    public static String m6403b(String str) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > 1024 ? strTrim.substring(0, 1024) : strTrim;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public Map<String, String> m6404a() {
        return Collections.unmodifiableMap(this.f12291b);
    }

    /* JADX INFO: renamed from: c */
    public void m6405c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strM6403b = m6403b(str);
        if (this.f12291b.size() < 64 || this.f12291b.containsKey(strM6403b)) {
            this.f12291b.put(strM6403b, str2 == null ? "" : m6403b(str2));
        } else {
            C4592b.f12227a.m6371b("Exceeded maximum number of custom attributes (64)");
        }
    }
}
