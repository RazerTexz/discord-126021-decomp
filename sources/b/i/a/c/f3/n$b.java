package b.i.a.c.f3;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: FlagSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b {
    public final SparseBooleanArray a = new SparseBooleanArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f972b;

    public n$b a(int i) {
        b.c.a.a0.d.D(!this.f972b);
        this.a.append(i, true);
        return this;
    }

    public n b() {
        b.c.a.a0.d.D(!this.f972b);
        this.f972b = true;
        return new n(this.a, null);
    }
}
