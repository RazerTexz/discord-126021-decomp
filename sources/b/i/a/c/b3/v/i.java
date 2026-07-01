package b.i.a.c.b3.v;

import android.text.TextUtils;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends b.i.a.c.b3.f {
    public final x n;
    public final e o;

    public i() {
        super("WebvttDecoder");
        this.n = new x();
        this.o = new e();
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
    @Override // b.i.a.c.b3.f
    public b.i.a.c.b3.g j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        g gVarD;
        String strSubstring;
        String str;
        e eVar;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b2;
        int i2;
        boolean z3;
        x xVar = this.n;
        xVar.a = bArr;
        xVar.c = i;
        int i3 = 0;
        xVar.f984b = 0;
        ArrayList arrayList = new ArrayList();
        try {
            j.c(this.n);
            while (!TextUtils.isEmpty(this.n.g())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                x xVar2 = this.n;
                int i4 = -1;
                ?? r7 = 1;
                byte b3 = -1;
                int i5 = 0;
                while (b3 == -1) {
                    i5 = xVar2.f984b;
                    String strG = xVar2.g();
                    if (strG == null) {
                        b3 = 0;
                    } else if ("STYLE".equals(strG)) {
                        b3 = 2;
                    } else {
                        b3 = strG.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                xVar2.E(i5);
                if (b3 == 0) {
                    return new k(arrayList2);
                }
                if (b3 == 1) {
                    while (!TextUtils.isEmpty(this.n.g())) {
                    }
                } else {
                    if (b3 == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.n.g();
                        e eVar2 = this.o;
                        x xVar3 = this.n;
                        eVar2.d.setLength(i3);
                        int i6 = xVar3.f984b;
                        while (!TextUtils.isEmpty(xVar3.g())) {
                        }
                        eVar2.c.C(xVar3.a, xVar3.f984b);
                        eVar2.c.E(i6);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            x xVar4 = eVar2.c;
                            StringBuilder sb = eVar2.d;
                            e.c(xVar4);
                            if (xVar4.a() >= 5 && "::cue".equals(xVar4.q(5))) {
                                int i7 = xVar4.f984b;
                                String strB = e.b(xVar4, sb);
                                if (strB == null) {
                                    strSubstring = null;
                                } else if ("{".equals(strB)) {
                                    xVar4.E(i7);
                                    strSubstring = "";
                                } else {
                                    if ("(".equals(strB)) {
                                        int i8 = xVar4.f984b;
                                        int i9 = xVar4.c;
                                        boolean z4 = false;
                                        while (i8 < i9 && !z4) {
                                            int i10 = i8 + 1;
                                            z4 = ((char) xVar4.a[i8]) == ')';
                                            i8 = i10;
                                        }
                                        strSubstring = xVar4.q((i8 - 1) - xVar4.f984b).trim();
                                    } else {
                                        strSubstring = null;
                                    }
                                    if (!")".equals(e.b(xVar4, sb))) {
                                        strSubstring = null;
                                    }
                                }
                            } else {
                                strSubstring = null;
                            }
                            if (strSubstring == null || !"{".equals(e.b(eVar2.c, eVar2.d))) {
                                break;
                            }
                            f fVar = new f();
                            if (!"".equals(strSubstring)) {
                                int iIndexOf = strSubstring.indexOf(91);
                                if (iIndexOf != i4) {
                                    Matcher matcher2 = e.a.matcher(strSubstring.substring(iIndexOf));
                                    if (matcher2.matches()) {
                                        String strGroup2 = matcher2.group((int) r7);
                                        Objects.requireNonNull(strGroup2);
                                        fVar.d = strGroup2;
                                    }
                                    strSubstring = strSubstring.substring(i3, iIndexOf);
                                }
                                String[] strArrH = e0.H(strSubstring, "\\.");
                                String str2 = strArrH[i3];
                                int iIndexOf2 = str2.indexOf(35);
                                if (iIndexOf2 != i4) {
                                    fVar.f889b = str2.substring(i3, iIndexOf2);
                                    fVar.a = str2.substring(iIndexOf2 + 1);
                                } else {
                                    fVar.f889b = str2;
                                }
                                if (strArrH.length > r7) {
                                    int length = strArrH.length;
                                    b.c.a.a0.d.j(r7);
                                    b.c.a.a0.d.j(length <= strArrH.length);
                                    fVar.c = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrH, (int) r7, length)));
                                }
                            }
                            boolean z5 = false;
                            String str3 = null;
                            while (!z5) {
                                x xVar5 = eVar2.c;
                                int i11 = xVar5.f984b;
                                String strB2 = e.b(xVar5, eVar2.d);
                                boolean z6 = strB2 == null || "}".equals(strB2);
                                if (z6) {
                                    str = strB2;
                                    eVar = eVar2;
                                } else {
                                    eVar2.c.E(i11);
                                    x xVar6 = eVar2.c;
                                    StringBuilder sb2 = eVar2.d;
                                    e.c(xVar6);
                                    String strA = e.a(xVar6, sb2);
                                    if (!"".equals(strA) && ":".equals(e.b(xVar6, sb2))) {
                                        e.c(xVar6);
                                        StringBuilder sb3 = new StringBuilder();
                                        boolean z7 = false;
                                        while (true) {
                                            if (z7) {
                                                str = strB2;
                                                eVar = eVar2;
                                                string = sb3.toString();
                                                break;
                                            }
                                            str = strB2;
                                            int i12 = xVar6.f984b;
                                            eVar = eVar2;
                                            String strB3 = e.b(xVar6, sb2);
                                            if (strB3 == null) {
                                                string = null;
                                                break;
                                            }
                                            if ("}".equals(strB3) || ";".equals(strB3)) {
                                                xVar6.E(i12);
                                                z7 = true;
                                            } else {
                                                sb3.append(strB3);
                                            }
                                            strB2 = str;
                                            eVar2 = eVar;
                                        }
                                        if (string != null && !"".equals(string)) {
                                            int i13 = xVar6.f984b;
                                            String strB4 = e.b(xVar6, sb2);
                                            if (";".equals(strB4)) {
                                                if (ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                    fVar.f = b.i.a.c.f3.i.a(string, true);
                                                    fVar.g = true;
                                                } else if ("background-color".equals(strA)) {
                                                    fVar.h = b.i.a.c.f3.i.a(string, true);
                                                    fVar.i = true;
                                                } else if ("ruby-position".equals(strA)) {
                                                    if ("over".equals(string)) {
                                                        fVar.p = 1;
                                                    } else if ("under".equals(string)) {
                                                        fVar.p = 2;
                                                    }
                                                } else if ("text-combine-upright".equals(strA)) {
                                                    if ("all".equals(string)) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    fVar.q = z3;
                                                } else if ("text-decoration".equals(strA)) {
                                                    if ("underline".equals(string)) {
                                                        fVar.k = 1;
                                                    }
                                                } else if ("font-family".equals(strA)) {
                                                    fVar.e = b.i.a.f.e.o.f.u1(string);
                                                } else if ("font-weight".equals(strA)) {
                                                    if ("bold".equals(string)) {
                                                        fVar.l = 1;
                                                    }
                                                } else if ("font-style".equals(strA)) {
                                                    if ("italic".equals(string)) {
                                                        fVar.m = 1;
                                                    }
                                                } else if ("font-size".equals(strA)) {
                                                    matcher = e.f888b.matcher(b.i.a.f.e.o.f.u1(string));
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
                                                                fVar.n = 2;
                                                            } else {
                                                                if (b2 == 2) {
                                                                    throw new IllegalStateException();
                                                                }
                                                                fVar.n = 1;
                                                            }
                                                        } else {
                                                            i2 = 1;
                                                            fVar.n = 3;
                                                        }
                                                        String strGroup3 = matcher.group(i2);
                                                        Objects.requireNonNull(strGroup3);
                                                        fVar.o = Float.parseFloat(strGroup3);
                                                    } else {
                                                        b.d.b.a.a.i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else if ("}".equals(strB4)) {
                                                xVar6.E(i13);
                                                if (ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                    fVar.f = b.i.a.c.f3.i.a(string, true);
                                                    fVar.g = true;
                                                } else if ("background-color".equals(strA)) {
                                                    fVar.h = b.i.a.c.f3.i.a(string, true);
                                                    fVar.i = true;
                                                } else if ("ruby-position".equals(strA)) {
                                                    if ("over".equals(string)) {
                                                        fVar.p = 1;
                                                    } else if ("under".equals(string)) {
                                                        fVar.p = 2;
                                                    }
                                                } else if ("text-combine-upright".equals(strA)) {
                                                    if ("all".equals(string) || string.startsWith("digits")) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    fVar.q = z3;
                                                } else if ("text-decoration".equals(strA)) {
                                                    if ("underline".equals(string)) {
                                                        fVar.k = 1;
                                                    }
                                                } else if ("font-family".equals(strA)) {
                                                    fVar.e = b.i.a.f.e.o.f.u1(string);
                                                } else if ("font-weight".equals(strA)) {
                                                    if ("bold".equals(string)) {
                                                        fVar.l = 1;
                                                    }
                                                } else if ("font-style".equals(strA)) {
                                                    if ("italic".equals(string)) {
                                                        fVar.m = 1;
                                                    }
                                                } else if ("font-size".equals(strA)) {
                                                    matcher = e.f888b.matcher(b.i.a.f.e.o.f.u1(string));
                                                    if (matcher.matches()) {
                                                        b.d.b.a.a.i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
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
                                                                fVar.n = 2;
                                                            } else {
                                                                if (b2 == 2) {
                                                                    throw new IllegalStateException();
                                                                }
                                                                fVar.n = 1;
                                                            }
                                                        } else {
                                                            i2 = 1;
                                                            fVar.n = 3;
                                                        }
                                                        String strGroup4 = matcher.group(i2);
                                                        Objects.requireNonNull(strGroup4);
                                                        fVar.o = Float.parseFloat(strGroup4);
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else {
                                        str = strB2;
                                        eVar = eVar2;
                                    }
                                }
                                str3 = str;
                                eVar2 = eVar;
                                z5 = z6;
                            }
                            e eVar3 = eVar2;
                            if ("}".equals(str3)) {
                                arrayList3.add(fVar);
                            }
                            i3 = 0;
                            i4 = -1;
                            r7 = 1;
                            eVar2 = eVar3;
                        }
                        arrayList.addAll(arrayList3);
                    } else if (b3 == 3) {
                        x xVar7 = this.n;
                        Pattern pattern = h.a;
                        String strG2 = xVar7.g();
                        if (strG2 == null) {
                            gVarD = null;
                        } else {
                            Pattern pattern2 = h.a;
                            Matcher matcher3 = pattern2.matcher(strG2);
                            if (matcher3.matches()) {
                                gVarD = h.d(null, matcher3, xVar7, arrayList);
                            } else {
                                String strG3 = xVar7.g();
                                if (strG3 == null) {
                                    gVarD = null;
                                } else {
                                    Matcher matcher4 = pattern2.matcher(strG3);
                                    if (matcher4.matches()) {
                                        gVarD = h.d(strG2.trim(), matcher4, xVar7, arrayList);
                                    } else {
                                        gVarD = null;
                                    }
                                }
                            }
                        }
                        if (gVarD != null) {
                            arrayList2.add(gVarD);
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
