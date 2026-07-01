package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f$c implements d0.e0.p.d.m0.i.h$a {
    RETURNS_CONSTANT(0),
    CALLS(1),
    RETURNS_NOT_NULL(2);

    private final int value;

    f$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static f$c valueOf(int i) {
        if (i == 0) {
            return RETURNS_CONSTANT;
        }
        if (i == 1) {
            return CALLS;
        }
        if (i != 2) {
            return null;
        }
        return RETURNS_NOT_NULL;
    }
}
