package b.a.q.k0;

import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: b.a.q.k0.g, reason: use source file name */
/* JADX INFO: compiled from: EchoCancellation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EchoCancellation {
    public volatile boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public static final a c = new a(null);
    public static final EchoCancellation a = new EchoCancellation(true, false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EchoCancellation f264b = new EchoCancellation(true, false, false);

    /* JADX INFO: renamed from: b.a.q.k0.g$a */
    /* JADX INFO: compiled from: EchoCancellation.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public EchoCancellation(boolean z2, boolean z3, boolean z4) {
        this.e = z2;
        this.f = z3;
        this.g = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EchoCancellation)) {
            return false;
        }
        EchoCancellation echoCancellation = (EchoCancellation) obj;
        return this.e == echoCancellation.e && this.f == echoCancellation.f && this.g == echoCancellation.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.e;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.f;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.g;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EchoCancellation(shouldEarlyEnableHwAec=");
        sbU.append(this.e);
        sbU.append(", alwaysEnableAec=");
        sbU.append(this.f);
        sbU.append(", disableSwAecWhenHwIsEnabled=");
        return outline.O(sbU, this.g, ")");
    }
}
