package b.f.b.b;

import com.facebook.cache.common.CacheKey;

/* JADX INFO: compiled from: SettableCacheEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f468b;
    public static int c;
    public CacheKey d;
    public i e;

    public static i a() {
        synchronized (a) {
            i iVar = f468b;
            if (iVar == null) {
                return new i();
            }
            f468b = iVar.e;
            iVar.e = null;
            c--;
            return iVar;
        }
    }

    public void b() {
        synchronized (a) {
            int i = c;
            if (i < 5) {
                c = i + 1;
                i iVar = f468b;
                if (iVar != null) {
                    this.e = iVar;
                }
                f468b = this;
            }
        }
    }
}
