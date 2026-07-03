package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.x */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11699x implements C11728h.a {
    INTERNAL(0),
    PRIVATE(1),
    PROTECTED(2),
    PUBLIC(3),
    PRIVATE_TO_THIS(4),
    LOCAL(5);

    private final int value;

    EnumC11699x(int i) {
        this.value = i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
    public final int getNumber() {
        return this.value;
    }
}
