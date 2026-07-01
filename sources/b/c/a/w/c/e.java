package b.c.a.w.c;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: IntegerKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<b.c.a.c0.a<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        return Integer.valueOf(j(aVar, f));
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
    public int j(b.c.a.c0.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.f347b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (num = (Integer) cVar.a(aVar.e, aVar.f.floatValue(), aVar.f347b, aVar.c, f, d(), this.d)) != null) {
            return num.intValue();
        }
        if (aVar.i == 784923401) {
            aVar.i = aVar.f347b.intValue();
        }
        int i = aVar.i;
        if (aVar.j == 784923401) {
            aVar.j = aVar.c.intValue();
        }
        int i2 = aVar.j;
        PointF pointF = b.c.a.b0.f.a;
        return (int) ((f * (i2 - i)) + i);
    }
}
