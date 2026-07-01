package g0;

import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: g0.s, reason: use source file name */
/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Segment2 {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3693b;
    public int c;
    public boolean d;
    public boolean e;
    public Segment2 f;
    public Segment2 g;

    public Segment2() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final Segment2 a() {
        Segment2 segment2 = this.f;
        if (segment2 == this) {
            segment2 = null;
        }
        Segment2 segment3 = this.g;
        if (segment3 == null) {
            Intrinsics3.throwNpe();
        }
        segment3.f = this.f;
        Segment2 segment4 = this.f;
        if (segment4 == null) {
            Intrinsics3.throwNpe();
        }
        segment4.g = this.g;
        this.f = null;
        this.g = null;
        return segment2;
    }

    public final Segment2 b(Segment2 segment2) {
        Intrinsics3.checkParameterIsNotNull(segment2, "segment");
        segment2.g = this;
        segment2.f = this.f;
        Segment2 segment3 = this.f;
        if (segment3 == null) {
            Intrinsics3.throwNpe();
        }
        segment3.g = segment2;
        this.f = segment2;
        return segment2;
    }

    public final Segment2 c() {
        this.d = true;
        return new Segment2(this.a, this.f3693b, this.c, true, false);
    }

    public final void d(Segment2 segment2, int i) {
        Intrinsics3.checkParameterIsNotNull(segment2, "sink");
        if (!segment2.e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = segment2.c;
        if (i2 + i > 8192) {
            if (segment2.d) {
                throw new IllegalArgumentException();
            }
            int i3 = segment2.f3693b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment2.a;
            _ArraysJvm.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
            segment2.c -= segment2.f3693b;
            segment2.f3693b = 0;
        }
        byte[] bArr2 = this.a;
        byte[] bArr3 = segment2.a;
        int i4 = segment2.c;
        int i5 = this.f3693b;
        _ArraysJvm.copyInto(bArr2, bArr3, i4, i5, i5 + i);
        segment2.c += i;
        this.f3693b += i;
    }

    public Segment2(byte[] bArr, int i, int i2, boolean z2, boolean z3) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.a = bArr;
        this.f3693b = i;
        this.c = i2;
        this.d = z2;
        this.e = z3;
    }
}
