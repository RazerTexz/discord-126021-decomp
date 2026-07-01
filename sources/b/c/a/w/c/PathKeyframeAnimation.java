package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.i, reason: use source file name */
/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF i;
    public final float[] j;
    public PathKeyframe k;
    public PathMeasure l;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
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
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.o;
        if (path == null) {
            return (PointF) keyframe.f347b;
        }
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.a(pathKeyframe.e, pathKeyframe.f.floatValue(), pathKeyframe.f347b, pathKeyframe.c, d(), f, this.d)) != null) {
            return pointF;
        }
        if (this.k != pathKeyframe) {
            this.l.setPath(path, false);
            this.k = pathKeyframe;
        }
        PathMeasure pathMeasure = this.l;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.j, null);
        PointF pointF2 = this.i;
        float[] fArr = this.j;
        pointF2.set(fArr[0], fArr[1]);
        return this.i;
    }
}
