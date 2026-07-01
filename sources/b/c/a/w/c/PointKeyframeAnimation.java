package b.c.a.w.c;

import android.graphics.PointF;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.j, reason: use source file name */
/* JADX INFO: compiled from: PointKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF i;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.i = new PointF();
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
        T t;
        PointF pointF;
        T t2 = keyframe.f347b;
        if (t2 == 0 || (t = keyframe.c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) t2;
        PointF pointF3 = (PointF) t;
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), pointF2, pointF3, f, d(), this.d)) != null) {
            return pointF;
        }
        PointF pointF4 = this.i;
        float f2 = pointF2.x;
        float fA = outline.a(pointF3.x, f2, f, f2);
        float f3 = pointF2.y;
        pointF4.set(fA, ((pointF3.y - f3) * f) + f3);
        return this.i;
    }
}
