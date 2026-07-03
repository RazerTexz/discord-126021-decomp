package p007b.p225i.p414e.p426q.p427r.p428f;

import p007b.p225i.p414e.p426q.p427r.C5005b;
import p007b.p225i.p414e.p426q.p427r.C5006c;

/* JADX INFO: renamed from: b.i.e.q.r.f.a */
/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5009a {

    /* JADX INFO: renamed from: a */
    public final C5005b f13421a;

    /* JADX INFO: renamed from: b */
    public final C5005b f13422b;

    /* JADX INFO: renamed from: c */
    public final C5006c f13423c;

    public C5009a(C5005b c5005b, C5005b c5005b2, C5006c c5006c, boolean z2) {
        this.f13421a = c5005b;
        this.f13422b = c5005b2;
        this.f13423c = c5006c;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m7018a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public static int m7019b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5009a)) {
            return false;
        }
        C5009a c5009a = (C5009a) obj;
        return m7018a(this.f13421a, c5009a.f13421a) && m7018a(this.f13422b, c5009a.f13422b) && m7018a(this.f13423c, c5009a.f13423c);
    }

    public int hashCode() {
        return (m7019b(this.f13421a) ^ m7019b(this.f13422b)) ^ m7019b(this.f13423c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f13421a);
        sb.append(" , ");
        sb.append(this.f13422b);
        sb.append(" : ");
        C5006c c5006c = this.f13423c;
        sb.append(c5006c == null ? "null" : Integer.valueOf(c5006c.f13407a));
        sb.append(" ]");
        return sb.toString();
    }
}
