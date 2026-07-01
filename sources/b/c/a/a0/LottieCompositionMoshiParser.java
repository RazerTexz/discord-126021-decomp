package b.c.a.a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import b.c.a.LottieComposition;
import b.c.a.LottieImageAsset;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.y.Font;
import b.c.a.y.FontCharacter;
import b.c.a.y.Marker2;
import b.c.a.y.l.ShapeGroup;
import b.c.a.y.m.Layer2;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: b.c.a.a0.t, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionMoshiParser.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionMoshiParser {
    public static final JsonReader2.a a = JsonReader2.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonReader2.a f343b = JsonReader2.a.a(ModelAuditLogEntry.CHANGE_KEY_ID, "layers", "w", "h", "p", "u");
    public static final JsonReader2.a c = JsonReader2.a.a("list");
    public static final JsonReader2.a d = JsonReader2.a.a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    public static LottieComposition a(JsonReader2 jsonReader2) throws IOException {
        ArrayList arrayList;
        float f;
        float f2;
        float fC = Utils.c();
        LongSparseArray<Layer2> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader2.b();
        float fN = 0.0f;
        int iQ = 0;
        int iQ2 = 0;
        float fN2 = 0.0f;
        float fN3 = 0.0f;
        while (jsonReader2.e()) {
            float f3 = fN;
            switch (jsonReader2.y(a)) {
                case 0:
                    iQ = jsonReader2.q();
                    fN = f3;
                    break;
                case 1:
                    iQ2 = jsonReader2.q();
                    fN = f3;
                    break;
                case 2:
                    fN2 = (float) jsonReader2.n();
                    fN = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 3:
                    fN3 = ((float) jsonReader2.n()) - 0.01f;
                    fN = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 4:
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fN = (float) jsonReader2.n();
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 5:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fN2;
                    f2 = fN3;
                    String[] strArrSplit = jsonReader2.t().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    boolean z2 = true;
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    int i3 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i2 < 4 || (i2 <= 4 && i3 < 0)))) {
                        z2 = false;
                    }
                    if (!z2) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 6:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.a();
                    int i4 = 0;
                    while (jsonReader2.e()) {
                        Layer2 layer2A = LayerParser.a(jsonReader2, lottieComposition);
                        if (layer2A.e == Layer2.a.IMAGE) {
                            i4++;
                        }
                        arrayList2.add(layer2A);
                        longSparseArray.put(layer2A.d, layer2A);
                        if (i4 > 4) {
                            Logger2.b("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jsonReader2.c();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 7:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jsonReader2.b();
                        String strT = null;
                        String strT2 = null;
                        String strT3 = null;
                        int iQ3 = 0;
                        int iQ4 = 0;
                        while (jsonReader2.e()) {
                            int iY = jsonReader2.y(f343b);
                            if (iY == 0) {
                                strT = jsonReader2.t();
                            } else if (iY == 1) {
                                jsonReader2.a();
                                while (jsonReader2.e()) {
                                    Layer2 layer2A2 = LayerParser.a(jsonReader2, lottieComposition);
                                    longSparseArray2.put(layer2A2.d, layer2A2);
                                    arrayList4.add(layer2A2);
                                }
                                jsonReader2.c();
                            } else if (iY == 2) {
                                iQ3 = jsonReader2.q();
                            } else if (iY == 3) {
                                iQ4 = jsonReader2.q();
                            } else if (iY == 4) {
                                strT2 = jsonReader2.t();
                            } else if (iY != 5) {
                                jsonReader2.A();
                                jsonReader2.C();
                            } else {
                                strT3 = jsonReader2.t();
                            }
                        }
                        jsonReader2.d();
                        if (strT2 != null) {
                            map2.put(strT, new LottieImageAsset(iQ3, iQ4, strT, strT2, strT3));
                        } else {
                            map.put(strT, arrayList4);
                        }
                    }
                    jsonReader2.c();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 8:
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.b();
                    while (jsonReader2.e()) {
                        if (jsonReader2.y(c) != 0) {
                            jsonReader2.A();
                            jsonReader2.C();
                        } else {
                            jsonReader2.a();
                            while (jsonReader2.e()) {
                                JsonReader2.a aVar = FontParser.a;
                                jsonReader2.b();
                                String strT4 = null;
                                String strT5 = null;
                                String strT6 = null;
                                float fN4 = 0.0f;
                                while (jsonReader2.e()) {
                                    arrayList3 = arrayList3;
                                    int iY2 = jsonReader2.y(FontParser.a);
                                    if (iY2 != 0) {
                                        SparseArrayCompat<FontCharacter> sparseArrayCompat2 = sparseArrayCompat;
                                        if (iY2 == 1) {
                                            strT5 = jsonReader2.t();
                                        } else if (iY2 == 2) {
                                            strT6 = jsonReader2.t();
                                        } else if (iY2 != 3) {
                                            jsonReader2.A();
                                            jsonReader2.C();
                                        } else {
                                            fN4 = (float) jsonReader2.n();
                                        }
                                        sparseArrayCompat = sparseArrayCompat2;
                                    } else {
                                        strT4 = jsonReader2.t();
                                    }
                                }
                                jsonReader2.d();
                                map3.put(strT5, new Font(strT4, strT5, strT6, fN4));
                                arrayList3 = arrayList3;
                            }
                            jsonReader2.c();
                        }
                    }
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    jsonReader2.d();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 9:
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        JsonReader2.a aVar2 = FontCharacterParser.a;
                        ArrayList arrayList5 = new ArrayList();
                        jsonReader2.b();
                        double dN = 0.0d;
                        double dN2 = 0.0d;
                        String strT7 = null;
                        String strT8 = null;
                        char cCharAt = 0;
                        while (jsonReader2.e()) {
                            int iY3 = jsonReader2.y(FontCharacterParser.a);
                            if (iY3 == 0) {
                                cCharAt = jsonReader2.t().charAt(0);
                            } else if (iY3 == 1) {
                                dN = jsonReader2.n();
                            } else if (iY3 == 2) {
                                dN2 = jsonReader2.n();
                            } else if (iY3 == 3) {
                                strT7 = jsonReader2.t();
                            } else if (iY3 == 4) {
                                strT8 = jsonReader2.t();
                            } else if (iY3 != 5) {
                                jsonReader2.A();
                                jsonReader2.C();
                            } else {
                                jsonReader2.b();
                                while (jsonReader2.e()) {
                                    if (jsonReader2.y(FontCharacterParser.f338b) != 0) {
                                        jsonReader2.A();
                                        jsonReader2.C();
                                    } else {
                                        jsonReader2.a();
                                        while (jsonReader2.e()) {
                                            arrayList5.add((ShapeGroup) ContentModelParser.a(jsonReader2, lottieComposition));
                                        }
                                        jsonReader2.c();
                                    }
                                }
                                jsonReader2.d();
                            }
                        }
                        jsonReader2.d();
                        FontCharacter fontCharacter = new FontCharacter(arrayList5, cCharAt, dN, dN2, strT7, strT8);
                        sparseArrayCompat.put(fontCharacter.hashCode(), fontCharacter);
                    }
                    jsonReader2.c();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 10:
                    jsonReader2.a();
                    while (jsonReader2.e()) {
                        jsonReader2.b();
                        String strT9 = null;
                        float fN5 = 0.0f;
                        float fN6 = 0.0f;
                        while (jsonReader2.e()) {
                            int iY4 = jsonReader2.y(d);
                            if (iY4 != 0) {
                                float f4 = fN3;
                                if (iY4 == 1) {
                                    fN5 = (float) jsonReader2.n();
                                } else if (iY4 != 2) {
                                    jsonReader2.A();
                                    jsonReader2.C();
                                    fN3 = f4;
                                } else {
                                    fN6 = (float) jsonReader2.n();
                                }
                                fN3 = f4;
                                fN2 = fN2;
                            } else {
                                strT9 = jsonReader2.t();
                            }
                        }
                        jsonReader2.d();
                        arrayList3.add(new Marker2(strT9, fN5, fN6));
                        fN2 = fN2;
                        fN3 = fN3;
                    }
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.c();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                default:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fN2;
                    f2 = fN3;
                    jsonReader2.A();
                    jsonReader2.C();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
            }
        }
        lottieComposition.j = new Rect(0, 0, (int) (iQ * fC), (int) (iQ2 * fC));
        lottieComposition.k = fN2;
        lottieComposition.l = fN3;
        lottieComposition.m = fN;
        lottieComposition.i = arrayList2;
        lottieComposition.h = longSparseArray;
        lottieComposition.c = map;
        lottieComposition.d = map2;
        lottieComposition.g = sparseArrayCompat;
        lottieComposition.e = map3;
        lottieComposition.f = arrayList3;
        return lottieComposition;
    }
}
