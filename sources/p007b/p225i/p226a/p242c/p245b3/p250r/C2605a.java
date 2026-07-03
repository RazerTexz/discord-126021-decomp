package p007b.p225i.p226a.p242c.p245b3.p250r;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p245b3.p250r.C2607c;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.r.a */
/* JADX INFO: compiled from: SsaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2605a extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public static final Pattern f5986n = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o */
    public final boolean f5987o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final C2606b f5988p;

    /* JADX INFO: renamed from: q */
    public Map<String, C2607c> f5989q;

    /* JADX INFO: renamed from: r */
    public float f5990r;

    /* JADX INFO: renamed from: s */
    public float f5991s;

    public C2605a(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f5990r = -3.4028235E38f;
        this.f5991s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f5987o = false;
            this.f5988p = null;
            return;
        }
        this.f5987o = true;
        String strM3004l = C2738e0.m3004l(list.get(0));
        C1460d.m531j(strM3004l.startsWith("Format:"));
        C2606b c2606bM2672a = C2606b.m2672a(strM3004l);
        Objects.requireNonNull(c2606bM2672a);
        this.f5988p = c2606bM2672a;
        m2671m(new C2757x(list.get(1)));
    }

    /* JADX INFO: renamed from: k */
    public static int m2668k(long j, List<Long> list, List<List<C2578b>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }

    /* JADX INFO: renamed from: l */
    public static float m2669l(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    /* JADX INFO: renamed from: n */
    public static long m2670n(String str) {
        Matcher matcher = f5986n.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = C2738e0.f6708a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(strGroup) * 60 * 60 * 1000000);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) {
        C2757x c2757x;
        int i2;
        int i3;
        float f;
        Layout.Alignment alignment;
        int i4;
        int i5;
        float fM2669l;
        float fM2669l2;
        float f2;
        int i6;
        float f3;
        int i7;
        int i8;
        int iM2673a;
        int i9;
        C2605a c2605a = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C2757x c2757x2 = new C2757x(bArr, i);
        if (!c2605a.f5987o) {
            c2605a.m2671m(c2757x2);
        }
        C2606b c2606bM2672a = c2605a.f5987o ? c2605a.f5988p : null;
        while (true) {
            String strM3087g = c2757x2.m3087g();
            if (strM3087g == null) {
                return new C2608d(arrayList, arrayList2);
            }
            if (strM3087g.startsWith("Format:")) {
                c2606bM2672a = C2606b.m2672a(strM3087g);
            } else {
                if (strM3087g.startsWith("Dialogue:")) {
                    if (c2606bM2672a == null) {
                        Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping dialogue line before complete format: ".concat(strM3087g) : new String("Skipping dialogue line before complete format: "));
                    } else {
                        C1460d.m531j(strM3087g.startsWith("Dialogue:"));
                        String[] strArrSplit = strM3087g.substring(9).split(",", c2606bM2672a.f5996e);
                        if (strArrSplit.length != c2606bM2672a.f5996e) {
                            Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(strM3087g) : new String("Skipping dialogue line with fewer columns than format: "));
                        } else {
                            long jM2670n = m2670n(strArrSplit[c2606bM2672a.f5992a]);
                            if (jM2670n == -9223372036854775807L) {
                                Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping invalid timing: ".concat(strM3087g) : new String("Skipping invalid timing: "));
                            } else {
                                long jM2670n2 = m2670n(strArrSplit[c2606bM2672a.f5993b]);
                                if (jM2670n2 == -9223372036854775807L) {
                                    Log.w("SsaDecoder", strM3087g.length() != 0 ? "Skipping invalid timing: ".concat(strM3087g) : new String("Skipping invalid timing: "));
                                } else {
                                    Map<String, C2607c> map = c2605a.f5989q;
                                    C2607c c2607c = (map == null || (i9 = c2606bM2672a.f5994c) == -1) ? null : map.get(strArrSplit[i9].trim());
                                    String str = strArrSplit[c2606bM2672a.f5995d];
                                    Matcher matcher = C2607c.b.f6014a.matcher(str);
                                    PointF pointF = null;
                                    int i10 = -1;
                                    while (true) {
                                        c2757x = c2757x2;
                                        if (matcher.find()) {
                                            String strGroup = matcher.group(1);
                                            Objects.requireNonNull(strGroup);
                                            try {
                                                PointF pointFM2676a = C2607c.b.m2676a(strGroup);
                                                if (pointFM2676a != null) {
                                                    pointF = pointFM2676a;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            try {
                                                Matcher matcher2 = C2607c.b.f6017d.matcher(strGroup);
                                                if (matcher2.find()) {
                                                    String strGroup2 = matcher2.group(1);
                                                    Objects.requireNonNull(strGroup2);
                                                    iM2673a = C2607c.m2673a(strGroup2);
                                                } else {
                                                    iM2673a = -1;
                                                }
                                                if (iM2673a != -1) {
                                                    i10 = iM2673a;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            c2757x2 = c2757x;
                                        } else {
                                            String strReplace = C2607c.b.f6014a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                            float f4 = c2605a.f5990r;
                                            float f5 = c2605a.f5991s;
                                            SpannableString spannableString = new SpannableString(strReplace);
                                            if (c2607c != null) {
                                                if (c2607c.f5999c != null) {
                                                    spannableString.setSpan(new ForegroundColorSpan(c2607c.f5999c.intValue()), 0, spannableString.length(), 33);
                                                }
                                                float f6 = c2607c.f6000d;
                                                if (f6 == -3.4028235E38f || f5 == -3.4028235E38f) {
                                                    f2 = -3.4028235E38f;
                                                    i6 = Integer.MIN_VALUE;
                                                } else {
                                                    f2 = f6 / f5;
                                                    i6 = 1;
                                                }
                                                boolean z3 = c2607c.f6001e;
                                                if (z3 && c2607c.f6002f) {
                                                    i7 = 0;
                                                    f3 = f2;
                                                    i8 = 33;
                                                    spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                                } else {
                                                    f3 = f2;
                                                    i7 = 0;
                                                    i8 = 33;
                                                    if (z3) {
                                                        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                                    } else if (c2607c.f6002f) {
                                                        spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                    }
                                                }
                                                if (c2607c.f6003g) {
                                                    spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                                }
                                                if (c2607c.f6004h) {
                                                    spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                                }
                                                i2 = -1;
                                                i3 = i6;
                                                f = f3;
                                            } else {
                                                c2606bM2672a = c2606bM2672a;
                                                jM2670n2 = jM2670n2;
                                                i2 = -1;
                                                i3 = Integer.MIN_VALUE;
                                                f = -3.4028235E38f;
                                            }
                                            if (i10 == i2) {
                                                i10 = c2607c != null ? c2607c.f5998b : i2;
                                            }
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", C1643a.m851g(30, "Unknown alignment: ", i10));
                                                case -1:
                                                    alignment = null;
                                                    break;
                                                case 1:
                                                case 4:
                                                case 7:
                                                    alignment = Layout.Alignment.ALIGN_NORMAL;
                                                    break;
                                                case 2:
                                                case 5:
                                                case 8:
                                                    alignment = Layout.Alignment.ALIGN_CENTER;
                                                    break;
                                                case 3:
                                                case 6:
                                                case 9:
                                                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                    break;
                                            }
                                            Layout.Alignment alignment2 = alignment;
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", C1643a.m851g(30, "Unknown alignment: ", i10));
                                                case -1:
                                                    i4 = Integer.MIN_VALUE;
                                                    break;
                                                case 1:
                                                case 4:
                                                case 7:
                                                    i4 = 0;
                                                    break;
                                                case 2:
                                                case 5:
                                                case 8:
                                                    i4 = 1;
                                                    break;
                                                case 3:
                                                case 6:
                                                case 9:
                                                    i4 = 2;
                                                    break;
                                            }
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", C1643a.m851g(30, "Unknown alignment: ", i10));
                                                case -1:
                                                    i5 = Integer.MIN_VALUE;
                                                    break;
                                                case 1:
                                                case 2:
                                                case 3:
                                                    i5 = 2;
                                                    break;
                                                case 4:
                                                case 5:
                                                case 6:
                                                    i5 = 1;
                                                    break;
                                                case 7:
                                                case 8:
                                                case 9:
                                                    i5 = 0;
                                                    break;
                                            }
                                            if (pointF == null || f5 == -3.4028235E38f || f4 == -3.4028235E38f) {
                                                fM2669l = m2669l(i4);
                                                fM2669l2 = m2669l(i5);
                                            } else {
                                                fM2669l = pointF.x / f4;
                                                fM2669l2 = pointF.y / f5;
                                            }
                                            C2578b c2578b = new C2578b(spannableString, alignment2, null, null, fM2669l2, 0, i5, fM2669l, i4, i3, f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                            int iM2668k = m2668k(jM2670n2, arrayList2, arrayList);
                                            for (int iM2668k2 = m2668k(jM2670n, arrayList2, arrayList); iM2668k2 < iM2668k; iM2668k2++) {
                                                ((List) arrayList.get(iM2668k2)).add(c2578b);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    c2757x = c2757x2;
                    c2606bM2672a = c2606bM2672a;
                } else {
                    c2757x = c2757x2;
                    c2606bM2672a = c2606bM2672a;
                }
                c2605a = this;
                c2606bM2672a = c2606bM2672a;
                c2757x2 = c2757x;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:147:0x0293  */
    /* JADX WARN: Code duplicated, block: B:75:0x012f  */
    /* JADX INFO: renamed from: m */
    public final void m2671m(C2757x c2757x) {
        C2607c c2607c;
        float f;
        while (true) {
            String strM3087g = c2757x.m3087g();
            if (strM3087g == null) {
                return;
            }
            int i = 91;
            char c = 2;
            char c2 = 0;
            if ("[Script Info]".equalsIgnoreCase(strM3087g)) {
                while (true) {
                    String strM3087g2 = c2757x.m3087g();
                    if (strM3087g2 == null || (c2757x.m3081a() != 0 && c2757x.m3083c() == 91)) {
                        break;
                    }
                    String[] strArrSplit = strM3087g2.split(":");
                    if (strArrSplit.length == 2) {
                        String strM4349u1 = C3404f.m4349u1(strArrSplit[0].trim());
                        strM4349u1.hashCode();
                        if (strM4349u1.equals("playresx")) {
                            this.f5990r = Float.parseFloat(strArrSplit[1].trim());
                        } else if (strM4349u1.equals("playresy")) {
                            try {
                                this.f5991s = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strM3087g)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (true) {
                    C2607c.a aVar = null;
                    while (true) {
                        String strM3087g3 = c2757x.m3087g();
                        if (strM3087g3 != null && (c2757x.m3081a() == 0 || c2757x.m3083c() != i)) {
                            if (strM3087g3.startsWith("Format:")) {
                                String[] strArrSplit2 = TextUtils.split(strM3087g3.substring(7), ",");
                                int i2 = -1;
                                int i3 = -1;
                                int i4 = -1;
                                int i5 = -1;
                                int i6 = -1;
                                int i7 = -1;
                                int i8 = -1;
                                int i9 = -1;
                                for (int i10 = 0; i10 < strArrSplit2.length; i10++) {
                                    String strM4349u2 = C3404f.m4349u1(strArrSplit2[i10].trim());
                                    strM4349u2.hashCode();
                                    switch (strM4349u2) {
                                        case "italic":
                                            i7 = i10;
                                            break;
                                        case "underline":
                                            i8 = i10;
                                            break;
                                        case "strikeout":
                                            i9 = i10;
                                            break;
                                        case "primarycolour":
                                            i4 = i10;
                                            break;
                                        case "bold":
                                            i6 = i10;
                                            break;
                                        case "name":
                                            i2 = i10;
                                            break;
                                        case "fontsize":
                                            i5 = i10;
                                            break;
                                        case "alignment":
                                            i3 = i10;
                                            break;
                                    }
                                }
                                if (i2 != -1) {
                                    aVar = new C2607c.a(i2, i3, i4, i5, i6, i7, i8, i9, strArrSplit2.length);
                                }
                            } else {
                                if (strM3087g3.startsWith("Style:")) {
                                    if (aVar == null) {
                                        Log.w("SsaDecoder", strM3087g3.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(strM3087g3) : new String("Skipping 'Style:' line before 'Format:' line: "));
                                    } else {
                                        C1460d.m531j(strM3087g3.startsWith("Style:"));
                                        String[] strArrSplit3 = TextUtils.split(strM3087g3.substring(6), ",");
                                        int length = strArrSplit3.length;
                                        int i11 = aVar.f6013i;
                                        if (length != i11) {
                                            Object[] objArr = new Object[3];
                                            objArr[c2] = Integer.valueOf(i11);
                                            objArr[1] = Integer.valueOf(strArrSplit3.length);
                                            objArr[c] = strM3087g3;
                                            Log.w("SsaStyle", C2738e0.m3003k("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
                                        } else {
                                            try {
                                                String strTrim = strArrSplit3[aVar.f6005a].trim();
                                                int i12 = aVar.f6006b;
                                                int iM2673a = i12 != -1 ? C2607c.m2673a(strArrSplit3[i12].trim()) : -1;
                                                int i13 = aVar.f6007c;
                                                Integer numM2675c = i13 != -1 ? C2607c.m2675c(strArrSplit3[i13].trim()) : null;
                                                int i14 = aVar.f6008d;
                                                if (i14 != -1) {
                                                    String strTrim2 = strArrSplit3[i14].trim();
                                                    try {
                                                        f = Float.parseFloat(strTrim2);
                                                    } catch (NumberFormatException e) {
                                                        StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                                                        sb.append("Failed to parse font size: '");
                                                        sb.append(strTrim2);
                                                        sb.append("'");
                                                        C2750q.m3040c("SsaStyle", sb.toString(), e);
                                                        f = -3.4028235E38f;
                                                    }
                                                } else {
                                                    f = -3.4028235E38f;
                                                }
                                                int i15 = aVar.f6009e;
                                                boolean z2 = i15 != -1 && C2607c.m2674b(strArrSplit3[i15].trim());
                                                int i16 = aVar.f6010f;
                                                boolean z3 = i16 != -1 && C2607c.m2674b(strArrSplit3[i16].trim());
                                                int i17 = aVar.f6011g;
                                                boolean z4 = i17 != -1 && C2607c.m2674b(strArrSplit3[i17].trim());
                                                int i18 = aVar.f6012h;
                                                c2607c = new C2607c(strTrim, iM2673a, numM2675c, f, z2, z3, z4, i18 != -1 && C2607c.m2674b(strArrSplit3[i18].trim()));
                                            } catch (RuntimeException e2) {
                                                C2750q.m3040c("SsaStyle", C1643a.m859k(strM3087g3.length() + 36, "Skipping malformed 'Style:' line: '", strM3087g3, "'"), e2);
                                                c2607c = null;
                                            }
                                            if (c2607c != null) {
                                                linkedHashMap.put(c2607c.f5997a, c2607c);
                                            }
                                        }
                                        c2607c = null;
                                        if (c2607c != null) {
                                            linkedHashMap.put(c2607c.f5997a, c2607c);
                                        }
                                    }
                                }
                                i = 91;
                                c = 2;
                                c2 = 0;
                            }
                        }
                    }
                }
                this.f5989q = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strM3087g)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strM3087g)) {
                return;
            }
        }
    }
}
