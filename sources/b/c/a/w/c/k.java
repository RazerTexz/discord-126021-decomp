package b.c.a.w.c;

import java.util.List;

/* JADX INFO: compiled from: ScaleKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends f<b.c.a.c0.d> {
    public final b.c.a.c0.d i;

    public k(List<b.c.a.c0.a<b.c.a.c0.d>> list) {
        super(list);
        this.i = new b.c.a.c0.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        T t;
        b.c.a.c0.d dVar;
        T t2 = aVar.f347b;
        if (t2 == 0 || (t = aVar.c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b.c.a.c0.d dVar2 = (b.c.a.c0.d) t2;
        b.c.a.c0.d dVar3 = (b.c.a.c0.d) t;
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (dVar = (b.c.a.c0.d) cVar.a(aVar.e, aVar.f.floatValue(), dVar2, dVar3, f, d(), this.d)) != null) {
            return dVar;
        }
        b.c.a.c0.d dVar4 = this.i;
        float fE = b.c.a.b0.f.e(dVar2.a, dVar3.a, f);
        float fE2 = b.c.a.b0.f.e(dVar2.f350b, dVar3.f350b, f);
        dVar4.a = fE;
        dVar4.f350b = fE2;
        return this.i;
    }
}
