package p007b.p008a.p041q.p042k0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.a.q.k0.g */
/* JADX INFO: compiled from: EchoCancellation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1215g {

    /* JADX INFO: renamed from: d */
    public volatile boolean f1663d;

    /* JADX INFO: renamed from: e */
    public final boolean f1664e;

    /* JADX INFO: renamed from: f */
    public final boolean f1665f;

    /* JADX INFO: renamed from: g */
    public final boolean f1666g;

    /* JADX INFO: renamed from: c */
    public static final a f1662c = new a(null);

    /* JADX INFO: renamed from: a */
    public static final C1215g f1660a = new C1215g(true, false, false);

    /* JADX INFO: renamed from: b */
    public static final C1215g f1661b = new C1215g(true, false, false);

    /* JADX INFO: renamed from: b.a.q.k0.g$a */
    /* JADX INFO: compiled from: EchoCancellation.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C1215g(boolean z2, boolean z3, boolean z4) {
        this.f1664e = z2;
        this.f1665f = z3;
        this.f1666g = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1215g)) {
            return false;
        }
        C1215g c1215g = (C1215g) obj;
        return this.f1664e == c1215g.f1664e && this.f1665f == c1215g.f1665f && this.f1666g == c1215g.f1666g;
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
        boolean z2 = this.f1664e;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.f1665f;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.f1666g;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EchoCancellation(shouldEarlyEnableHwAec=");
        sbM833U.append(this.f1664e);
        sbM833U.append(", alwaysEnableAec=");
        sbM833U.append(this.f1665f);
        sbM833U.append(", disableSwAecWhenHwIsEnabled=");
        return C1643a.m827O(sbM833U, this.f1666g, ")");
    }
}
