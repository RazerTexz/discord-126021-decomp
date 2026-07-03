package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p090c0.C1504d;

/* JADX INFO: renamed from: b.c.a.w.c.k */
/* JADX INFO: compiled from: ScaleKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1554k extends AbstractC1549f<C1504d> {

    /* JADX INFO: renamed from: i */
    public final C1504d f2621i;

    public C1554k(List<C1501a<C1504d>> list) {
        super(list);
        this.f2621i = new C1504d();
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
    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public Object mo728f(C1501a c1501a, float f) {
        T t;
        C1504d c1504d;
        T t2 = c1501a.f2317b;
        if (t2 == 0 || (t = c1501a.f2318c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C1504d c1504d2 = (C1504d) t2;
        C1504d c1504d3 = (C1504d) t;
        C1503c<A> c1503c = this.f2600e;
        if (c1503c != 0 && (c1504d = (C1504d) c1503c.m668a(c1501a.f2320e, c1501a.f2321f.floatValue(), c1504d2, c1504d3, f, m726d(), this.f2599d)) != null) {
            return c1504d;
        }
        C1504d c1504d4 = this.f2621i;
        float fM655e = C1498f.m655e(c1504d2.f2334a, c1504d3.f2334a, f);
        float fM655e2 = C1498f.m655e(c1504d2.f2335b, c1504d3.f2335b, f);
        c1504d4.f2334a = fM655e;
        c1504d4.f2335b = fM655e2;
        return this.f2621i;
    }
}
