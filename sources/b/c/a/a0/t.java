package b.c.a.a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import b.c.a.a0.i0.c$a;
import b.c.a.y.m.e$a;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: LottieCompositionMoshiParser.java */
/* JADX INFO: loaded from: classes.dex */
public class t {
    public static final c$a a = c$a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c$a f343b = c$a.a(ModelAuditLogEntry.CHANGE_KEY_ID, "layers", "w", "h", "p", "u");
    public static final c$a c = c$a.a("list");
    public static final c$a d = c$a.a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    public static b.c.a.d a(b.c.a.a0.i0.c cVar) throws IOException {
        ArrayList arrayList;
        float f;
        float f2;
        float fC = b.c.a.b0.g.c();
        LongSparseArray<b.c.a.y.m.e> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<b.c.a.y.e> sparseArrayCompat = new SparseArrayCompat<>();
        b.c.a.d dVar = new b.c.a.d();
        cVar.b();
        float fN = 0.0f;
        int iQ = 0;
        int iQ2 = 0;
        float fN2 = 0.0f;
        float fN3 = 0.0f;
        while (cVar.e()) {
            float f3 = fN;
            switch (cVar.y(a)) {
                case 0:
                    iQ = cVar.q();
                    fN = f3;
                    break;
                case 1:
                    iQ2 = cVar.q();
                    fN = f3;
                    break;
                case 2:
                    fN2 = (float) cVar.n();
                    fN = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 3:
                    fN3 = ((float) cVar.n()) - 0.01f;
                    fN = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 4:
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fN = (float) cVar.n();
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 5:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fN2;
                    f2 = fN3;
                    String[] strArrSplit = cVar.t().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    boolean z2 = true;
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    int i3 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i2 < 4 || (i2 <= 4 && i3 < 0)))) {
                        z2 = false;
                    }
                    if (!z2) {
                        dVar.a("Lottie only supports bodymovin >= 4.4.0");
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
                    cVar.a();
                    int i4 = 0;
                    while (cVar.e()) {
                        b.c.a.y.m.e eVarA = s.a(cVar, dVar);
                        if (eVarA.e == e$a.IMAGE) {
                            i4++;
                        }
                        arrayList2.add(eVarA);
                        longSparseArray.put(eVarA.d, eVarA);
                        if (i4 > 4) {
                            b.c.a.b0.c.b("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    cVar.c();
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
                    cVar.a();
                    while (cVar.e()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        cVar.b();
                        String strT = null;
                        String strT2 = null;
                        String strT3 = null;
                        int iQ3 = 0;
                        int iQ4 = 0;
                        while (cVar.e()) {
                            int iY = cVar.y(f343b);
                            if (iY == 0) {
                                strT = cVar.t();
                            } else if (iY == 1) {
                                cVar.a();
                                while (cVar.e()) {
                                    b.c.a.y.m.e eVarA2 = s.a(cVar, dVar);
                                    longSparseArray2.put(eVarA2.d, eVarA2);
                                    arrayList4.add(eVarA2);
                                }
                                cVar.c();
                            } else if (iY == 2) {
                                iQ3 = cVar.q();
                            } else if (iY == 3) {
                                iQ4 = cVar.q();
                            } else if (iY == 4) {
                                strT2 = cVar.t();
                            } else if (iY != 5) {
                                cVar.A();
                                cVar.C();
                            } else {
                                strT3 = cVar.t();
                            }
                        }
                        cVar.d();
                        if (strT2 != null) {
                            map2.put(strT, new b.c.a.k(iQ3, iQ4, strT, strT2, strT3));
                        } else {
                            map.put(strT, arrayList4);
                        }
                    }
                    cVar.c();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 8:
                    f = fN2;
                    f2 = fN3;
                    cVar.b();
                    while (cVar.e()) {
                        if (cVar.y(c) != 0) {
                            cVar.A();
                            cVar.C();
                        } else {
                            cVar.a();
                            while (cVar.e()) {
                                c$a c_a = k.a;
                                cVar.b();
                                String strT4 = null;
                                String strT5 = null;
                                String strT6 = null;
                                float fN4 = 0.0f;
                                while (cVar.e()) {
                                    arrayList3 = arrayList3;
                                    int iY2 = cVar.y(k.a);
                                    if (iY2 != 0) {
                                        SparseArrayCompat<b.c.a.y.e> sparseArrayCompat2 = sparseArrayCompat;
                                        if (iY2 == 1) {
                                            strT5 = cVar.t();
                                        } else if (iY2 == 2) {
                                            strT6 = cVar.t();
                                        } else if (iY2 != 3) {
                                            cVar.A();
                                            cVar.C();
                                        } else {
                                            fN4 = (float) cVar.n();
                                        }
                                        sparseArrayCompat = sparseArrayCompat2;
                                    } else {
                                        strT4 = cVar.t();
                                    }
                                }
                                cVar.d();
                                map3.put(strT5, new b.c.a.y.d(strT4, strT5, strT6, fN4));
                                arrayList3 = arrayList3;
                            }
                            cVar.c();
                        }
                    }
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    cVar.d();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 9:
                    f = fN2;
                    f2 = fN3;
                    cVar.a();
                    while (cVar.e()) {
                        c$a c_a2 = j.a;
                        ArrayList arrayList5 = new ArrayList();
                        cVar.b();
                        double dN = 0.0d;
                        double dN2 = 0.0d;
                        String strT7 = null;
                        String strT8 = null;
                        char cCharAt = 0;
                        while (cVar.e()) {
                            int iY3 = cVar.y(j.a);
                            if (iY3 == 0) {
                                cCharAt = cVar.t().charAt(0);
                            } else if (iY3 == 1) {
                                dN = cVar.n();
                            } else if (iY3 == 2) {
                                dN2 = cVar.n();
                            } else if (iY3 == 3) {
                                strT7 = cVar.t();
                            } else if (iY3 == 4) {
                                strT8 = cVar.t();
                            } else if (iY3 != 5) {
                                cVar.A();
                                cVar.C();
                            } else {
                                cVar.b();
                                while (cVar.e()) {
                                    if (cVar.y(j.f338b) != 0) {
                                        cVar.A();
                                        cVar.C();
                                    } else {
                                        cVar.a();
                                        while (cVar.e()) {
                                            arrayList5.add((b.c.a.y.l.m) g.a(cVar, dVar));
                                        }
                                        cVar.c();
                                    }
                                }
                                cVar.d();
                            }
                        }
                        cVar.d();
                        b.c.a.y.e eVar = new b.c.a.y.e(arrayList5, cCharAt, dN, dN2, strT7, strT8);
                        sparseArrayCompat.put(eVar.hashCode(), eVar);
                    }
                    cVar.c();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 10:
                    cVar.a();
                    while (cVar.e()) {
                        cVar.b();
                        String strT9 = null;
                        float fN5 = 0.0f;
                        float fN6 = 0.0f;
                        while (cVar.e()) {
                            int iY4 = cVar.y(d);
                            if (iY4 != 0) {
                                float f4 = fN3;
                                if (iY4 == 1) {
                                    fN5 = (float) cVar.n();
                                } else if (iY4 != 2) {
                                    cVar.A();
                                    cVar.C();
                                    fN3 = f4;
                                } else {
                                    fN6 = (float) cVar.n();
                                }
                                fN3 = f4;
                                fN2 = fN2;
                            } else {
                                strT9 = cVar.t();
                            }
                        }
                        cVar.d();
                        arrayList3.add(new b.c.a.y.i(strT9, fN5, fN6));
                        fN2 = fN2;
                        fN3 = fN3;
                    }
                    f = fN2;
                    f2 = fN3;
                    cVar.c();
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
                    cVar.A();
                    cVar.C();
                    fN = f3;
                    fN2 = f;
                    arrayList3 = arrayList;
                    fN3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
            }
        }
        dVar.j = new Rect(0, 0, (int) (iQ * fC), (int) (iQ2 * fC));
        dVar.k = fN2;
        dVar.l = fN3;
        dVar.m = fN;
        dVar.i = arrayList2;
        dVar.h = longSparseArray;
        dVar.c = map;
        dVar.d = map2;
        dVar.g = sparseArrayCompat;
        dVar.e = map3;
        dVar.f = arrayList3;
        return dVar;
    }
}
