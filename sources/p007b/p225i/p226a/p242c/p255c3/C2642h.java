package p007b.p225i.p226a.p242c.p255c3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p357b.AbstractC4506g0;
import p007b.p225i.p355b.p357b.AbstractC4511j;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4504f0;
import p007b.p225i.p355b.p357b.C4514k0;

/* JADX INFO: renamed from: b.i.a.c.c3.h */
/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2642h extends AbstractC2646l {

    /* JADX INFO: renamed from: b */
    public static final int[] f6192b = new int[0];

    /* JADX INFO: renamed from: c */
    public static final AbstractC4506g0<Integer> f6193c = AbstractC4506g0.m6237a(new Comparator() { // from class: b.i.a.c.c3.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int[] iArr = C2642h.f6192b;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });

    /* JADX INFO: renamed from: d */
    public static final AbstractC4506g0<Integer> f6194d = AbstractC4506g0.m6237a(new Comparator() { // from class: b.i.a.c.c3.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int[] iArr = C2642h.f6192b;
            return 0;
        }
    });

    /* JADX INFO: renamed from: e */
    public final InterfaceC2644j.b f6195e;

    /* JADX INFO: renamed from: f */
    public final AtomicReference<d> f6196f;

    /* JADX INFO: renamed from: b.i.a.c.c3.h$b */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: j */
        public final boolean f6197j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public final String f6198k;

        /* JADX INFO: renamed from: l */
        public final d f6199l;

        /* JADX INFO: renamed from: m */
        public final boolean f6200m;

        /* JADX INFO: renamed from: n */
        public final int f6201n;

        /* JADX INFO: renamed from: o */
        public final int f6202o;

        /* JADX INFO: renamed from: p */
        public final int f6203p;

        /* JADX INFO: renamed from: q */
        public final int f6204q;

        /* JADX INFO: renamed from: r */
        public final int f6205r;

        /* JADX INFO: renamed from: s */
        public final boolean f6206s;

        /* JADX INFO: renamed from: t */
        public final int f6207t;

        /* JADX INFO: renamed from: u */
        public final int f6208u;

        /* JADX INFO: renamed from: v */
        public final int f6209v;

        /* JADX INFO: renamed from: w */
        public final int f6210w;

        public b(C2811j1 c2811j1, d dVar, int i) {
            int i2;
            int iM2735c;
            String[] strArrM2987H;
            int iM2735c2;
            this.f6199l = dVar;
            this.f6198k = C2642h.m2739g(c2811j1.f7146n);
            this.f6200m = C2642h.m2737e(i, false);
            int i3 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i3 >= dVar.f6297w.size()) {
                    i3 = Integer.MAX_VALUE;
                    iM2735c = 0;
                    break;
                } else {
                    iM2735c = C2642h.m2735c(c2811j1, dVar.f6297w.get(i3), false);
                    if (iM2735c > 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.f6202o = i3;
            this.f6201n = iM2735c;
            this.f6203p = Integer.bitCount(c2811j1.f7148p & dVar.f6298x);
            this.f6206s = (c2811j1.f7147o & 1) != 0;
            int i4 = c2811j1.f7136J;
            this.f6207t = i4;
            this.f6208u = c2811j1.f7137K;
            int i5 = c2811j1.f7151s;
            this.f6209v = i5;
            this.f6197j = (i5 == -1 || i5 <= dVar.f6300z) && (i4 == -1 || i4 <= dVar.f6299y);
            int i6 = C2738e0.f6708a;
            Configuration configuration = Resources.getSystem().getConfiguration();
            int i7 = C2738e0.f6708a;
            if (i7 >= 24) {
                strArrM2987H = C2738e0.m2987H(configuration.getLocales().toLanguageTags(), ",");
            } else {
                String[] strArr = new String[1];
                Locale locale = configuration.locale;
                strArr[0] = i7 >= 21 ? locale.toLanguageTag() : locale.toString();
                strArrM2987H = strArr;
            }
            for (int i8 = 0; i8 < strArrM2987H.length; i8++) {
                strArrM2987H[i8] = C2738e0.m2982C(strArrM2987H[i8]);
            }
            int i9 = 0;
            while (true) {
                if (i9 >= strArrM2987H.length) {
                    i9 = Integer.MAX_VALUE;
                    iM2735c2 = 0;
                    break;
                } else {
                    iM2735c2 = C2642h.m2735c(c2811j1, strArrM2987H[i9], false);
                    if (iM2735c2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.f6204q = i9;
            this.f6205r = iM2735c2;
            for (int i10 = 0; i10 < dVar.f6277A.size(); i10++) {
                String str = c2811j1.f7155w;
                if (str != null && str.equals(dVar.f6277A.get(i10))) {
                    i2 = i10;
                    break;
                }
            }
            this.f6210w = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Object objMo6236b = (this.f6197j && this.f6200m) ? C2642h.f6193c : C2642h.f6193c.mo6236b();
            AbstractC4511j abstractC4511jMo6256c = AbstractC4511j.f12028a.mo6256c(this.f6200m, bVar.f6200m);
            Integer numValueOf = Integer.valueOf(this.f6202o);
            Integer numValueOf2 = Integer.valueOf(bVar.f6202o);
            C4514k0 c4514k0 = C4514k0.f12038j;
            AbstractC4511j abstractC4511jMo6255b = abstractC4511jMo6256c.mo6255b(numValueOf, numValueOf2, c4514k0).mo6254a(this.f6201n, bVar.f6201n).mo6254a(this.f6203p, bVar.f6203p).mo6256c(this.f6197j, bVar.f6197j).mo6255b(Integer.valueOf(this.f6210w), Integer.valueOf(bVar.f6210w), c4514k0).mo6255b(Integer.valueOf(this.f6209v), Integer.valueOf(bVar.f6209v), this.f6199l.f6281E ? C2642h.f6193c.mo6236b() : C2642h.f6194d).mo6256c(this.f6206s, bVar.f6206s).mo6255b(Integer.valueOf(this.f6204q), Integer.valueOf(bVar.f6204q), c4514k0).mo6254a(this.f6205r, bVar.f6205r).mo6255b(Integer.valueOf(this.f6207t), Integer.valueOf(bVar.f6207t), objMo6236b).mo6255b(Integer.valueOf(this.f6208u), Integer.valueOf(bVar.f6208u), objMo6236b);
            Integer numValueOf3 = Integer.valueOf(this.f6209v);
            Integer numValueOf4 = Integer.valueOf(bVar.f6209v);
            if (!C2738e0.m2993a(this.f6198k, bVar.f6198k)) {
                objMo6236b = C2642h.f6194d;
            }
            return abstractC4511jMo6255b.mo6255b(numValueOf3, numValueOf4, objMo6236b).mo6258e();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$c */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: j */
        public final boolean f6211j;

        /* JADX INFO: renamed from: k */
        public final boolean f6212k;

        public c(C2811j1 c2811j1, int i) {
            this.f6211j = (c2811j1.f7147o & 1) != 0;
            this.f6212k = C2642h.m2737e(i, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return AbstractC4511j.f12028a.mo6256c(this.f6212k, cVar.f6212k).mo6256c(this.f6211j, cVar.f6211j).mo6258e();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$d */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class d extends C2650p implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: I */
        public static final d f6213I = new e().m2745d();

        /* JADX INFO: renamed from: J */
        public final int f6214J;

        /* JADX INFO: renamed from: K */
        public final boolean f6215K;

        /* JADX INFO: renamed from: L */
        public final boolean f6216L;

        /* JADX INFO: renamed from: M */
        public final boolean f6217M;

        /* JADX INFO: renamed from: N */
        public final boolean f6218N;

        /* JADX INFO: renamed from: O */
        public final boolean f6219O;

        /* JADX INFO: renamed from: P */
        public final boolean f6220P;

        /* JADX INFO: renamed from: Q */
        public final boolean f6221Q;

        /* JADX INFO: renamed from: R */
        public final boolean f6222R;

        /* JADX INFO: renamed from: S */
        public final boolean f6223S;

        /* JADX INFO: renamed from: T */
        public final boolean f6224T;

        /* JADX INFO: renamed from: U */
        public final SparseArray<Map<C2558o0, f>> f6225U;

        /* JADX INFO: renamed from: V */
        public final SparseBooleanArray f6226V;

        public d(e eVar, a aVar) {
            super(eVar);
            this.f6215K = eVar.f6238y;
            this.f6216L = eVar.f6239z;
            this.f6217M = eVar.f6227A;
            this.f6218N = eVar.f6228B;
            this.f6219O = eVar.f6229C;
            this.f6220P = eVar.f6230D;
            this.f6221Q = eVar.f6231E;
            this.f6214J = eVar.f6232F;
            this.f6222R = eVar.f6233G;
            this.f6223S = eVar.f6234H;
            this.f6224T = eVar.f6235I;
            this.f6225U = eVar.f6236J;
            this.f6226V = eVar.f6237K;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.C2650p
        public boolean equals(@Nullable Object obj) {
            boolean z2;
            boolean z3;
            boolean z4;
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (super.equals(dVar) && this.f6215K == dVar.f6215K && this.f6216L == dVar.f6216L && this.f6217M == dVar.f6217M && this.f6218N == dVar.f6218N && this.f6219O == dVar.f6219O && this.f6220P == dVar.f6220P && this.f6221Q == dVar.f6221Q && this.f6214J == dVar.f6214J && this.f6222R == dVar.f6222R && this.f6223S == dVar.f6223S && this.f6224T == dVar.f6224T) {
                SparseBooleanArray sparseBooleanArray = this.f6226V;
                SparseBooleanArray sparseBooleanArray2 = dVar.f6226V;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z2 = true;
                            break;
                        }
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                            z2 = false;
                            break;
                        }
                        i++;
                    }
                } else {
                    z2 = false;
                    break;
                }
                if (z2) {
                    SparseArray<Map<C2558o0, f>> sparseArray = this.f6225U;
                    SparseArray<Map<C2558o0, f>> sparseArray2 = dVar.f6225U;
                    int size2 = sparseArray.size();
                    if (sparseArray2.size() != size2) {
                        z3 = false;
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                if (iIndexOfKey < 0) {
                                    break;
                                }
                                Map<C2558o0, f> mapValueAt = sparseArray.valueAt(i2);
                                Map<C2558o0, f> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                                if (mapValueAt2.size() == mapValueAt.size()) {
                                    Iterator<Map.Entry<C2558o0, f>> it = mapValueAt.entrySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            z4 = true;
                                            break;
                                        }
                                        Map.Entry<C2558o0, f> next = it.next();
                                        C2558o0 key = next.getKey();
                                        if (!mapValueAt2.containsKey(key) || !C2738e0.m2993a(next.getValue(), mapValueAt2.get(key))) {
                                            z4 = false;
                                            break;
                                        }
                                    }
                                } else {
                                    z4 = false;
                                    break;
                                }
                                if (!z4) {
                                    break;
                                }
                                i2++;
                            } else {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                    if (z3) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.C2650p
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f6215K ? 1 : 0)) * 31) + (this.f6216L ? 1 : 0)) * 31) + (this.f6217M ? 1 : 0)) * 31) + (this.f6218N ? 1 : 0)) * 31) + (this.f6219O ? 1 : 0)) * 31) + (this.f6220P ? 1 : 0)) * 31) + (this.f6221Q ? 1 : 0)) * 31) + this.f6214J) * 31) + (this.f6222R ? 1 : 0)) * 31) + (this.f6223S ? 1 : 0)) * 31) + (this.f6224T ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$f */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class f implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public final int f6240j;

        /* JADX INFO: renamed from: k */
        public final int[] f6241k;

        /* JADX INFO: renamed from: l */
        public final int f6242l;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f6240j == fVar.f6240j && Arrays.equals(this.f6241k, fVar.f6241k) && this.f6242l == fVar.f6242l;
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.f6241k) + (this.f6240j * 31)) * 31) + this.f6242l;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$g */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class g implements Comparable<g> {

        /* JADX INFO: renamed from: j */
        public final boolean f6243j;

        /* JADX INFO: renamed from: k */
        public final boolean f6244k;

        /* JADX INFO: renamed from: l */
        public final boolean f6245l;

        /* JADX INFO: renamed from: m */
        public final boolean f6246m;

        /* JADX INFO: renamed from: n */
        public final int f6247n;

        /* JADX INFO: renamed from: o */
        public final int f6248o;

        /* JADX INFO: renamed from: p */
        public final int f6249p;

        /* JADX INFO: renamed from: q */
        public final int f6250q;

        /* JADX INFO: renamed from: r */
        public final boolean f6251r;

        public g(C2811j1 c2811j1, d dVar, int i, @Nullable String str) {
            int iM2735c;
            boolean z2 = false;
            this.f6244k = C2642h.m2737e(i, false);
            int i2 = c2811j1.f7147o & (~dVar.f6214J);
            this.f6245l = (i2 & 1) != 0;
            this.f6246m = (i2 & 2) != 0;
            int i3 = Integer.MAX_VALUE;
            AbstractC4523p<String> abstractC4523pM6266u = dVar.f6278B.isEmpty() ? AbstractC4523p.m6266u("") : dVar.f6278B;
            int i4 = 0;
            while (true) {
                if (i4 >= abstractC4523pM6266u.size()) {
                    iM2735c = 0;
                    break;
                }
                iM2735c = C2642h.m2735c(c2811j1, abstractC4523pM6266u.get(i4), dVar.f6280D);
                if (iM2735c > 0) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            this.f6247n = i3;
            this.f6248o = iM2735c;
            int iBitCount = Integer.bitCount(c2811j1.f7148p & dVar.f6279C);
            this.f6249p = iBitCount;
            this.f6251r = (c2811j1.f7148p & 1088) != 0;
            int iM2735c2 = C2642h.m2735c(c2811j1, str, C2642h.m2739g(str) == null);
            this.f6250q = iM2735c2;
            if (iM2735c > 0 || ((dVar.f6278B.isEmpty() && iBitCount > 0) || this.f6245l || (this.f6246m && iM2735c2 > 0))) {
                z2 = true;
            }
            this.f6243j = z2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            AbstractC4511j abstractC4511jMo6256c = AbstractC4511j.f12028a.mo6256c(this.f6244k, gVar.f6244k);
            Integer numValueOf = Integer.valueOf(this.f6247n);
            Integer numValueOf2 = Integer.valueOf(gVar.f6247n);
            AbstractC4506g0 abstractC4506g0 = C4504f0.f12005j;
            C4514k0 c4514k0 = C4514k0.f12038j;
            AbstractC4511j abstractC4511jMo6256c2 = abstractC4511jMo6256c.mo6255b(numValueOf, numValueOf2, c4514k0).mo6254a(this.f6248o, gVar.f6248o).mo6254a(this.f6249p, gVar.f6249p).mo6256c(this.f6245l, gVar.f6245l);
            Boolean boolValueOf = Boolean.valueOf(this.f6246m);
            Boolean boolValueOf2 = Boolean.valueOf(gVar.f6246m);
            if (this.f6248o != 0) {
                abstractC4506g0 = c4514k0;
            }
            AbstractC4511j abstractC4511jMo6254a = abstractC4511jMo6256c2.mo6255b(boolValueOf, boolValueOf2, abstractC4506g0).mo6254a(this.f6250q, gVar.f6250q);
            if (this.f6249p == 0) {
                abstractC4511jMo6254a = abstractC4511jMo6254a.mo6257d(this.f6251r, gVar.f6251r);
            }
            return abstractC4511jMo6254a.mo6258e();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$h */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class h implements Comparable<h> {

        /* JADX INFO: renamed from: j */
        public final boolean f6252j;

        /* JADX INFO: renamed from: k */
        public final d f6253k;

        /* JADX INFO: renamed from: l */
        public final boolean f6254l;

        /* JADX INFO: renamed from: m */
        public final boolean f6255m;

        /* JADX INFO: renamed from: n */
        public final int f6256n;

        /* JADX INFO: renamed from: o */
        public final int f6257o;

        /* JADX INFO: renamed from: p */
        public final int f6258p;

        /* JADX WARN: Code duplicated, block: B:21:0x0033  */
        /* JADX WARN: Code duplicated, block: B:41:0x005e  */
        public h(C2811j1 c2811j1, d dVar, int i, boolean z2) {
            boolean z3;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            this.f6253k = dVar;
            boolean z4 = true;
            int i9 = -1;
            if (!z2 || (((i6 = c2811j1.f7128B) != -1 && i6 > dVar.f6285k) || ((i7 = c2811j1.f7129C) != -1 && i7 > dVar.f6286l))) {
                z3 = false;
            } else {
                float f = c2811j1.f7130D;
                if ((f == -1.0f || f <= dVar.f6287m) && ((i8 = c2811j1.f7151s) == -1 || i8 <= dVar.f6288n)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            this.f6252j = z3;
            if (!z2 || (((i3 = c2811j1.f7128B) != -1 && i3 < dVar.f6289o) || ((i4 = c2811j1.f7129C) != -1 && i4 < dVar.f6290p))) {
                z4 = false;
            } else {
                float f2 = c2811j1.f7130D;
                if ((f2 != -1.0f && f2 < dVar.f6291q) || ((i5 = c2811j1.f7151s) != -1 && i5 < dVar.f6292r)) {
                    z4 = false;
                }
            }
            this.f6254l = z4;
            this.f6255m = C2642h.m2737e(i, false);
            this.f6256n = c2811j1.f7151s;
            int i10 = c2811j1.f7128B;
            if (i10 != -1 && (i2 = c2811j1.f7129C) != -1) {
                i9 = i10 * i2;
            }
            this.f6257o = i9;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < dVar.f6296v.size(); i12++) {
                String str = c2811j1.f7155w;
                if (str != null && str.equals(dVar.f6296v.get(i12))) {
                    i11 = i12;
                    break;
                }
            }
            this.f6258p = i11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            Object objMo6236b = (this.f6252j && this.f6255m) ? C2642h.f6193c : C2642h.f6193c.mo6236b();
            return AbstractC4511j.f12028a.mo6256c(this.f6255m, hVar.f6255m).mo6256c(this.f6252j, hVar.f6252j).mo6256c(this.f6254l, hVar.f6254l).mo6255b(Integer.valueOf(this.f6258p), Integer.valueOf(hVar.f6258p), C4514k0.f12038j).mo6255b(Integer.valueOf(this.f6256n), Integer.valueOf(hVar.f6256n), this.f6253k.f6281E ? C2642h.f6193c.mo6236b() : C2642h.f6194d).mo6255b(Integer.valueOf(this.f6257o), Integer.valueOf(hVar.f6257o), objMo6236b).mo6255b(Integer.valueOf(this.f6256n), Integer.valueOf(hVar.f6256n), objMo6236b).mo6258e();
        }
    }

    public C2642h(Context context) {
        C2640f.b bVar = new C2640f.b();
        d dVar = d.f6213I;
        d dVarM2745d = new e(context).m2745d();
        this.f6195e = bVar;
        this.f6196f = new AtomicReference<>(dVarM2745d);
    }

    /* JADX INFO: renamed from: c */
    public static int m2735c(C2811j1 c2811j1, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(c2811j1.f7146n)) {
            return 4;
        }
        String strM2739g = m2739g(str);
        String strM2739g2 = m2739g(c2811j1.f7146n);
        if (strM2739g2 == null || strM2739g == null) {
            return (z2 && strM2739g2 == null) ? 1 : 0;
        }
        if (strM2739g2.startsWith(strM2739g) || strM2739g.startsWith(strM2739g2)) {
            return 3;
        }
        int i = C2738e0.f6708a;
        return strM2739g2.split("-", 2)[0].equals(strM2739g.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0045  */
    /* JADX INFO: renamed from: d */
    public static List<Integer> m2736d(C2556n0 c2556n0, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList(c2556n0.f5661k);
        for (int i7 = 0; i7 < c2556n0.f5661k; i7++) {
            arrayList.add(Integer.valueOf(i7));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i8 = 0;
            int i9 = Integer.MAX_VALUE;
            while (true) {
                if (i8 >= c2556n0.f5661k) {
                    break;
                }
                C2811j1 c2811j1 = c2556n0.f5662l[i8];
                int i10 = c2811j1.f7128B;
                if (i10 > 0 && (i4 = c2811j1.f7129C) > 0) {
                    if (!z2) {
                        i5 = i;
                        i6 = i2;
                    } else if ((i10 > i4) != (i > i2)) {
                        i6 = i;
                        i5 = i2;
                    } else {
                        i5 = i;
                        i6 = i2;
                    }
                    int i11 = i10 * i6;
                    int i12 = i4 * i5;
                    Point point = i11 >= i12 ? new Point(i5, C2738e0.m2998f(i12, i10)) : new Point(C2738e0.m2998f(i11, i4), i6);
                    int i13 = c2811j1.f7128B;
                    int i14 = c2811j1.f7129C;
                    int i15 = i13 * i14;
                    if (i13 >= ((int) (point.x * 0.98f)) && i14 >= ((int) (point.y * 0.98f)) && i15 < i9) {
                        i9 = i15;
                    }
                }
                i8++;
            }
            if (i9 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C2811j1 c2811j2 = c2556n0.f5662l[((Integer) arrayList.get(size)).intValue()];
                    int i16 = c2811j2.f7128B;
                    int i17 = (i16 == -1 || (i3 = c2811j2.f7129C) == -1) ? -1 : i16 * i3;
                    if (i17 == -1 || i17 > i9) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2737e(int i, boolean z2) {
        int i2 = i & 7;
        return i2 == 4 || (z2 && i2 == 3);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m2738f(C2811j1 c2811j1, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if ((c2811j1.f7148p & 16384) != 0 || !m2737e(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !C2738e0.m2993a(c2811j1.f7155w, str)) {
            return false;
        }
        int i12 = c2811j1.f7128B;
        if (i12 != -1 && (i7 > i12 || i12 > i3)) {
            return false;
        }
        int i13 = c2811j1.f7129C;
        if (i13 != -1 && (i8 > i13 || i13 > i4)) {
            return false;
        }
        float f2 = c2811j1.f7130D;
        return (f2 == -1.0f || (((float) i9) <= f2 && f2 <= ((float) i5))) && (i11 = c2811j1.f7151s) != -1 && i10 <= i11 && i11 <= i6;
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public static String m2739g(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.h$e */
    /* JADX INFO: compiled from: DefaultTrackSelector.java */
    public static final class e extends C2650p.a {

        /* JADX INFO: renamed from: A */
        public boolean f6227A;

        /* JADX INFO: renamed from: B */
        public boolean f6228B;

        /* JADX INFO: renamed from: C */
        public boolean f6229C;

        /* JADX INFO: renamed from: D */
        public boolean f6230D;

        /* JADX INFO: renamed from: E */
        public boolean f6231E;

        /* JADX INFO: renamed from: F */
        public int f6232F;

        /* JADX INFO: renamed from: G */
        public boolean f6233G;

        /* JADX INFO: renamed from: H */
        public boolean f6234H;

        /* JADX INFO: renamed from: I */
        public boolean f6235I;

        /* JADX INFO: renamed from: J */
        public final SparseArray<Map<C2558o0, f>> f6236J;

        /* JADX INFO: renamed from: K */
        public final SparseBooleanArray f6237K;

        /* JADX INFO: renamed from: y */
        public boolean f6238y;

        /* JADX INFO: renamed from: z */
        public boolean f6239z;

        public e(Context context) {
            mo2742a(context);
            mo2744c(context, true);
            this.f6236J = new SparseArray<>();
            this.f6237K = new SparseBooleanArray();
            m2746e();
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.C2650p.a
        /* JADX INFO: renamed from: a */
        public C2650p.a mo2742a(Context context) {
            super.mo2742a(context);
            return this;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.C2650p.a
        /* JADX INFO: renamed from: b */
        public C2650p.a mo2743b(int i, int i2, boolean z2) {
            this.f6309i = i;
            this.f6310j = i2;
            this.f6311k = z2;
            return this;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.C2650p.a
        /* JADX INFO: renamed from: c */
        public C2650p.a mo2744c(Context context, boolean z2) {
            super.mo2744c(context, z2);
            return this;
        }

        /* JADX INFO: renamed from: d */
        public d m2745d() {
            return new d(this, null);
        }

        /* JADX INFO: renamed from: e */
        public final void m2746e() {
            this.f6238y = true;
            this.f6239z = false;
            this.f6227A = true;
            this.f6228B = true;
            this.f6229C = false;
            this.f6230D = false;
            this.f6231E = false;
            this.f6232F = 0;
            this.f6233G = true;
            this.f6234H = false;
            this.f6235I = true;
        }

        @Deprecated
        public e() {
            this.f6236J = new SparseArray<>();
            this.f6237K = new SparseBooleanArray();
            m2746e();
        }
    }
}
