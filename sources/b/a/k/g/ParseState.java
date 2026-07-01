package b.a.k.g;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.a.k.g.c, reason: use source file name */
/* JADX INFO: compiled from: ParseState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParseState {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f246b;

    public ParseState() {
        this(false, 0, 3);
    }

    public ParseState(boolean z2, int i) {
        this.a = z2;
        this.f246b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParseState)) {
            return false;
        }
        ParseState parseState = (ParseState) obj;
        return this.a == parseState.a && this.f246b == parseState.f246b;
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
        StringBuilder sbU = outline.U("ParseState(isEscaped=");
        sbU.append(this.a);
        sbU.append(", argumentIndex=");
        return outline.B(sbU, this.f246b, ")");
    }

    public ParseState(boolean z2, int i, int i2) {
        z2 = (i2 & 1) != 0 ? false : z2;
        i = (i2 & 2) != 0 ? 0 : i;
        this.a = z2;
        this.f246b = i;
    }
}
