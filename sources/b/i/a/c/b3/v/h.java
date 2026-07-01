package b.i.a.c.b3.v;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebvttCueParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f891b = Pattern.compile("(\\S+?):(\\S+)");
    public static final Map<String, Integer> c;
    public static final Map<String, Integer> d;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        d = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    public static void a(@Nullable String str, h$c h_c, List<h$b> list, SpannableStringBuilder spannableStringBuilder, List<f> list2) {
        byte b2;
        int i = h_c.f893b;
        int length = spannableStringBuilder.length();
        String str2 = h_c.a;
        str2.hashCode();
        int iHashCode = str2.hashCode();
        int i2 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode != 3511770) {
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 117) {
                                    if (iHashCode == 118 && str2.equals("v")) {
                                        b2 = 5;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (str2.equals("u")) {
                                    b2 = 4;
                                } else {
                                    b2 = -1;
                                }
                            } else if (str2.equals("c")) {
                                b2 = 2;
                            } else {
                                b2 = -1;
                            }
                        } else if (str2.equals("b")) {
                            b2 = 1;
                        } else {
                            b2 = -1;
                        }
                    } else if (str2.equals("ruby")) {
                        b2 = 7;
                    } else {
                        b2 = -1;
                    }
                } else if (str2.equals("lang")) {
                    b2 = 6;
                } else {
                    b2 = -1;
                }
            } else if (str2.equals("i")) {
                b2 = 3;
            } else {
                b2 = -1;
            }
        } else if (str2.equals("")) {
            b2 = 0;
        } else {
            b2 = -1;
        }
        switch (b2) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 2:
                for (String str3 : h_c.d) {
                    Map<String, Integer> map = c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str3).intValue()), i, length, 33);
                    } else {
                        Map<String, Integer> map2 = d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str3).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 7:
                int iC = c(list2, str, h_c);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                int i3 = h$b.a;
                Collections.sort(arrayList, a.j);
                int i4 = h_c.f893b;
                int i5 = 0;
                int length2 = 0;
                while (i5 < arrayList.size()) {
                    if ("rt".equals(((h$b) arrayList.get(i5)).f892b.a)) {
                        h$b h_b = (h$b) arrayList.get(i5);
                        int iC2 = c(list2, str, h_b.f892b);
                        if (iC2 == i2) {
                            iC2 = iC != i2 ? iC : 1;
                        }
                        int i6 = h_b.f892b.f893b - length2;
                        int i7 = h_b.c - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i6, i7);
                        spannableStringBuilder.delete(i6, i7);
                        spannableStringBuilder.setSpan(new b.i.a.c.b3.q.c(charSequenceSubSequence.toString(), iC2), i4, i6, 33);
                        length2 = charSequenceSubSequence.length() + length2;
                        i4 = i6;
                    }
                    i5++;
                    i2 = -1;
                }
                break;
            default:
                return;
        }
        List<h$d> listB = b(list2, str, h_c);
        int i8 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) listB;
            if (i8 >= arrayList2.size()) {
                return;
            }
            f fVar = ((h$d) arrayList2.get(i8)).k;
            if (fVar != null) {
                if (fVar.a() != -1) {
                    b.c.a.a0.d.c(spannableStringBuilder, new StyleSpan(fVar.a()), i, length, 33);
                }
                if (fVar.j == 1) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (fVar.k == 1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (fVar.g) {
                    if (!fVar.g) {
                        throw new IllegalStateException("Font color not defined");
                    }
                    b.c.a.a0.d.c(spannableStringBuilder, new ForegroundColorSpan(fVar.f), i, length, 33);
                }
                if (fVar.i) {
                    if (!fVar.i) {
                        throw new IllegalStateException("Background color not defined.");
                    }
                    b.c.a.a0.d.c(spannableStringBuilder, new BackgroundColorSpan(fVar.h), i, length, 33);
                }
                if (fVar.e != null) {
                    b.c.a.a0.d.c(spannableStringBuilder, new TypefaceSpan(fVar.e), i, length, 33);
                }
                int i9 = fVar.n;
                if (i9 == 1) {
                    b.c.a.a0.d.c(spannableStringBuilder, new AbsoluteSizeSpan((int) fVar.o, true), i, length, 33);
                } else if (i9 == 2) {
                    b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVar.o), i, length, 33);
                } else if (i9 == 3) {
                    b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVar.o / 100.0f), i, length, 33);
                }
                if (fVar.q) {
                    spannableStringBuilder.setSpan(new b.i.a.c.b3.q.a(), i, length, 33);
                }
            }
            i8++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static List<h$d> b(List<f> list, @Nullable String str, h$c h_c) {
        ?? r4;
        int size;
        boolean zIsEmpty;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            f fVar = list.get(i);
            String str2 = h_c.a;
            Set<String> set = h_c.d;
            String str3 = h_c.c;
            if (fVar.a.isEmpty() && fVar.f889b.isEmpty() && fVar.c.isEmpty() && fVar.d.isEmpty()) {
                zIsEmpty = TextUtils.isEmpty(str2);
            } else {
                int iB = f.b(f.b(f.b(0, fVar.a, str, BasicMeasure.EXACTLY), fVar.f889b, str2, 2), fVar.d, str3, 4);
                if (iB == -1 || !set.containsAll(fVar.c)) {
                    r4 = 0;
                } else {
                    size = iB + (fVar.c.size() * 4);
                }
            }
            if (r4 > 0) {
                r4 = size;
                r4 = zIsEmpty;
                arrayList.add(new h$d(r4, fVar));
            } else {
                r4 = size;
                r4 = zIsEmpty;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List<f> list, @Nullable String str, h$c h_c) {
        List<h$d> listB = b(list, str, h_c);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) listB;
            if (i >= arrayList.size()) {
                return -1;
            }
            int i2 = ((h$d) arrayList.get(i)).k.p;
            if (i2 != -1) {
                return i2;
            }
            i++;
        }
    }

    @Nullable
    public static g d(@Nullable String str, Matcher matcher, x xVar, List<f> list) {
        h$e h_e = new h$e();
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            h_e.a = j.b(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            h_e.f894b = j.b(strGroup2);
            String strGroup3 = matcher.group(3);
            Objects.requireNonNull(strGroup3);
            e(strGroup3, h_e);
            StringBuilder sb = new StringBuilder();
            String strG = xVar.g();
            while (!TextUtils.isEmpty(strG)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strG.trim());
                strG = xVar.g();
            }
            h_e.c = f(str, sb.toString(), list);
            return new g(h_e.a().a(), h_e.a, h_e.f894b);
        } catch (NumberFormatException unused) {
            String strValueOf = String.valueOf(matcher.group());
            Log.w("WebvttCueParser", strValueOf.length() != 0 ? "Skipping cue with bad header: ".concat(strValueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(String str, h$e h_e) {
        Matcher matcher = f891b.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            try {
                if ("line".equals(strGroup)) {
                    g(strGroup2, h_e);
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2) {
                        case "center":
                        case "middle":
                            i = 2;
                            break;
                        case "end":
                            i = 3;
                            break;
                        case "left":
                            i = 4;
                            break;
                        case "right":
                            i = 5;
                            break;
                        case "start":
                            break;
                        default:
                            Log.w("WebvttCueParser", strGroup2.length() != 0 ? "Invalid alignment value: ".concat(strGroup2) : new String("Invalid alignment value: "));
                            i = 2;
                            break;
                    }
                    h_e.d = i;
                } else if (ModelAuditLogEntry.CHANGE_KEY_POSITION.equals(strGroup)) {
                    h(strGroup2, h_e);
                } else if ("size".equals(strGroup)) {
                    h_e.j = j.a(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    if (strGroup2.equals("lr")) {
                        i = 2;
                    } else if (!strGroup2.equals("rl")) {
                        Log.w("WebvttCueParser", strGroup2.length() != 0 ? "Invalid 'vertical' value: ".concat(strGroup2) : new String("Invalid 'vertical' value: "));
                        i = Integer.MIN_VALUE;
                    }
                    h_e.k = i;
                } else {
                    StringBuilder sb = new StringBuilder(strGroup.length() + 21 + strGroup2.length());
                    sb.append("Unknown cue setting ");
                    sb.append(strGroup);
                    sb.append(":");
                    sb.append(strGroup2);
                    Log.w("WebvttCueParser", sb.toString());
                }
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(matcher.group());
                Log.w("WebvttCueParser", strValueOf.length() != 0 ? "Skipping bad cue setting: ".concat(strValueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:69:0x00f5  */
    public static SpannedString f(@Nullable String str, String str2, List<f> list) {
        boolean z2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            String strTrim = "";
            if (i2 >= str2.length()) {
                while (!arrayDeque.isEmpty()) {
                    a(str, (h$c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new h$c("", 0, "", Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char cCharAt = str2.charAt(i2);
            if (cCharAt == '&') {
                i2++;
                int iIndexOf = str2.indexOf(59, i2);
                int iIndexOf2 = str2.indexOf(32, i2);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(i2, iIndexOf);
                    strSubstring.hashCode();
                    strSubstring.hashCode();
                    switch (strSubstring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            b.d.b.a.a.i0(strSubstring.length() + 33, "ignoring unsupported entity: '&", strSubstring, ";'", "WebvttCueParser");
                            break;
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i2 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i2++;
            } else {
                int length = i2 + 1;
                if (length < str2.length()) {
                    boolean z3 = str2.charAt(length) == '/';
                    int iIndexOf3 = str2.indexOf(62, length);
                    length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                    int i3 = length - 2;
                    boolean z4 = str2.charAt(i3) == '/';
                    int i4 = i2 + (z3 ? 2 : 1);
                    if (!z4) {
                        i3 = length - 1;
                    }
                    String strSubstring2 = str2.substring(i4, i3);
                    if (!strSubstring2.trim().isEmpty()) {
                        String strTrim2 = strSubstring2.trim();
                        b.c.a.a0.d.j(!strTrim2.isEmpty());
                        int i5 = e0.a;
                        String str3 = strTrim2.split("[ \\.]", 2)[i];
                        str3.hashCode();
                        switch (str3) {
                            case "b":
                            case "c":
                            case "i":
                            case "u":
                            case "v":
                            case "rt":
                            case "lang":
                            case "ruby":
                                z2 = true;
                                break;
                            default:
                                z2 = false;
                                break;
                        }
                        if (z2) {
                            if (z3) {
                                while (!arrayDeque.isEmpty()) {
                                    h$c h_c = (h$c) arrayDeque.pop();
                                    a(str, h_c, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new h$b(h_c, spannableStringBuilder.length(), null));
                                    }
                                    if (h_c.a.equals(str3)) {
                                    }
                                }
                            } else if (!z4) {
                                int length2 = spannableStringBuilder.length();
                                String strTrim3 = strSubstring2.trim();
                                b.c.a.a0.d.j(!strTrim3.isEmpty());
                                int iIndexOf4 = strTrim3.indexOf(" ");
                                if (iIndexOf4 != -1) {
                                    strTrim = strTrim3.substring(iIndexOf4).trim();
                                    strTrim3 = strTrim3.substring(i, iIndexOf4);
                                }
                                String[] strArrH = e0.H(strTrim3, "\\.");
                                String str4 = strArrH[i];
                                HashSet hashSet = new HashSet();
                                for (int i6 = 1; i6 < strArrH.length; i6++) {
                                    hashSet.add(strArrH[i6]);
                                }
                                arrayDeque.push(new h$c(str4, length2, strTrim, hashSet));
                            }
                        }
                    }
                    i2 = length;
                }
                i2 = length;
            }
            i = 0;
        }
    }

    public static void g(String str, h$e h_e) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            strSubstring.hashCode();
            int i = 2;
            switch (strSubstring) {
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i = 0;
                    break;
                default:
                    Log.w("WebvttCueParser", strSubstring.length() != 0 ? "Invalid anchor value: ".concat(strSubstring) : new String("Invalid anchor value: "));
                    i = Integer.MIN_VALUE;
                    break;
            }
            h_e.g = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            h_e.e = j.a(str);
            h_e.f = 0;
        } else {
            h_e.e = Integer.parseInt(str);
            h_e.f = 1;
        }
    }

    public static void h(String str, h$e h_e) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            strSubstring.hashCode();
            int i = 2;
            switch (strSubstring) {
                case "line-left":
                case "start":
                    i = 0;
                    break;
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "line-right":
                case "end":
                    break;
                default:
                    Log.w("WebvttCueParser", strSubstring.length() != 0 ? "Invalid anchor value: ".concat(strSubstring) : new String("Invalid anchor value: "));
                    i = Integer.MIN_VALUE;
                    break;
            }
            h_e.i = i;
            str = str.substring(0, iIndexOf);
        }
        h_e.h = j.a(str);
    }
}
