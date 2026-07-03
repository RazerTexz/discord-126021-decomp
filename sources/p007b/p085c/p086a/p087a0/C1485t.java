package p007b.p085c.p086a.p087a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.C1512k;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p095y.C1565d;
import p007b.p085c.p086a.p095y.C1566e;
import p007b.p085c.p086a.p095y.C1570i;
import p007b.p085c.p086a.p095y.p097l.C1598m;
import p007b.p085c.p086a.p095y.p098m.C1606e;

/* JADX INFO: renamed from: b.c.a.a0.t */
/* JADX INFO: compiled from: LottieCompositionMoshiParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1485t {

    /* JADX INFO: renamed from: a */
    public static final AbstractC1473c.a f2283a = AbstractC1473c.a.m616a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b */
    public static AbstractC1473c.a f2284b = AbstractC1473c.a.m616a(ModelAuditLogEntry.CHANGE_KEY_ID, "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c */
    public static final AbstractC1473c.a f2285c = AbstractC1473c.a.m616a("list");

    /* JADX INFO: renamed from: d */
    public static final AbstractC1473c.a f2286d = AbstractC1473c.a.m616a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    /* JADX INFO: renamed from: a */
    public static C1505d m635a(AbstractC1473c abstractC1473c) throws IOException {
        ArrayList arrayList;
        float f;
        float f2;
        float fM659c = C1499g.m659c();
        LongSparseArray<C1606e> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<C1566e> sparseArrayCompat = new SparseArrayCompat<>();
        C1505d c1505d = new C1505d();
        abstractC1473c.mo604b();
        float fMo609n = 0.0f;
        int iMo610q = 0;
        int iMo610q2 = 0;
        float fMo609n2 = 0.0f;
        float fMo609n3 = 0.0f;
        while (abstractC1473c.mo607e()) {
            float f3 = fMo609n;
            switch (abstractC1473c.mo615y(f2283a)) {
                case 0:
                    iMo610q = abstractC1473c.mo610q();
                    fMo609n = f3;
                    break;
                case 1:
                    iMo610q2 = abstractC1473c.mo610q();
                    fMo609n = f3;
                    break;
                case 2:
                    fMo609n2 = (float) abstractC1473c.mo609n();
                    fMo609n = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 3:
                    fMo609n3 = ((float) abstractC1473c.mo609n()) - 0.01f;
                    fMo609n = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 4:
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fMo609n = (float) abstractC1473c.mo609n();
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 5:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    String[] strArrSplit = abstractC1473c.mo612t().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    boolean z2 = true;
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    int i3 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i2 < 4 || (i2 <= 4 && i3 < 0)))) {
                        z2 = false;
                    }
                    if (!z2) {
                        c1505d.m669a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 6:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo603a();
                    int i4 = 0;
                    while (abstractC1473c.mo607e()) {
                        C1606e c1606eM634a = C1484s.m634a(abstractC1473c, c1505d);
                        if (c1606eM634a.f2872e == C1606e.a.IMAGE) {
                            i4++;
                        }
                        arrayList2.add(c1606eM634a);
                        longSparseArray.put(c1606eM634a.f2871d, c1606eM634a);
                        if (i4 > 4) {
                            C1495c.m640b("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    abstractC1473c.mo605c();
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 7:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo603a();
                    while (abstractC1473c.mo607e()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        abstractC1473c.mo604b();
                        String strMo612t = null;
                        String strMo612t2 = null;
                        String strMo612t3 = null;
                        int iMo610q3 = 0;
                        int iMo610q4 = 0;
                        while (abstractC1473c.mo607e()) {
                            int iMo615y = abstractC1473c.mo615y(f2284b);
                            if (iMo615y == 0) {
                                strMo612t = abstractC1473c.mo612t();
                            } else if (iMo615y == 1) {
                                abstractC1473c.mo603a();
                                while (abstractC1473c.mo607e()) {
                                    C1606e c1606eM634a2 = C1484s.m634a(abstractC1473c, c1505d);
                                    longSparseArray2.put(c1606eM634a2.f2871d, c1606eM634a2);
                                    arrayList4.add(c1606eM634a2);
                                }
                                abstractC1473c.mo605c();
                            } else if (iMo615y == 2) {
                                iMo610q3 = abstractC1473c.mo610q();
                            } else if (iMo615y == 3) {
                                iMo610q4 = abstractC1473c.mo610q();
                            } else if (iMo615y == 4) {
                                strMo612t2 = abstractC1473c.mo612t();
                            } else if (iMo615y != 5) {
                                abstractC1473c.mo600A();
                                abstractC1473c.mo601C();
                            } else {
                                strMo612t3 = abstractC1473c.mo612t();
                            }
                        }
                        abstractC1473c.mo606d();
                        if (strMo612t2 != null) {
                            map2.put(strMo612t, new C1512k(iMo610q3, iMo610q4, strMo612t, strMo612t2, strMo612t3));
                        } else {
                            map.put(strMo612t, arrayList4);
                        }
                    }
                    abstractC1473c.mo605c();
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 8:
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo604b();
                    while (abstractC1473c.mo607e()) {
                        if (abstractC1473c.mo615y(f2285c) != 0) {
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                        } else {
                            abstractC1473c.mo603a();
                            while (abstractC1473c.mo607e()) {
                                AbstractC1473c.a aVar = C1476k.f2267a;
                                abstractC1473c.mo604b();
                                String strMo612t4 = null;
                                String strMo612t5 = null;
                                String strMo612t6 = null;
                                float fMo609n4 = 0.0f;
                                while (abstractC1473c.mo607e()) {
                                    arrayList3 = arrayList3;
                                    int iMo615y2 = abstractC1473c.mo615y(C1476k.f2267a);
                                    if (iMo615y2 != 0) {
                                        SparseArrayCompat<C1566e> sparseArrayCompat2 = sparseArrayCompat;
                                        if (iMo615y2 == 1) {
                                            strMo612t5 = abstractC1473c.mo612t();
                                        } else if (iMo615y2 == 2) {
                                            strMo612t6 = abstractC1473c.mo612t();
                                        } else if (iMo615y2 != 3) {
                                            abstractC1473c.mo600A();
                                            abstractC1473c.mo601C();
                                        } else {
                                            fMo609n4 = (float) abstractC1473c.mo609n();
                                        }
                                        sparseArrayCompat = sparseArrayCompat2;
                                    } else {
                                        strMo612t4 = abstractC1473c.mo612t();
                                    }
                                }
                                abstractC1473c.mo606d();
                                map3.put(strMo612t5, new C1565d(strMo612t4, strMo612t5, strMo612t6, fMo609n4));
                                arrayList3 = arrayList3;
                            }
                            abstractC1473c.mo605c();
                        }
                    }
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    abstractC1473c.mo606d();
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 9:
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo603a();
                    while (abstractC1473c.mo607e()) {
                        AbstractC1473c.a aVar2 = C1475j.f2265a;
                        ArrayList arrayList5 = new ArrayList();
                        abstractC1473c.mo604b();
                        double dMo609n = 0.0d;
                        double dMo609n2 = 0.0d;
                        String strMo612t7 = null;
                        String strMo612t8 = null;
                        char cCharAt = 0;
                        while (abstractC1473c.mo607e()) {
                            int iMo615y3 = abstractC1473c.mo615y(C1475j.f2265a);
                            if (iMo615y3 == 0) {
                                cCharAt = abstractC1473c.mo612t().charAt(0);
                            } else if (iMo615y3 == 1) {
                                dMo609n = abstractC1473c.mo609n();
                            } else if (iMo615y3 == 2) {
                                dMo609n2 = abstractC1473c.mo609n();
                            } else if (iMo615y3 == 3) {
                                strMo612t7 = abstractC1473c.mo612t();
                            } else if (iMo615y3 == 4) {
                                strMo612t8 = abstractC1473c.mo612t();
                            } else if (iMo615y3 != 5) {
                                abstractC1473c.mo600A();
                                abstractC1473c.mo601C();
                            } else {
                                abstractC1473c.mo604b();
                                while (abstractC1473c.mo607e()) {
                                    if (abstractC1473c.mo615y(C1475j.f2266b) != 0) {
                                        abstractC1473c.mo600A();
                                        abstractC1473c.mo601C();
                                    } else {
                                        abstractC1473c.mo603a();
                                        while (abstractC1473c.mo607e()) {
                                            arrayList5.add((C1598m) C1466g.m599a(abstractC1473c, c1505d));
                                        }
                                        abstractC1473c.mo605c();
                                    }
                                }
                                abstractC1473c.mo606d();
                            }
                        }
                        abstractC1473c.mo606d();
                        C1566e c1566e = new C1566e(arrayList5, cCharAt, dMo609n, dMo609n2, strMo612t7, strMo612t8);
                        sparseArrayCompat.put(c1566e.hashCode(), c1566e);
                    }
                    abstractC1473c.mo605c();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 10:
                    abstractC1473c.mo603a();
                    while (abstractC1473c.mo607e()) {
                        abstractC1473c.mo604b();
                        String strMo612t9 = null;
                        float fMo609n5 = 0.0f;
                        float fMo609n6 = 0.0f;
                        while (abstractC1473c.mo607e()) {
                            int iMo615y4 = abstractC1473c.mo615y(f2286d);
                            if (iMo615y4 != 0) {
                                float f4 = fMo609n3;
                                if (iMo615y4 == 1) {
                                    fMo609n5 = (float) abstractC1473c.mo609n();
                                } else if (iMo615y4 != 2) {
                                    abstractC1473c.mo600A();
                                    abstractC1473c.mo601C();
                                    fMo609n3 = f4;
                                } else {
                                    fMo609n6 = (float) abstractC1473c.mo609n();
                                }
                                fMo609n3 = f4;
                                fMo609n2 = fMo609n2;
                            } else {
                                strMo612t9 = abstractC1473c.mo612t();
                            }
                        }
                        abstractC1473c.mo606d();
                        arrayList3.add(new C1570i(strMo612t9, fMo609n5, fMo609n6));
                        fMo609n2 = fMo609n2;
                        fMo609n3 = fMo609n3;
                    }
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo605c();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                default:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    abstractC1473c.mo600A();
                    abstractC1473c.mo601C();
                    fMo609n = f3;
                    fMo609n2 = f;
                    arrayList3 = arrayList;
                    fMo609n3 = f2;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
            }
        }
        c1505d.f2345j = new Rect(0, 0, (int) (iMo610q * fM659c), (int) (iMo610q2 * fM659c));
        c1505d.f2346k = fMo609n2;
        c1505d.f2347l = fMo609n3;
        c1505d.f2348m = fMo609n;
        c1505d.f2344i = arrayList2;
        c1505d.f2343h = longSparseArray;
        c1505d.f2338c = map;
        c1505d.f2339d = map2;
        c1505d.f2342g = sparseArrayCompat;
        c1505d.f2340e = map3;
        c1505d.f2341f = arrayList3;
        return c1505d;
    }
}
