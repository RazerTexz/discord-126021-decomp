package b.i.c.m.d.k;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: AbstractSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final Pattern a = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1676b;
    public final b.i.c.m.d.n.b c;
    public final int d;
    public final String e;

    public a(String str, String str2, b.i.c.m.d.n.b bVar, int i) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.e = str;
        this.f1676b = h.t(str) ? str2 : a.matcher(str2).replaceFirst(str);
        this.c = bVar;
        this.d = i;
    }

    public b.i.c.m.d.n.a b() {
        return c(Collections.emptyMap());
    }

    public b.i.c.m.d.n.a c(Map<String, String> map) {
        b.i.c.m.d.n.b bVar = this.c;
        int i = this.d;
        String str = this.f1676b;
        Objects.requireNonNull(bVar);
        b.i.c.m.d.n.a aVar = new b.i.c.m.d.n.a(i, str, map);
        aVar.e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        aVar.e.put("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return aVar;
    }
}
