package b.i.a.c.x2;

import b.i.a.c.f3.e0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: FlacFrameReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static boolean a(b.i.a.c.f3.x xVar, o oVar, boolean z2, m$a m_a) {
        try {
            long jZ = xVar.z();
            if (!z2) {
                jZ *= (long) oVar.f1292b;
            }
            m_a.a = jZ;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x00ae, please report this as an issue */
    public static boolean b(b.i.a.c.f3.x xVar, o oVar, int i, m$a m_a) {
        boolean z2;
        long jU = xVar.u();
        long j = jU >>> 16;
        if (j != i) {
            return false;
        }
        boolean z3 = (j & 1) == 1;
        int i2 = (int) ((jU >> 12) & 15);
        int i3 = (int) ((jU >> 8) & 15);
        int i4 = (int) (15 & (jU >> 4));
        int i5 = (int) ((jU >> 1) & 7);
        boolean z4 = (jU & 1) == 1;
        if (!(i4 > 7 ? !(i4 > 10 || oVar.g != 2) : i4 == oVar.g - 1)) {
            return false;
        }
        if (!(i5 == 0 || i5 == oVar.i) || z4 || !a(xVar, oVar, z3, m_a)) {
            return false;
        }
        int iC = c(xVar, i2);
        if (!(iC != -1 && iC <= oVar.f1292b)) {
            return false;
        }
        int i6 = oVar.e;
        if (i3 != 0) {
            if (i3 <= 11) {
                if (i3 == oVar.f) {
                }
            } else if (i3 != 12) {
                if (i3 <= 14) {
                    int iY = xVar.y();
                    if (i3 == 14) {
                        iY *= 10;
                    }
                    z2 = iY == i6;
                }
            } else if (xVar.t() * 1000 == i6) {
            }
        }
        if (!z2) {
            return false;
        }
        int iT = xVar.t();
        int i7 = xVar.f984b;
        byte[] bArr = xVar.a;
        int i8 = i7 - 1;
        int i9 = e0.a;
        int i10 = 0;
        for (int i11 = xVar.f984b; i11 < i8; i11++) {
            i10 = e0.l[i10 ^ (bArr[i11] & 255)];
        }
        return iT == i10;
    }

    public static int c(b.i.a.c.f3.x xVar, int i) {
        switch (i) {
            case 1:
                return Opcodes.CHECKCAST;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return xVar.t() + 1;
            case 7:
                return xVar.y() + 1;
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
