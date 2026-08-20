package p007b.p225i.p226a.p242c.p256d3;

import android.content.Context;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.SparseArray;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p505ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2601a;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2603c;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2604d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p356a.C4483c;
import p007b.p225i.p355b.p357b.C4510i0;

/* JADX INFO: renamed from: b.i.a.c.d3.r */
/* JADX INFO: compiled from: WebViewSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2674r extends FrameLayout implements SubtitleView.InterfaceC10760a {

    /* JADX INFO: renamed from: j */
    public final C2666j f6402j;

    /* JADX INFO: renamed from: k */
    public final WebView f6403k;

    /* JADX INFO: renamed from: l */
    public List<C2578b> f6404l;

    /* JADX INFO: renamed from: m */
    public C2667k f6405m;

    /* JADX INFO: renamed from: n */
    public float f6406n;

    /* JADX INFO: renamed from: o */
    public int f6407o;

    /* JADX INFO: renamed from: p */
    public float f6408p;

    /* JADX INFO: renamed from: b.i.a.c.d3.r$a */
    /* JADX INFO: compiled from: WebViewSubtitleOutput.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f6409a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f6409a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6409a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6409a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C2674r(Context context) {
        super(context, null);
        this.f6404l = Collections.emptyList();
        this.f6405m = C2667k.f6349a;
        this.f6406n = 0.0533f;
        this.f6407o = 0;
        this.f6408p = 0.08f;
        C2666j c2666j = new C2666j(context, null);
        this.f6402j = c2666j;
        C2673q c2673q = new C2673q(context, null);
        this.f6403k = c2673q;
        c2673q.setBackgroundColor(0);
        addView(c2666j);
        addView(c2673q);
    }

    /* JADX INFO: renamed from: b */
    public static int m2766b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    /* JADX INFO: renamed from: c */
    public static String m2767c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = a.f6409a[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }

    @Override // com.google.android.exoplayer2.p505ui.SubtitleView.InterfaceC10760a
    /* JADX INFO: renamed from: a */
    public void mo2758a(List<C2578b> list, C2667k c2667k, float f, int i, float f2) {
        this.f6405m = c2667k;
        this.f6406n = f;
        this.f6407o = i;
        this.f6408p = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2578b c2578b = list.get(i2);
            if (c2578b.f5761o != null) {
                arrayList.add(c2578b);
            } else {
                arrayList2.add(c2578b);
            }
        }
        if (!this.f6404l.isEmpty() || !arrayList2.isEmpty()) {
            this.f6404l = arrayList2;
            m2769e();
        }
        this.f6402j.mo2758a(arrayList, c2667k, f, i, f2);
        invalidate();
    }

    /* JADX INFO: renamed from: d */
    public final String m2768d(int i, float f) {
        float fM479U1 = C1460d.m479U1(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fM479U1 == -3.4028235E38f ? "unset" : C2738e0.m3003k("%.2fpx", Float.valueOf(fM479U1 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0434  */
    /* JADX WARN: Code duplicated, block: B:206:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:233:0x0599  */
    /* JADX WARN: Code duplicated, block: B:239:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:243:0x0609  */
    /* JADX WARN: Code duplicated, block: B:248:0x0615  */
    /* JADX WARN: Code duplicated, block: B:250:0x0629  */
    /* JADX WARN: Code duplicated, block: B:253:0x064b  */
    /* JADX WARN: Code duplicated, block: B:254:0x0667  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b5  */
    /* JADX INFO: renamed from: e */
    public final void m2769e() {
        String strM3003k;
        char c;
        String strM3003k2;
        int iM2766b;
        String strM3003k3;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        C2669m.b bVar;
        String str7;
        String str8;
        int i2;
        String strM3003k4;
        String str9;
        String strM859k;
        float f;
        int i3;
        String strM3003k5;
        Layout.Alignment alignment;
        String str10;
        int i4;
        String str11;
        String str12;
        boolean z2;
        C2674r c2674r = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c2 = 0;
        objArr[0] = C1460d.m518f2(c2674r.f6405m.f6350b);
        int i5 = 1;
        objArr[1] = c2674r.m2768d(c2674r.f6407o, c2674r.f6406n);
        float f2 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        C2667k c2667k = c2674r.f6405m;
        int i6 = c2667k.f6353e;
        if (i6 == 1) {
            strM3003k = C2738e0.m3003k("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", C1460d.m518f2(c2667k.f6354f));
        } else if (i6 == 2) {
            strM3003k = C2738e0.m3003k("0.1em 0.12em 0.15em %s", C1460d.m518f2(c2667k.f6354f));
        } else if (i6 != 3) {
            strM3003k = i6 != 4 ? "unset" : C2738e0.m3003k("-0.05em -0.05em 0.15em %s", C1460d.m518f2(c2667k.f6354f));
        } else {
            strM3003k = C2738e0.m3003k("0.06em 0.08em 0.15em %s", C1460d.m518f2(c2667k.f6354f));
        }
        objArr[3] = strM3003k;
        sb.append(C2738e0.m3003k("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr));
        HashMap map = new HashMap();
        String str13 = "default_bg";
        String str14 = "background-color:%s;";
        map.put(C1460d.m483W("default_bg"), C2738e0.m3003k("background-color:%s;", C1460d.m518f2(c2674r.f6405m.f6351c)));
        int i7 = 0;
        while (i7 < c2674r.f6404l.size()) {
            C2578b c2578b = c2674r.f6404l.get(i7);
            float f3 = c2578b.f5765s;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int iM2766b2 = m2766b(c2578b.f5766t);
            float f5 = c2578b.f5762p;
            if (f5 == -3.4028235E38f) {
                c = 0;
                Object[] objArr2 = new Object[i5];
                objArr2[0] = Float.valueOf((1.0f - c2674r.f6408p) * 100.0f);
                strM3003k2 = C2738e0.m3003k("%.2f%%", objArr2);
                c2 = 0;
                iM2766b = -100;
            } else if (c2578b.f5763q != i5) {
                Object[] objArr3 = new Object[i5];
                objArr3[c2] = Float.valueOf(f5 * 100.0f);
                strM3003k2 = C2738e0.m3003k("%.2f%%", objArr3);
                c = 0;
                iM2766b = c2578b.f5756A == i5 ? -m2766b(c2578b.f5764r) : m2766b(c2578b.f5764r);
            } else {
                if (f5 >= 0.0f) {
                    Object[] objArr4 = new Object[i5];
                    Float fValueOf = Float.valueOf(f5 * f2);
                    c = 0;
                    objArr4[0] = fValueOf;
                    strM3003k2 = C2738e0.m3003k("%.2fem", objArr4);
                    c2 = 0;
                } else {
                    Object[] objArr5 = new Object[i5];
                    Float fValueOf2 = Float.valueOf(((-f5) - 1.0f) * f2);
                    c = 0;
                    objArr5[0] = fValueOf2;
                    strM3003k2 = C2738e0.m3003k("%.2fem", objArr5);
                    c2 = 1;
                }
                iM2766b = 0;
            }
            float f6 = c2578b.f5767u;
            if (f6 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i5];
                objArr6[c] = Float.valueOf(f6 * 100.0f);
                strM3003k3 = C2738e0.m3003k("%.2f%%", objArr6);
            } else {
                strM3003k3 = "fit-content";
            }
            String strM2767c = m2767c(c2578b.f5759m);
            int i8 = c2578b.f5756A;
            String str15 = i8 != i5 ? i8 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
            String strM2768d = c2674r.m2768d(c2578b.f5771y, c2578b.f5772z);
            String strM518f2 = C1460d.m518f2(c2578b.f5769w ? c2578b.f5770x : c2674r.f6405m.f6352d);
            int i9 = c2578b.f5756A;
            String str16 = "right";
            String str17 = "left";
            String str18 = str13;
            if (i9 == 1) {
                if (c2 != 0) {
                    str16 = "left";
                }
                i = 2;
                str17 = "top";
                str = str16;
            } else if (i9 != 2) {
                str = c2 != 0 ? "bottom" : "top";
                i = 2;
            } else {
                if (c2 == 0) {
                    str16 = "left";
                }
                i = 2;
                str17 = "top";
                str = str16;
            }
            if (i9 == i || i9 == 1) {
                str2 = "height";
            } else {
                str2 = "width";
                iM2766b2 = iM2766b;
                iM2766b = iM2766b2;
            }
            CharSequence charSequence = c2578b.f5758l;
            float f7 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = C2669m.f6357a;
            StringBuilder sb2 = sb;
            String str19 = "";
            if (charSequence == null) {
                bVar = new C2669m.b("", C4510i0.f12015m, null);
            } else {
                if (charSequence instanceof Spanned) {
                    str19 = "";
                    Spanned spanned = (Spanned) charSequence;
                    HashSet hashSet = new HashSet();
                    BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
                    int length = backgroundColorSpanArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        hashSet.add(Integer.valueOf(backgroundColorSpanArr[i10].getBackgroundColor()));
                        i10++;
                        backgroundColorSpanArr = backgroundColorSpanArr;
                    }
                    HashMap map2 = new HashMap();
                    for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        StringBuilder sb3 = new StringBuilder(14);
                        sb3.append("bg_");
                        sb3.append(iIntValue);
                        map2.put(C1460d.m483W(sb3.toString()), C2738e0.m3003k(str14, C1460d.m518f2(iIntValue)));
                    }
                    SparseArray sparseArray = new SparseArray();
                    Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
                    int length2 = spans.length;
                    int i11 = 0;
                    while (i11 < length2) {
                        int i12 = length2;
                        Object obj = spans[i11];
                        Object[] objArr7 = spans;
                        boolean z3 = obj instanceof StrikethroughSpan;
                        if (z3) {
                            str8 = strM2767c;
                            str7 = str15;
                            strM3003k4 = "<span style='text-decoration:line-through;'>";
                        } else {
                            str7 = str15;
                            if (obj instanceof ForegroundColorSpan) {
                                str8 = strM2767c;
                                strM3003k4 = C2738e0.m3003k("<span style='color:%s;'>", C1460d.m518f2(((ForegroundColorSpan) obj).getForegroundColor()));
                            } else {
                                str8 = strM2767c;
                                if (obj instanceof BackgroundColorSpan) {
                                    strM3003k4 = C2738e0.m3003k("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
                                } else if (obj instanceof C2601a) {
                                    strM3003k4 = "<span style='text-combine-upright:all;'>";
                                } else if (obj instanceof AbsoluteSizeSpan) {
                                    AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                                    strM3003k4 = C2738e0.m3003k("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f7));
                                } else if (obj instanceof RelativeSizeSpan) {
                                    strM3003k4 = C2738e0.m3003k("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
                                } else if (obj instanceof TypefaceSpan) {
                                    String family = ((TypefaceSpan) obj).getFamily();
                                    strM3003k4 = family != null ? C2738e0.m3003k("<span style='font-family:\"%s\";'>", family) : null;
                                } else if (obj instanceof StyleSpan) {
                                    int style = ((StyleSpan) obj).getStyle();
                                    if (style == 1) {
                                        strM3003k4 = "<b>";
                                    } else if (style == 2) {
                                        strM3003k4 = "<i>";
                                    } else if (style != 3) {
                                        strM3003k4 = null;
                                    } else {
                                        strM3003k4 = "<b><i>";
                                    }
                                } else if (obj instanceof C2603c) {
                                    int i13 = ((C2603c) obj).f5982b;
                                    if (i13 == -1) {
                                        strM3003k4 = "<ruby style='ruby-position:unset;'>";
                                    } else if (i13 == 1) {
                                        strM3003k4 = "<ruby style='ruby-position:over;'>";
                                    } else if (i13 != 2) {
                                        strM3003k4 = null;
                                    } else {
                                        strM3003k4 = "<ruby style='ruby-position:under;'>";
                                    }
                                } else if (obj instanceof UnderlineSpan) {
                                    strM3003k4 = "<u>";
                                } else if (obj instanceof C2604d) {
                                    C2604d c2604d = (C2604d) obj;
                                    int i14 = c2604d.f5983a;
                                    int i15 = c2604d.f5984b;
                                    StringBuilder sb4 = new StringBuilder();
                                    if (i15 != 1) {
                                        i2 = 2;
                                        if (i15 == 2) {
                                            sb4.append("open ");
                                        }
                                    } else {
                                        i2 = 2;
                                        sb4.append("filled ");
                                    }
                                    if (i14 == 0) {
                                        sb4.append("none");
                                    } else if (i14 == 1) {
                                        sb4.append("circle");
                                    } else if (i14 == i2) {
                                        sb4.append("dot");
                                    } else if (i14 != 3) {
                                        sb4.append("unset");
                                    } else {
                                        sb4.append("sesame");
                                    }
                                    strM3003k4 = C2738e0.m3003k("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4.toString(), c2604d.f5985c != 2 ? "over right" : "under left");
                                } else {
                                    strM3003k4 = null;
                                }
                            }
                        }
                        String str20 = strM3003k4;
                        if (z3 || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof C2601a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof C2604d)) {
                            str9 = "</span>";
                        } else {
                            if (!(obj instanceof TypefaceSpan)) {
                                if (obj instanceof StyleSpan) {
                                    int style2 = ((StyleSpan) obj).getStyle();
                                    if (style2 == 1) {
                                        strM859k = "</b>";
                                    } else if (style2 == 2) {
                                        strM859k = "</i>";
                                    } else if (style2 == 3) {
                                        strM859k = "</i></b>";
                                    }
                                } else if (obj instanceof C2603c) {
                                    String strM2759a = C2669m.m2759a(((C2603c) obj).f5981a);
                                    strM859k = C1643a.m859k(C1643a.m841b(strM2759a, 16), "<rt>", strM2759a, "</rt></ruby>");
                                } else if (obj instanceof UnderlineSpan) {
                                    strM859k = "</u>";
                                }
                                str9 = strM859k;
                            } else if (((TypefaceSpan) obj).getFamily() != null) {
                                str9 = "</span>";
                            }
                            strM859k = null;
                            str9 = strM859k;
                        }
                        int spanStart = spanned.getSpanStart(obj);
                        int spanEnd = spanned.getSpanEnd(obj);
                        if (str20 != null) {
                            Objects.requireNonNull(str9);
                            C2669m.c cVar = new C2669m.c(spanStart, spanEnd, str20, str9, null);
                            C2669m.d dVar = (C2669m.d) sparseArray.get(spanStart);
                            if (dVar == null) {
                                dVar = new C2669m.d();
                                sparseArray.put(spanStart, dVar);
                            }
                            dVar.f6364a.add(cVar);
                            C2669m.d dVar2 = (C2669m.d) sparseArray.get(spanEnd);
                            if (dVar2 == null) {
                                dVar2 = new C2669m.d();
                                sparseArray.put(spanEnd, dVar2);
                            }
                            dVar2.f6365b.add(cVar);
                        }
                        i11++;
                        length2 = i12;
                        spans = objArr7;
                        str15 = str7;
                        strM2767c = str8;
                        f7 = f7;
                        strM3003k3 = strM3003k3;
                        str2 = str2;
                    }
                    str3 = str2;
                    str4 = str15;
                    str5 = strM3003k3;
                    str6 = strM2767c;
                    StringBuilder sb5 = new StringBuilder(spanned.length());
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < sparseArray.size()) {
                        int iKeyAt = sparseArray.keyAt(i16);
                        sb5.append(C2669m.m2759a(spanned.subSequence(i17, iKeyAt)));
                        C2669m.d dVar3 = (C2669m.d) sparseArray.get(iKeyAt);
                        Collections.sort(dVar3.f6365b, new Comparator() { // from class: b.i.a.c.d3.f
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                C2669m.c cVar2 = (C2669m.c) obj2;
                                C2669m.c cVar3 = (C2669m.c) obj3;
                                int iCompare = Integer.compare(cVar3.f6360a, cVar2.f6360a);
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                                int iCompareTo = cVar3.f6362c.compareTo(cVar2.f6362c);
                                return iCompareTo != 0 ? iCompareTo : cVar3.f6363d.compareTo(cVar2.f6363d);
                            }
                        });
                        Iterator<C2669m.c> it2 = dVar3.f6365b.iterator();
                        while (it2.hasNext()) {
                            sb5.append(it2.next().f6363d);
                        }
                        Collections.sort(dVar3.f6364a, new Comparator() { // from class: b.i.a.c.d3.e
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                C2669m.c cVar2 = (C2669m.c) obj2;
                                C2669m.c cVar3 = (C2669m.c) obj3;
                                int iCompare = Integer.compare(cVar3.f6361b, cVar2.f6361b);
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                                int iCompareTo = cVar2.f6362c.compareTo(cVar3.f6362c);
                                return iCompareTo != 0 ? iCompareTo : cVar2.f6363d.compareTo(cVar3.f6363d);
                            }
                        });
                        Iterator<C2669m.c> it3 = dVar3.f6364a.iterator();
                        while (it3.hasNext()) {
                            sb5.append(it3.next().f6362c);
                        }
                        i16++;
                        i17 = iKeyAt;
                    }
                    sb5.append(C2669m.m2759a(spanned.subSequence(i17, spanned.length())));
                    bVar = new C2669m.b(sb5.toString(), map2, null);
                } else {
                    bVar = new C2669m.b(C2669m.m2759a(charSequence), C4510i0.f12015m, null);
                }
                for (String str21 : map.keySet()) {
                    str12 = (String) map.put(str21, (String) map.get(str21));
                    if (str12 != null || str12.equals(map.get(str21))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C1460d.m426D(z2);
                }
                Object[] objArr8 = new Object[14];
                objArr8[0] = Integer.valueOf(i7);
                objArr8[1] = str17;
                objArr8[2] = Float.valueOf(f4);
                objArr8[3] = str;
                objArr8[4] = strM3003k2;
                objArr8[5] = str3;
                objArr8[6] = str5;
                objArr8[7] = str6;
                objArr8[8] = str4;
                objArr8[9] = strM2768d;
                objArr8[10] = strM518f2;
                objArr8[11] = Integer.valueOf(iM2766b);
                objArr8[12] = Integer.valueOf(iM2766b2);
                f = c2578b.f5757B;
                if (f != 0.0f) {
                    i4 = c2578b.f5756A;
                    i3 = 1;
                    if (i4 != 2 || i4 == 1) {
                        str11 = "skewY";
                    } else {
                        str11 = "skewX";
                    }
                    strM3003k5 = C2738e0.m3003k("%s(%.2fdeg)", str11, Float.valueOf(f));
                } else {
                    i3 = 1;
                    strM3003k5 = str19;
                }
                objArr8[13] = strM3003k5;
                sb = sb2;
                sb.append(C2738e0.m3003k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr8));
                Object[] objArr9 = new Object[i3];
                objArr9[0] = str18;
                sb.append(C2738e0.m3003k("<span class='%s'>", objArr9));
                alignment = c2578b.f5760n;
                if (alignment != null) {
                    Object[] objArr10 = new Object[i3];
                    objArr10[0] = m2767c(alignment);
                    sb.append(C2738e0.m3003k("<span style='display:inline-block; text-align:%s;'>", objArr10));
                    sb.append(bVar.f6358a);
                    str10 = "</span>";
                    sb.append(str10);
                } else {
                    str10 = "</span>";
                    sb.append(bVar.f6358a);
                }
                sb.append(str10);
                sb.append("</div>");
                i7++;
                f2 = 1.2f;
                c2 = 0;
                i5 = 1;
                c2674r = this;
                str13 = str18;
                str14 = str14;
            }
            str3 = str2;
            str4 = str15;
            str5 = strM3003k3;
            str6 = strM2767c;
            while (r0.hasNext()) {
                str12 = (String) map.put(str21, (String) map.get(str21));
                if (str12 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                C1460d.m426D(z2);
            }
            Object[] objArr11 = new Object[14];
            objArr11[0] = Integer.valueOf(i7);
            objArr11[1] = str17;
            objArr11[2] = Float.valueOf(f4);
            objArr11[3] = str;
            objArr11[4] = strM3003k2;
            objArr11[5] = str3;
            objArr11[6] = str5;
            objArr11[7] = str6;
            objArr11[8] = str4;
            objArr11[9] = strM2768d;
            objArr11[10] = strM518f2;
            objArr11[11] = Integer.valueOf(iM2766b);
            objArr11[12] = Integer.valueOf(iM2766b2);
            f = c2578b.f5757B;
            if (f != 0.0f) {
                i4 = c2578b.f5756A;
                i3 = 1;
                if (i4 != 2) {
                    str11 = "skewY";
                } else {
                    str11 = "skewY";
                }
                strM3003k5 = C2738e0.m3003k("%s(%.2fdeg)", str11, Float.valueOf(f));
            } else {
                i3 = 1;
                strM3003k5 = str19;
            }
            objArr11[13] = strM3003k5;
            sb = sb2;
            sb.append(C2738e0.m3003k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr11));
            Object[] objArr12 = new Object[i3];
            objArr12[0] = str18;
            sb.append(C2738e0.m3003k("<span class='%s'>", objArr12));
            alignment = c2578b.f5760n;
            if (alignment != null) {
                Object[] objArr13 = new Object[i3];
                objArr13[0] = m2767c(alignment);
                sb.append(C2738e0.m3003k("<span style='display:inline-block; text-align:%s;'>", objArr13));
                sb.append(bVar.f6358a);
                str10 = "</span>";
                sb.append(str10);
            } else {
                str10 = "</span>";
                sb.append(bVar.f6358a);
            }
            sb.append(str10);
            sb.append("</div>");
            i7++;
            f2 = 1.2f;
            c2 = 0;
            i5 = 1;
            c2674r = this;
            str13 = str18;
            str14 = str14;
        }
        sb.append("</div></body></html>");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("<html><head><style>");
        for (String str22 : map.keySet()) {
            sb6.append(str22);
            sb6.append("{");
            sb6.append((String) map.get(str22));
            sb6.append("}");
        }
        sb6.append("</style></head>");
        sb.insert(0, sb6.toString());
        this.f6403k.loadData(Base64.encodeToString(sb.toString().getBytes(C4483c.f11945c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (!z2 || this.f6404l.isEmpty()) {
            return;
        }
        m2769e();
    }
}
