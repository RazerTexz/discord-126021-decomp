package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.Internal;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum j implements Internal.a {
    DECLARATION(0),
    FAKE_OVERRIDE(1),
    DELEGATION(2),
    SYNTHESIZED(3);

    private final int value;

    j(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.Internal.a
    public final int getNumber() {
        return this.value;
    }
}
