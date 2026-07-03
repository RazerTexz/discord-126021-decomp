package p007b.p225i.p226a.p242c.p267x2;

import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.x2.m */
/* JADX INFO: compiled from: FlacFrameReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3112m {

    /* JADX INFO: renamed from: b.i.a.c.x2.m$a */
    /* JADX INFO: compiled from: FlacFrameReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public long f8967a;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3802a(C2757x c2757x, C3114o c3114o, boolean z2, a aVar) {
        try {
            long jM3106z = c2757x.m3106z();
            if (!z2) {
                jM3106z *= (long) c3114o.f8971b;
            }
            aVar.f8967a = jM3106z;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x00ae, please report this as an issue */
    /* JADX INFO: renamed from: b */
    public static boolean m3803b(C2757x c2757x, C3114o c3114o, int i, a aVar) {
        boolean z2;
        long jM3101u = c2757x.m3101u();
        long j = jM3101u >>> 16;
        if (j != i) {
            return false;
        }
        boolean z3 = (j & 1) == 1;
        int i2 = (int) ((jM3101u >> 12) & 15);
        int i3 = (int) ((jM3101u >> 8) & 15);
        int i4 = (int) (15 & (jM3101u >> 4));
        int i5 = (int) ((jM3101u >> 1) & 7);
        boolean z4 = (jM3101u & 1) == 1;
        if (!(i4 > 7 ? !(i4 > 10 || c3114o.f8976g != 2) : i4 == c3114o.f8976g - 1)) {
            return false;
        }
        if (!(i5 == 0 || i5 == c3114o.f8978i) || z4 || !m3802a(c2757x, c3114o, z3, aVar)) {
            return false;
        }
        int iM3804c = m3804c(c2757x, i2);
        if (!(iM3804c != -1 && iM3804c <= c3114o.f8971b)) {
            return false;
        }
        int i6 = c3114o.f8974e;
        if (i3 != 0) {
            if (i3 <= 11) {
                if (i3 == c3114o.f8975f) {
                }
            } else if (i3 != 12) {
                if (i3 <= 14) {
                    int iM3105y = c2757x.m3105y();
                    if (i3 == 14) {
                        iM3105y *= 10;
                    }
                    z2 = iM3105y == i6;
                }
            } else if (c2757x.m3100t() * 1000 == i6) {
            }
        }
        if (!z2) {
            return false;
        }
        int iM3100t = c2757x.m3100t();
        int i7 = c2757x.f6794b;
        byte[] bArr = c2757x.f6793a;
        int i8 = i7 - 1;
        int i9 = C2738e0.f6708a;
        int i10 = 0;
        for (int i11 = c2757x.f6794b; i11 < i8; i11++) {
            i10 = C2738e0.f6719l[i10 ^ (bArr[i11] & 255)];
        }
        return iM3100t == i10;
    }

    /* JADX INFO: renamed from: c */
    public static int m3804c(C2757x c2757x, int i) {
        switch (i) {
            case 1:
                return Opcodes.CHECKCAST;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return c2757x.m3100t() + 1;
            case 7:
                return c2757x.m3105y() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
