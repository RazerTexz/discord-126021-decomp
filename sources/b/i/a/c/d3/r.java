package b.i.a.c.d3;

import android.content.Context;
import android.text.Layout$Alignment;
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
import b.i.a.c.f3.e0;
import b.i.b.b.i0;
import com.google.android.exoplayer2.ui.SubtitleView$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebViewSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends FrameLayout implements SubtitleView$a {
    public final j j;
    public final WebView k;
    public List<b.i.a.c.b3.b> l;
    public k m;
    public float n;
    public int o;
    public float p;

    public r(Context context) {
        super(context, null);
        this.l = Collections.emptyList();
        this.m = k.a;
        this.n = 0.0533f;
        this.o = 0;
        this.p = 0.08f;
        j jVar = new j(context, null);
        this.j = jVar;
        q qVar = new q(context, null);
        this.k = qVar;
        qVar.setBackgroundColor(0);
        addView(jVar);
        addView(qVar);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout$Alignment layout$Alignment) {
        if (layout$Alignment == null) {
            return "center";
        }
        int i = r$a.a[layout$Alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView$a
    public void a(List<b.i.a.c.b3.b> list, k kVar, float f, int i, float f2) {
        this.m = kVar;
        this.n = f;
        this.o = i;
        this.p = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b.i.a.c.b3.b bVar = list.get(i2);
            if (bVar.o != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.l.isEmpty() || !arrayList2.isEmpty()) {
            this.l = arrayList2;
            e();
        }
        this.j.a(arrayList, kVar, f, i, f2);
        invalidate();
    }

    public final String d(int i, float f) {
        float fU1 = b.c.a.a0.d.U1(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fU1 == -3.4028235E38f ? "unset" : e0.k("%.2fpx", Float.valueOf(fU1 / getContext().getResources().getDisplayMetrics().density));
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
    public final void e() {
        String strK;
        char c;
        String strK2;
        int iB;
        String strK3;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        m$b m_b;
        String str7;
        String str8;
        int i2;
        String strK4;
        String str9;
        String strK5;
        float f;
        int i3;
        String strK6;
        Layout$Alignment layout$Alignment;
        String str10;
        int i4;
        String str11;
        String str12;
        boolean z2;
        r rVar = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c2 = 0;
        objArr[0] = b.c.a.a0.d.f2(rVar.m.f914b);
        int i5 = 1;
        objArr[1] = rVar.d(rVar.o, rVar.n);
        float f2 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        k kVar = rVar.m;
        int i6 = kVar.e;
        if (i6 == 1) {
            strK = e0.k("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", b.c.a.a0.d.f2(kVar.f));
        } else if (i6 == 2) {
            strK = e0.k("0.1em 0.12em 0.15em %s", b.c.a.a0.d.f2(kVar.f));
        } else if (i6 != 3) {
            strK = i6 != 4 ? "unset" : e0.k("-0.05em -0.05em 0.15em %s", b.c.a.a0.d.f2(kVar.f));
        } else {
            strK = e0.k("0.06em 0.08em 0.15em %s", b.c.a.a0.d.f2(kVar.f));
        }
        objArr[3] = strK;
        sb.append(e0.k("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr));
        HashMap map = new HashMap();
        String str13 = "default_bg";
        String str14 = "background-color:%s;";
        map.put(b.c.a.a0.d.W("default_bg"), e0.k("background-color:%s;", b.c.a.a0.d.f2(rVar.m.c)));
        int i7 = 0;
        while (i7 < rVar.l.size()) {
            b.i.a.c.b3.b bVar = rVar.l.get(i7);
            float f3 = bVar.f838s;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int iB2 = b(bVar.t);
            float f5 = bVar.p;
            if (f5 == -3.4028235E38f) {
                c = 0;
                Object[] objArr2 = new Object[i5];
                objArr2[0] = Float.valueOf((1.0f - rVar.p) * 100.0f);
                strK2 = e0.k("%.2f%%", objArr2);
                c2 = 0;
                iB = -100;
            } else if (bVar.q != i5) {
                Object[] objArr3 = new Object[i5];
                objArr3[c2] = Float.valueOf(f5 * 100.0f);
                strK2 = e0.k("%.2f%%", objArr3);
                c = 0;
                iB = bVar.A == i5 ? -b(bVar.r) : b(bVar.r);
            } else {
                if (f5 >= 0.0f) {
                    Object[] objArr4 = new Object[i5];
                    Float fValueOf = Float.valueOf(f5 * f2);
                    c = 0;
                    objArr4[0] = fValueOf;
                    strK2 = e0.k("%.2fem", objArr4);
                    c2 = 0;
                } else {
                    Object[] objArr5 = new Object[i5];
                    Float fValueOf2 = Float.valueOf(((-f5) - 1.0f) * f2);
                    c = 0;
                    objArr5[0] = fValueOf2;
                    strK2 = e0.k("%.2fem", objArr5);
                    c2 = 1;
                }
                iB = 0;
            }
            float f6 = bVar.u;
            if (f6 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i5];
                objArr6[c] = Float.valueOf(f6 * 100.0f);
                strK3 = e0.k("%.2f%%", objArr6);
            } else {
                strK3 = "fit-content";
            }
            String strC = c(bVar.m);
            int i8 = bVar.A;
            String str15 = i8 != i5 ? i8 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
            String strD = rVar.d(bVar.f840y, bVar.f841z);
            String strF2 = b.c.a.a0.d.f2(bVar.w ? bVar.f839x : rVar.m.d);
            int i9 = bVar.A;
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
                iB2 = iB;
                iB = iB2;
            }
            CharSequence charSequence = bVar.l;
            float f7 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = m.a;
            StringBuilder sb2 = sb;
            String str19 = "";
            if (charSequence == null) {
                m_b = new m$b("", i0.m, null);
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
                        map2.put(b.c.a.a0.d.W(sb3.toString()), e0.k(str14, b.c.a.a0.d.f2(iIntValue)));
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
                            str8 = strC;
                            str7 = str15;
                            strK4 = "<span style='text-decoration:line-through;'>";
                        } else {
                            str7 = str15;
                            if (obj instanceof ForegroundColorSpan) {
                                str8 = strC;
                                strK4 = e0.k("<span style='color:%s;'>", b.c.a.a0.d.f2(((ForegroundColorSpan) obj).getForegroundColor()));
                            } else {
                                str8 = strC;
                                if (obj instanceof BackgroundColorSpan) {
                                    strK4 = e0.k("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
                                } else if (obj instanceof b.i.a.c.b3.q.a) {
                                    strK4 = "<span style='text-combine-upright:all;'>";
                                } else if (obj instanceof AbsoluteSizeSpan) {
                                    AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                                    strK4 = e0.k("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f7));
                                } else if (obj instanceof RelativeSizeSpan) {
                                    strK4 = e0.k("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
                                } else if (obj instanceof TypefaceSpan) {
                                    String family = ((TypefaceSpan) obj).getFamily();
                                    strK4 = family != null ? e0.k("<span style='font-family:\"%s\";'>", family) : null;
                                } else if (obj instanceof StyleSpan) {
                                    int style = ((StyleSpan) obj).getStyle();
                                    if (style == 1) {
                                        strK4 = "<b>";
                                    } else if (style == 2) {
                                        strK4 = "<i>";
                                    } else if (style != 3) {
                                        strK4 = null;
                                    } else {
                                        strK4 = "<b><i>";
                                    }
                                } else if (obj instanceof b.i.a.c.b3.q.c) {
                                    int i13 = ((b.i.a.c.b3.q.c) obj).f872b;
                                    if (i13 == -1) {
                                        strK4 = "<ruby style='ruby-position:unset;'>";
                                    } else if (i13 == 1) {
                                        strK4 = "<ruby style='ruby-position:over;'>";
                                    } else if (i13 != 2) {
                                        strK4 = null;
                                    } else {
                                        strK4 = "<ruby style='ruby-position:under;'>";
                                    }
                                } else if (obj instanceof UnderlineSpan) {
                                    strK4 = "<u>";
                                } else if (obj instanceof b.i.a.c.b3.q.d) {
                                    b.i.a.c.b3.q.d dVar = (b.i.a.c.b3.q.d) obj;
                                    int i14 = dVar.a;
                                    int i15 = dVar.f873b;
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
                                    strK4 = e0.k("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4.toString(), dVar.c != 2 ? "over right" : "under left");
                                } else {
                                    strK4 = null;
                                }
                            }
                        }
                        String str20 = strK4;
                        if (z3 || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof b.i.a.c.b3.q.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof b.i.a.c.b3.q.d)) {
                            str9 = "</span>";
                        } else {
                            if (!(obj instanceof TypefaceSpan)) {
                                if (obj instanceof StyleSpan) {
                                    int style2 = ((StyleSpan) obj).getStyle();
                                    if (style2 == 1) {
                                        strK5 = "</b>";
                                    } else if (style2 == 2) {
                                        strK5 = "</i>";
                                    } else if (style2 == 3) {
                                        strK5 = "</i></b>";
                                    }
                                } else if (obj instanceof b.i.a.c.b3.q.c) {
                                    String strA = m.a(((b.i.a.c.b3.q.c) obj).a);
                                    strK5 = b.d.b.a.a.k(b.d.b.a.a.b(strA, 16), "<rt>", strA, "</rt></ruby>");
                                } else if (obj instanceof UnderlineSpan) {
                                    strK5 = "</u>";
                                }
                                str9 = strK5;
                            } else if (((TypefaceSpan) obj).getFamily() != null) {
                                str9 = "</span>";
                            }
                            strK5 = null;
                            str9 = strK5;
                        }
                        int spanStart = spanned.getSpanStart(obj);
                        int spanEnd = spanned.getSpanEnd(obj);
                        if (str20 != null) {
                            Objects.requireNonNull(str9);
                            m$c m_c = new m$c(spanStart, spanEnd, str20, str9, null);
                            m$d m_d = (m$d) sparseArray.get(spanStart);
                            if (m_d == null) {
                                m_d = new m$d();
                                sparseArray.put(spanStart, m_d);
                            }
                            m_d.a.add(m_c);
                            m$d m_d2 = (m$d) sparseArray.get(spanEnd);
                            if (m_d2 == null) {
                                m_d2 = new m$d();
                                sparseArray.put(spanEnd, m_d2);
                            }
                            m_d2.f917b.add(m_c);
                        }
                        i11++;
                        length2 = i12;
                        spans = objArr7;
                        str15 = str7;
                        strC = str8;
                        f7 = f7;
                        strK3 = strK3;
                        str2 = str2;
                    }
                    str3 = str2;
                    str4 = str15;
                    str5 = strK3;
                    str6 = strC;
                    StringBuilder sb5 = new StringBuilder(spanned.length());
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < sparseArray.size()) {
                        int iKeyAt = sparseArray.keyAt(i16);
                        sb5.append(m.a(spanned.subSequence(i17, iKeyAt)));
                        m$d m_d3 = (m$d) sparseArray.get(iKeyAt);
                        Collections.sort(m_d3.f917b, f.j);
                        Iterator<m$c> it2 = m_d3.f917b.iterator();
                        while (it2.hasNext()) {
                            sb5.append(it2.next().d);
                        }
                        Collections.sort(m_d3.a, e.j);
                        Iterator<m$c> it3 = m_d3.a.iterator();
                        while (it3.hasNext()) {
                            sb5.append(it3.next().c);
                        }
                        i16++;
                        i17 = iKeyAt;
                    }
                    sb5.append(m.a(spanned.subSequence(i17, spanned.length())));
                    m_b = new m$b(sb5.toString(), map2, null);
                } else {
                    m_b = new m$b(m.a(charSequence), i0.m, null);
                }
                for (String str21 : map.keySet()) {
                    str12 = (String) map.put(str21, (String) map.get(str21));
                    if (str12 != null || str12.equals(map.get(str21))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    b.c.a.a0.d.D(z2);
                }
                Object[] objArr8 = new Object[14];
                objArr8[0] = Integer.valueOf(i7);
                objArr8[1] = str17;
                objArr8[2] = Float.valueOf(f4);
                objArr8[3] = str;
                objArr8[4] = strK2;
                objArr8[5] = str3;
                objArr8[6] = str5;
                objArr8[7] = str6;
                objArr8[8] = str4;
                objArr8[9] = strD;
                objArr8[10] = strF2;
                objArr8[11] = Integer.valueOf(iB);
                objArr8[12] = Integer.valueOf(iB2);
                f = bVar.B;
                if (f != 0.0f) {
                    i4 = bVar.A;
                    i3 = 1;
                    if (i4 != 2 || i4 == 1) {
                        str11 = "skewY";
                    } else {
                        str11 = "skewX";
                    }
                    strK6 = e0.k("%s(%.2fdeg)", str11, Float.valueOf(f));
                } else {
                    i3 = 1;
                    strK6 = str19;
                }
                objArr8[13] = strK6;
                sb = sb2;
                sb.append(e0.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr8));
                Object[] objArr9 = new Object[i3];
                objArr9[0] = str18;
                sb.append(e0.k("<span class='%s'>", objArr9));
                layout$Alignment = bVar.n;
                if (layout$Alignment != null) {
                    Object[] objArr10 = new Object[i3];
                    objArr10[0] = c(layout$Alignment);
                    sb.append(e0.k("<span style='display:inline-block; text-align:%s;'>", objArr10));
                    sb.append(m_b.a);
                    str10 = "</span>";
                    sb.append(str10);
                } else {
                    str10 = "</span>";
                    sb.append(m_b.a);
                }
                sb.append(str10);
                sb.append("</div>");
                i7++;
                f2 = 1.2f;
                c2 = 0;
                i5 = 1;
                rVar = this;
                str13 = str18;
                str14 = str14;
            }
            str3 = str2;
            str4 = str15;
            str5 = strK3;
            str6 = strC;
            while (r0.hasNext()) {
                str12 = (String) map.put(str21, (String) map.get(str21));
                if (str12 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                b.c.a.a0.d.D(z2);
            }
            Object[] objArr11 = new Object[14];
            objArr11[0] = Integer.valueOf(i7);
            objArr11[1] = str17;
            objArr11[2] = Float.valueOf(f4);
            objArr11[3] = str;
            objArr11[4] = strK2;
            objArr11[5] = str3;
            objArr11[6] = str5;
            objArr11[7] = str6;
            objArr11[8] = str4;
            objArr11[9] = strD;
            objArr11[10] = strF2;
            objArr11[11] = Integer.valueOf(iB);
            objArr11[12] = Integer.valueOf(iB2);
            f = bVar.B;
            if (f != 0.0f) {
                i4 = bVar.A;
                i3 = 1;
                if (i4 != 2) {
                    str11 = "skewY";
                } else {
                    str11 = "skewY";
                }
                strK6 = e0.k("%s(%.2fdeg)", str11, Float.valueOf(f));
            } else {
                i3 = 1;
                strK6 = str19;
            }
            objArr11[13] = strK6;
            sb = sb2;
            sb.append(e0.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr11));
            Object[] objArr12 = new Object[i3];
            objArr12[0] = str18;
            sb.append(e0.k("<span class='%s'>", objArr12));
            layout$Alignment = bVar.n;
            if (layout$Alignment != null) {
                Object[] objArr13 = new Object[i3];
                objArr13[0] = c(layout$Alignment);
                sb.append(e0.k("<span style='display:inline-block; text-align:%s;'>", objArr13));
                sb.append(m_b.a);
                str10 = "</span>";
                sb.append(str10);
            } else {
                str10 = "</span>";
                sb.append(m_b.a);
            }
            sb.append(str10);
            sb.append("</div>");
            i7++;
            f2 = 1.2f;
            c2 = 0;
            i5 = 1;
            rVar = this;
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
        this.k.loadData(Base64.encodeToString(sb.toString().getBytes(b.i.b.a.c.c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (!z2 || this.l.isEmpty()) {
            return;
        }
        e();
    }
}
