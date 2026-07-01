package b.i.e.q.r.f;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final List<a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1866b;
    public final boolean c;

    public b(List<a> list, int i, boolean z2) {
        this.a = new ArrayList(list);
        this.f1866b = i;
        this.c = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.c == bVar.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return b.d.b.a.a.L(new StringBuilder("{ "), this.a, " }");
    }
}
