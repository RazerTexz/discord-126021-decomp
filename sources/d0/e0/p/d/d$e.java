package d0.e0.p.d;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$e extends d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.a0.b.e$b f3193b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$e(d0.e0.p.d.m0.f.a0.b.e$b e_b) {
        super(null);
        d0.z.d.m.checkNotNullParameter(e_b, "signature");
        this.f3193b = e_b;
        this.a = e_b.asString();
    }

    @Override // d0.e0.p.d.d
    public String asString() {
        return this.a;
    }

    public final String getMethodDesc() {
        return this.f3193b.getDesc();
    }

    public final String getMethodName() {
        return this.f3193b.getName();
    }
}
