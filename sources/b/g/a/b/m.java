package b.g.a.b;

/* JADX INFO: compiled from: StreamWriteCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum m implements b.g.a.b.t.g {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    m(boolean z2) {
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
