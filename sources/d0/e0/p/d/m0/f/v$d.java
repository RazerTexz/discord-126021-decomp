package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum v$d implements d0.e0.p.d.m0.i.h$a {
    LANGUAGE_VERSION(0),
    COMPILER_VERSION(1),
    API_VERSION(2);

    private final int value;

    v$d(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static v$d valueOf(int i) {
        if (i == 0) {
            return LANGUAGE_VERSION;
        }
        if (i == 1) {
            return COMPILER_VERSION;
        }
        if (i != 2) {
            return null;
        }
        return API_VERSION;
    }
}
