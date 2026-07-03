package p615g0;

import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.s */
/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12402s {

    /* JADX INFO: renamed from: a */
    public final byte[] f26118a;

    /* JADX INFO: renamed from: b */
    public int f26119b;

    /* JADX INFO: renamed from: c */
    public int f26120c;

    /* JADX INFO: renamed from: d */
    public boolean f26121d;

    /* JADX INFO: renamed from: e */
    public boolean f26122e;

    /* JADX INFO: renamed from: f */
    public C12402s f26123f;

    /* JADX INFO: renamed from: g */
    public C12402s f26124g;

    public C12402s() {
        this.f26118a = new byte[8192];
        this.f26122e = true;
        this.f26121d = false;
    }

    /* JADX INFO: renamed from: a */
    public final C12402s m10494a() {
        C12402s c12402s = this.f26123f;
        if (c12402s == this) {
            c12402s = null;
        }
        C12402s c12402s2 = this.f26124g;
        if (c12402s2 == null) {
            C12238m.throwNpe();
        }
        c12402s2.f26123f = this.f26123f;
        C12402s c12402s3 = this.f26123f;
        if (c12402s3 == null) {
            C12238m.throwNpe();
        }
        c12402s3.f26124g = this.f26124g;
        this.f26123f = null;
        this.f26124g = null;
        return c12402s;
    }

    /* JADX INFO: renamed from: b */
    public final C12402s m10495b(C12402s c12402s) {
        C12238m.checkParameterIsNotNull(c12402s, "segment");
        c12402s.f26124g = this;
        c12402s.f26123f = this.f26123f;
        C12402s c12402s2 = this.f26123f;
        if (c12402s2 == null) {
            C12238m.throwNpe();
        }
        c12402s2.f26124g = c12402s;
        this.f26123f = c12402s;
        return c12402s;
    }

    /* JADX INFO: renamed from: c */
    public final C12402s m10496c() {
        this.f26121d = true;
        return new C12402s(this.f26118a, this.f26119b, this.f26120c, true, false);
    }

    /* JADX INFO: renamed from: d */
    public final void m10497d(C12402s c12402s, int i) {
        C12238m.checkParameterIsNotNull(c12402s, "sink");
        if (!c12402s.f26122e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = c12402s.f26120c;
        if (i2 + i > 8192) {
            if (c12402s.f26121d) {
                throw new IllegalArgumentException();
            }
            int i3 = c12402s.f26119b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c12402s.f26118a;
            C12139j.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
            c12402s.f26120c -= c12402s.f26119b;
            c12402s.f26119b = 0;
        }
        byte[] bArr2 = this.f26118a;
        byte[] bArr3 = c12402s.f26118a;
        int i4 = c12402s.f26120c;
        int i5 = this.f26119b;
        C12139j.copyInto(bArr2, bArr3, i4, i5, i5 + i);
        c12402s.f26120c += i;
        this.f26119b += i;
    }

    public C12402s(byte[] bArr, int i, int i2, boolean z2, boolean z3) {
        C12238m.checkParameterIsNotNull(bArr, "data");
        this.f26118a = bArr;
        this.f26119b = i;
        this.f26120c = i2;
        this.f26121d = z2;
        this.f26122e = z3;
    }
}
