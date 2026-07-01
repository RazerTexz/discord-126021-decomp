package b.i.a.c.b3.r;

import android.graphics.PointF;
import android.text.Layout$Alignment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.f;
import b.i.a.c.b3.g;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.q;
import b.i.a.c.f3.x;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SsaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public static final Pattern n = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean o;

    @Nullable
    public final b p;
    public Map<String, c> q;
    public float r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f874s;

    public a(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.f874s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String strL = e0.l(list.get(0));
        b.c.a.a0.d.j(strL.startsWith("Format:"));
        b bVarA = b.a(strL);
        Objects.requireNonNull(bVarA);
        this.p = bVarA;
        m(new x(list.get(1)));
    }

    public static int k(long j, List<Long> list, List<List<b.i.a.c.b3.b>> list2) {
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

    public static float l(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static long n(String str) {
        Matcher matcher = n.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = e0.a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(strGroup) * 60 * 60 * 1000000);
    }

    @Override // b.i.a.c.b3.f
    public g j(byte[] bArr, int i, boolean z2) {
        x xVar;
        int i2;
        int i3;
        float f;
        Layout$Alignment layout$Alignment;
        int i4;
        int i5;
        float fL;
        float fL2;
        float f2;
        int i6;
        float f3;
        int i7;
        int i8;
        int iA;
        int i9;
        a aVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        x xVar2 = new x(bArr, i);
        if (!aVar.o) {
            aVar.m(xVar2);
        }
        b bVarA = aVar.o ? aVar.p : null;
        while (true) {
            String strG = xVar2.g();
            if (strG == null) {
                return new d(arrayList, arrayList2);
            }
            if (strG.startsWith("Format:")) {
                bVarA = b.a(strG);
            } else {
                if (strG.startsWith("Dialogue:")) {
                    if (bVarA == null) {
                        Log.w("SsaDecoder", strG.length() != 0 ? "Skipping dialogue line before complete format: ".concat(strG) : new String("Skipping dialogue line before complete format: "));
                    } else {
                        b.c.a.a0.d.j(strG.startsWith("Dialogue:"));
                        String[] strArrSplit = strG.substring(9).split(",", bVarA.e);
                        if (strArrSplit.length != bVarA.e) {
                            Log.w("SsaDecoder", strG.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(strG) : new String("Skipping dialogue line with fewer columns than format: "));
                        } else {
                            long jN = n(strArrSplit[bVarA.a]);
                            if (jN == -9223372036854775807L) {
                                Log.w("SsaDecoder", strG.length() != 0 ? "Skipping invalid timing: ".concat(strG) : new String("Skipping invalid timing: "));
                            } else {
                                long jN2 = n(strArrSplit[bVarA.f875b]);
                                if (jN2 == -9223372036854775807L) {
                                    Log.w("SsaDecoder", strG.length() != 0 ? "Skipping invalid timing: ".concat(strG) : new String("Skipping invalid timing: "));
                                } else {
                                    Map<String, c> map = aVar.q;
                                    c cVar = (map == null || (i9 = bVarA.c) == -1) ? null : map.get(strArrSplit[i9].trim());
                                    String str = strArrSplit[bVarA.d];
                                    Matcher matcher = c$b.a.matcher(str);
                                    PointF pointF = null;
                                    int i10 = -1;
                                    while (true) {
                                        xVar = xVar2;
                                        if (matcher.find()) {
                                            String strGroup = matcher.group(1);
                                            Objects.requireNonNull(strGroup);
                                            try {
                                                PointF pointFA = c$b.a(strGroup);
                                                if (pointFA != null) {
                                                    pointF = pointFA;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            try {
                                                Matcher matcher2 = c$b.d.matcher(strGroup);
                                                if (matcher2.find()) {
                                                    String strGroup2 = matcher2.group(1);
                                                    Objects.requireNonNull(strGroup2);
                                                    iA = c.a(strGroup2);
                                                } else {
                                                    iA = -1;
                                                }
                                                if (iA != -1) {
                                                    i10 = iA;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            xVar2 = xVar;
                                        } else {
                                            String strReplace = c$b.a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                            float f4 = aVar.r;
                                            float f5 = aVar.f874s;
                                            SpannableString spannableString = new SpannableString(strReplace);
                                            if (cVar != null) {
                                                if (cVar.c != null) {
                                                    spannableString.setSpan(new ForegroundColorSpan(cVar.c.intValue()), 0, spannableString.length(), 33);
                                                }
                                                float f6 = cVar.d;
                                                if (f6 == -3.4028235E38f || f5 == -3.4028235E38f) {
                                                    f2 = -3.4028235E38f;
                                                    i6 = Integer.MIN_VALUE;
                                                } else {
                                                    f2 = f6 / f5;
                                                    i6 = 1;
                                                }
                                                boolean z3 = cVar.e;
                                                if (z3 && cVar.f) {
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
                                                    } else if (cVar.f) {
                                                        spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                    }
                                                }
                                                if (cVar.g) {
                                                    spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                                }
                                                if (cVar.h) {
                                                    spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                                }
                                                i2 = -1;
                                                i3 = i6;
                                                f = f3;
                                            } else {
                                                bVarA = bVarA;
                                                jN2 = jN2;
                                                i2 = -1;
                                                i3 = Integer.MIN_VALUE;
                                                f = -3.4028235E38f;
                                            }
                                            if (i10 == i2) {
                                                i10 = cVar != null ? cVar.f876b : i2;
                                            }
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", b.d.b.a.a.g(30, "Unknown alignment: ", i10));
                                                case -1:
                                                    layout$Alignment = null;
                                                    break;
                                                case 1:
                                                case 4:
                                                case 7:
                                                    layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
                                                    break;
                                                case 2:
                                                case 5:
                                                case 8:
                                                    layout$Alignment = Layout$Alignment.ALIGN_CENTER;
                                                    break;
                                                case 3:
                                                case 6:
                                                case 9:
                                                    layout$Alignment = Layout$Alignment.ALIGN_OPPOSITE;
                                                    break;
                                            }
                                            Layout$Alignment layout$Alignment2 = layout$Alignment;
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", b.d.b.a.a.g(30, "Unknown alignment: ", i10));
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
                                                    Log.w("SsaDecoder", b.d.b.a.a.g(30, "Unknown alignment: ", i10));
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
                                                fL = l(i4);
                                                fL2 = l(i5);
                                            } else {
                                                fL = pointF.x / f4;
                                                fL2 = pointF.y / f5;
                                            }
                                            b.i.a.c.b3.b bVar = new b.i.a.c.b3.b(spannableString, layout$Alignment2, null, null, fL2, 0, i5, fL, i4, i3, f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                            int iK = k(jN2, arrayList2, arrayList);
                                            for (int iK2 = k(jN, arrayList2, arrayList); iK2 < iK; iK2++) {
                                                ((List) arrayList.get(iK2)).add(bVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    xVar = xVar2;
                    bVarA = bVarA;
                } else {
                    xVar = xVar2;
                    bVarA = bVarA;
                }
                aVar = this;
                bVarA = bVarA;
                xVar2 = xVar;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:147:0x0293  */
    /* JADX WARN: Code duplicated, block: B:75:0x012f  */
    public final void m(x xVar) {
        c cVar;
        float f;
        while (true) {
            String strG = xVar.g();
            if (strG == null) {
                return;
            }
            int i = 91;
            char c = 2;
            char c2 = 0;
            if ("[Script Info]".equalsIgnoreCase(strG)) {
                while (true) {
                    String strG2 = xVar.g();
                    if (strG2 == null || (xVar.a() != 0 && xVar.c() == 91)) {
                        break;
                    }
                    String[] strArrSplit = strG2.split(":");
                    if (strArrSplit.length == 2) {
                        String strU1 = b.i.a.f.e.o.f.u1(strArrSplit[0].trim());
                        strU1.hashCode();
                        if (strU1.equals("playresx")) {
                            this.r = Float.parseFloat(strArrSplit[1].trim());
                        } else if (strU1.equals("playresy")) {
                            try {
                                this.f874s = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strG)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (true) {
                    c$a c_a = null;
                    while (true) {
                        String strG3 = xVar.g();
                        if (strG3 != null && (xVar.a() == 0 || xVar.c() != i)) {
                            if (strG3.startsWith("Format:")) {
                                String[] strArrSplit2 = TextUtils.split(strG3.substring(7), ",");
                                int i2 = -1;
                                int i3 = -1;
                                int i4 = -1;
                                int i5 = -1;
                                int i6 = -1;
                                int i7 = -1;
                                int i8 = -1;
                                int i9 = -1;
                                for (int i10 = 0; i10 < strArrSplit2.length; i10++) {
                                    String strU2 = b.i.a.f.e.o.f.u1(strArrSplit2[i10].trim());
                                    strU2.hashCode();
                                    switch (strU2) {
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
                                    c_a = new c$a(i2, i3, i4, i5, i6, i7, i8, i9, strArrSplit2.length);
                                }
                            } else {
                                if (strG3.startsWith("Style:")) {
                                    if (c_a == null) {
                                        Log.w("SsaDecoder", strG3.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(strG3) : new String("Skipping 'Style:' line before 'Format:' line: "));
                                    } else {
                                        b.c.a.a0.d.j(strG3.startsWith("Style:"));
                                        String[] strArrSplit3 = TextUtils.split(strG3.substring(6), ",");
                                        int length = strArrSplit3.length;
                                        int i11 = c_a.i;
                                        if (length != i11) {
                                            Object[] objArr = new Object[3];
                                            objArr[c2] = Integer.valueOf(i11);
                                            objArr[1] = Integer.valueOf(strArrSplit3.length);
                                            objArr[c] = strG3;
                                            Log.w("SsaStyle", e0.k("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
                                        } else {
                                            try {
                                                String strTrim = strArrSplit3[c_a.a].trim();
                                                int i12 = c_a.f877b;
                                                int iA = i12 != -1 ? c.a(strArrSplit3[i12].trim()) : -1;
                                                int i13 = c_a.c;
                                                Integer numC = i13 != -1 ? c.c(strArrSplit3[i13].trim()) : null;
                                                int i14 = c_a.d;
                                                if (i14 != -1) {
                                                    String strTrim2 = strArrSplit3[i14].trim();
                                                    try {
                                                        f = Float.parseFloat(strTrim2);
                                                    } catch (NumberFormatException e) {
                                                        StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                                                        sb.append("Failed to parse font size: '");
                                                        sb.append(strTrim2);
                                                        sb.append("'");
                                                        q.c("SsaStyle", sb.toString(), e);
                                                        f = -3.4028235E38f;
                                                    }
                                                } else {
                                                    f = -3.4028235E38f;
                                                }
                                                int i15 = c_a.e;
                                                boolean z2 = i15 != -1 && c.b(strArrSplit3[i15].trim());
                                                int i16 = c_a.f;
                                                boolean z3 = i16 != -1 && c.b(strArrSplit3[i16].trim());
                                                int i17 = c_a.g;
                                                boolean z4 = i17 != -1 && c.b(strArrSplit3[i17].trim());
                                                int i18 = c_a.h;
                                                cVar = new c(strTrim, iA, numC, f, z2, z3, z4, i18 != -1 && c.b(strArrSplit3[i18].trim()));
                                            } catch (RuntimeException e2) {
                                                q.c("SsaStyle", b.d.b.a.a.k(strG3.length() + 36, "Skipping malformed 'Style:' line: '", strG3, "'"), e2);
                                                cVar = null;
                                            }
                                            if (cVar != null) {
                                                linkedHashMap.put(cVar.a, cVar);
                                            }
                                        }
                                        cVar = null;
                                        if (cVar != null) {
                                            linkedHashMap.put(cVar.a, cVar);
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
                this.q = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strG)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strG)) {
                return;
            }
        }
    }
}
