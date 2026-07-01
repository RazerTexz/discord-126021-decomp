package d0.e0.p.d.m0.c.k1.b;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends d implements d0.e0.p.d.m0.e.a.k0.o {
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d0.e0.p.d.m0.g.e eVar, Object obj) {
        super(eVar);
        d0.z.d.m.checkNotNullParameter(obj, "value");
        this.c = obj;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.o
    public Object getValue() {
        return this.c;
    }
}
