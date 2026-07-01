package b.i.a.c.f3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$c<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n$b f974b = new n$b();
    public boolean c;
    public boolean d;

    public p$c(T t) {
        this.a = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p$c.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((p$c) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
