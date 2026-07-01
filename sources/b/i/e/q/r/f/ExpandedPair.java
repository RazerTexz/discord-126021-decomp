package b.i.e.q.r.f;

import b.i.e.q.r.DataCharacter;
import b.i.e.q.r.FinderPattern;

/* JADX INFO: renamed from: b.i.e.q.r.f.a, reason: use source file name */
/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedPair {
    public final DataCharacter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCharacter f1865b;
    public final FinderPattern c;

    public ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z2) {
        this.a = dataCharacter;
        this.f1865b = dataCharacter2;
        this.c = finderPattern;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        return a(this.a, expandedPair.a) && a(this.f1865b, expandedPair.f1865b) && a(this.c, expandedPair.c);
    }

    public int hashCode() {
        return (b(this.a) ^ b(this.f1865b)) ^ b(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.f1865b);
        sb.append(" : ");
        FinderPattern finderPattern = this.c;
        sb.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.a));
        sb.append(" ]");
        return sb.toString();
    }
}
