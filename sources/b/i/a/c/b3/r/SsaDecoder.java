package b.i.a.c.b3.r;

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
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.b3.r.SsaStyle;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.r.a, reason: use source file name */
/* JADX INFO: compiled from: SsaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder2 {
    public static final Pattern n = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean o;

    @Nullable
    public final SsaDialogueFormat p;
    public Map<String, SsaStyle> q;
    public float r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f874s;

    public SsaDecoder(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.f874s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String strL = Util2.l(list.get(0));
        AnimatableValueParser.j(strL.startsWith("Format:"));
        SsaDialogueFormat ssaDialogueFormatA = SsaDialogueFormat.a(strL);
        Objects.requireNonNull(ssaDialogueFormatA);
        this.p = ssaDialogueFormatA;
        m(new ParsableByteArray(list.get(1)));
    }

    public static int k(long j, List<Long> list, List<List<Cue>> list2) {
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
        int i = Util2.a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(strGroup) * 60 * 60 * 1000000);
    }

    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public Subtitle j(byte[] bArr, int i, boolean z2) {
        ParsableByteArray parsableByteArray;
        int i2;
        int i3;
        float f;
        Layout.Alignment alignment;
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
        SsaDecoder ssaDecoder = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        if (!ssaDecoder.o) {
            ssaDecoder.m(parsableByteArray2);
        }
        SsaDialogueFormat ssaDialogueFormatA = ssaDecoder.o ? ssaDecoder.p : null;
        while (true) {
            String strG = parsableByteArray2.g();
            if (strG == null) {
                return new SsaSubtitle(arrayList, arrayList2);
            }
            if (strG.startsWith("Format:")) {
                ssaDialogueFormatA = SsaDialogueFormat.a(strG);
            } else {
                if (strG.startsWith("Dialogue:")) {
                    if (ssaDialogueFormatA == null) {
                        Log.w("SsaDecoder", strG.length() != 0 ? "Skipping dialogue line before complete format: ".concat(strG) : new String("Skipping dialogue line before complete format: "));
                    } else {
                        AnimatableValueParser.j(strG.startsWith("Dialogue:"));
                        String[] strArrSplit = strG.substring(9).split(",", ssaDialogueFormatA.e);
                        if (strArrSplit.length != ssaDialogueFormatA.e) {
                            Log.w("SsaDecoder", strG.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(strG) : new String("Skipping dialogue line with fewer columns than format: "));
                        } else {
                            long jN = n(strArrSplit[ssaDialogueFormatA.a]);
                            if (jN == -9223372036854775807L) {
                                Log.w("SsaDecoder", strG.length() != 0 ? "Skipping invalid timing: ".concat(strG) : new String("Skipping invalid timing: "));
                            } else {
                                long jN2 = n(strArrSplit[ssaDialogueFormatA.f875b]);
                                if (jN2 == -9223372036854775807L) {
                                    Log.w("SsaDecoder", strG.length() != 0 ? "Skipping invalid timing: ".concat(strG) : new String("Skipping invalid timing: "));
                                } else {
                                    Map<String, SsaStyle> map = ssaDecoder.q;
                                    SsaStyle ssaStyle = (map == null || (i9 = ssaDialogueFormatA.c) == -1) ? null : map.get(strArrSplit[i9].trim());
                                    String str = strArrSplit[ssaDialogueFormatA.d];
                                    Matcher matcher = SsaStyle.b.a.matcher(str);
                                    PointF pointF = null;
                                    int i10 = -1;
                                    while (true) {
                                        parsableByteArray = parsableByteArray2;
                                        if (matcher.find()) {
                                            String strGroup = matcher.group(1);
                                            Objects.requireNonNull(strGroup);
                                            try {
                                                PointF pointFA = SsaStyle.b.a(strGroup);
                                                if (pointFA != null) {
                                                    pointF = pointFA;
                                                }
                                            } catch (RuntimeException unused) {
                                            }
                                            try {
                                                Matcher matcher2 = SsaStyle.b.d.matcher(strGroup);
                                                if (matcher2.find()) {
                                                    String strGroup2 = matcher2.group(1);
                                                    Objects.requireNonNull(strGroup2);
                                                    iA = SsaStyle.a(strGroup2);
                                                } else {
                                                    iA = -1;
                                                }
                                                if (iA != -1) {
                                                    i10 = iA;
                                                }
                                            } catch (RuntimeException unused2) {
                                            }
                                            parsableByteArray2 = parsableByteArray;
                                        } else {
                                            String strReplace = SsaStyle.b.a.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                            float f4 = ssaDecoder.r;
                                            float f5 = ssaDecoder.f874s;
                                            SpannableString spannableString = new SpannableString(strReplace);
                                            if (ssaStyle != null) {
                                                if (ssaStyle.c != null) {
                                                    spannableString.setSpan(new ForegroundColorSpan(ssaStyle.c.intValue()), 0, spannableString.length(), 33);
                                                }
                                                float f6 = ssaStyle.d;
                                                if (f6 == -3.4028235E38f || f5 == -3.4028235E38f) {
                                                    f2 = -3.4028235E38f;
                                                    i6 = Integer.MIN_VALUE;
                                                } else {
                                                    f2 = f6 / f5;
                                                    i6 = 1;
                                                }
                                                boolean z3 = ssaStyle.e;
                                                if (z3 && ssaStyle.f) {
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
                                                    } else if (ssaStyle.f) {
                                                        spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                    }
                                                }
                                                if (ssaStyle.g) {
                                                    spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i8);
                                                }
                                                if (ssaStyle.h) {
                                                    spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i8);
                                                }
                                                i2 = -1;
                                                i3 = i6;
                                                f = f3;
                                            } else {
                                                ssaDialogueFormatA = ssaDialogueFormatA;
                                                jN2 = jN2;
                                                i2 = -1;
                                                i3 = Integer.MIN_VALUE;
                                                f = -3.4028235E38f;
                                            }
                                            if (i10 == i2) {
                                                i10 = ssaStyle != null ? ssaStyle.f876b : i2;
                                            }
                                            switch (i10) {
                                                case 0:
                                                default:
                                                    Log.w("SsaDecoder", outline.g(30, "Unknown alignment: ", i10));
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
                                                    Log.w("SsaDecoder", outline.g(30, "Unknown alignment: ", i10));
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
                                                    Log.w("SsaDecoder", outline.g(30, "Unknown alignment: ", i10));
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
                                            Cue cue = new Cue(spannableString, alignment2, null, null, fL2, 0, i5, fL, i4, i3, f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                            int iK = k(jN2, arrayList2, arrayList);
                                            for (int iK2 = k(jN, arrayList2, arrayList); iK2 < iK; iK2++) {
                                                ((List) arrayList.get(iK2)).add(cue);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    parsableByteArray = parsableByteArray2;
                    ssaDialogueFormatA = ssaDialogueFormatA;
                } else {
                    parsableByteArray = parsableByteArray2;
                    ssaDialogueFormatA = ssaDialogueFormatA;
                }
                ssaDecoder = this;
                ssaDialogueFormatA = ssaDialogueFormatA;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:147:0x0293  */
    /* JADX WARN: Code duplicated, block: B:75:0x012f  */
    public final void m(ParsableByteArray parsableByteArray) {
        SsaStyle ssaStyle;
        float f;
        while (true) {
            String strG = parsableByteArray.g();
            if (strG == null) {
                return;
            }
            int i = 91;
            char c = 2;
            char c2 = 0;
            if ("[Script Info]".equalsIgnoreCase(strG)) {
                while (true) {
                    String strG2 = parsableByteArray.g();
                    if (strG2 == null || (parsableByteArray.a() != 0 && parsableByteArray.c() == 91)) {
                        break;
                    }
                    String[] strArrSplit = strG2.split(":");
                    if (strArrSplit.length == 2) {
                        String strU1 = f.u1(strArrSplit[0].trim());
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
                    SsaStyle.a aVar = null;
                    while (true) {
                        String strG3 = parsableByteArray.g();
                        if (strG3 != null && (parsableByteArray.a() == 0 || parsableByteArray.c() != i)) {
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
                                    String strU2 = f.u1(strArrSplit2[i10].trim());
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
                                    aVar = new SsaStyle.a(i2, i3, i4, i5, i6, i7, i8, i9, strArrSplit2.length);
                                }
                            } else {
                                if (strG3.startsWith("Style:")) {
                                    if (aVar == null) {
                                        Log.w("SsaDecoder", strG3.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(strG3) : new String("Skipping 'Style:' line before 'Format:' line: "));
                                    } else {
                                        AnimatableValueParser.j(strG3.startsWith("Style:"));
                                        String[] strArrSplit3 = TextUtils.split(strG3.substring(6), ",");
                                        int length = strArrSplit3.length;
                                        int i11 = aVar.i;
                                        if (length != i11) {
                                            Object[] objArr = new Object[3];
                                            objArr[c2] = Integer.valueOf(i11);
                                            objArr[1] = Integer.valueOf(strArrSplit3.length);
                                            objArr[c] = strG3;
                                            Log.w("SsaStyle", Util2.k("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
                                        } else {
                                            try {
                                                String strTrim = strArrSplit3[aVar.a].trim();
                                                int i12 = aVar.f877b;
                                                int iA = i12 != -1 ? SsaStyle.a(strArrSplit3[i12].trim()) : -1;
                                                int i13 = aVar.c;
                                                Integer numC = i13 != -1 ? SsaStyle.c(strArrSplit3[i13].trim()) : null;
                                                int i14 = aVar.d;
                                                if (i14 != -1) {
                                                    String strTrim2 = strArrSplit3[i14].trim();
                                                    try {
                                                        f = Float.parseFloat(strTrim2);
                                                    } catch (NumberFormatException e) {
                                                        StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                                                        sb.append("Failed to parse font size: '");
                                                        sb.append(strTrim2);
                                                        sb.append("'");
                                                        Log2.c("SsaStyle", sb.toString(), e);
                                                        f = -3.4028235E38f;
                                                    }
                                                } else {
                                                    f = -3.4028235E38f;
                                                }
                                                int i15 = aVar.e;
                                                boolean z2 = i15 != -1 && SsaStyle.b(strArrSplit3[i15].trim());
                                                int i16 = aVar.f;
                                                boolean z3 = i16 != -1 && SsaStyle.b(strArrSplit3[i16].trim());
                                                int i17 = aVar.g;
                                                boolean z4 = i17 != -1 && SsaStyle.b(strArrSplit3[i17].trim());
                                                int i18 = aVar.h;
                                                ssaStyle = new SsaStyle(strTrim, iA, numC, f, z2, z3, z4, i18 != -1 && SsaStyle.b(strArrSplit3[i18].trim()));
                                            } catch (RuntimeException e2) {
                                                Log2.c("SsaStyle", outline.k(strG3.length() + 36, "Skipping malformed 'Style:' line: '", strG3, "'"), e2);
                                                ssaStyle = null;
                                            }
                                            if (ssaStyle != null) {
                                                linkedHashMap.put(ssaStyle.a, ssaStyle);
                                            }
                                        }
                                        ssaStyle = null;
                                        if (ssaStyle != null) {
                                            linkedHashMap.put(ssaStyle.a, ssaStyle);
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
