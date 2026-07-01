package b.g.a.b;

/* JADX INFO: compiled from: StreamReadCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum l implements b.g.a.b.t.g {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    l(boolean z2) {
        this._defaultState = z2;
    }

    @Override // b.g.a.b.t.g
    public boolean f() {
        return this._defaultState;
    }

    @Override // b.g.a.b.t.g
    public int g() {
        return this._mask;
    }
}
