package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.Internal;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum x implements Internal.a {
    INTERNAL(0),
    PRIVATE(1),
    PROTECTED(2),
    PUBLIC(3),
    PRIVATE_TO_THIS(4),
    LOCAL(5);

    private final int value;

    x(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.Internal.a
    public final int getNumber() {
        return this.value;
    }
}
