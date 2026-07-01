package b.g.a.a;

/* JADX INFO: compiled from: OptBoolean.java */
/* JADX INFO: loaded from: classes3.dex */
public enum m0 {
    TRUE,
    FALSE,
    DEFAULT;

    public Boolean f() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
