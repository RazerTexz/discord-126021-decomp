package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.r1 */
/* JADX INFO: compiled from: MediaPeriodInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2843r1 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2530a0.a f7465a;

    /* JADX INFO: renamed from: b */
    public final long f7466b;

    /* JADX INFO: renamed from: c */
    public final long f7467c;

    /* JADX INFO: renamed from: d */
    public final long f7468d;

    /* JADX INFO: renamed from: e */
    public final long f7469e;

    /* JADX INFO: renamed from: f */
    public final boolean f7470f;

    /* JADX INFO: renamed from: g */
    public final boolean f7471g;

    /* JADX INFO: renamed from: h */
    public final boolean f7472h;

    /* JADX INFO: renamed from: i */
    public final boolean f7473i;

    public C2843r1(InterfaceC2530a0.a aVar, long j, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        C1460d.m531j(!z5 || z3);
        C1460d.m531j(!z4 || z3);
        if (!z2 || (!z3 && !z4 && !z5)) {
            z6 = true;
        }
        C1460d.m531j(z6);
        this.f7465a = aVar;
        this.f7466b = j;
        this.f7467c = j2;
        this.f7468d = j3;
        this.f7469e = j4;
        this.f7470f = z2;
        this.f7471g = z3;
        this.f7472h = z4;
        this.f7473i = z5;
    }

    /* JADX INFO: renamed from: a */
    public C2843r1 m3360a(long j) {
        return j == this.f7467c ? this : new C2843r1(this.f7465a, this.f7466b, j, this.f7468d, this.f7469e, this.f7470f, this.f7471g, this.f7472h, this.f7473i);
    }

    /* JADX INFO: renamed from: b */
    public C2843r1 m3361b(long j) {
        return j == this.f7466b ? this : new C2843r1(this.f7465a, j, this.f7467c, this.f7468d, this.f7469e, this.f7470f, this.f7471g, this.f7472h, this.f7473i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2843r1.class != obj.getClass()) {
            return false;
        }
        C2843r1 c2843r1 = (C2843r1) obj;
        return this.f7466b == c2843r1.f7466b && this.f7467c == c2843r1.f7467c && this.f7468d == c2843r1.f7468d && this.f7469e == c2843r1.f7469e && this.f7470f == c2843r1.f7470f && this.f7471g == c2843r1.f7471g && this.f7472h == c2843r1.f7472h && this.f7473i == c2843r1.f7473i && C2738e0.m2993a(this.f7465a, c2843r1.f7465a);
    }

    public int hashCode() {
        return ((((((((((((((((this.f7465a.hashCode() + 527) * 31) + ((int) this.f7466b)) * 31) + ((int) this.f7467c)) * 31) + ((int) this.f7468d)) * 31) + ((int) this.f7469e)) * 31) + (this.f7470f ? 1 : 0)) * 31) + (this.f7471g ? 1 : 0)) * 31) + (this.f7472h ? 1 : 0)) * 31) + (this.f7473i ? 1 : 0);
    }
}
