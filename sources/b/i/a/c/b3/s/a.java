package b.i.a.c.b3.s;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.f;
import b.i.a.c.b3.g;
import b.i.a.c.f3.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SubripDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public static final Pattern n = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final Pattern o = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder p;
    public final ArrayList<String> q;

    public a() {
        super("SubripDecoder");
        this.p = new StringBuilder();
        this.q = new ArrayList<>();
    }

    public static float k(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long l(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        Objects.requireNonNull(strGroup2);
        long j2 = (Long.parseLong(strGroup2) * 60 * 1000) + j;
        String strGroup3 = matcher.group(i + 3);
        Objects.requireNonNull(strGroup3);
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:101:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:113:0x0200  */
    /* JADX WARN: Code duplicated, block: B:115:0x0206  */
    /* JADX WARN: Code duplicated, block: B:116:0x0208  */
    /* JADX WARN: Code duplicated, block: B:129:0x021f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0102  */
    /* JADX WARN: Code duplicated, block: B:41:0x0128  */
    /* JADX WARN: Code duplicated, block: B:44:0x0156  */
    /* JADX WARN: Code duplicated, block: B:46:0x015c  */
    /* JADX WARN: Code duplicated, block: B:47:0x015e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0164  */
    /* JADX WARN: Code duplicated, block: B:50:0x0167  */
    /* JADX WARN: Code duplicated, block: B:52:0x016d  */
    /* JADX WARN: Code duplicated, block: B:53:0x016f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0175  */
    /* JADX WARN: Code duplicated, block: B:56:0x0177  */
    /* JADX WARN: Code duplicated, block: B:58:0x017d  */
    /* JADX WARN: Code duplicated, block: B:59:0x017f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0185  */
    /* JADX WARN: Code duplicated, block: B:62:0x0187  */
    /* JADX WARN: Code duplicated, block: B:64:0x018d  */
    /* JADX WARN: Code duplicated, block: B:65:0x018f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0195  */
    /* JADX WARN: Code duplicated, block: B:68:0x0197  */
    /* JADX WARN: Code duplicated, block: B:70:0x019d  */
    /* JADX WARN: Code duplicated, block: B:71:0x019f  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:89:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:94:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:95:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d7  */
    @Override // b.i.a.c.b3.f
    public g j(byte[] bArr, int i, boolean z2) {
        byte b2;
        int i2;
        byte b3;
        int i3;
        b.i.a.c.b3.b bVar;
        this = this;
        ArrayList arrayList = new ArrayList();
        long[] jArrCopyOf = new long[32];
        x xVar = new x(bArr, i);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String strG = xVar.g();
            if (strG != null) {
                if (strG.length() != 0) {
                    try {
                        Integer.parseInt(strG);
                        String strG2 = xVar.g();
                        if (strG2 == null) {
                            Log.w("SubripDecoder", "Unexpected end");
                        } else {
                            Matcher matcher = n.matcher(strG2);
                            if (matcher.matches()) {
                                long jL = l(matcher, 1);
                                if (i5 == jArrCopyOf.length) {
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i5 * 2);
                                }
                                int i6 = i5 + 1;
                                jArrCopyOf[i5] = jL;
                                long jL2 = l(matcher, 6);
                                if (i6 == jArrCopyOf.length) {
                                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i6 * 2);
                                }
                                int i7 = i6 + 1;
                                jArrCopyOf[i6] = jL2;
                                this.p.setLength(i4);
                                this.q.clear();
                                for (String strG3 = xVar.g(); !TextUtils.isEmpty(strG3); strG3 = xVar.g()) {
                                    if (this.p.length() > 0) {
                                        this.p.append("<br>");
                                    }
                                    StringBuilder sb = this.p;
                                    ArrayList<String> arrayList2 = this.q;
                                    String strTrim = strG3.trim();
                                    StringBuilder sb2 = new StringBuilder(strTrim);
                                    Matcher matcher2 = o.matcher(strTrim);
                                    int i8 = 0;
                                    while (matcher2.find()) {
                                        String strGroup = matcher2.group();
                                        arrayList2.add(strGroup);
                                        int iStart = matcher2.start() - i8;
                                        int length = strGroup.length();
                                        sb2.replace(iStart, iStart + length, "");
                                        i8 += length;
                                    }
                                    sb.append(sb2.toString());
                                }
                                Spanned spannedFromHtml = Html.fromHtml(this.p.toString());
                                String str = null;
                                for (int i9 = 0; i9 < this.q.size(); i9++) {
                                    String str2 = this.q.get(i9);
                                    if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                        str = str2;
                                        if (str == null) {
                                            bVar = new b.i.a.c.b3.b(spannedFromHtml, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                        } else {
                                            switch (str) {
                                                case "{\an1}":
                                                    b2 = 0;
                                                    break;
                                                case "{\an2}":
                                                    b2 = 6;
                                                    break;
                                                case "{\an3}":
                                                    b2 = 3;
                                                    break;
                                                case "{\an4}":
                                                    b2 = 1;
                                                    break;
                                                case "{\an5}":
                                                    b2 = 7;
                                                    break;
                                                case "{\an6}":
                                                    b2 = 4;
                                                    break;
                                                case "{\an7}":
                                                    b2 = 2;
                                                    break;
                                                case "{\an8}":
                                                    b2 = 8;
                                                    break;
                                                case "{\an9}":
                                                    b2 = 5;
                                                    break;
                                                default:
                                                    b2 = -1;
                                                    break;
                                            }
                                            if (b2 != 0 || b2 == 1 || b2 == 2) {
                                                i2 = 0;
                                            } else {
                                                i2 = (b2 == 3 || b2 == 4 || b2 == 5) ? 2 : 1;
                                            }
                                            switch (str) {
                                                case "{\an1}":
                                                    b3 = 0;
                                                    break;
                                                case "{\an2}":
                                                    b3 = 1;
                                                    break;
                                                case "{\an3}":
                                                    b3 = 2;
                                                    break;
                                                case "{\an4}":
                                                    b3 = 6;
                                                    break;
                                                case "{\an5}":
                                                    b3 = 7;
                                                    break;
                                                case "{\an6}":
                                                    b3 = 8;
                                                    break;
                                                case "{\an7}":
                                                    b3 = 3;
                                                    break;
                                                case "{\an8}":
                                                    b3 = 4;
                                                    break;
                                                case "{\an9}":
                                                    b3 = 5;
                                                    break;
                                                default:
                                                    b3 = -1;
                                                    break;
                                            }
                                            if (b3 != 0 || b3 == 1 || b3 == 2) {
                                                i3 = 2;
                                            } else {
                                                i3 = (b3 == 3 || b3 == 4 || b3 == 5) ? 0 : 1;
                                            }
                                            bVar = new b.i.a.c.b3.b(spannedFromHtml, null, null, null, k(i3), 0, i3, k(i2), i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                        }
                                        arrayList.add(bVar);
                                        arrayList.add(b.i.a.c.b3.b.j);
                                        jArrCopyOf = jArrCopyOf;
                                        i5 = i7;
                                    }
                                }
                                if (str == null) {
                                    bVar = new b.i.a.c.b3.b(spannedFromHtml, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                } else {
                                    switch (str) {
                                        case -685620710:
                                            if (!str.equals("{\\an1}")) {
                                                b2 = 0;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620679:
                                            if (!str.equals("{\\an2}")) {
                                                b2 = 6;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620648:
                                            if (!str.equals("{\\an3}")) {
                                                b2 = 3;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620617:
                                            if (!str.equals("{\\an4}")) {
                                                b2 = 1;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620586:
                                            if (!str.equals("{\\an5}")) {
                                                b2 = 7;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620555:
                                            if (!str.equals("{\\an6}")) {
                                                b2 = 4;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620524:
                                            if (!str.equals("{\\an7}")) {
                                                b2 = 2;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620493:
                                            if (!str.equals("{\\an8}")) {
                                                b2 = 8;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        case -685620462:
                                            if (!str.equals("{\\an9}")) {
                                                b2 = 5;
                                            } else {
                                                b2 = -1;
                                            }
                                            break;
                                        default:
                                            b2 = -1;
                                            break;
                                    }
                                    if (b2 != 0) {
                                        i2 = 0;
                                    } else {
                                        i2 = 0;
                                    }
                                    switch (str) {
                                        case -685620710:
                                            if (!str.equals("{\\an1}")) {
                                                b3 = 0;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620679:
                                            if (!str.equals("{\\an2}")) {
                                                b3 = 1;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620648:
                                            if (!str.equals("{\\an3}")) {
                                                b3 = 2;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620617:
                                            if (!str.equals("{\\an4}")) {
                                                b3 = 6;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620586:
                                            if (!str.equals("{\\an5}")) {
                                                b3 = 7;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620555:
                                            if (!str.equals("{\\an6}")) {
                                                b3 = 8;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620524:
                                            if (!str.equals("{\\an7}")) {
                                                b3 = 3;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620493:
                                            if (!str.equals("{\\an8}")) {
                                                b3 = 4;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -685620462:
                                            if (!str.equals("{\\an9}")) {
                                                b3 = 5;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        default:
                                            b3 = -1;
                                            break;
                                    }
                                    if (b3 != 0) {
                                        i3 = 2;
                                    } else {
                                        i3 = 2;
                                    }
                                    bVar = new b.i.a.c.b3.b(spannedFromHtml, null, null, null, k(i3), 0, i3, k(i2), i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                }
                                arrayList.add(bVar);
                                arrayList.add(b.i.a.c.b3.b.j);
                                jArrCopyOf = jArrCopyOf;
                                i5 = i7;
                            } else {
                                Log.w("SubripDecoder", strG2.length() != 0 ? "Skipping invalid timing: ".concat(strG2) : new String("Skipping invalid timing: "));
                            }
                            i4 = 0;
                        }
                    } catch (NumberFormatException unused) {
                        Log.w("SubripDecoder", strG.length() != 0 ? "Skipping invalid index: ".concat(strG) : new String("Skipping invalid index: "));
                    }
                }
            }
        }
        return new b((b.i.a.c.b3.b[]) arrayList.toArray(new b.i.a.c.b3.b[0]), Arrays.copyOf(jArrCopyOf, i5));
    }
}
