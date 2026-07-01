package b.a.k.g;

/* JADX INFO: compiled from: ParseState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f246b;

    public c() {
        this(false, 0, 3);
    }

    public c(boolean z2, int i) {
        this.a = z2;
        this.f246b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.f246b == cVar.f246b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return (r0 * 31) + this.f246b;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ParseState(isEscaped=");
        sbU.append(this.a);
        sbU.append(", argumentIndex=");
        return b.d.b.a.a.B(sbU, this.f246b, ")");
    }

    public c(boolean z2, int i, int i2) {
        z2 = (i2 & 1) != 0 ? false : z2;
        i = (i2 & 2) != 0 ? 0 : i;
        this.a = z2;
        this.f246b = i;
    }
}
