package p007b.p008a.p027k.p030g;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.a.k.g.c */
/* JADX INFO: compiled from: ParseState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1117c {

    /* JADX INFO: renamed from: a */
    public final boolean f1501a;

    /* JADX INFO: renamed from: b */
    public int f1502b;

    public C1117c() {
        this(false, 0, 3);
    }

    public C1117c(boolean z2, int i) {
        this.f1501a = z2;
        this.f1502b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1117c)) {
            return false;
        }
        C1117c c1117c = (C1117c) obj;
        return this.f1501a == c1117c.f1501a && this.f1502b == c1117c.f1502b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.f1501a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return (r0 * 31) + this.f1502b;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ParseState(isEscaped=");
        sbM833U.append(this.f1501a);
        sbM833U.append(", argumentIndex=");
        return C1643a.m814B(sbM833U, this.f1502b, ")");
    }

    public C1117c(boolean z2, int i, int i2) {
        z2 = (i2 & 1) != 0 ? false : z2;
        i = (i2 & 2) != 0 ? 0 : i;
        this.f1501a = z2;
        this.f1502b = i;
    }
}
