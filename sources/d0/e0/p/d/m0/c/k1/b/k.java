package d0.e0.p.d.m0.c.k1.b;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends d implements d0.e0.p.d.m0.e.a.k0.h {
    public final Class<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d0.e0.p.d.m0.g.e eVar, Class<?> cls) {
        super(eVar);
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        this.c = cls;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.h
    public d0.e0.p.d.m0.e.a.k0.x getReferencedType() {
        return w.a.create(this.c);
    }
}
