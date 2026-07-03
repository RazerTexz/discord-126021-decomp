package p007b.p225i.p226a.p242c.p245b3.p254v;

import android.text.TextUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2742i;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.v.i */
/* JADX INFO: compiled from: WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2628i extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public final C2757x f6158n;

    /* JADX INFO: renamed from: o */
    public final C2624e f6159o;

    public C2628i() {
        super("WebvttDecoder");
        this.f6158n = new C2757x();
        this.f6159o = new C2624e();
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0240  */
    /* JADX WARN: Code duplicated, block: B:130:0x024b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0254  */
    /* JADX WARN: Code duplicated, block: B:133:0x025e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0266  */
    /* JADX WARN: Code duplicated, block: B:137:0x026e  */
    /* JADX WARN: Code duplicated, block: B:138:0x0272  */
    /* JADX WARN: Code duplicated, block: B:140:0x027a  */
    /* JADX WARN: Code duplicated, block: B:141:0x027f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0287  */
    /* JADX WARN: Code duplicated, block: B:149:0x029a  */
    /* JADX WARN: Code duplicated, block: B:151:0x029f  */
    /* JADX WARN: Code duplicated, block: B:153:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:155:0x02af  */
    /* JADX WARN: Code duplicated, block: B:156:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:158:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:159:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:161:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:163:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:166:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:168:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:169:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:171:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:173:0x0306  */
    /* JADX WARN: Code duplicated, block: B:174:0x0317  */
    /* JADX WARN: Code duplicated, block: B:176:0x0327  */
    /* JADX WARN: Code duplicated, block: B:178:0x032b  */
    /* JADX WARN: Code duplicated, block: B:185:0x033b  */
    /* JADX WARN: Code duplicated, block: B:188:0x0344  */
    /* JADX WARN: Code duplicated, block: B:189:0x0346  */
    /* JADX WARN: Code duplicated, block: B:191:0x034e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0350  */
    /* JADX WARN: Code duplicated, block: B:194:0x0353  */
    /* JADX WARN: Code duplicated, block: B:196:0x0356  */
    /* JADX WARN: Code duplicated, block: B:198:0x0359  */
    /* JADX WARN: Code duplicated, block: B:201:0x0362  */
    /* JADX WARN: Code duplicated, block: B:202:0x0366  */
    /* JADX WARN: Code duplicated, block: B:204:0x0378  */
    /* JADX WARN: Code duplicated, block: B:227:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:244:0x035c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0110  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        C2626g c2626gM2713d;
        String strSubstring;
        String str;
        C2624e c2624e;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b2;
        int i2;
        boolean z3;
        C2757x c2757x = this.f6158n;
        c2757x.f6793a = bArr;
        c2757x.f6795c = i;
        int i3 = 0;
        c2757x.f6794b = 0;
        ArrayList arrayList = new ArrayList();
        try {
            C2629j.m2721c(this.f6158n);
            while (!TextUtils.isEmpty(this.f6158n.m3087g())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                C2757x c2757x2 = this.f6158n;
                int i4 = -1;
                ?? r7 = 1;
                byte b3 = -1;
                int i5 = 0;
                while (b3 == -1) {
                    i5 = c2757x2.f6794b;
                    String strM3087g = c2757x2.m3087g();
                    if (strM3087g == null) {
                        b3 = 0;
                    } else if ("STYLE".equals(strM3087g)) {
                        b3 = 2;
                    } else {
                        b3 = strM3087g.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                c2757x2.m3079E(i5);
                if (b3 == 0) {
                    return new C2630k(arrayList2);
                }
                if (b3 == 1) {
                    while (!TextUtils.isEmpty(this.f6158n.m3087g())) {
                    }
                } else {
                    if (b3 == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.f6158n.m3087g();
                        C2624e c2624e2 = this.f6159o;
                        C2757x c2757x3 = this.f6158n;
                        c2624e2.f6113d.setLength(i3);
                        int i6 = c2757x3.f6794b;
                        while (!TextUtils.isEmpty(c2757x3.m3087g())) {
                        }
                        c2624e2.f6112c.m3077C(c2757x3.f6793a, c2757x3.f6794b);
                        c2624e2.f6112c.m3079E(i6);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            C2757x c2757x4 = c2624e2.f6112c;
                            StringBuilder sb = c2624e2.f6113d;
                            C2624e.m2707c(c2757x4);
                            if (c2757x4.m3081a() >= 5 && "::cue".equals(c2757x4.m3097q(5))) {
                                int i7 = c2757x4.f6794b;
                                String strM2706b = C2624e.m2706b(c2757x4, sb);
                                if (strM2706b == null) {
                                    strSubstring = null;
                                } else if ("{".equals(strM2706b)) {
                                    c2757x4.m3079E(i7);
                                    strSubstring = "";
                                } else {
                                    if ("(".equals(strM2706b)) {
                                        int i8 = c2757x4.f6794b;
                                        int i9 = c2757x4.f6795c;
                                        boolean z4 = false;
                                        while (i8 < i9 && !z4) {
                                            int i10 = i8 + 1;
                                            z4 = ((char) c2757x4.f6793a[i8]) == ')';
                                            i8 = i10;
                                        }
                                        strSubstring = c2757x4.m3097q((i8 - 1) - c2757x4.f6794b).trim();
                                    } else {
                                        strSubstring = null;
                                    }
                                    if (!")".equals(C2624e.m2706b(c2757x4, sb))) {
                                        strSubstring = null;
                                    }
                                }
                            } else {
                                strSubstring = null;
                            }
                            if (strSubstring == null || !"{".equals(C2624e.m2706b(c2624e2.f6112c, c2624e2.f6113d))) {
                                break;
                            }
                            C2625f c2625f = new C2625f();
                            if (!"".equals(strSubstring)) {
                                int iIndexOf = strSubstring.indexOf(91);
                                if (iIndexOf != i4) {
                                    Matcher matcher2 = C2624e.f6110a.matcher(strSubstring.substring(iIndexOf));
                                    if (matcher2.matches()) {
                                        String strGroup2 = matcher2.group((int) r7);
                                        Objects.requireNonNull(strGroup2);
                                        c2625f.f6117d = strGroup2;
                                    }
                                    strSubstring = strSubstring.substring(i3, iIndexOf);
                                }
                                String[] strArrM2987H = C2738e0.m2987H(strSubstring, "\\.");
                                String str2 = strArrM2987H[i3];
                                int iIndexOf2 = str2.indexOf(35);
                                if (iIndexOf2 != i4) {
                                    c2625f.f6115b = str2.substring(i3, iIndexOf2);
                                    c2625f.f6114a = str2.substring(iIndexOf2 + 1);
                                } else {
                                    c2625f.f6115b = str2;
                                }
                                if (strArrM2987H.length > r7) {
                                    int length = strArrM2987H.length;
                                    C1460d.m531j(r7);
                                    C1460d.m531j(length <= strArrM2987H.length);
                                    c2625f.f6116c = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrM2987H, (int) r7, length)));
                                }
                            }
                            boolean z5 = false;
                            String str3 = null;
                            while (!z5) {
                                C2757x c2757x5 = c2624e2.f6112c;
                                int i11 = c2757x5.f6794b;
                                String strM2706b2 = C2624e.m2706b(c2757x5, c2624e2.f6113d);
                                boolean z6 = strM2706b2 == null || "}".equals(strM2706b2);
                                if (z6) {
                                    str = strM2706b2;
                                    c2624e = c2624e2;
                                } else {
                                    c2624e2.f6112c.m3079E(i11);
                                    C2757x c2757x6 = c2624e2.f6112c;
                                    StringBuilder sb2 = c2624e2.f6113d;
                                    C2624e.m2707c(c2757x6);
                                    String strM2705a = C2624e.m2705a(c2757x6, sb2);
                                    if (!"".equals(strM2705a) && ":".equals(C2624e.m2706b(c2757x6, sb2))) {
                                        C2624e.m2707c(c2757x6);
                                        StringBuilder sb3 = new StringBuilder();
                                        boolean z7 = false;
                                        while (true) {
                                            if (z7) {
                                                str = strM2706b2;
                                                c2624e = c2624e2;
                                                string = sb3.toString();
                                                break;
                                            }
                                            str = strM2706b2;
                                            int i12 = c2757x6.f6794b;
                                            c2624e = c2624e2;
                                            String strM2706b3 = C2624e.m2706b(c2757x6, sb2);
                                            if (strM2706b3 == null) {
                                                string = null;
                                                break;
                                            }
                                            if ("}".equals(strM2706b3) || ";".equals(strM2706b3)) {
                                                c2757x6.m3079E(i12);
                                                z7 = true;
                                            } else {
                                                sb3.append(strM2706b3);
                                            }
                                            strM2706b2 = str;
                                            c2624e2 = c2624e;
                                        }
                                        if (string != null && !"".equals(string)) {
                                            int i13 = c2757x6.f6794b;
                                            String strM2706b4 = C2624e.m2706b(c2757x6, sb2);
                                            if (";".equals(strM2706b4)) {
                                                if (ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strM2705a)) {
                                                    c2625f.f6119f = C2742i.m3024a(string, true);
                                                    c2625f.f6120g = true;
                                                } else if ("background-color".equals(strM2705a)) {
                                                    c2625f.f6121h = C2742i.m3024a(string, true);
                                                    c2625f.f6122i = true;
                                                } else if ("ruby-position".equals(strM2705a)) {
                                                    if ("over".equals(string)) {
                                                        c2625f.f6129p = 1;
                                                    } else if ("under".equals(string)) {
                                                        c2625f.f6129p = 2;
                                                    }
                                                } else if ("text-combine-upright".equals(strM2705a)) {
                                                    if ("all".equals(string)) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    c2625f.f6130q = z3;
                                                } else if ("text-decoration".equals(strM2705a)) {
                                                    if ("underline".equals(string)) {
                                                        c2625f.f6124k = 1;
                                                    }
                                                } else if ("font-family".equals(strM2705a)) {
                                                    c2625f.f6118e = C3404f.m4349u1(string);
                                                } else if ("font-weight".equals(strM2705a)) {
                                                    if ("bold".equals(string)) {
                                                        c2625f.f6125l = 1;
                                                    }
                                                } else if ("font-style".equals(strM2705a)) {
                                                    if ("italic".equals(string)) {
                                                        c2625f.f6126m = 1;
                                                    }
                                                } else if ("font-size".equals(strM2705a)) {
                                                    matcher = C2624e.f6111b.matcher(C3404f.m4349u1(string));
                                                    if (matcher.matches()) {
                                                        strGroup = matcher.group(2);
                                                        Objects.requireNonNull(strGroup);
                                                        iHashCode = strGroup.hashCode();
                                                        if (iHashCode != 37) {
                                                            if (iHashCode != 3240) {
                                                                if (iHashCode != 3592) {
                                                                    b2 = -1;
                                                                } else {
                                                                    b2 = 2;
                                                                }
                                                            } else if (strGroup.equals("em")) {
                                                                b2 = 1;
                                                            } else {
                                                                b2 = -1;
                                                            }
                                                        } else if (strGroup.equals("%")) {
                                                            b2 = 0;
                                                        } else {
                                                            b2 = -1;
                                                        }
                                                        if (b2 != 0) {
                                                            i2 = 1;
                                                            if (b2 != 1) {
                                                                c2625f.f6127n = 2;
                                                            } else {
                                                                if (b2 == 2) {
                                                                    throw new IllegalStateException();
                                                                }
                                                                c2625f.f6127n = 1;
                                                            }
                                                        } else {
                                                            i2 = 1;
                                                            c2625f.f6127n = 3;
                                                        }
                                                        String strGroup3 = matcher.group(i2);
                                                        Objects.requireNonNull(strGroup3);
                                                        c2625f.f6128o = Float.parseFloat(strGroup3);
                                                    } else {
                                                        C1643a.m856i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else if ("}".equals(strM2706b4)) {
                                                c2757x6.m3079E(i13);
                                                if (ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strM2705a)) {
                                                    c2625f.f6119f = C2742i.m3024a(string, true);
                                                    c2625f.f6120g = true;
                                                } else if ("background-color".equals(strM2705a)) {
                                                    c2625f.f6121h = C2742i.m3024a(string, true);
                                                    c2625f.f6122i = true;
                                                } else if ("ruby-position".equals(strM2705a)) {
                                                    if ("over".equals(string)) {
                                                        c2625f.f6129p = 1;
                                                    } else if ("under".equals(string)) {
                                                        c2625f.f6129p = 2;
                                                    }
                                                } else if ("text-combine-upright".equals(strM2705a)) {
                                                    if ("all".equals(string) || string.startsWith("digits")) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    c2625f.f6130q = z3;
                                                } else if ("text-decoration".equals(strM2705a)) {
                                                    if ("underline".equals(string)) {
                                                        c2625f.f6124k = 1;
                                                    }
                                                } else if ("font-family".equals(strM2705a)) {
                                                    c2625f.f6118e = C3404f.m4349u1(string);
                                                } else if ("font-weight".equals(strM2705a)) {
                                                    if ("bold".equals(string)) {
                                                        c2625f.f6125l = 1;
                                                    }
                                                } else if ("font-style".equals(strM2705a)) {
                                                    if ("italic".equals(string)) {
                                                        c2625f.f6126m = 1;
                                                    }
                                                } else if ("font-size".equals(strM2705a)) {
                                                    matcher = C2624e.f6111b.matcher(C3404f.m4349u1(string));
                                                    if (matcher.matches()) {
                                                        C1643a.m856i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                    } else {
                                                        strGroup = matcher.group(2);
                                                        Objects.requireNonNull(strGroup);
                                                        iHashCode = strGroup.hashCode();
                                                        if (iHashCode != 37) {
                                                            if (iHashCode != 3240) {
                                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                                    b2 = 2;
                                                                } else {
                                                                    b2 = -1;
                                                                }
                                                            } else if (strGroup.equals("em")) {
                                                                b2 = -1;
                                                            } else {
                                                                b2 = 1;
                                                            }
                                                        } else if (strGroup.equals("%")) {
                                                            b2 = -1;
                                                        } else {
                                                            b2 = 0;
                                                        }
                                                        if (b2 != 0) {
                                                            i2 = 1;
                                                            if (b2 != 1) {
                                                                c2625f.f6127n = 2;
                                                            } else {
                                                                if (b2 == 2) {
                                                                    throw new IllegalStateException();
                                                                }
                                                                c2625f.f6127n = 1;
                                                            }
                                                        } else {
                                                            i2 = 1;
                                                            c2625f.f6127n = 3;
                                                        }
                                                        String strGroup4 = matcher.group(i2);
                                                        Objects.requireNonNull(strGroup4);
                                                        c2625f.f6128o = Float.parseFloat(strGroup4);
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else {
                                        str = strM2706b2;
                                        c2624e = c2624e2;
                                    }
                                }
                                str3 = str;
                                c2624e2 = c2624e;
                                z5 = z6;
                            }
                            C2624e c2624e3 = c2624e2;
                            if ("}".equals(str3)) {
                                arrayList3.add(c2625f);
                            }
                            i3 = 0;
                            i4 = -1;
                            r7 = 1;
                            c2624e2 = c2624e3;
                        }
                        arrayList.addAll(arrayList3);
                    } else if (b3 == 3) {
                        C2757x c2757x7 = this.f6158n;
                        Pattern pattern = C2627h.f6134a;
                        String strM3087g2 = c2757x7.m3087g();
                        if (strM3087g2 == null) {
                            c2626gM2713d = null;
                        } else {
                            Pattern pattern2 = C2627h.f6134a;
                            Matcher matcher3 = pattern2.matcher(strM3087g2);
                            if (matcher3.matches()) {
                                c2626gM2713d = C2627h.m2713d(null, matcher3, c2757x7, arrayList);
                            } else {
                                String strM3087g3 = c2757x7.m3087g();
                                if (strM3087g3 == null) {
                                    c2626gM2713d = null;
                                } else {
                                    Matcher matcher4 = pattern2.matcher(strM3087g3);
                                    if (matcher4.matches()) {
                                        c2626gM2713d = C2627h.m2713d(strM3087g2.trim(), matcher4, c2757x7, arrayList);
                                    } else {
                                        c2626gM2713d = null;
                                    }
                                }
                            }
                        }
                        if (c2626gM2713d != null) {
                            arrayList2.add(c2626gM2713d);
                        }
                    }
                    i3 = 0;
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
