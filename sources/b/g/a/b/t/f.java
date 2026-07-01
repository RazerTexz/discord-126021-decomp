package b.g.a.b.t;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: InternCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends ConcurrentHashMap<String, String> {
    public static final f j = new f();
    private static final long serialVersionUID = 1;
    private final Object lock;

    public f() {
        super(180, 0.8f, 4);
        this.lock = new Object();
    }

    public String a(String str) {
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
