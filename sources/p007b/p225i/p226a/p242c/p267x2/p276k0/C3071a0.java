package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.a0 */
/* JADX INFO: compiled from: PsDurationReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3071a0 {

    /* JADX INFO: renamed from: c */
    public boolean f8567c;

    /* JADX INFO: renamed from: d */
    public boolean f8568d;

    /* JADX INFO: renamed from: e */
    public boolean f8569e;

    /* JADX INFO: renamed from: a */
    public final C2736d0 f8565a = new C2736d0(0);

    /* JADX INFO: renamed from: f */
    public long f8570f = -9223372036854775807L;

    /* JADX INFO: renamed from: g */
    public long f8571g = -9223372036854775807L;

    /* JADX INFO: renamed from: h */
    public long f8572h = -9223372036854775807L;

    /* JADX INFO: renamed from: b */
    public final C2757x f8566b = new C2757x();

    /* JADX INFO: renamed from: c */
    public static long m3749c(C2757x c2757x) {
        int i = c2757x.f6794b;
        if (c2757x.m3081a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, 9);
        c2757x.f6794b += 9;
        c2757x.m3079E(i);
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
        }
        return -9223372036854775807L;
    }

    /* JADX INFO: renamed from: a */
    public final int m3750a(InterfaceC3041i interfaceC3041i) {
        this.f8566b.m3076B(C2738e0.f6713f);
        this.f8567c = true;
        interfaceC3041i.mo3649k();
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public final int m3751b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
