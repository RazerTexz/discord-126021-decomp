package b.i.e.o.b;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.o.b.e, reason: use source file name */
/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Version2 {
    public static final Version2[] a = {new Version2(1, 10, 10, 8, 8, new c(5, new b(1, 3, null), null)), new Version2(2, 12, 12, 10, 10, new c(7, new b(1, 5, null), null)), new Version2(3, 14, 14, 12, 12, new c(10, new b(1, 8, null), null)), new Version2(4, 16, 16, 14, 14, new c(12, new b(1, 12, null), null)), new Version2(5, 18, 18, 16, 16, new c(14, new b(1, 18, null), null)), new Version2(6, 20, 20, 18, 18, new c(18, new b(1, 22, null), null)), new Version2(7, 22, 22, 20, 20, new c(20, new b(1, 30, null), null)), new Version2(8, 24, 24, 22, 22, new c(24, new b(1, 36, null), null)), new Version2(9, 26, 26, 24, 24, new c(28, new b(1, 44, null), null)), new Version2(10, 32, 32, 14, 14, new c(36, new b(1, 62, null), null)), new Version2(11, 36, 36, 16, 16, new c(42, new b(1, 86, null), null)), new Version2(12, 40, 40, 18, 18, new c(48, new b(1, 114, null), null)), new Version2(13, 44, 44, 20, 20, new c(56, new b(1, Opcodes.D2F, null), null)), new Version2(14, 48, 48, 22, 22, new c(68, new b(1, Opcodes.FRETURN, null), null)), new Version2(15, 52, 52, 24, 24, new c(42, new b(2, 102, null), null)), new Version2(16, 64, 64, 14, 14, new c(56, new b(2, Opcodes.F2L, null), null)), new Version2(17, 72, 72, 16, 16, new c(36, new b(4, 92, null), null)), new Version2(18, 80, 80, 18, 18, new c(48, new b(4, 114, null), null)), new Version2(19, 88, 88, 20, 20, new c(56, new b(4, Opcodes.D2F, null), null)), new Version2(20, 96, 96, 22, 22, new c(68, new b(4, Opcodes.FRETURN, null), null)), new Version2(21, 104, 104, 24, 24, new c(56, new b(6, Opcodes.L2I, null), null)), new Version2(22, 120, 120, 18, 18, new c(68, new b(6, 175, null), null)), new Version2(23, Opcodes.IINC, Opcodes.IINC, 20, 20, new c(62, new b(8, Opcodes.IF_ICMPGT, null), null)), new Version2(24, Opcodes.D2F, Opcodes.D2F, 22, 22, new c(62, new b(8, 156, null), new b(2, 155, null), null)), new Version2(25, 8, 18, 6, 16, new c(7, new b(1, 5, null), null)), new Version2(26, 8, 32, 6, 14, new c(11, new b(1, 10, null), null)), new Version2(27, 12, 26, 10, 24, new c(14, new b(1, 16, null), null)), new Version2(28, 12, 36, 10, 16, new c(18, new b(1, 22, null), null)), new Version2(29, 16, 36, 14, 16, new c(24, new b(1, 32, null), null)), new Version2(30, 16, 48, 14, 22, new c(28, new b(1, 49, null), null))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1847b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final c g;
    public final int h;

    /* JADX INFO: renamed from: b.i.e.o.b.e$b */
    /* JADX INFO: compiled from: Version.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1848b;

        public b(int i, int i2, a aVar) {
            this.a = i;
            this.f1848b = i2;
        }
    }

    public Version2(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f1847b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = cVar;
        int i6 = cVar.a;
        int i7 = 0;
        for (b bVar : cVar.f1849b) {
            i7 += (bVar.f1848b + i6) * bVar.a;
        }
        this.h = i7;
    }

    public String toString() {
        return String.valueOf(this.f1847b);
    }

    /* JADX INFO: renamed from: b.i.e.o.b.e$c */
    /* JADX INFO: compiled from: Version.java */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f1849b;

        public c(int i, b bVar, a aVar) {
            this.a = i;
            this.f1849b = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2, a aVar) {
            this.a = i;
            this.f1849b = new b[]{bVar, bVar2};
        }
    }
}
