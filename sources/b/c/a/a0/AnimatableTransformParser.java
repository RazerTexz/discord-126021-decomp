package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.c0.Keyframe;
import b.c.a.c0.ScaleXY;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePathValue;
import b.c.a.y.k.AnimatableScaleValue;
import b.c.a.y.k.AnimatableSplitDimensionPathValue;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.k.AnimatableValue;
import java.io.IOException;

/* JADX INFO: renamed from: b.c.a.a0.c, reason: use source file name */
/* JADX INFO: compiled from: AnimatableTransformParser.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableTransformParser {
    public static JsonReader2.a a = JsonReader2.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonReader2.a f328b = JsonReader2.a.a("k");

    /* JADX WARN: Code duplicated, block: B:113:0x0219  */
    /* JADX WARN: Code duplicated, block: B:114:0x021c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x009b  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static AnimatableTransform a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        boolean z2;
        AnimatableFloatValue animatableFloatValue;
        boolean z3;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableScaleValue animatableScaleValue;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableValue<PointF, PointF> animatableValue;
        AnimatableFloatValue animatableFloatValueR1;
        AnimatableFloatValue animatableFloatValue4;
        boolean z4 = false;
        boolean z5 = jsonReader2.u() == JsonReader2.b.BEGIN_OBJECT;
        if (z5) {
            jsonReader2.b();
        }
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableScaleValue animatableScaleValue2 = null;
        AnimatableValue<PointF, PointF> animatableValueB = null;
        AnimatableFloatValue animatableFloatValueR2 = null;
        AnimatableFloatValue animatableFloatValueR3 = null;
        AnimatablePathValue animatablePathValueA = null;
        AnimatableIntegerValue animatableIntegerValueS1 = null;
        AnimatableFloatValue animatableFloatValueR4 = null;
        AnimatableFloatValue animatableFloatValueR5 = null;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(a)) {
                case 0:
                    animatableScaleValue = animatableScaleValue2;
                    animatableFloatValue3 = animatableFloatValueR2;
                    animatableValue = animatableValueB;
                    jsonReader2.b();
                    while (jsonReader2.e()) {
                        if (jsonReader2.y(f328b) != 0) {
                            jsonReader2.A();
                            jsonReader2.C();
                        } else {
                            animatablePathValueA = AnimatablePathValueParser.a(jsonReader2, lottieComposition);
                        }
                    }
                    jsonReader2.d();
                    animatableScaleValue2 = animatableScaleValue;
                    animatableValueB = animatableValue;
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
                case 1:
                    animatableFloatValue3 = animatableFloatValueR2;
                    animatableValueB = AnimatablePathValueParser.b(jsonReader2, lottieComposition);
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
                case 2:
                    animatableFloatValue3 = animatableFloatValueR2;
                    animatableValue = animatableValueB;
                    animatableScaleValue2 = new AnimatableScaleValue(AnimatableValueParser.o1(jsonReader2, lottieComposition, ScaleXYParser.a));
                    animatableValueB = animatableValue;
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
                case 3:
                    lottieComposition.a("Lottie doesn't support 3D layers.");
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    if (animatableFloatValueR1.a.isEmpty()) {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue = animatableScaleValue2;
                        animatableFloatValue3 = animatableFloatValueR2;
                        animatableValue = animatableValueB;
                        animatableFloatValueR1.a.add((Keyframe<V>) new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                    } else {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue = animatableScaleValue2;
                        animatableFloatValue3 = animatableFloatValueR2;
                        animatableValue = animatableValueB;
                        if (((Keyframe) animatableFloatValue4.a.get(0)).f347b == 0) {
                            animatableFloatValue4.a.set(0, (Keyframe<V>) new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                        }
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue2 = animatableScaleValue;
                    animatableValueB = animatableValue;
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
                case 4:
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    if (animatableFloatValueR1.a.isEmpty()) {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue = animatableScaleValue2;
                        animatableFloatValue3 = animatableFloatValueR2;
                        animatableValue = animatableValueB;
                        animatableFloatValueR1.a.add((Keyframe<V>) new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                    } else {
                        animatableFloatValue4 = animatableFloatValueR1;
                        animatableScaleValue = animatableScaleValue2;
                        animatableFloatValue3 = animatableFloatValueR2;
                        animatableValue = animatableValueB;
                        if (((Keyframe) animatableFloatValue4.a.get(0)).f347b == 0) {
                            animatableFloatValue4.a.set(0, (Keyframe<V>) new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.l)));
                        }
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue2 = animatableScaleValue;
                    animatableValueB = animatableValue;
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
                case 5:
                    animatableIntegerValueS1 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                    break;
                case 6:
                    animatableFloatValueR4 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    break;
                case 7:
                    animatableFloatValueR5 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    break;
                case 8:
                    animatableFloatValueR3 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    break;
                case 9:
                    animatableFloatValueR2 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z4);
                    break;
                default:
                    animatableFloatValue3 = animatableFloatValueR2;
                    jsonReader2.A();
                    jsonReader2.C();
                    animatableFloatValueR2 = animatableFloatValue3;
                    z4 = false;
                    break;
            }
        }
        AnimatableScaleValue animatableScaleValue3 = animatableScaleValue2;
        AnimatableFloatValue animatableFloatValue6 = animatableFloatValueR2;
        AnimatableValue<PointF, PointF> animatableValue2 = animatableValueB;
        if (z5) {
            jsonReader2.d();
        }
        if (animatablePathValueA == null || (animatablePathValueA.isStatic() && animatablePathValueA.a.get(0).f347b.equals(0.0f, 0.0f))) {
            animatablePathValueA = null;
        }
        if (animatableValue2 == null || (!(animatableValue2 instanceof AnimatableSplitDimensionPathValue) && animatableValue2.isStatic() && animatableValue2.b().get(0).f347b.equals(0.0f, 0.0f))) {
            animatableValue2 = null;
        }
        AnimatableFloatValue animatableFloatValue7 = animatableFloatValue5 == null || (animatableFloatValue5.isStatic() && (((Float) ((Keyframe) animatableFloatValue5.a.get(0)).f347b).floatValue() > 0.0f ? 1 : (((Float) ((Keyframe) animatableFloatValue5.a.get(0)).f347b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : animatableFloatValue5;
        if (animatableScaleValue3 != 0) {
            if (animatableScaleValue3.isStatic()) {
                ScaleXY scaleXY = (ScaleXY) ((Keyframe) animatableScaleValue3.a.get(0)).f347b;
                z2 = (scaleXY.a > 1.0f ? 1 : (scaleXY.a == 1.0f ? 0 : -1)) == 0 && (scaleXY.f350b > 1.0f ? 1 : (scaleXY.f350b == 1.0f ? 0 : -1)) == 0;
            }
        }
        AnimatableScaleValue animatableScaleValue4 = z2 ? null : animatableScaleValue3;
        if (animatableFloatValueR3 == null || (animatableFloatValueR3.isStatic() && ((Float) ((Keyframe) animatableFloatValueR3.a.get(0)).f347b).floatValue() == 0.0f)) {
            animatableFloatValueR3 = null;
        }
        if (animatableFloatValue6 != null) {
            animatableFloatValue = animatableFloatValue6;
            z3 = animatableFloatValue6.isStatic() && ((Float) ((Keyframe) animatableFloatValue.a.get(0)).f347b).floatValue() == 0.0f;
            if (z3) {
                animatableFloatValue2 = null;
            } else {
                animatableFloatValue2 = animatableFloatValue;
            }
            return new AnimatableTransform(animatablePathValueA, animatableValue2, animatableScaleValue4, animatableFloatValue7, animatableIntegerValueS1, animatableFloatValueR4, animatableFloatValueR5, animatableFloatValueR3, animatableFloatValue2);
        }
        animatableFloatValue = animatableFloatValue6;
        if (z3) {
            animatableFloatValue2 = null;
        } else {
            animatableFloatValue2 = animatableFloatValue;
        }
        return new AnimatableTransform(animatablePathValueA, animatableValue2, animatableScaleValue4, animatableFloatValue7, animatableIntegerValueS1, animatableFloatValueR4, animatableFloatValueR5, animatableFloatValueR3, animatableFloatValue2);
    }
}
