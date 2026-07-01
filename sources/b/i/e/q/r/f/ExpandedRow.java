package b.i.e.q.r.f;

import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.e.q.r.f.b, reason: use source file name */
/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedRow {
    public final List<ExpandedPair> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1866b;
    public final boolean c;

    public ExpandedRow(List<ExpandedPair> list, int i, boolean z2) {
        this.a = new ArrayList(list);
        this.f1866b = i;
        this.c = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow expandedRow = (ExpandedRow) obj;
        return this.a.equals(expandedRow.a) && this.c == expandedRow.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return outline.L(new StringBuilder("{ "), this.a, " }");
    }
}
