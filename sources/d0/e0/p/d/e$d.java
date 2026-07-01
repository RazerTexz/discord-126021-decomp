package d0.e0.p.d;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d extends e {
    public final d$e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d$e f3196b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$d(d$e d_e, d$e d_e2) {
        super(null);
        d0.z.d.m.checkNotNullParameter(d_e, "getterSignature");
        this.a = d_e;
        this.f3196b = d_e2;
    }

    @Override // d0.e0.p.d.e
    public String asString() {
        return this.a.asString();
    }

    public final d$e getGetterSignature() {
        return this.a;
    }

    public final d$e getSetterSignature() {
        return this.f3196b;
    }
}
