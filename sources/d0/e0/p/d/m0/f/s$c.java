package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum s$c implements d0.e0.p.d.m0.i.h$a {
    IN(0),
    OUT(1),
    INV(2);

    private final int value;

    s$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static s$c valueOf(int i) {
        if (i == 0) {
            return IN;
        }
        if (i == 1) {
            return OUT;
        }
        if (i != 2) {
            return null;
        }
        return INV;
    }
}
