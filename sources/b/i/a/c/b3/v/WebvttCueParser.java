package b.i.a.c.b3.v;

import android.graphics.Color;
import android.text.Layout;
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
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.q.HorizontalTextInVerticalContextSpan;
import b.i.a.c.b3.q.RubySpan;
import b.i.a.c.b3.v.WebvttCueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.v.h, reason: use source file name */
/* JADX INFO: compiled from: WebvttCueParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttCueParser {
    public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f891b = Pattern.compile("(\\S+?):(\\S+)");
    public static final Map<String, Integer> c;
    public static final Map<String, Integer> d;

    /* JADX INFO: renamed from: b.i.a.c.b3.v.h$b */
    /* JADX INFO: compiled from: WebvttCueParser.java */
    public static class b {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f892b;
        public final int c;

        public b(c cVar, int i, a aVar) {
            this.f892b = cVar;
            this.c = i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.v.h$c */
    /* JADX INFO: compiled from: WebvttCueParser.java */
    public static final class c {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f893b;
        public final String c;
        public final Set<String> d;

        public c(String str, int i, String str2, Set<String> set) {
            this.f893b = i;
            this.a = str;
            this.c = str2;
            this.d = set;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.v.h$d */
    /* JADX INFO: compiled from: WebvttCueParser.java */
    public static final class d implements Comparable<d> {
        public final int j;
        public final WebvttCssStyle k;

        public d(int i, WebvttCssStyle webvttCssStyle) {
            this.j = i;
            this.k = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            return Integer.compare(this.j, dVar.j);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.v.h$e */
    /* JADX INFO: compiled from: WebvttCueParser.java */
    public static final class e {
        public CharSequence c;
        public long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f894b = 0;
        public int d = 2;
        public float e = -3.4028235E38f;
        public int f = 1;
        public int g = 0;
        public float h = -3.4028235E38f;
        public int i = Integer.MIN_VALUE;
        public float j = 1.0f;
        public int k = Integer.MIN_VALUE;

        /* JADX WARN: Code duplicated, block: B:20:0x0034  */
        /* JADX WARN: Code duplicated, block: B:21:0x0036  */
        /* JADX WARN: Code duplicated, block: B:29:0x0053  */
        /* JADX WARN: Code duplicated, block: B:31:0x0059  */
        /* JADX WARN: Code duplicated, block: B:43:0x0076  */
        public Cue.b a() {
            Layout.Alignment alignment;
            float f = this.h;
            float f2 = -3.4028235E38f;
            if (f == -3.4028235E38f) {
                int i = this.d;
                if (i != 4) {
                    f = i != 5 ? 0.5f : 1.0f;
                } else {
                    f = 0.0f;
                }
            }
            int i2 = this.i;
            if (i2 == Integer.MIN_VALUE) {
                int i3 = this.d;
                if (i3 == 1) {
                    i2 = 0;
                } else if (i3 == 3) {
                    i2 = 2;
                } else if (i3 == 4) {
                    i2 = 0;
                } else if (i3 != 5) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
            }
            Cue.b bVar = new Cue.b();
            int i4 = this.d;
            if (i4 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 == 2) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            } else if (i4 == 3) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i4 == 4) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 != 5) {
                outline.g0(34, "Unknown textAlignment: ", i4, "WebvttCueParser");
                alignment = null;
            } else {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            bVar.c = alignment;
            float f3 = this.e;
            int i5 = this.f;
            if (f3 != -3.4028235E38f && i5 == 0 && (f3 < 0.0f || f3 > 1.0f)) {
                f2 = 1.0f;
            } else if (f3 != -3.4028235E38f) {
                f2 = f3;
            } else if (i5 == 0) {
                f2 = 1.0f;
            }
            bVar.e = f2;
            bVar.f = i5;
            bVar.g = this.g;
            bVar.h = f;
            bVar.i = i2;
            float f4 = this.j;
            if (i2 == 0) {
                f = 1.0f - f;
            } else if (i2 == 1) {
                f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            } else if (i2 != 2) {
                throw new IllegalStateException(String.valueOf(i2));
            }
            bVar.l = Math.min(f4, f);
            bVar.p = this.k;
            CharSequence charSequence = this.c;
            if (charSequence != null) {
                bVar.a = charSequence;
            }
            return bVar;
        }
    }

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
    public static void a(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        byte b2;
        int i = cVar.f893b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.a;
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
                for (String str3 : cVar.d) {
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
                int iC = c(list2, str, cVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                int i3 = b.a;
                Collections.sort(arrayList, new Comparator() { // from class: b.i.a.c.b3.v.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Integer.compare(((WebvttCueParser.b) obj).f892b.f893b, ((WebvttCueParser.b) obj2).f892b.f893b);
                    }
                });
                int i4 = cVar.f893b;
                int i5 = 0;
                int length2 = 0;
                while (i5 < arrayList.size()) {
                    if ("rt".equals(((b) arrayList.get(i5)).f892b.a)) {
                        b bVar = (b) arrayList.get(i5);
                        int iC2 = c(list2, str, bVar.f892b);
                        if (iC2 == i2) {
                            iC2 = iC != i2 ? iC : 1;
                        }
                        int i6 = bVar.f892b.f893b - length2;
                        int i7 = bVar.c - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i6, i7);
                        spannableStringBuilder.delete(i6, i7);
                        spannableStringBuilder.setSpan(new RubySpan(charSequenceSubSequence.toString(), iC2), i4, i6, 33);
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
        List<d> listB = b(list2, str, cVar);
        int i8 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) listB;
            if (i8 >= arrayList2.size()) {
                return;
            }
            WebvttCssStyle webvttCssStyle = ((d) arrayList2.get(i8)).k;
            if (webvttCssStyle != null) {
                if (webvttCssStyle.a() != -1) {
                    AnimatableValueParser.c(spannableStringBuilder, new StyleSpan(webvttCssStyle.a()), i, length, 33);
                }
                if (webvttCssStyle.j == 1) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (webvttCssStyle.k == 1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (webvttCssStyle.g) {
                    if (!webvttCssStyle.g) {
                        throw new IllegalStateException("Font color not defined");
                    }
                    AnimatableValueParser.c(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.f), i, length, 33);
                }
                if (webvttCssStyle.i) {
                    if (!webvttCssStyle.i) {
                        throw new IllegalStateException("Background color not defined.");
                    }
                    AnimatableValueParser.c(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.h), i, length, 33);
                }
                if (webvttCssStyle.e != null) {
                    AnimatableValueParser.c(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.e), i, length, 33);
                }
                int i9 = webvttCssStyle.n;
                if (i9 == 1) {
                    AnimatableValueParser.c(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.o, true), i, length, 33);
                } else if (i9 == 2) {
                    AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.o), i, length, 33);
                } else if (i9 == 3) {
                    AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.o / 100.0f), i, length, 33);
                }
                if (webvttCssStyle.q) {
                    spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i, length, 33);
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
    public static List<d> b(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        ?? r4;
        int size;
        boolean zIsEmpty;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WebvttCssStyle webvttCssStyle = list.get(i);
            String str2 = cVar.a;
            Set<String> set = cVar.d;
            String str3 = cVar.c;
            if (webvttCssStyle.a.isEmpty() && webvttCssStyle.f889b.isEmpty() && webvttCssStyle.c.isEmpty() && webvttCssStyle.d.isEmpty()) {
                zIsEmpty = TextUtils.isEmpty(str2);
            } else {
                int iB = WebvttCssStyle.b(WebvttCssStyle.b(WebvttCssStyle.b(0, webvttCssStyle.a, str, BasicMeasure.EXACTLY), webvttCssStyle.f889b, str2, 2), webvttCssStyle.d, str3, 4);
                if (iB == -1 || !set.containsAll(webvttCssStyle.c)) {
                    r4 = 0;
                } else {
                    size = iB + (webvttCssStyle.c.size() * 4);
                }
            }
            if (r4 > 0) {
                r4 = size;
                r4 = zIsEmpty;
                arrayList.add(new d(r4, webvttCssStyle));
            } else {
                r4 = size;
                r4 = zIsEmpty;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        List<d> listB = b(list, str, cVar);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) listB;
            if (i >= arrayList.size()) {
                return -1;
            }
            int i2 = ((d) arrayList.get(i)).k.p;
            if (i2 != -1) {
                return i2;
            }
            i++;
        }
    }

    @Nullable
    public static WebvttCueInfo d(@Nullable String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        e eVar = new e();
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            eVar.a = WebvttParserUtil.b(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            eVar.f894b = WebvttParserUtil.b(strGroup2);
            String strGroup3 = matcher.group(3);
            Objects.requireNonNull(strGroup3);
            e(strGroup3, eVar);
            StringBuilder sb = new StringBuilder();
            String strG = parsableByteArray.g();
            while (!TextUtils.isEmpty(strG)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strG.trim());
                strG = parsableByteArray.g();
            }
            eVar.c = f(str, sb.toString(), list);
            return new WebvttCueInfo(eVar.a().a(), eVar.a, eVar.f894b);
        } catch (NumberFormatException unused) {
            String strValueOf = String.valueOf(matcher.group());
            Log.w("WebvttCueParser", strValueOf.length() != 0 ? "Skipping cue with bad header: ".concat(strValueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(String str, e eVar) {
        Matcher matcher = f891b.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            try {
                if ("line".equals(strGroup)) {
                    g(strGroup2, eVar);
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
                    eVar.d = i;
                } else if (ModelAuditLogEntry.CHANGE_KEY_POSITION.equals(strGroup)) {
                    h(strGroup2, eVar);
                } else if ("size".equals(strGroup)) {
                    eVar.j = WebvttParserUtil.a(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    if (strGroup2.equals("lr")) {
                        i = 2;
                    } else if (!strGroup2.equals("rl")) {
                        Log.w("WebvttCueParser", strGroup2.length() != 0 ? "Invalid 'vertical' value: ".concat(strGroup2) : new String("Invalid 'vertical' value: "));
                        i = Integer.MIN_VALUE;
                    }
                    eVar.k = i;
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
    public static SpannedString f(@Nullable String str, String str2, List<WebvttCssStyle> list) {
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
                    a(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new c("", 0, "", Collections.emptySet()), Collections.emptyList(), spannableStringBuilder, list);
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
                            outline.i0(strSubstring.length() + 33, "ignoring unsupported entity: '&", strSubstring, ";'", "WebvttCueParser");
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
                        AnimatableValueParser.j(!strTrim2.isEmpty());
                        int i5 = Util2.a;
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
                                    c cVar = (c) arrayDeque.pop();
                                    a(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length(), null));
                                    }
                                    if (cVar.a.equals(str3)) {
                                    }
                                }
                            } else if (!z4) {
                                int length2 = spannableStringBuilder.length();
                                String strTrim3 = strSubstring2.trim();
                                AnimatableValueParser.j(!strTrim3.isEmpty());
                                int iIndexOf4 = strTrim3.indexOf(" ");
                                if (iIndexOf4 != -1) {
                                    strTrim = strTrim3.substring(iIndexOf4).trim();
                                    strTrim3 = strTrim3.substring(i, iIndexOf4);
                                }
                                String[] strArrH = Util2.H(strTrim3, "\\.");
                                String str4 = strArrH[i];
                                HashSet hashSet = new HashSet();
                                for (int i6 = 1; i6 < strArrH.length; i6++) {
                                    hashSet.add(strArrH[i6]);
                                }
                                arrayDeque.push(new c(str4, length2, strTrim, hashSet));
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

    public static void g(String str, e eVar) {
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
            eVar.g = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.e = WebvttParserUtil.a(str);
            eVar.f = 0;
        } else {
            eVar.e = Integer.parseInt(str);
            eVar.f = 1;
        }
    }

    public static void h(String str, e eVar) {
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
            eVar.i = i;
            str = str.substring(0, iIndexOf);
        }
        eVar.h = WebvttParserUtil.a(str);
    }
}
