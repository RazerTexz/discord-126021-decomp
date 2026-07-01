package b.g.a.b;

/* JADX INFO: compiled from: JsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public enum c$a implements b.g.a.b.t.g {
    INTERN_FIELD_NAMES(true),
    CANONICALIZE_FIELD_NAMES(true),
    FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
    USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

    private final boolean _defaultState;

    c$a(boolean z2) {
        this._defaultState = z2;
    }

    public static int h() {
        c$a[] c_aArrValues = values();
        int iG = 0;
        for (int i = 0; i < 4; i++) {
            c$a c_a = c_aArrValues[i];
            if (c_a._defaultState) {
                iG |= c_a.g();
            }
        }
        return iG;
    }

    @Override // b.g.a.b.t.g
    public boolean f() {
        return this._defaultState;
    }

    @Override // b.g.a.b.t.g
    public int g() {
        return 1 << ordinal();
    }
}
