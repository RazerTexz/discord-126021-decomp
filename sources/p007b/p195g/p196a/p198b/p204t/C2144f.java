package p007b.p195g.p196a.p198b.p204t;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.b.t.f */
/* JADX INFO: compiled from: InternCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2144f extends ConcurrentHashMap<String, String> {

    /* JADX INFO: renamed from: j */
    public static final C2144f f4602j = new C2144f();
    private static final long serialVersionUID = 1;
    private final Object lock;

    public C2144f() {
        super(180, 0.8f, 4);
        this.lock = new Object();
    }

    /* JADX INFO: renamed from: a */
    public String m1733a(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}
