package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum k implements d0.e0.p.d.m0.i.h$a {
    FINAL(0),
    OPEN(1),
    ABSTRACT(2),
    SEALED(3);

    private final int value;

    k(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }
}
