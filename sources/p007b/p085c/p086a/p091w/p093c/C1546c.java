package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;

/* JADX INFO: renamed from: b.c.a.w.c.c */
/* JADX INFO: compiled from: FloatKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1546c extends AbstractC1549f<Float> {
    public C1546c(List<C1501a<Float>> list) {
        super(list);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public Object mo728f(C1501a c1501a, float f) {
        return Float.valueOf(m740k(c1501a, f));
    }

    /* JADX INFO: renamed from: j */
    public float m739j() {
        return m740k(m723a(), m725c());
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
    /* JADX INFO: renamed from: k */
    public float m740k(C1501a<Float> c1501a, float f) {
        Float f2;
        if (c1501a.f2317b == null || c1501a.f2318c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C1503c<A> c1503c = this.f2600e;
        if (c1503c != 0 && (f2 = (Float) c1503c.m668a(c1501a.f2320e, c1501a.f2321f.floatValue(), c1501a.f2317b, c1501a.f2318c, f, m726d(), this.f2599d)) != null) {
            return f2.floatValue();
        }
        if (c1501a.f2322g == -3987645.8f) {
            c1501a.f2322g = c1501a.f2317b.floatValue();
        }
        float f3 = c1501a.f2322g;
        if (c1501a.f2323h == -3987645.8f) {
            c1501a.f2323h = c1501a.f2318c.floatValue();
        }
        return C1498f.m655e(f3, c1501a.f2323h, f);
    }
}
