package b.c.a.w.c;

import java.util.List;

/* JADX INFO: compiled from: FloatKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<b.c.a.c0.a<Float>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        return Float.valueOf(k(aVar, f));
    }

    public float j() {
        return k(a(), c());
    }

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
    public float k(b.c.a.c0.a<Float> aVar, float f) {
        Float f2;
        if (aVar.f347b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (f2 = (Float) cVar.a(aVar.e, aVar.f.floatValue(), aVar.f347b, aVar.c, f, d(), this.d)) != null) {
            return f2.floatValue();
        }
        if (aVar.g == -3987645.8f) {
            aVar.g = aVar.f347b.floatValue();
        }
        float f3 = aVar.g;
        if (aVar.h == -3987645.8f) {
            aVar.h = aVar.c.floatValue();
        }
        return b.c.a.b0.f.e(f3, aVar.h, f);
    }
}
