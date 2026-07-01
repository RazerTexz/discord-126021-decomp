package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.PathKeyframe;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatablePathValue;
import b.c.a.y.k.AnimatableSplitDimensionPathValue;
import b.c.a.y.k.AnimatableValue;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.c.a.a0.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatablePathValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatablePathValueParser {
    public static JsonReader2.a a = JsonReader2.a.a("k", "x", "y");

    public static AnimatablePathValue a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.a();
            while (jsonReader2.e()) {
                arrayList.add(new PathKeyframe(lottieComposition, KeyframeParser.a(jsonReader2, lottieComposition, Utils.c(), PathParser2.a, jsonReader2.u() == JsonReader2.b.BEGIN_OBJECT)));
            }
            jsonReader2.c();
            KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.b(jsonReader2, Utils.c())));
        }
        return new AnimatablePathValue(arrayList);
    }

    public static AnimatableValue<PointF, PointF> b(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        JsonReader2.b bVar = JsonReader2.b.STRING;
        jsonReader2.b();
        AnimatablePathValue animatablePathValueA = null;
        AnimatableFloatValue animatableFloatValueQ1 = null;
        AnimatableFloatValue animatableFloatValueQ2 = null;
        boolean z2 = false;
        while (jsonReader2.u() != JsonReader2.b.END_OBJECT) {
            int iY = jsonReader2.y(a);
            if (iY == 0) {
                animatablePathValueA = a(jsonReader2, lottieComposition);
            } else if (iY != 1) {
                if (iY != 2) {
                    jsonReader2.A();
                    jsonReader2.C();
                } else if (jsonReader2.u() == bVar) {
                    jsonReader2.C();
                    z2 = true;
                } else {
                    animatableFloatValueQ2 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                }
            } else if (jsonReader2.u() == bVar) {
                jsonReader2.C();
                z2 = true;
            } else {
                animatableFloatValueQ1 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
            }
        }
        jsonReader2.d();
        if (z2) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return animatablePathValueA != null ? animatablePathValueA : new AnimatableSplitDimensionPathValue(animatableFloatValueQ1, animatableFloatValueQ2);
    }
}
