package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$g<K, V> {
    public final K a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends V> f3515b;

    public f$g(K k, Function0<? extends V> function0) {
        this.a = k;
        this.f3515b = function0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f$g.class == obj.getClass() && this.a.equals(((f$g) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
