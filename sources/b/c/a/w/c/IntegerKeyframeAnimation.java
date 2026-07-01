package b.c.a.w.c;

import android.graphics.PointF;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.e, reason: use source file name */
/* JADX INFO: compiled from: IntegerKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        return Integer.valueOf(j(keyframe, f));
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
    public int j(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.f347b == null || keyframe.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.e;
        if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.a(keyframe.e, keyframe.f.floatValue(), keyframe.f347b, keyframe.c, f, d(), this.d)) != null) {
            return num.intValue();
        }
        if (keyframe.i == 784923401) {
            keyframe.i = keyframe.f347b.intValue();
        }
        int i = keyframe.i;
        if (keyframe.j == 784923401) {
            keyframe.j = keyframe.c.intValue();
        }
        int i2 = keyframe.j;
        PointF pointF = MiscUtils.a;
        return (int) ((f * (i2 - i)) + i);
    }
}
