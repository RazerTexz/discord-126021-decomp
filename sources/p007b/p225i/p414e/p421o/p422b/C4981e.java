package p007b.p225i.p414e.p421o.p422b;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.o.b.e */
/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4981e {

    /* JADX INFO: renamed from: a */
    public static final C4981e[] f13330a = {new C4981e(1, 10, 10, 8, 8, new c(5, new b(1, 3, null), null)), new C4981e(2, 12, 12, 10, 10, new c(7, new b(1, 5, null), null)), new C4981e(3, 14, 14, 12, 12, new c(10, new b(1, 8, null), null)), new C4981e(4, 16, 16, 14, 14, new c(12, new b(1, 12, null), null)), new C4981e(5, 18, 18, 16, 16, new c(14, new b(1, 18, null), null)), new C4981e(6, 20, 20, 18, 18, new c(18, new b(1, 22, null), null)), new C4981e(7, 22, 22, 20, 20, new c(20, new b(1, 30, null), null)), new C4981e(8, 24, 24, 22, 22, new c(24, new b(1, 36, null), null)), new C4981e(9, 26, 26, 24, 24, new c(28, new b(1, 44, null), null)), new C4981e(10, 32, 32, 14, 14, new c(36, new b(1, 62, null), null)), new C4981e(11, 36, 36, 16, 16, new c(42, new b(1, 86, null), null)), new C4981e(12, 40, 40, 18, 18, new c(48, new b(1, 114, null), null)), new C4981e(13, 44, 44, 20, 20, new c(56, new b(1, Opcodes.D2F, null), null)), new C4981e(14, 48, 48, 22, 22, new c(68, new b(1, Opcodes.FRETURN, null), null)), new C4981e(15, 52, 52, 24, 24, new c(42, new b(2, 102, null), null)), new C4981e(16, 64, 64, 14, 14, new c(56, new b(2, Opcodes.F2L, null), null)), new C4981e(17, 72, 72, 16, 16, new c(36, new b(4, 92, null), null)), new C4981e(18, 80, 80, 18, 18, new c(48, new b(4, 114, null), null)), new C4981e(19, 88, 88, 20, 20, new c(56, new b(4, Opcodes.D2F, null), null)), new C4981e(20, 96, 96, 22, 22, new c(68, new b(4, Opcodes.FRETURN, null), null)), new C4981e(21, 104, 104, 24, 24, new c(56, new b(6, Opcodes.L2I, null), null)), new C4981e(22, 120, 120, 18, 18, new c(68, new b(6, 175, null), null)), new C4981e(23, Opcodes.IINC, Opcodes.IINC, 20, 20, new c(62, new b(8, Opcodes.IF_ICMPGT, null), null)), new C4981e(24, Opcodes.D2F, Opcodes.D2F, 22, 22, new c(62, new b(8, 156, null), new b(2, 155, null), null)), new C4981e(25, 8, 18, 6, 16, new c(7, new b(1, 5, null), null)), new C4981e(26, 8, 32, 6, 14, new c(11, new b(1, 10, null), null)), new C4981e(27, 12, 26, 10, 24, new c(14, new b(1, 16, null), null)), new C4981e(28, 12, 36, 10, 16, new c(18, new b(1, 22, null), null)), new C4981e(29, 16, 36, 14, 16, new c(24, new b(1, 32, null), null)), new C4981e(30, 16, 48, 14, 22, new c(28, new b(1, 49, null), null))};

    /* JADX INFO: renamed from: b */
    public final int f13331b;

    /* JADX INFO: renamed from: c */
    public final int f13332c;

    /* JADX INFO: renamed from: d */
    public final int f13333d;

    /* JADX INFO: renamed from: e */
    public final int f13334e;

    /* JADX INFO: renamed from: f */
    public final int f13335f;

    /* JADX INFO: renamed from: g */
    public final c f13336g;

    /* JADX INFO: renamed from: h */
    public final int f13337h;

    /* JADX INFO: renamed from: b.i.e.o.b.e$b */
    /* JADX INFO: compiled from: Version.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f13338a;

        /* JADX INFO: renamed from: b */
        public final int f13339b;

        public b(int i, int i2, a aVar) {
            this.f13338a = i;
            this.f13339b = i2;
        }
    }

    public C4981e(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f13331b = i;
        this.f13332c = i2;
        this.f13333d = i3;
        this.f13334e = i4;
        this.f13335f = i5;
        this.f13336g = cVar;
        int i6 = cVar.f13340a;
        int i7 = 0;
        for (b bVar : cVar.f13341b) {
            i7 += (bVar.f13339b + i6) * bVar.f13338a;
        }
        this.f13337h = i7;
    }

    public String toString() {
        return String.valueOf(this.f13331b);
    }

    /* JADX INFO: renamed from: b.i.e.o.b.e$c */
    /* JADX INFO: compiled from: Version.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f13340a;

        /* JADX INFO: renamed from: b */
        public final b[] f13341b;

        public c(int i, b bVar, a aVar) {
            this.f13340a = i;
            this.f13341b = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2, a aVar) {
            this.f13340a = i;
            this.f13341b = new b[]{bVar, bVar2};
        }
    }
}
