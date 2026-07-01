package b.i.a.c.x2.k0;

/* JADX INFO: compiled from: PsDurationReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public boolean c;
    public boolean d;
    public boolean e;
    public final b.i.a.c.f3.d0 a = new b.i.a.c.f3.d0(0);
    public long f = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1242b = new b.i.a.c.f3.x();

    public static long c(b.i.a.c.f3.x xVar) {
        int i = xVar.f984b;
        if (xVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        System.arraycopy(xVar.a, xVar.f984b, bArr, 0, 9);
        xVar.f984b += 9;
        xVar.E(i);
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
        }
        return -9223372036854775807L;
    }

    public final int a(b.i.a.c.x2.i iVar) {
        this.f1242b.B(b.i.a.c.f3.e0.f);
        this.c = true;
        iVar.k();
        return 0;
    }

    public final int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
