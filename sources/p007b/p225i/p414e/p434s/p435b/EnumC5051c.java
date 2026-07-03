package p007b.p225i.p414e.p434s.p435b;

import p007b.p225i.p414e.p418n.C4963b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.e.s.b.c */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumC5051c {

    /* JADX INFO: renamed from: j */
    public static final EnumC5051c f13516j;

    /* JADX INFO: renamed from: k */
    public static final EnumC5051c f13517k;

    /* JADX INFO: renamed from: l */
    public static final EnumC5051c f13518l;

    /* JADX INFO: renamed from: m */
    public static final EnumC5051c f13519m;

    /* JADX INFO: renamed from: n */
    public static final EnumC5051c f13520n;

    /* JADX INFO: renamed from: o */
    public static final EnumC5051c f13521o;

    /* JADX INFO: renamed from: p */
    public static final EnumC5051c f13522p;

    /* JADX INFO: renamed from: q */
    public static final EnumC5051c f13523q;

    /* JADX INFO: renamed from: r */
    public static final /* synthetic */ EnumC5051c[] f13524r;

    /* JADX INFO: renamed from: b.i.e.s.b.c$a */
    /* JADX INFO: compiled from: DataMask.java */
    public static enum a extends EnumC5051c {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
        /* JADX INFO: renamed from: f */
        public boolean mo7089f(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f13516j = aVar;
        EnumC5051c enumC5051c = new EnumC5051c("DATA_MASK_001", 1) { // from class: b.i.e.s.b.c.b
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return (i & 1) == 0;
            }
        };
        f13517k = enumC5051c;
        EnumC5051c enumC5051c2 = new EnumC5051c("DATA_MASK_010", 2) { // from class: b.i.e.s.b.c.c
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return i2 % 3 == 0;
            }
        };
        f13518l = enumC5051c2;
        EnumC5051c enumC5051c3 = new EnumC5051c("DATA_MASK_011", 3) { // from class: b.i.e.s.b.c.d
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return (i + i2) % 3 == 0;
            }
        };
        f13519m = enumC5051c3;
        EnumC5051c enumC5051c4 = new EnumC5051c("DATA_MASK_100", 4) { // from class: b.i.e.s.b.c.e
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return (((i2 / 3) + (i / 2)) & 1) == 0;
            }
        };
        f13520n = enumC5051c4;
        EnumC5051c enumC5051c5 = new EnumC5051c("DATA_MASK_101", 5) { // from class: b.i.e.s.b.c.f
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return (i * i2) % 6 == 0;
            }
        };
        f13521o = enumC5051c5;
        EnumC5051c enumC5051c6 = new EnumC5051c("DATA_MASK_110", 6) { // from class: b.i.e.s.b.c.g
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return (i * i2) % 6 < 3;
            }
        };
        f13522p = enumC5051c6;
        EnumC5051c enumC5051c7 = new EnumC5051c("DATA_MASK_111", 7) { // from class: b.i.e.s.b.c.h
            @Override // p007b.p225i.p414e.p434s.p435b.EnumC5051c
            /* JADX INFO: renamed from: f */
            public boolean mo7089f(int i, int i2) {
                return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
            }
        };
        f13523q = enumC5051c7;
        f13524r = new EnumC5051c[]{aVar, enumC5051c, enumC5051c2, enumC5051c3, enumC5051c4, enumC5051c5, enumC5051c6, enumC5051c7};
    }

    public EnumC5051c(String str, int i, a aVar) {
        super(str, i);
    }

    public static EnumC5051c valueOf(String str) {
        return (EnumC5051c) Enum.valueOf(EnumC5051c.class, str);
    }

    public static EnumC5051c[] values() {
        return (EnumC5051c[]) f13524r.clone();
    }

    /* JADX INFO: renamed from: f */
    public abstract boolean mo7089f(int i, int i2);

    /* JADX INFO: renamed from: g */
    public final void m7090g(C4963b c4963b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo7089f(i2, i3)) {
                    c4963b.m6941b(i3, i2);
                }
            }
        }
    }
}
