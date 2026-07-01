package d0.e0.p.d.m0.k.a0;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends c {
    public static final c$a a = new c$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3452b;

    static {
        d$a d_a = d.a;
        f3452b = (~(d_a.getVARIABLES_MASK() | d_a.getFUNCTIONS_MASK())) & d_a.getALL_KINDS_MASK();
    }

    @Override // d0.e0.p.d.m0.k.a0.c
    public int getFullyExcludedDescriptorKinds() {
        return f3452b;
    }
}
