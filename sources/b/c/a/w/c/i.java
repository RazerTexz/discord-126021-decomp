package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f<PointF> {
    public final PointF i;
    public final float[] j;
    public h k;
    public PathMeasure l;

    public i(List<? extends b.c.a.c0.a<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.l = new PathMeasure();
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
        PointF pointF;
        h hVar = (h) aVar;
        Path path = hVar.o;
        if (path == null) {
            return (PointF) aVar.f347b;
        }
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (pointF = (PointF) cVar.a(hVar.e, hVar.f.floatValue(), hVar.f347b, hVar.c, d(), f, this.d)) != null) {
            return pointF;
        }
        if (this.k != hVar) {
            this.l.setPath(path, false);
            this.k = hVar;
        }
        PathMeasure pathMeasure = this.l;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
