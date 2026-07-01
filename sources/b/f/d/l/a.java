package b.f.d.l;

/* JADX INFO: compiled from: TriState.java */
/* JADX INFO: loaded from: classes.dex */
public enum a {
    YES,
    NO,
    UNSET;

    public static a f(boolean z2) {
        return z2 ? YES : NO;
    }
}
