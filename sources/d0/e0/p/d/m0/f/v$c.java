package d0.e0.p.d.m0.f;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum v$c implements d0.e0.p.d.m0.i.h$a {
    WARNING(0),
    ERROR(1),
    HIDDEN(2);

    private final int value;

    v$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static v$c valueOf(int i) {
        if (i == 0) {
            return WARNING;
        }
        if (i == 1) {
            return ERROR;
        }
        if (i != 2) {
            return null;
        }
        return HIDDEN;
    }
}
