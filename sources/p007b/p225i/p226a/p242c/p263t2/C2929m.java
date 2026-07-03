package p007b.p225i.p226a.p242c.p263t2;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.t2.m */
/* JADX INFO: compiled from: Ac3Util.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2929m {

    /* JADX INFO: renamed from: a */
    public static final int[] f7769a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b */
    public static final int[] f7770b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c */
    public static final int[] f7771c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d */
    public static final int[] f7772d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e */
    public static final int[] f7773e = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, Opcodes.CHECKCAST, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f */
    public static final int[] f7774f = {69, 87, 104, 121, Opcodes.F2I, Opcodes.FRETURN, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: a */
    public static int m3491a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = f7770b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f7774f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return ((i2 % 2) + iArr2[i3]) * 2;
        }
        int i5 = f7773e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }
}
