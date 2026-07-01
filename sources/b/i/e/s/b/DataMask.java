package b.i.e.s.b;

import b.i.e.n.BitMatrix;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.e.s.b.c, reason: use source file name */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DataMask {
    public static final DataMask j;
    public static final DataMask k;
    public static final DataMask l;
    public static final DataMask m;
    public static final DataMask n;
    public static final DataMask o;
    public static final DataMask p;
    public static final DataMask q;
    public static final /* synthetic */ DataMask[] r;

    /* JADX INFO: renamed from: b.i.e.s.b.c$a */
    /* JADX INFO: compiled from: DataMask.java */
    public static enum a extends DataMask {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.e.s.b.DataMask
        public boolean f(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        j = aVar;
        DataMask dataMask = new DataMask("DATA_MASK_001", 1) { // from class: b.i.e.s.b.c.b
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return (i & 1) == 0;
            }
        };
        k = dataMask;
        DataMask dataMask2 = new DataMask("DATA_MASK_010", 2) { // from class: b.i.e.s.b.c.c
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return i2 % 3 == 0;
            }
        };
        l = dataMask2;
        DataMask dataMask3 = new DataMask("DATA_MASK_011", 3) { // from class: b.i.e.s.b.c.d
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return (i + i2) % 3 == 0;
            }
        };
        m = dataMask3;
        DataMask dataMask4 = new DataMask("DATA_MASK_100", 4) { // from class: b.i.e.s.b.c.e
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return (((i2 / 3) + (i / 2)) & 1) == 0;
            }
        };
        n = dataMask4;
        DataMask dataMask5 = new DataMask("DATA_MASK_101", 5) { // from class: b.i.e.s.b.c.f
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return (i * i2) % 6 == 0;
            }
        };
        o = dataMask5;
        DataMask dataMask6 = new DataMask("DATA_MASK_110", 6) { // from class: b.i.e.s.b.c.g
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return (i * i2) % 6 < 3;
            }
        };
        p = dataMask6;
        DataMask dataMask7 = new DataMask("DATA_MASK_111", 7) { // from class: b.i.e.s.b.c.h
            @Override // b.i.e.s.b.DataMask
            public boolean f(int i, int i2) {
                return ((((i * i2) % 3) + (i + i2)) & 1) == 0;
            }
        };
        q = dataMask7;
        r = new DataMask[]{aVar, dataMask, dataMask2, dataMask3, dataMask4, dataMask5, dataMask6, dataMask7};
    }

    public DataMask(String str, int i, a aVar) {
        super(str, i);
    }

    public static DataMask valueOf(String str) {
        return (DataMask) Enum.valueOf(DataMask.class, str);
    }

    public static DataMask[] values() {
        return (DataMask[]) r.clone();
    }

    public abstract boolean f(int i, int i2);

    public final void g(BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (f(i2, i3)) {
                    bitMatrix.b(i3, i2);
                }
            }
        }
    }
}
