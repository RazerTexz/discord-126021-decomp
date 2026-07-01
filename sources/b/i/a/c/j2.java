package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SeekParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j2 {
    public static final j2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j2 f1026b;
    public final long c;
    public final long d;

    static {
        j2 j2Var = new j2(0L, 0L);
        a = j2Var;
        b.c.a.a0.d.j(RecyclerView.FOREVER_NS >= 0);
        b.c.a.a0.d.j(RecyclerView.FOREVER_NS >= 0);
        b.c.a.a0.d.j(RecyclerView.FOREVER_NS >= 0);
        b.c.a.a0.d.j(0 >= 0);
        b.c.a.a0.d.j(0 >= 0);
        b.c.a.a0.d.j(RecyclerView.FOREVER_NS >= 0);
        f1026b = j2Var;
    }

    public j2(long j, long j2) {
        b.c.a.a0.d.j(j >= 0);
        b.c.a.a0.d.j(j2 >= 0);
        this.c = j;
        this.d = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j2.class != obj.getClass()) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return this.c == j2Var.c && this.d == j2Var.d;
    }

    public int hashCode() {
        return (((int) this.c) * 31) + ((int) this.d);
    }
}
