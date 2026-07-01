package b.i.a.c.x2;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.m, reason: use source file name */
/* JADX INFO: compiled from: FlacFrameReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacFrameReader {

    /* JADX INFO: renamed from: b.i.a.c.x2.m$a */
    /* JADX INFO: compiled from: FlacFrameReader.java */
    public static final class a {
        public long a;
    }

    public static boolean a(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z2, a aVar) {
        try {
            long jZ = parsableByteArray.z();
            if (!z2) {
                jZ *= (long) flacStreamMetadata.f1292b;
            }
            aVar.a = jZ;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x00ae, please report this as an issue */
    public static boolean b(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
        boolean z2;
        long jU = parsableByteArray.u();
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
        if (!(i4 > 7 ? !(i4 > 10 || flacStreamMetadata.g != 2) : i4 == flacStreamMetadata.g - 1)) {
            return false;
        }
        if (!(i5 == 0 || i5 == flacStreamMetadata.i) || z4 || !a(parsableByteArray, flacStreamMetadata, z3, aVar)) {
            return false;
        }
        int iC = c(parsableByteArray, i2);
        if (!(iC != -1 && iC <= flacStreamMetadata.f1292b)) {
            return false;
        }
        int i6 = flacStreamMetadata.e;
        if (i3 != 0) {
            if (i3 <= 11) {
                if (i3 == flacStreamMetadata.f) {
                }
            } else if (i3 != 12) {
                if (i3 <= 14) {
                    int iY = parsableByteArray.y();
                    if (i3 == 14) {
                        iY *= 10;
                    }
                    z2 = iY == i6;
                }
            } else if (parsableByteArray.t() * 1000 == i6) {
            }
        }
        if (!z2) {
            return false;
        }
        int iT = parsableByteArray.t();
        int i7 = parsableByteArray.f984b;
        byte[] bArr = parsableByteArray.a;
        int i8 = i7 - 1;
        int i9 = Util2.a;
        int i10 = 0;
        for (int i11 = parsableByteArray.f984b; i11 < i8; i11++) {
            i10 = Util2.l[i10 ^ (bArr[i11] & 255)];
        }
        return iT == i10;
    }

    public static int c(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return Opcodes.CHECKCAST;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.t() + 1;
            case 7:
                return parsableByteArray.y() + 1;
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
