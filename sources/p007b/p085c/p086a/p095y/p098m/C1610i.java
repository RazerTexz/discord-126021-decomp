package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p092b.C1528d;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1557n;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p094x.C1560a;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.C1564c;
import p007b.p085c.p086a.p095y.C1565d;
import p007b.p085c.p086a.p095y.C1566e;
import p007b.p085c.p086a.p095y.C1571j;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1582k;
import p007b.p085c.p086a.p095y.p097l.C1598m;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.m.i */
/* JADX INFO: compiled from: TextLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1610i extends AbstractC1603b {

    /* JADX INFO: renamed from: A */
    public final Paint f2905A;

    /* JADX INFO: renamed from: B */
    public final Paint f2906B;

    /* JADX INFO: renamed from: C */
    public final Map<C1566e, List<C1528d>> f2907C;

    /* JADX INFO: renamed from: D */
    public final LongSparseArray<String> f2908D;

    /* JADX INFO: renamed from: E */
    public final C1557n f2909E;

    /* JADX INFO: renamed from: F */
    public final C1511j f2910F;

    /* JADX INFO: renamed from: G */
    public final C1505d f2911G;

    /* JADX INFO: renamed from: H */
    @Nullable
    public AbstractC1544a<Integer, Integer> f2912H;

    /* JADX INFO: renamed from: I */
    @Nullable
    public AbstractC1544a<Integer, Integer> f2913I;

    /* JADX INFO: renamed from: J */
    @Nullable
    public AbstractC1544a<Integer, Integer> f2914J;

    /* JADX INFO: renamed from: K */
    @Nullable
    public AbstractC1544a<Integer, Integer> f2915K;

    /* JADX INFO: renamed from: L */
    @Nullable
    public AbstractC1544a<Float, Float> f2916L;

    /* JADX INFO: renamed from: M */
    @Nullable
    public AbstractC1544a<Float, Float> f2917M;

    /* JADX INFO: renamed from: N */
    @Nullable
    public AbstractC1544a<Float, Float> f2918N;

    /* JADX INFO: renamed from: O */
    @Nullable
    public AbstractC1544a<Float, Float> f2919O;

    /* JADX INFO: renamed from: P */
    @Nullable
    public AbstractC1544a<Float, Float> f2920P;

    /* JADX INFO: renamed from: x */
    public final StringBuilder f2921x;

    /* JADX INFO: renamed from: y */
    public final RectF f2922y;

    /* JADX INFO: renamed from: z */
    public final Matrix f2923z;

    /* JADX INFO: renamed from: b.c.a.y.m.i$a */
    /* JADX INFO: compiled from: TextLayer.java */
    public class a extends Paint {
        public a(C1610i c1610i, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: renamed from: b.c.a.y.m.i$b */
    /* JADX INFO: compiled from: TextLayer.java */
    public class b extends Paint {
        public b(C1610i c1610i, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public C1610i(C1511j c1511j, C1606e c1606e) {
        C1573b c1573b;
        C1573b c1573b2;
        C1572a c1572a;
        C1572a c1572a2;
        super(c1511j, c1606e);
        this.f2921x = new StringBuilder(2);
        this.f2922y = new RectF();
        this.f2923z = new Matrix();
        this.f2905A = new a(this, 1);
        this.f2906B = new b(this, 1);
        this.f2907C = new HashMap();
        this.f2908D = new LongSparseArray<>();
        this.f2910F = c1511j;
        this.f2911G = c1606e.f2869b;
        C1557n c1557n = new C1557n(c1606e.f2884q.f2738a);
        this.f2909E = c1557n;
        c1557n.f2596a.add(this);
        m777e(c1557n);
        C1582k c1582k = c1606e.f2885r;
        if (c1582k != null && (c1572a2 = c1582k.f2725a) != null) {
            AbstractC1544a<Integer, Integer> abstractC1544aMo773a = c1572a2.mo773a();
            this.f2912H = abstractC1544aMo773a;
            abstractC1544aMo773a.f2596a.add(this);
            m777e(this.f2912H);
        }
        if (c1582k != null && (c1572a = c1582k.f2726b) != null) {
            AbstractC1544a<Integer, Integer> abstractC1544aMo773a2 = c1572a.mo773a();
            this.f2914J = abstractC1544aMo773a2;
            abstractC1544aMo773a2.f2596a.add(this);
            m777e(this.f2914J);
        }
        if (c1582k != null && (c1573b2 = c1582k.f2727c) != null) {
            AbstractC1544a<Float, Float> abstractC1544aMo773a3 = c1573b2.mo773a();
            this.f2916L = abstractC1544aMo773a3;
            abstractC1544aMo773a3.f2596a.add(this);
            m777e(this.f2916L);
        }
        if (c1582k == null || (c1573b = c1582k.f2728d) == null) {
            return;
        }
        AbstractC1544a<Float, Float> abstractC1544aMo773a4 = c1573b.mo773a();
        this.f2918N = abstractC1544aMo773a4;
        abstractC1544aMo773a4.f2596a.add(this);
        m777e(this.f2918N);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.f2911G.f2345j.width(), this.f2911G.f2345j.height());
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        this.f2857v.m745c(t, c1503c);
        if (t == InterfaceC1516o.f2423a) {
            AbstractC1544a<Integer, Integer> abstractC1544a = this.f2913I;
            if (abstractC1544a != null) {
                this.f2856u.remove(abstractC1544a);
            }
            if (c1503c == null) {
                this.f2913I = null;
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2913I = c1559p;
            c1559p.f2596a.add(this);
            m777e(this.f2913I);
            return;
        }
        if (t == InterfaceC1516o.f2424b) {
            AbstractC1544a<Integer, Integer> abstractC1544a2 = this.f2915K;
            if (abstractC1544a2 != null) {
                this.f2856u.remove(abstractC1544a2);
            }
            if (c1503c == null) {
                this.f2915K = null;
                return;
            }
            C1559p c1559p2 = new C1559p(c1503c, null);
            this.f2915K = c1559p2;
            c1559p2.f2596a.add(this);
            m777e(this.f2915K);
            return;
        }
        if (t == InterfaceC1516o.f2437o) {
            AbstractC1544a<Float, Float> abstractC1544a3 = this.f2917M;
            if (abstractC1544a3 != null) {
                this.f2856u.remove(abstractC1544a3);
            }
            if (c1503c == null) {
                this.f2917M = null;
                return;
            }
            C1559p c1559p3 = new C1559p(c1503c, null);
            this.f2917M = c1559p3;
            c1559p3.f2596a.add(this);
            m777e(this.f2917M);
            return;
        }
        if (t == InterfaceC1516o.f2438p) {
            AbstractC1544a<Float, Float> abstractC1544a4 = this.f2919O;
            if (abstractC1544a4 != null) {
                this.f2856u.remove(abstractC1544a4);
            }
            if (c1503c == null) {
                this.f2919O = null;
                return;
            }
            C1559p c1559p4 = new C1559p(c1503c, null);
            this.f2919O = c1559p4;
            c1559p4.f2596a.add(this);
            m777e(this.f2919O);
            return;
        }
        if (t == InterfaceC1516o.f2420B) {
            AbstractC1544a<Float, Float> abstractC1544a5 = this.f2920P;
            if (abstractC1544a5 != null) {
                this.f2856u.remove(abstractC1544a5);
            }
            if (c1503c == null) {
                this.f2920P = null;
                return;
            }
            C1559p c1559p5 = new C1559p(c1503c, null);
            this.f2920P = c1559p5;
            c1559p5.f2596a.add(this);
            m777e(this.f2920P);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        C1560a c1560a;
        String str;
        float fFloatValue;
        int i2;
        int i3;
        String str2;
        List<C1528d> list;
        float fFloatValue2;
        canvas.save();
        if (!(this.f2910F.f2370k.f2342g.size() > 0)) {
            canvas.setMatrix(matrix);
        }
        C1564c c1564cMo727e = this.f2909E.mo727e();
        C1565d c1565d = this.f2911G.f2340e.get(c1564cMo727e.f2694b);
        if (c1565d == null) {
            canvas.restore();
            return;
        }
        AbstractC1544a<Integer, Integer> abstractC1544a = this.f2913I;
        if (abstractC1544a != null) {
            this.f2905A.setColor(abstractC1544a.mo727e().intValue());
        } else {
            AbstractC1544a<Integer, Integer> abstractC1544a2 = this.f2912H;
            if (abstractC1544a2 != null) {
                this.f2905A.setColor(abstractC1544a2.mo727e().intValue());
            } else {
                this.f2905A.setColor(c1564cMo727e.f2700h);
            }
        }
        AbstractC1544a<Integer, Integer> abstractC1544a3 = this.f2915K;
        if (abstractC1544a3 != null) {
            this.f2906B.setColor(abstractC1544a3.mo727e().intValue());
        } else {
            AbstractC1544a<Integer, Integer> abstractC1544a4 = this.f2914J;
            if (abstractC1544a4 != null) {
                this.f2906B.setColor(abstractC1544a4.mo727e().intValue());
            } else {
                this.f2906B.setColor(c1564cMo727e.f2701i);
            }
        }
        AbstractC1544a<Integer, Integer> abstractC1544a5 = this.f2857v.f2636j;
        int iIntValue = ((abstractC1544a5 == null ? 100 : abstractC1544a5.mo727e().intValue()) * 255) / 100;
        this.f2905A.setAlpha(iIntValue);
        this.f2906B.setAlpha(iIntValue);
        AbstractC1544a<Float, Float> abstractC1544a6 = this.f2917M;
        if (abstractC1544a6 != null) {
            this.f2906B.setStrokeWidth(abstractC1544a6.mo727e().floatValue());
        } else {
            AbstractC1544a<Float, Float> abstractC1544a7 = this.f2916L;
            if (abstractC1544a7 != null) {
                this.f2906B.setStrokeWidth(abstractC1544a7.mo727e().floatValue());
            } else {
                this.f2906B.setStrokeWidth(C1499g.m659c() * c1564cMo727e.f2702j * C1499g.m660d(matrix));
            }
        }
        if (this.f2910F.f2370k.f2342g.size() > 0) {
            AbstractC1544a<Float, Float> abstractC1544a8 = this.f2920P;
            float fFloatValue3 = (abstractC1544a8 != null ? abstractC1544a8.mo727e().floatValue() : c1564cMo727e.f2695c) / 100.0f;
            float fM660d = C1499g.m660d(matrix);
            String str3 = c1564cMo727e.f2693a;
            float fM659c = C1499g.m659c() * c1564cMo727e.f2698f;
            List<String> listM792t = m792t(str3);
            int size = listM792t.size();
            int i4 = 0;
            while (i4 < size) {
                String str4 = listM792t.get(i4);
                float fM659c2 = 0.0f;
                int i5 = 0;
                while (i5 < str4.length()) {
                    C1566e c1566e = this.f2911G.f2342g.get(C1566e.m765a(str4.charAt(i5), c1565d.f2704a, c1565d.f2706c));
                    if (c1566e != null) {
                        fM659c2 = (float) ((c1566e.f2709c * ((double) fFloatValue3) * ((double) C1499g.m659c()) * ((double) fM660d)) + ((double) fM659c2));
                    }
                    i5++;
                    str4 = str4;
                    fM659c = fM659c;
                    i4 = i4;
                }
                float f = fM659c;
                int i6 = i4;
                String str5 = str4;
                canvas.save();
                m789q(c1564cMo727e.f2696d, canvas, fM659c2);
                canvas.translate(0.0f, (i6 * f) - (((size - 1) * f) / 2.0f));
                int i7 = 0;
                while (i7 < str5.length()) {
                    String str6 = str5;
                    C1566e c1566e2 = this.f2911G.f2342g.get(C1566e.m765a(str6.charAt(i7), c1565d.f2704a, c1565d.f2706c));
                    if (c1566e2 == null) {
                        listM792t = listM792t;
                        i3 = size;
                        str2 = str6;
                    } else {
                        if (this.f2907C.containsKey(c1566e2)) {
                            list = this.f2907C.get(c1566e2);
                            i3 = size;
                            str2 = str6;
                        } else {
                            List<C1598m> list2 = c1566e2.f2707a;
                            int size2 = list2.size();
                            ArrayList arrayList = new ArrayList(size2);
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new C1528d(this.f2910F, this, list2.get(i8)));
                                i8++;
                                str6 = str6;
                                size = size;
                                list2 = list2;
                            }
                            i3 = size;
                            str2 = str6;
                            this.f2907C.put(c1566e2, arrayList);
                            list = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list.size()) {
                            Path path = list.get(i9).getPath();
                            path.computeBounds(this.f2922y, false);
                            this.f2923z.set(matrix);
                            List<C1528d> list3 = list;
                            this.f2923z.preTranslate(0.0f, (-c1564cMo727e.f2699g) * C1499g.m659c());
                            this.f2923z.preScale(fFloatValue3, fFloatValue3);
                            path.transform(this.f2923z);
                            if (c1564cMo727e.f2703k) {
                                m791s(path, this.f2905A, canvas);
                                m791s(path, this.f2906B, canvas);
                            } else {
                                m791s(path, this.f2906B, canvas);
                                m791s(path, this.f2905A, canvas);
                            }
                            i9++;
                            list = list3;
                        }
                        float fM659c3 = C1499g.m659c() * ((float) c1566e2.f2709c) * fFloatValue3 * fM660d;
                        float f2 = c1564cMo727e.f2697e / 10.0f;
                        AbstractC1544a<Float, Float> abstractC1544a9 = this.f2919O;
                        if (abstractC1544a9 != null) {
                            fFloatValue2 = abstractC1544a9.mo727e().floatValue();
                        } else {
                            AbstractC1544a<Float, Float> abstractC1544a10 = this.f2918N;
                            if (abstractC1544a10 != null) {
                                fFloatValue2 = abstractC1544a10.mo727e().floatValue();
                            }
                            canvas.translate((f2 * fM660d) + fM659c3, 0.0f);
                        }
                        f2 += fFloatValue2;
                        canvas.translate((f2 * fM660d) + fM659c3, 0.0f);
                    }
                    i7++;
                    listM792t = listM792t;
                    str5 = str2;
                    size = i3;
                }
                canvas.restore();
                i4 = i6 + 1;
                fM659c = f;
            }
        } else {
            float fM660d2 = C1499g.m660d(matrix);
            C1511j c1511j = this.f2910F;
            String str7 = c1565d.f2704a;
            String str8 = c1565d.f2706c;
            Typeface typefaceCreate = null;
            if (c1511j.getCallback() == null) {
                c1560a = null;
            } else {
                if (c1511j.f2381v == null) {
                    c1511j.f2381v = new C1560a(c1511j.getCallback());
                }
                c1560a = c1511j.f2381v;
            }
            if (c1560a != null) {
                C1571j<String> c1571j = c1560a.f2642a;
                c1571j.f2720a = str7;
                c1571j.f2721b = str8;
                typefaceCreate = c1560a.f2643b.get(c1571j);
                if (typefaceCreate == null) {
                    Typeface typefaceCreateFromAsset = c1560a.f2644c.get(str7);
                    if (typefaceCreateFromAsset == null) {
                        StringBuilder sbM836X = C1643a.m836X("fonts/", str7);
                        sbM836X.append(c1560a.f2646e);
                        typefaceCreateFromAsset = Typeface.createFromAsset(c1560a.f2645d, sbM836X.toString());
                        c1560a.f2644c.put(str7, typefaceCreateFromAsset);
                    }
                    boolean zContains = str8.contains("Italic");
                    boolean zContains2 = str8.contains("Bold");
                    if (zContains && zContains2) {
                        i2 = 3;
                    } else if (zContains) {
                        i2 = 2;
                    } else {
                        i2 = zContains2 ? 1 : 0;
                    }
                    typefaceCreate = typefaceCreateFromAsset.getStyle() == i2 ? typefaceCreateFromAsset : Typeface.create(typefaceCreateFromAsset, i2);
                    c1560a.f2643b.put(c1560a.f2642a, typefaceCreate);
                }
            }
            if (typefaceCreate != null) {
                String str9 = c1564cMo727e.f2693a;
                Objects.requireNonNull(this.f2910F);
                this.f2905A.setTypeface(typefaceCreate);
                AbstractC1544a<Float, Float> abstractC1544a11 = this.f2920P;
                this.f2905A.setTextSize(C1499g.m659c() * (abstractC1544a11 != null ? abstractC1544a11.mo727e().floatValue() : c1564cMo727e.f2695c));
                this.f2906B.setTypeface(this.f2905A.getTypeface());
                this.f2906B.setTextSize(this.f2905A.getTextSize());
                float fM659c4 = C1499g.m659c() * c1564cMo727e.f2698f;
                List<String> listM792t2 = m792t(str9);
                int size3 = listM792t2.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    String str10 = listM792t2.get(i10);
                    m789q(c1564cMo727e.f2696d, canvas, this.f2906B.measureText(str10));
                    canvas.translate(0.0f, (i10 * fM659c4) - (((size3 - 1) * fM659c4) / 2.0f));
                    int length = 0;
                    while (length < str10.length()) {
                        int iCodePointAt = str10.codePointAt(length);
                        int iCharCount = Character.charCount(iCodePointAt) + length;
                        while (iCharCount < str10.length()) {
                            int iCodePointAt2 = str10.codePointAt(iCharCount);
                            if (!(Character.getType(iCodePointAt2) == 16 || Character.getType(iCodePointAt2) == 27 || Character.getType(iCodePointAt2) == 6 || Character.getType(iCodePointAt2) == 28 || Character.getType(iCodePointAt2) == 19)) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                        }
                        int i11 = size3;
                        float f3 = fM659c4;
                        long j = iCodePointAt;
                        if (this.f2908D.containsKey(j)) {
                            str = this.f2908D.get(j);
                        } else {
                            this.f2921x.setLength(0);
                            int iCharCount2 = length;
                            while (iCharCount2 < iCharCount) {
                                int iCodePointAt3 = str10.codePointAt(iCharCount2);
                                this.f2921x.appendCodePoint(iCodePointAt3);
                                iCharCount2 += Character.charCount(iCodePointAt3);
                            }
                            String string = this.f2921x.toString();
                            this.f2908D.put(j, string);
                            str = string;
                        }
                        length += str.length();
                        if (c1564cMo727e.f2703k) {
                            m790r(str, this.f2905A, canvas);
                            m790r(str, this.f2906B, canvas);
                        } else {
                            m790r(str, this.f2906B, canvas);
                            m790r(str, this.f2905A, canvas);
                        }
                        float fMeasureText = this.f2905A.measureText(str, 0, 1);
                        float f4 = c1564cMo727e.f2697e / 10.0f;
                        AbstractC1544a<Float, Float> abstractC1544a12 = this.f2919O;
                        if (abstractC1544a12 != null) {
                            fFloatValue = abstractC1544a12.mo727e().floatValue();
                        } else {
                            AbstractC1544a<Float, Float> abstractC1544a13 = this.f2918N;
                            if (abstractC1544a13 != null) {
                                fFloatValue = abstractC1544a13.mo727e().floatValue();
                            }
                            canvas.translate((f4 * fM660d2) + fMeasureText, 0.0f);
                            fM659c4 = f3;
                            size3 = i11;
                        }
                        f4 += fFloatValue;
                        canvas.translate((f4 * fM660d2) + fMeasureText, 0.0f);
                        fM659c4 = f3;
                        size3 = i11;
                    }
                    canvas.setMatrix(matrix);
                }
            }
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: q */
    public final void m789q(int i, Canvas canvas, float f) {
        int iM758h = C1563b.m758h(i);
        if (iM758h == 1) {
            canvas.translate(-f, 0.0f);
        } else {
            if (iM758h != 2) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m790r(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* JADX INFO: renamed from: s */
    public final void m791s(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /* JADX INFO: renamed from: t */
    public final List<String> m792t(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
}
