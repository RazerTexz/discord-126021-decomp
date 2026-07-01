package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum h$c implements d0.e0.p.d.m0.i.h$a {
    TRUE(0),
    FALSE(1),
    NULL(2);

    private final int value;

    h$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static h$c valueOf(int i) {
        if (i == 0) {
            return TRUE;
        }
        if (i == 1) {
            return FALSE;
        }
        if (i != 2) {
            return null;
        }
        return NULL;
    }
}
