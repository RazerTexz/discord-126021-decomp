package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum q$b$c implements d0.e0.p.d.m0.i.h$a {
    IN(0),
    OUT(1),
    INV(2),
    STAR(3);

    private final int value;

    q$b$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static q$b$c valueOf(int i) {
        if (i == 0) {
            return IN;
        }
        if (i == 1) {
            return OUT;
        }
        if (i == 2) {
            return INV;
        }
        if (i != 3) {
            return null;
        }
        return STAR;
    }
}
