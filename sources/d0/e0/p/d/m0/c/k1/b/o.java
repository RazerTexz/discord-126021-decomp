package d0.e0.p.d.m0.c.k1.b;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d implements d0.e0.p.d.m0.e.a.k0.m {
    public final Enum<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.g.e eVar, Enum<?> r3) {
        super(eVar);
        d0.z.d.m.checkNotNullParameter(r3, "value");
        this.c = r3;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.m
    public d0.e0.p.d.m0.g.e getEntryName() {
        return d0.e0.p.d.m0.g.e.identifier(this.c.name());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.m
    public d0.e0.p.d.m0.g.a getEnumClassId() {
        Class<?> enclosingClass = this.c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        d0.z.d.m.checkNotNullExpressionValue(enclosingClass, "enumClass");
        return b.getClassId(enclosingClass);
    }
}
