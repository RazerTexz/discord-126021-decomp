package p007b.p225i.p414e.p426q.p427r.p428f;

import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.e.q.r.f.b */
/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5010b {

    /* JADX INFO: renamed from: a */
    public final List<C5009a> f13424a;

    /* JADX INFO: renamed from: b */
    public final int f13425b;

    /* JADX INFO: renamed from: c */
    public final boolean f13426c;

    public C5010b(List<C5009a> list, int i, boolean z2) {
        this.f13424a = new ArrayList(list);
        this.f13425b = i;
        this.f13426c = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5010b)) {
            return false;
        }
        C5010b c5010b = (C5010b) obj;
        return this.f13424a.equals(c5010b.f13424a) && this.f13426c == c5010b.f13426c;
    }

    public int hashCode() {
        return this.f13424a.hashCode() ^ Boolean.valueOf(this.f13426c).hashCode();
    }

    public String toString() {
        return C1643a.m824L(new StringBuilder("{ "), this.f13424a, " }");
    }
}
