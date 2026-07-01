package b.i.a.c.d3;

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
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.q.HorizontalTextInVerticalContextSpan;
import b.i.a.c.b3.q.RubySpan;
import b.i.a.c.b3.q.TextEmphasisSpan;
import b.i.a.c.d3.SpannedToHtmlConverter;
import b.i.a.c.f3.Util2;
import b.i.b.a.Charsets;
import b.i.b.b.RegularImmutableMap;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.d3.r, reason: use source file name */
/* JADX INFO: compiled from: WebViewSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebViewSubtitleOutput2 extends FrameLayout implements SubtitleView.a {
    public final CanvasSubtitleOutput j;
    public final WebView k;
    public List<Cue> l;
    public CaptionStyleCompat m;
    public float n;
    public int o;
    public float p;

    /* JADX INFO: renamed from: b.i.a.c.d3.r$a */
    /* JADX INFO: compiled from: WebViewSubtitleOutput.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput2(Context context) {
        super(context, null);
        this.l = Collections.emptyList();
        this.m = CaptionStyleCompat.a;
        this.n = 0.0533f;
        this.o = 0;
        this.p = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.j = canvasSubtitleOutput;
        WebViewSubtitleOutput webViewSubtitleOutput = new WebViewSubtitleOutput(context, null);
        this.k = webViewSubtitleOutput;
        webViewSubtitleOutput.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webViewSubtitleOutput);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = a.a[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.m = captionStyleCompat;
        this.n = f;
        this.o = i;
        this.p = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.o != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.l.isEmpty() || !arrayList2.isEmpty()) {
            this.l = arrayList2;
            e();
        }
        this.j.a(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    public final String d(int i, float f) {
        float fU1 = AnimatableValueParser.U1(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fU1 == -3.4028235E38f ? "unset" : Util2.k("%.2fpx", Float.valueOf(fU1 / getContext().getResources().getDisplayMetrics().density));
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
        SpannedToHtmlConverter.b bVar;
        String str7;
        String str8;
        int i2;
        String strK4;
        String str9;
        String strK5;
        float f;
        int i3;
        String strK6;
        Layout.Alignment alignment;
        String str10;
        int i4;
        String str11;
        String str12;
        boolean z2;
        WebViewSubtitleOutput2 webViewSubtitleOutput2 = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c2 = 0;
        objArr[0] = AnimatableValueParser.f2(webViewSubtitleOutput2.m.f914b);
        int i5 = 1;
        objArr[1] = webViewSubtitleOutput2.d(webViewSubtitleOutput2.o, webViewSubtitleOutput2.n);
        float f2 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        CaptionStyleCompat captionStyleCompat = webViewSubtitleOutput2.m;
        int i6 = captionStyleCompat.e;
        if (i6 == 1) {
            strK = Util2.k("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", AnimatableValueParser.f2(captionStyleCompat.f));
        } else if (i6 == 2) {
            strK = Util2.k("0.1em 0.12em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f));
        } else if (i6 != 3) {
            strK = i6 != 4 ? "unset" : Util2.k("-0.05em -0.05em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f));
        } else {
            strK = Util2.k("0.06em 0.08em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f));
        }
        objArr[3] = strK;
        sb.append(Util2.k("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr));
        HashMap map = new HashMap();
        String str13 = "default_bg";
        String str14 = "background-color:%s;";
        map.put(AnimatableValueParser.W("default_bg"), Util2.k("background-color:%s;", AnimatableValueParser.f2(webViewSubtitleOutput2.m.c)));
        int i7 = 0;
        while (i7 < webViewSubtitleOutput2.l.size()) {
            Cue cue = webViewSubtitleOutput2.l.get(i7);
            float f3 = cue.f838s;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int iB2 = b(cue.t);
            float f5 = cue.p;
            if (f5 == -3.4028235E38f) {
                c = 0;
                Object[] objArr2 = new Object[i5];
                objArr2[0] = Float.valueOf((1.0f - webViewSubtitleOutput2.p) * 100.0f);
                strK2 = Util2.k("%.2f%%", objArr2);
                c2 = 0;
                iB = -100;
            } else if (cue.q != i5) {
                Object[] objArr3 = new Object[i5];
                objArr3[c2] = Float.valueOf(f5 * 100.0f);
                strK2 = Util2.k("%.2f%%", objArr3);
                c = 0;
                iB = cue.A == i5 ? -b(cue.r) : b(cue.r);
            } else {
                if (f5 >= 0.0f) {
                    Object[] objArr4 = new Object[i5];
                    Float fValueOf = Float.valueOf(f5 * f2);
                    c = 0;
                    objArr4[0] = fValueOf;
                    strK2 = Util2.k("%.2fem", objArr4);
                    c2 = 0;
                } else {
                    Object[] objArr5 = new Object[i5];
                    Float fValueOf2 = Float.valueOf(((-f5) - 1.0f) * f2);
                    c = 0;
                    objArr5[0] = fValueOf2;
                    strK2 = Util2.k("%.2fem", objArr5);
                    c2 = 1;
                }
                iB = 0;
            }
            float f6 = cue.u;
            if (f6 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i5];
                objArr6[c] = Float.valueOf(f6 * 100.0f);
                strK3 = Util2.k("%.2f%%", objArr6);
            } else {
                strK3 = "fit-content";
            }
            String strC = c(cue.m);
            int i8 = cue.A;
            String str15 = i8 != i5 ? i8 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
            String strD = webViewSubtitleOutput2.d(cue.f840y, cue.f841z);
            String strF2 = AnimatableValueParser.f2(cue.w ? cue.f839x : webViewSubtitleOutput2.m.d);
            int i9 = cue.A;
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
            CharSequence charSequence = cue.l;
            float f7 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = SpannedToHtmlConverter.a;
            StringBuilder sb2 = sb;
            String str19 = "";
            if (charSequence == null) {
                bVar = new SpannedToHtmlConverter.b("", RegularImmutableMap.m, null);
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
                        map2.put(AnimatableValueParser.W(sb3.toString()), Util2.k(str14, AnimatableValueParser.f2(iIntValue)));
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
                                strK4 = Util2.k("<span style='color:%s;'>", AnimatableValueParser.f2(((ForegroundColorSpan) obj).getForegroundColor()));
                            } else {
                                str8 = strC;
                                if (obj instanceof BackgroundColorSpan) {
                                    strK4 = Util2.k("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
                                } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
                                    strK4 = "<span style='text-combine-upright:all;'>";
                                } else if (obj instanceof AbsoluteSizeSpan) {
                                    AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                                    strK4 = Util2.k("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f7));
                                } else if (obj instanceof RelativeSizeSpan) {
                                    strK4 = Util2.k("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
                                } else if (obj instanceof TypefaceSpan) {
                                    String family = ((TypefaceSpan) obj).getFamily();
                                    strK4 = family != null ? Util2.k("<span style='font-family:\"%s\";'>", family) : null;
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
                                } else if (obj instanceof RubySpan) {
                                    int i13 = ((RubySpan) obj).f872b;
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
                                } else if (obj instanceof TextEmphasisSpan) {
                                    TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                                    int i14 = textEmphasisSpan.a;
                                    int i15 = textEmphasisSpan.f873b;
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
                                    strK4 = Util2.k("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4.toString(), textEmphasisSpan.c != 2 ? "over right" : "under left");
                                } else {
                                    strK4 = null;
                                }
                            }
                        }
                        String str20 = strK4;
                        if (z3 || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
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
                                } else if (obj instanceof RubySpan) {
                                    String strA = SpannedToHtmlConverter.a(((RubySpan) obj).a);
                                    strK5 = outline.k(outline.b(strA, 16), "<rt>", strA, "</rt></ruby>");
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
                            SpannedToHtmlConverter.c cVar = new SpannedToHtmlConverter.c(spanStart, spanEnd, str20, str9, null);
                            SpannedToHtmlConverter.d dVar = (SpannedToHtmlConverter.d) sparseArray.get(spanStart);
                            if (dVar == null) {
                                dVar = new SpannedToHtmlConverter.d();
                                sparseArray.put(spanStart, dVar);
                            }
                            dVar.a.add(cVar);
                            SpannedToHtmlConverter.d dVar2 = (SpannedToHtmlConverter.d) sparseArray.get(spanEnd);
                            if (dVar2 == null) {
                                dVar2 = new SpannedToHtmlConverter.d();
                                sparseArray.put(spanEnd, dVar2);
                            }
                            dVar2.f917b.add(cVar);
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
                        sb5.append(SpannedToHtmlConverter.a(spanned.subSequence(i17, iKeyAt)));
                        SpannedToHtmlConverter.d dVar3 = (SpannedToHtmlConverter.d) sparseArray.get(iKeyAt);
                        Collections.sort(dVar3.f917b, new Comparator() { // from class: b.i.a.c.d3.f
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
                                SpannedToHtmlConverter.c cVar3 = (SpannedToHtmlConverter.c) obj3;
                                int iCompare = Integer.compare(cVar3.a, cVar2.a);
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                                int iCompareTo = cVar3.c.compareTo(cVar2.c);
                                return iCompareTo != 0 ? iCompareTo : cVar3.d.compareTo(cVar2.d);
                            }
                        });
                        Iterator<SpannedToHtmlConverter.c> it2 = dVar3.f917b.iterator();
                        while (it2.hasNext()) {
                            sb5.append(it2.next().d);
                        }
                        Collections.sort(dVar3.a, new Comparator() { // from class: b.i.a.c.d3.e
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
                                SpannedToHtmlConverter.c cVar3 = (SpannedToHtmlConverter.c) obj3;
                                int iCompare = Integer.compare(cVar3.f916b, cVar2.f916b);
                                if (iCompare != 0) {
                                    return iCompare;
                                }
                                int iCompareTo = cVar2.c.compareTo(cVar3.c);
                                return iCompareTo != 0 ? iCompareTo : cVar2.d.compareTo(cVar3.d);
                            }
                        });
                        Iterator<SpannedToHtmlConverter.c> it3 = dVar3.a.iterator();
                        while (it3.hasNext()) {
                            sb5.append(it3.next().c);
                        }
                        i16++;
                        i17 = iKeyAt;
                    }
                    sb5.append(SpannedToHtmlConverter.a(spanned.subSequence(i17, spanned.length())));
                    bVar = new SpannedToHtmlConverter.b(sb5.toString(), map2, null);
                } else {
                    bVar = new SpannedToHtmlConverter.b(SpannedToHtmlConverter.a(charSequence), RegularImmutableMap.m, null);
                }
                for (String str21 : map.keySet()) {
                    str12 = (String) map.put(str21, (String) map.get(str21));
                    if (str12 != null || str12.equals(map.get(str21))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    AnimatableValueParser.D(z2);
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
                f = cue.B;
                if (f != 0.0f) {
                    i4 = cue.A;
                    i3 = 1;
                    if (i4 != 2 || i4 == 1) {
                        str11 = "skewY";
                    } else {
                        str11 = "skewX";
                    }
                    strK6 = Util2.k("%s(%.2fdeg)", str11, Float.valueOf(f));
                } else {
                    i3 = 1;
                    strK6 = str19;
                }
                objArr8[13] = strK6;
                sb = sb2;
                sb.append(Util2.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr8));
                Object[] objArr9 = new Object[i3];
                objArr9[0] = str18;
                sb.append(Util2.k("<span class='%s'>", objArr9));
                alignment = cue.n;
                if (alignment != null) {
                    Object[] objArr10 = new Object[i3];
                    objArr10[0] = c(alignment);
                    sb.append(Util2.k("<span style='display:inline-block; text-align:%s;'>", objArr10));
                    sb.append(bVar.a);
                    str10 = "</span>";
                    sb.append(str10);
                } else {
                    str10 = "</span>";
                    sb.append(bVar.a);
                }
                sb.append(str10);
                sb.append("</div>");
                i7++;
                f2 = 1.2f;
                c2 = 0;
                i5 = 1;
                webViewSubtitleOutput2 = this;
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
                AnimatableValueParser.D(z2);
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
            f = cue.B;
            if (f != 0.0f) {
                i4 = cue.A;
                i3 = 1;
                if (i4 != 2) {
                    str11 = "skewY";
                } else {
                    str11 = "skewY";
                }
                strK6 = Util2.k("%s(%.2fdeg)", str11, Float.valueOf(f));
            } else {
                i3 = 1;
                strK6 = str19;
            }
            objArr11[13] = strK6;
            sb = sb2;
            sb.append(Util2.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr11));
            Object[] objArr12 = new Object[i3];
            objArr12[0] = str18;
            sb.append(Util2.k("<span class='%s'>", objArr12));
            alignment = cue.n;
            if (alignment != null) {
                Object[] objArr13 = new Object[i3];
                objArr13[0] = c(alignment);
                sb.append(Util2.k("<span style='display:inline-block; text-align:%s;'>", objArr13));
                sb.append(bVar.a);
                str10 = "</span>";
                sb.append(str10);
            } else {
                str10 = "</span>";
                sb.append(bVar.a);
            }
            sb.append(str10);
            sb.append("</div>");
            i7++;
            f2 = 1.2f;
            c2 = 0;
            i5 = 1;
            webViewSubtitleOutput2 = this;
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
        this.k.loadData(Base64.encodeToString(sb.toString().getBytes(Charsets.c), 1), "text/html", "base64");
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
