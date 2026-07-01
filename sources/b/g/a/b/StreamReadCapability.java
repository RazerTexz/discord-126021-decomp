package b.g.a.b;

import b.g.a.b.t.JacksonFeature;

/* JADX INFO: renamed from: b.g.a.b.l, reason: use source file name */
/* JADX INFO: compiled from: StreamReadCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum StreamReadCapability implements JacksonFeature {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamReadCapability(boolean z2) {
        this._defaultState = z2;
    }

    @Override // b.g.a.b.t.JacksonFeature
    public boolean f() {
        return this._defaultState;
    }

    @Override // b.g.a.b.t.JacksonFeature
    public int g() {
        return this._mask;
    }
}
