package b.c.a.a0;

import android.graphics.Color;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatableShapeValue;
import b.c.a.y.k.AnimatableTextFrame;
import b.c.a.y.k.AnimatableTextProperties;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.l.Mask;
import b.c.a.y.m.Layer2;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.c.a.a0.s, reason: use source file name */
/* JADX INFO: compiled from: LayerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class LayerParser {
    public static final JsonReader2.a a = JsonReader2.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader2.a f342b = JsonReader2.a.a("d", "a");
    public static final JsonReader2.a c = JsonReader2.a.a("nm");

    /* JADX WARN: Code duplicated, block: B:113:0x0254  */
    /* JADX WARN: Code duplicated, block: B:146:0x02af  */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    public static Layer2 a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        long j;
        byte b2;
        byte b3;
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader2.b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jQ = -1;
        float fN = 0.0f;
        String strT = null;
        Layer2.a aVar = null;
        String strT2 = null;
        AnimatableTransform animatableTransformA = null;
        int iC = 0;
        int iC2 = 0;
        int color = 0;
        float fN2 = 1.0f;
        float fN3 = 0.0f;
        int iC3 = 0;
        int iC4 = 0;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        int i2 = 1;
        AnimatableFloatValue animatableFloatValueR1 = null;
        boolean zF = false;
        long jQ2 = 0;
        String strT3 = "UNSET";
        float fN4 = 0.0f;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(a)) {
                case 0:
                    strT = strT;
                    strT3 = jsonReader2.t();
                    strT = strT;
                    break;
                case 1:
                    strT = strT;
                    jQ2 = jsonReader2.q();
                    strT = strT;
                    break;
                case 2:
                    strT = strT;
                    strT2 = jsonReader2.t();
                    strT = strT;
                    break;
                case 3:
                    strT = strT;
                    j = jQ2;
                    int iQ = jsonReader2.q();
                    aVar = iQ < 6 ? Layer2.a.values()[iQ] : Layer2.a.UNKNOWN;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 4:
                    strT = strT;
                    j = jQ2;
                    jQ = jsonReader2.q();
                    jQ2 = j;
                    strT = strT;
                    break;
                case 5:
                    strT = strT;
                    iC = (int) (Utils.c() * jsonReader2.q());
                    strT = strT;
                    break;
                case 6:
                    strT = strT;
                    iC2 = (int) (Utils.c() * jsonReader2.q());
                    strT = strT;
                    break;
                case 7:
                    strT = strT;
                    color = Color.parseColor(jsonReader2.t());
                    strT = strT;
                    break;
                case 8:
                    strT = strT;
                    animatableTransformA = AnimatableTransformParser.a(jsonReader2, lottieComposition);
                    strT = strT;
                    break;
                case 9:
                    strT = strT;
                    j = jQ2;
                    i2 = b.c.a.y.b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[jsonReader2.q()];
                    lottieComposition.o++;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 10:
                    strT = strT;
                    AnimatableShapeValue animatableShapeValue = null;
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        jsonReader2.b();
                        AnimatableShapeValue animatableShapeValue2 = animatableShapeValue;
                        AnimatableIntegerValue animatableIntegerValueS1 = animatableShapeValue2;
                        int i3 = 0;
                        boolean zF2 = false;
                        while (jsonReader2.e()) {
                            String strS = jsonReader2.s();
                            strS.hashCode();
                            long j2 = jQ2;
                            int iHashCode = strS.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        if (iHashCode == 3357091 && strS.equals("mode")) {
                                            b2 = 3;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (strS.equals("inv")) {
                                        b2 = 2;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (strS.equals("pt")) {
                                    b2 = 1;
                                } else {
                                    b2 = -1;
                                }
                            } else if (strS.equals("o")) {
                                b2 = 0;
                            } else {
                                b2 = -1;
                            }
                            if (b2 == 0) {
                                animatableIntegerValueS1 = AnimatableValueParser.s1(jsonReader2, lottieComposition);
                            } else if (b2 == 1) {
                                animatableShapeValue2 = new AnimatableShapeValue(KeyframesParser.a(jsonReader2, lottieComposition, Utils.c(), ShapeDataParser.a));
                            } else if (b2 == 2) {
                                zF2 = jsonReader2.f();
                            } else if (b2 != 3) {
                                jsonReader2.C();
                            } else {
                                String strT4 = jsonReader2.t();
                                strT4.hashCode();
                                int iHashCode2 = strT4.hashCode();
                                if (iHashCode2 != 97) {
                                    if (iHashCode2 != 105) {
                                        if (iHashCode2 != 110) {
                                            if (iHashCode2 == 115 && strT4.equals("s")) {
                                                b3 = 3;
                                            } else {
                                                b3 = -1;
                                            }
                                        } else if (strT4.equals("n")) {
                                            b3 = 2;
                                        } else {
                                            b3 = -1;
                                        }
                                    } else if (strT4.equals("i")) {
                                        b3 = 1;
                                    } else {
                                        b3 = -1;
                                    }
                                } else if (strT4.equals("a")) {
                                    b3 = 0;
                                } else {
                                    b3 = -1;
                                }
                                if (b3 != 0) {
                                    if (b3 == 1) {
                                        lottieComposition.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                        i3 = 3;
                                    } else if (b3 == 2) {
                                        i3 = 4;
                                    } else if (b3 != 3) {
                                        Logger2.b("Unknown mask mode " + strS + ". Defaulting to Add.");
                                    } else {
                                        i3 = 2;
                                    }
                                }
                                i3 = 1;
                            }
                            jQ2 = j2;
                            animatableIntegerValueS1 = animatableIntegerValueS1;
                        }
                        jsonReader2.d();
                        arrayList.add(new Mask(i3, animatableShapeValue2, animatableIntegerValueS1, zF2));
                        jQ2 = jQ2;
                        animatableShapeValue = null;
                    }
                    j = jQ2;
                    lottieComposition.o += arrayList.size();
                    jsonReader2.c();
                    jQ2 = j;
                    strT = strT;
                    break;
                case 11:
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        ContentModel2 contentModel2A = ContentModelParser.a(jsonReader2, lottieComposition);
                        if (contentModel2A != null) {
                            arrayList2.add(contentModel2A);
                        }
                    }
                    jsonReader2.c();
                    j = jQ2;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 12:
                    jsonReader2.b();
                    while (jsonReader2.e()) {
                        int iY = jsonReader2.y(f342b);
                        if (iY == 0) {
                            str = strT;
                            animatableTextFrame = new AnimatableTextFrame(AnimatableValueParser.o1(jsonReader2, lottieComposition, DocumentDataParser.a));
                        } else if (iY != i) {
                            jsonReader2.A();
                            jsonReader2.C();
                        } else {
                            jsonReader2.a();
                            if (jsonReader2.e()) {
                                JsonReader2.a aVar2 = AnimatableTextPropertiesParser.a;
                                jsonReader2.b();
                                AnimatableTextProperties animatableTextProperties2 = null;
                                while (jsonReader2.e()) {
                                    if (jsonReader2.y(AnimatableTextPropertiesParser.a) != 0) {
                                        jsonReader2.A();
                                        jsonReader2.C();
                                    } else {
                                        jsonReader2.b();
                                        AnimatableFloatValue animatableFloatValueQ1 = null;
                                        AnimatableFloatValue animatableFloatValueQ2 = null;
                                        AnimatableColorValue animatableColorValueP1 = null;
                                        AnimatableColorValue animatableColorValueP2 = null;
                                        while (jsonReader2.e()) {
                                            int iY2 = jsonReader2.y(AnimatableTextPropertiesParser.f326b);
                                            if (iY2 == 0) {
                                                animatableColorValueP1 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                                            } else if (iY2 == i) {
                                                animatableColorValueP2 = AnimatableValueParser.p1(jsonReader2, lottieComposition);
                                            } else if (iY2 == 2) {
                                                animatableFloatValueQ1 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                            } else if (iY2 != 3) {
                                                jsonReader2.A();
                                                jsonReader2.C();
                                            } else {
                                                animatableFloatValueQ2 = AnimatableValueParser.q1(jsonReader2, lottieComposition);
                                            }
                                            i = 1;
                                        }
                                        jsonReader2.d();
                                        animatableTextProperties2 = new AnimatableTextProperties(animatableColorValueP1, animatableColorValueP2, animatableFloatValueQ1, animatableFloatValueQ2);
                                        strT = strT;
                                        i = 1;
                                    }
                                }
                                str = strT;
                                jsonReader2.d();
                                animatableTextProperties = animatableTextProperties2 == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties2;
                            } else {
                                str = strT;
                            }
                            while (jsonReader2.e()) {
                                jsonReader2.C();
                            }
                            jsonReader2.c();
                        }
                        strT = str;
                        i = 1;
                    }
                    strT = strT;
                    jsonReader2.d();
                    strT = strT;
                    break;
                case 13:
                    jsonReader2.a();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader2.e()) {
                        jsonReader2.b();
                        while (jsonReader2.e()) {
                            if (jsonReader2.y(c) != 0) {
                                jsonReader2.A();
                                jsonReader2.C();
                            } else {
                                arrayList3.add(jsonReader2.t());
                            }
                        }
                        jsonReader2.d();
                    }
                    jsonReader2.c();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    j = jQ2;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 14:
                    fN2 = (float) jsonReader2.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 15:
                    fN3 = (float) jsonReader2.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 16:
                    iC3 = (int) (Utils.c() * jsonReader2.q());
                    strT = strT;
                    strT = strT;
                    break;
                case 17:
                    iC4 = (int) (Utils.c() * jsonReader2.q());
                    strT = strT;
                    strT = strT;
                    break;
                case 18:
                    fN = (float) jsonReader2.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 19:
                    fN4 = (float) jsonReader2.n();
                    break;
                case 20:
                    animatableFloatValueR1 = AnimatableValueParser.r1(jsonReader2, lottieComposition, z2);
                    break;
                case 21:
                    strT = jsonReader2.t();
                    break;
                case 22:
                    zF = jsonReader2.f();
                    break;
                default:
                    strT = strT;
                    j = jQ2;
                    jsonReader2.A();
                    jsonReader2.C();
                    jQ2 = j;
                    strT = strT;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str2 = strT;
        long j3 = jQ2;
        jsonReader2.d();
        float f = fN / fN2;
        float f2 = fN4 / fN2;
        ArrayList arrayList4 = new ArrayList();
        if (f > 0.0f) {
            arrayList4.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        }
        if (f2 <= 0.0f) {
            f2 = lottieComposition.l;
        }
        arrayList4.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList4.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strT3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer2(arrayList2, lottieComposition, strT3, j3, aVar, jQ, strT2, arrayList, animatableTransformA, iC, iC2, color, fN2, fN3, iC3, iC4, animatableTextFrame, animatableTextProperties, arrayList4, i2, animatableFloatValueR1, zF);
    }
}
