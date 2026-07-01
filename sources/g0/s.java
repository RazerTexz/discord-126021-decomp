package g0;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3693b;
    public int c;
    public boolean d;
    public boolean e;
    public s f;
    public s g;

    public s() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final s a() {
        s sVar = this.f;
        if (sVar == this) {
            sVar = null;
        }
        s sVar2 = this.g;
        if (sVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        sVar2.f = this.f;
        s sVar3 = this.f;
        if (sVar3 == null) {
            d0.z.d.m.throwNpe();
        }
        sVar3.g = this.g;
        this.f = null;
        this.g = null;
        return sVar;
    }

    public final s b(s sVar) {
        d0.z.d.m.checkParameterIsNotNull(sVar, "segment");
        sVar.g = this;
        sVar.f = this.f;
        s sVar2 = this.f;
        if (sVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        sVar2.g = sVar;
        this.f = sVar;
        return sVar;
    }

    public final s c() {
        this.d = true;
        return new s(this.a, this.f3693b, this.c, true, false);
    }

    public final void d(s sVar, int i) {
        d0.z.d.m.checkParameterIsNotNull(sVar, "sink");
        if (!sVar.e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = sVar.c;
        if (i2 + i > 8192) {
            if (sVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = sVar.f3693b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sVar.a;
            d0.t.j.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
            sVar.c -= sVar.f3693b;
            sVar.f3693b = 0;
        }
        byte[] bArr2 = this.a;
        byte[] bArr3 = sVar.a;
        int i4 = sVar.c;
        int i5 = this.f3693b;
        d0.t.j.copyInto(bArr2, bArr3, i4, i5, i5 + i);
        sVar.c += i;
        this.f3693b += i;
    }

    public s(byte[] bArr, int i, int i2, boolean z2, boolean z3) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "data");
        this.a = bArr;
        this.f3693b = i;
        this.c = i2;
        this.d = z2;
        this.e = z3;
    }
}
