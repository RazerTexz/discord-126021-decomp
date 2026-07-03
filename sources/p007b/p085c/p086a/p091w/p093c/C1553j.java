package p007b.p085c.p086a.p091w.p093c;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.w.c.j */
/* JADX INFO: compiled from: PointKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1553j extends AbstractC1549f<PointF> {

    /* JADX INFO: renamed from: i */
    public final PointF f2620i;

    public C1553j(List<C1501a<PointF>> list) {
        super(list);
        this.f2620i = new PointF();
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
        PointF pointF;
        T t2 = c1501a.f2317b;
        if (t2 == 0 || (t = c1501a.f2318c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) t2;
        PointF pointF3 = (PointF) t;
        C1503c<A> c1503c = this.f2600e;
        if (c1503c != 0 && (pointF = (PointF) c1503c.m668a(c1501a.f2320e, c1501a.f2321f.floatValue(), pointF2, pointF3, f, m726d(), this.f2599d)) != null) {
            return pointF;
        }
        PointF pointF4 = this.f2620i;
        float f2 = pointF2.x;
        float fM839a = C1643a.m839a(pointF3.x, f2, f, f2);
        float f3 = pointF2.y;
        pointF4.set(fM839a, ((pointF3.y - f3) * f) + f3);
        return this.f2620i;
    }
}
