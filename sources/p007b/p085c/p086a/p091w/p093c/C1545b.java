package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;

/* JADX INFO: renamed from: b.c.a.w.c.b */
/* JADX INFO: compiled from: ColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1545b extends AbstractC1549f<Integer> {
    public C1545b(List<C1501a<Integer>> list) {
        super(list);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public Object mo728f(C1501a c1501a, float f) {
        return Integer.valueOf(m738j(c1501a, f));
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
    /* JADX INFO: renamed from: j */
    public int m738j(C1501a<Integer> c1501a, float f) {
        Integer num;
        Integer num2 = c1501a.f2317b;
        if (num2 == null || c1501a.f2318c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = c1501a.f2318c.intValue();
        C1503c<A> c1503c = this.f2600e;
        return (c1503c == 0 || (num = (Integer) c1503c.m668a(c1501a.f2320e, c1501a.f2321f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, m726d(), this.f2599d)) == null) ? C1460d.m528i0(C1498f.m652b(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }
}
