package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import b.i.c.m.d.Logger3;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.i.c.m.d.k.f1, reason: use source file name */
/* JADX INFO: compiled from: UserMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public class UserMetadata {
    public String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f1683b = new ConcurrentHashMap<>();

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > 1024 ? strTrim.substring(0, 1024) : strTrim;
    }

    @NonNull
    public Map<String, String> a() {
        return Collections.unmodifiableMap(this.f1683b);
    }

    public void c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strB = b(str);
        if (this.f1683b.size() < 64 || this.f1683b.containsKey(strB)) {
            this.f1683b.put(strB, str2 == null ? "" : b(str2));
        } else {
            Logger3.a.b("Exceeded maximum number of custom attributes (64)");
        }
    }
}
