package p007b.p195g.p196a.p197a;

/* JADX INFO: renamed from: b.g.a.a.m0 */
/* JADX INFO: compiled from: OptBoolean.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2090m0 {
    TRUE,
    FALSE,
    DEFAULT;

    /* JADX INFO: renamed from: f */
    public Boolean m1613f() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
