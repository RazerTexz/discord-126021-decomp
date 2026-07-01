package b.g.a.b;

import b.g.a.b.t.JacksonFeature;

/* JADX INFO: renamed from: b.g.a.b.m, reason: use source file name */
/* JADX INFO: compiled from: StreamWriteCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum StreamWriteCapability implements JacksonFeature {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamWriteCapability(boolean z2) {
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
