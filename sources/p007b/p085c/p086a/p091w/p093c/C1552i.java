package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;

/* JADX INFO: renamed from: b.c.a.w.c.i */
/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1552i extends AbstractC1549f<PointF> {

    /* JADX INFO: renamed from: i */
    public final PointF f2616i;

    /* JADX INFO: renamed from: j */
    public final float[] f2617j;

    /* JADX INFO: renamed from: k */
    public C1551h f2618k;

    /* JADX INFO: renamed from: l */
    public PathMeasure f2619l;

    public C1552i(List<? extends C1501a<PointF>> list) {
        super(list);
        this.f2616i = new PointF();
        this.f2617j = new float[2];
        this.f2619l = new PathMeasure();
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
        PointF pointF;
        C1551h c1551h = (C1551h) c1501a;
        Path path = c1551h.f2614o;
        if (path == null) {
            return (PointF) c1501a.f2317b;
        }
        C1503c<A> c1503c = this.f2600e;
        if (c1503c != 0 && (pointF = (PointF) c1503c.m668a(c1551h.f2320e, c1551h.f2321f.floatValue(), c1551h.f2317b, c1551h.f2318c, m726d(), f, this.f2599d)) != null) {
            return pointF;
        }
        if (this.f2618k != c1551h) {
            this.f2619l.setPath(path, false);
            this.f2618k = c1551h;
        }
        PathMeasure pathMeasure = this.f2619l;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.f2617j, null);
        PointF pointF2 = this.f2616i;
        float[] fArr = this.f2617j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f2616i;
    }
}
