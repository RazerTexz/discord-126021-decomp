package b.f.d.l;

/* JADX INFO: renamed from: b.f.d.l.a, reason: use source file name */
/* JADX INFO: compiled from: TriState.java */
/* JADX INFO: loaded from: classes.dex */
public enum TriState {
    YES,
    NO,
    UNSET;

    public static TriState f(boolean z2) {
        return z2 ? YES : NO;
    }
}
