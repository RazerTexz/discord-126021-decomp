package b.i.e.o.b;

import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final e[] a = {new e(1, 10, 10, 8, 8, new e$c(5, new e$b(1, 3, null), null)), new e(2, 12, 12, 10, 10, new e$c(7, new e$b(1, 5, null), null)), new e(3, 14, 14, 12, 12, new e$c(10, new e$b(1, 8, null), null)), new e(4, 16, 16, 14, 14, new e$c(12, new e$b(1, 12, null), null)), new e(5, 18, 18, 16, 16, new e$c(14, new e$b(1, 18, null), null)), new e(6, 20, 20, 18, 18, new e$c(18, new e$b(1, 22, null), null)), new e(7, 22, 22, 20, 20, new e$c(20, new e$b(1, 30, null), null)), new e(8, 24, 24, 22, 22, new e$c(24, new e$b(1, 36, null), null)), new e(9, 26, 26, 24, 24, new e$c(28, new e$b(1, 44, null), null)), new e(10, 32, 32, 14, 14, new e$c(36, new e$b(1, 62, null), null)), new e(11, 36, 36, 16, 16, new e$c(42, new e$b(1, 86, null), null)), new e(12, 40, 40, 18, 18, new e$c(48, new e$b(1, 114, null), null)), new e(13, 44, 44, 20, 20, new e$c(56, new e$b(1, Opcodes.D2F, null), null)), new e(14, 48, 48, 22, 22, new e$c(68, new e$b(1, Opcodes.FRETURN, null), null)), new e(15, 52, 52, 24, 24, new e$c(42, new e$b(2, 102, null), null)), new e(16, 64, 64, 14, 14, new e$c(56, new e$b(2, Opcodes.F2L, null), null)), new e(17, 72, 72, 16, 16, new e$c(36, new e$b(4, 92, null), null)), new e(18, 80, 80, 18, 18, new e$c(48, new e$b(4, 114, null), null)), new e(19, 88, 88, 20, 20, new e$c(56, new e$b(4, Opcodes.D2F, null), null)), new e(20, 96, 96, 22, 22, new e$c(68, new e$b(4, Opcodes.FRETURN, null), null)), new e(21, 104, 104, 24, 24, new e$c(56, new e$b(6, Opcodes.L2I, null), null)), new e(22, 120, 120, 18, 18, new e$c(68, new e$b(6, 175, null), null)), new e(23, Opcodes.IINC, Opcodes.IINC, 20, 20, new e$c(62, new e$b(8, Opcodes.IF_ICMPGT, null), null)), new e(24, Opcodes.D2F, Opcodes.D2F, 22, 22, new e$c(62, new e$b(8, 156, null), new e$b(2, 155, null), null)), new e(25, 8, 18, 6, 16, new e$c(7, new e$b(1, 5, null), null)), new e(26, 8, 32, 6, 14, new e$c(11, new e$b(1, 10, null), null)), new e(27, 12, 26, 10, 24, new e$c(14, new e$b(1, 16, null), null)), new e(28, 12, 36, 10, 16, new e$c(18, new e$b(1, 22, null), null)), new e(29, 16, 36, 14, 16, new e$c(24, new e$b(1, 32, null), null)), new e(30, 16, 48, 14, 22, new e$c(28, new e$b(1, 49, null), null))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1847b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final e$c g;
    public final int h;

    public e(int i, int i2, int i3, int i4, int i5, e$c e_c) {
        this.f1847b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = e_c;
        int i6 = e_c.a;
        int i7 = 0;
        for (e$b e_b : e_c.f1849b) {
            i7 += (e_b.f1848b + i6) * e_b.a;
        }
        this.h = i7;
    }

    public String toString() {
        return String.valueOf(this.f1847b);
    }
}
