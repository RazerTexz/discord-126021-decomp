package b.i.e.s.b;

/* JADX INFO: compiled from: ErrorCorrectionLevel.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);

    public static final f[] n;
    private final int bits;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        n = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i) {
        this.bits = i;
    }
}
