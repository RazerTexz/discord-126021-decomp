package b.c.a.a0;

import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.PathKeyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.a0.r, reason: use source file name */
/* JADX INFO: compiled from: KeyframesParser.java */
/* JADX INFO: loaded from: classes.dex */
public class KeyframesParser {
    public static JsonReader2.a a = JsonReader2.a.a("k");

    public static <T> List<Keyframe<T>> a(JsonReader2 jsonReader2, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader2.u() == JsonReader2.b.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader2.b();
        while (jsonReader2.e()) {
            if (jsonReader2.y(a) != 0) {
                jsonReader2.C();
            } else if (jsonReader2.u() == JsonReader2.b.BEGIN_ARRAY) {
                jsonReader2.a();
                if (jsonReader2.u() == JsonReader2.b.NUMBER) {
                    arrayList.add(KeyframeParser.a(jsonReader2, lottieComposition, f, valueParser, false));
                } else {
                    while (jsonReader2.e()) {
                        arrayList.add(KeyframeParser.a(jsonReader2, lottieComposition, f, valueParser, true));
                    }
                }
                jsonReader2.c();
            } else {
                arrayList.add(KeyframeParser.a(jsonReader2, lottieComposition, f, valueParser, false));
            }
        }
        jsonReader2.d();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends Keyframe<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe<T> keyframe = list.get(i2);
            i2++;
            Keyframe<T> keyframe2 = list.get(i2);
            keyframe.f = Float.valueOf(keyframe2.e);
            if (keyframe.c == null && (t = keyframe2.f347b) != null) {
                keyframe.c = t;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).e();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i);
        if ((keyframe3.f347b == null || keyframe3.c == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
