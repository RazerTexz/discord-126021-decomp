package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2742i;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4524p0;
import p007b.p225i.p355b.p357b.AbstractC4527r;
import p007b.p225i.p355b.p357b.C4507h;
import p007b.p225i.p355b.p357b.C4520n0;

/* JADX INFO: renamed from: b.i.a.c.b3.t.c */
/* JADX INFO: compiled from: TtmlDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2613c extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public static final Pattern f6034n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: o */
    public static final Pattern f6035o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: p */
    public static final Pattern f6036p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: q */
    public static final Pattern f6037q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: r */
    public static final Pattern f6038r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: s */
    public static final Pattern f6039s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: t */
    public static final Pattern f6040t = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: u */
    public static final b f6041u = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: v */
    public static final a f6042v = new a(32, 15);

    /* JADX INFO: renamed from: w */
    public final XmlPullParserFactory f6043w;

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$a */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f6044a;

        public a(int i, int i2) {
            this.f6044a = i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$b */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final float f6045a;

        /* JADX INFO: renamed from: b */
        public final int f6046b;

        /* JADX INFO: renamed from: c */
        public final int f6047c;

        public b(float f, int i, int i2) {
            this.f6045a = f;
            this.f6046b = i;
            this.f6047c = i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$c */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f6048a;

        /* JADX INFO: renamed from: b */
        public final int f6049b;

        public c(int i, int i2) {
            this.f6048a = i;
            this.f6049b = i2;
        }
    }

    public C2613c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f6043w = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX INFO: renamed from: k */
    public static C2616f m2679k(@Nullable C2616f c2616f) {
        return c2616f == null ? new C2616f() : c2616f;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m2680l(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public static Layout.Alignment m2681m(String str) {
        String strM4349u1 = C3404f.m4349u1(str);
        strM4349u1.hashCode();
        switch (strM4349u1) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: n */
    public static a m2682n(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f6040t.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            int i2 = Integer.parseInt(strGroup2);
            if (i != 0 && i2 != 0) {
                return new a(i, i2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(i);
            sb.append(" ");
            sb.append(i2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    /* JADX INFO: renamed from: o */
    public static void m2683o(String str, C2616f c2616f) throws SubtitleDecoderException {
        Matcher matcher;
        int i = C2738e0.f6708a;
        String[] strArrSplit = str.split("\\s+", -1);
        if (strArrSplit.length == 1) {
            matcher = f6036p.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                int length = strArrSplit.length;
                StringBuilder sb = new StringBuilder(52);
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(length);
                sb.append(".");
                throw new SubtitleDecoderException(sb.toString());
            }
            matcher = f6036p.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(C1643a.m859k(str.length() + 36, "Invalid expression for fontSize: '", str, "'."));
        }
        String strGroup = matcher.group(3);
        Objects.requireNonNull(strGroup);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                c2616f.f6082j = 3;
                break;
            case "em":
                c2616f.f6082j = 2;
                break;
            case "px":
                c2616f.f6082j = 1;
                break;
            default:
                throw new SubtitleDecoderException(C1643a.m859k(strGroup.length() + 30, "Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        Objects.requireNonNull(strGroup2);
        c2616f.f6083k = Float.parseFloat(strGroup2);
    }

    /* JADX INFO: renamed from: p */
    public static b m2684p(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i2 = C2738e0.f6708a;
            String[] strArrSplit = attributeValue2.split(" ", -1);
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        }
        b bVar = f6041u;
        int i3 = bVar.f6046b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.f6047c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i3, i4);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x021d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0225  */
    /* JADX WARN: Code duplicated, block: B:108:0x022a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0233  */
    /* JADX WARN: Code duplicated, block: B:140:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x0131  */
    /* JADX WARN: Code duplicated, block: B:53:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0139  */
    /* JADX WARN: Code duplicated, block: B:56:0x013f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0144  */
    /* JADX WARN: Code duplicated, block: B:63:0x0178  */
    /* JADX WARN: Code duplicated, block: B:65:0x0187  */
    /* JADX WARN: Code duplicated, block: B:68:0x0190  */
    /* JADX WARN: Code duplicated, block: B:69:0x0194  */
    /* JADX WARN: Code duplicated, block: B:70:0x019c  */
    /* JADX WARN: Code duplicated, block: B:73:0x01af  */
    /* JADX WARN: Code duplicated, block: B:75:0x01be  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:88:0x01df  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f7  */
    /* JADX INFO: renamed from: q */
    public static Map<String, C2616f> m2685q(XmlPullParser xmlPullParser, Map<String, C2616f> map, a aVar, @Nullable c cVar, Map<String, C2615e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        String strM564r0;
        C2615e c2615e;
        float f;
        float f2;
        String strM564r1;
        Matcher matcher;
        Matcher matcher2;
        float f3;
        float f4;
        String strM564r2;
        float f5;
        int i;
        String strM564r3;
        int i2;
        String strM4349u1;
        int iHashCode;
        byte b2;
        String strM4349u2;
        String str;
        String str2;
        do {
            xmlPullParser.next();
            if (C1460d.m490Y0(xmlPullParser, "style")) {
                String strM564r4 = C1460d.m564r0(xmlPullParser, "style");
                C2616f c2616fM2687s = m2687s(xmlPullParser, new C2616f());
                if (strM564r4 != null) {
                    for (String str3 : m2688t(strM564r4)) {
                        c2616fM2687s.m2701a(map.get(str3));
                    }
                }
                String str4 = c2616fM2687s.f6084l;
                if (str4 != null) {
                    map.put(str4, c2616fM2687s);
                }
            } else if (C1460d.m490Y0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                String strM564r5 = C1460d.m564r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID);
                if (strM564r5 != null) {
                    String strM564r6 = C1460d.m564r0(xmlPullParser, "origin");
                    if (strM564r6 != null) {
                        Pattern pattern = f6038r;
                        Matcher matcher3 = pattern.matcher(strM564r6);
                        Pattern pattern2 = f6039s;
                        Matcher matcher4 = pattern2.matcher(strM564r6);
                        if (matcher3.matches()) {
                            try {
                                String strGroup = matcher3.group(1);
                                Objects.requireNonNull(strGroup);
                                f = Float.parseFloat(strGroup) / 100.0f;
                                String strGroup2 = matcher3.group(2);
                                Objects.requireNonNull(strGroup2);
                                f2 = Float.parseFloat(strGroup2) / 100.0f;
                                strM564r1 = C1460d.m564r0(xmlPullParser, "extent");
                                if (strM564r1 != null) {
                                    matcher = pattern.matcher(strM564r1);
                                    matcher2 = pattern2.matcher(strM564r1);
                                    if (matcher.matches()) {
                                        try {
                                            String strGroup3 = matcher.group(1);
                                            Objects.requireNonNull(strGroup3);
                                            float f6 = Float.parseFloat(strGroup3) / 100.0f;
                                            String strGroup4 = matcher.group(2);
                                            Objects.requireNonNull(strGroup4);
                                            f3 = Float.parseFloat(strGroup4) / 100.0f;
                                            f4 = f6;
                                        } catch (NumberFormatException unused) {
                                            Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with malformed extent: ".concat(strM564r6) : new String("Ignoring region with malformed extent: "));
                                            c2615e = null;
                                        }
                                    } else if (matcher2.matches()) {
                                        if (strM564r6.length() != 0) {
                                            str = "Ignoring region with unsupported extent: ".concat(strM564r6);
                                        } else {
                                            str = new String("Ignoring region with unsupported extent: ");
                                        }
                                        Log.w("TtmlDecoder", str);
                                    } else if (cVar == null) {
                                        if (strM564r6.length() != 0) {
                                            str2 = "Ignoring region with missing tts:extent: ".concat(strM564r6);
                                        } else {
                                            str2 = new String("Ignoring region with missing tts:extent: ");
                                        }
                                        Log.w("TtmlDecoder", str2);
                                    } else {
                                        try {
                                            String strGroup5 = matcher2.group(1);
                                            Objects.requireNonNull(strGroup5);
                                            int i3 = Integer.parseInt(strGroup5);
                                            String strGroup6 = matcher2.group(2);
                                            Objects.requireNonNull(strGroup6);
                                            float f7 = Integer.parseInt(strGroup6);
                                            f4 = i3 / cVar.f6048a;
                                            f3 = f7 / cVar.f6049b;
                                        } catch (NumberFormatException unused2) {
                                            Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with malformed extent: ".concat(strM564r6) : new String("Ignoring region with malformed extent: "));
                                            c2615e = null;
                                        }
                                    }
                                    strM564r2 = C1460d.m564r0(xmlPullParser, "displayAlign");
                                    if (strM564r2 != null) {
                                        strM4349u2 = C3404f.m4349u1(strM564r2);
                                        strM4349u2.hashCode();
                                        if (!strM4349u2.equals("center")) {
                                            f5 = (f3 / 2.0f) + f2;
                                            i = 1;
                                        } else if (strM4349u2.equals("after")) {
                                            f5 = f2 + f3;
                                            i = 2;
                                        } else {
                                            f5 = f2;
                                            i = 0;
                                        }
                                    } else {
                                        f5 = f2;
                                        i = 0;
                                    }
                                    float f8 = 1.0f / aVar.f6044a;
                                    strM564r3 = C1460d.m564r0(xmlPullParser, "writingMode");
                                    if (strM564r3 != null) {
                                        strM4349u1 = C3404f.m4349u1(strM564r3);
                                        strM4349u1.hashCode();
                                        iHashCode = strM4349u1.hashCode();
                                        if (iHashCode != 3694) {
                                            if (iHashCode != 3553396) {
                                                if (iHashCode != 3553576 && strM4349u1.equals("tbrl")) {
                                                    b2 = 2;
                                                } else {
                                                    b2 = -1;
                                                }
                                            } else if (strM4349u1.equals("tblr")) {
                                                b2 = 1;
                                            } else {
                                                b2 = -1;
                                            }
                                        } else if (strM4349u1.equals("tb")) {
                                            b2 = 0;
                                        } else {
                                            b2 = -1;
                                        }
                                        if (b2 != 0 || b2 == 1) {
                                            i2 = 2;
                                        } else if (b2 != 2) {
                                            i2 = Integer.MIN_VALUE;
                                        } else {
                                            i2 = 1;
                                        }
                                    } else {
                                        i2 = Integer.MIN_VALUE;
                                    }
                                    c2615e = new C2615e(strM564r5, f, f5, 0, i, f4, f3, 1, f8, i2);
                                } else {
                                    Log.w("TtmlDecoder", "Ignoring region without an extent");
                                }
                            } catch (NumberFormatException unused3) {
                                Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with malformed origin: ".concat(strM564r6) : new String("Ignoring region with malformed origin: "));
                            }
                        } else if (!matcher4.matches()) {
                            Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with unsupported origin: ".concat(strM564r6) : new String("Ignoring region with unsupported origin: "));
                        } else if (cVar == null) {
                            Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strM564r6) : new String("Ignoring region with missing tts:extent: "));
                        } else {
                            try {
                                String strGroup7 = matcher4.group(1);
                                Objects.requireNonNull(strGroup7);
                                int i4 = Integer.parseInt(strGroup7);
                                String strGroup8 = matcher4.group(2);
                                Objects.requireNonNull(strGroup8);
                                int i5 = Integer.parseInt(strGroup8);
                                float f9 = i4 / cVar.f6048a;
                                float f10 = i5 / cVar.f6049b;
                                f = f9;
                                f2 = f10;
                                strM564r1 = C1460d.m564r0(xmlPullParser, "extent");
                                if (strM564r1 != null) {
                                    matcher = pattern.matcher(strM564r1);
                                    matcher2 = pattern2.matcher(strM564r1);
                                    if (matcher.matches()) {
                                        String strGroup9 = matcher.group(1);
                                        Objects.requireNonNull(strGroup9);
                                        float f11 = Float.parseFloat(strGroup9) / 100.0f;
                                        String strGroup10 = matcher.group(2);
                                        Objects.requireNonNull(strGroup10);
                                        f3 = Float.parseFloat(strGroup10) / 100.0f;
                                        f4 = f11;
                                    } else if (matcher2.matches()) {
                                        if (strM564r6.length() != 0) {
                                            str = "Ignoring region with unsupported extent: ".concat(strM564r6);
                                        } else {
                                            str = new String("Ignoring region with unsupported extent: ");
                                        }
                                        Log.w("TtmlDecoder", str);
                                    } else if (cVar == null) {
                                        if (strM564r6.length() != 0) {
                                            str2 = "Ignoring region with missing tts:extent: ".concat(strM564r6);
                                        } else {
                                            str2 = new String("Ignoring region with missing tts:extent: ");
                                        }
                                        Log.w("TtmlDecoder", str2);
                                    } else {
                                        String strGroup11 = matcher2.group(1);
                                        Objects.requireNonNull(strGroup11);
                                        int i6 = Integer.parseInt(strGroup11);
                                        String strGroup12 = matcher2.group(2);
                                        Objects.requireNonNull(strGroup12);
                                        float f12 = Integer.parseInt(strGroup12);
                                        f4 = i6 / cVar.f6048a;
                                        f3 = f12 / cVar.f6049b;
                                    }
                                    strM564r2 = C1460d.m564r0(xmlPullParser, "displayAlign");
                                    if (strM564r2 != null) {
                                        strM4349u2 = C3404f.m4349u1(strM564r2);
                                        strM4349u2.hashCode();
                                        if (!strM4349u2.equals("center")) {
                                            f5 = (f3 / 2.0f) + f2;
                                            i = 1;
                                        } else if (strM4349u2.equals("after")) {
                                            f5 = f2;
                                            i = 0;
                                        } else {
                                            f5 = f2 + f3;
                                            i = 2;
                                        }
                                    } else {
                                        f5 = f2;
                                        i = 0;
                                    }
                                    float f13 = 1.0f / aVar.f6044a;
                                    strM564r3 = C1460d.m564r0(xmlPullParser, "writingMode");
                                    if (strM564r3 != null) {
                                        strM4349u1 = C3404f.m4349u1(strM564r3);
                                        strM4349u1.hashCode();
                                        iHashCode = strM4349u1.hashCode();
                                        if (iHashCode != 3694) {
                                            if (iHashCode != 3553396) {
                                                if (iHashCode != 3553576) {
                                                    b2 = -1;
                                                } else {
                                                    b2 = 2;
                                                }
                                            } else if (strM4349u1.equals("tblr")) {
                                                b2 = -1;
                                            } else {
                                                b2 = 1;
                                            }
                                        } else if (strM4349u1.equals("tb")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 0;
                                        }
                                        if (b2 != 0) {
                                            i2 = 2;
                                        } else {
                                            i2 = 2;
                                        }
                                    } else {
                                        i2 = Integer.MIN_VALUE;
                                    }
                                    c2615e = new C2615e(strM564r5, f, f5, 0, i, f4, f3, 1, f13, i2);
                                } else {
                                    Log.w("TtmlDecoder", "Ignoring region without an extent");
                                }
                            } catch (NumberFormatException unused4) {
                                Log.w("TtmlDecoder", strM564r6.length() != 0 ? "Ignoring region with malformed origin: ".concat(strM564r6) : new String("Ignoring region with malformed origin: "));
                            }
                        }
                    } else {
                        Log.w("TtmlDecoder", "Ignoring region without an origin");
                    }
                    c2615e = null;
                } else {
                    c2615e = null;
                }
                if (c2615e != null) {
                    map2.put(c2615e.f6063a, c2615e);
                }
            } else if (C1460d.m490Y0(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (C1460d.m490Y0(xmlPullParser, "image") && (strM564r0 = C1460d.m564r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID)) != null) {
                        map3.put(strM564r0, xmlPullParser.nextText());
                    }
                } while (!C1460d.m469R0(xmlPullParser, "metadata"));
            }
        } while (!C1460d.m469R0(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x007c  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fc  */
    /* JADX INFO: renamed from: r */
    public static C2614d m2686r(XmlPullParser xmlPullParser, @Nullable C2614d c2614d, Map<String, C2615e> map, b bVar) throws SubtitleDecoderException {
        long j;
        long j2;
        byte b2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser.getAttributeCount();
        C2616f c2616fM2687s = m2687s(xmlPullParser2, null);
        String strSubstring = null;
        String str = "";
        long jM2689u = -9223372036854775807L;
        long jM2689u2 = -9223372036854775807L;
        long jM2689u3 = -9223372036854775807L;
        String[] strArr = null;
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            String attributeValue = xmlPullParser2.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    b2 = 0;
                    break;
                case "dur":
                    b2 = 1;
                    break;
                case "end":
                    b2 = 2;
                    break;
                case "begin":
                    b2 = 3;
                    break;
                case "style":
                    b2 = 4;
                    break;
                case "backgroundImage":
                    b2 = 5;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 != 0) {
                if (b2 == 1) {
                    jM2689u3 = m2689u(attributeValue, bVar);
                } else if (b2 == 2) {
                    jM2689u2 = m2689u(attributeValue, bVar);
                } else if (b2 == 3) {
                    jM2689u = m2689u(attributeValue, bVar);
                } else if (b2 == 4) {
                    String[] strArrM2688t = m2688t(attributeValue);
                    if (strArrM2688t.length > 0) {
                        strArr = strArrM2688t;
                    }
                } else if (b2 == 5 && attributeValue.startsWith("#")) {
                    strSubstring = attributeValue.substring(1);
                }
            } else if (map.containsKey(attributeValue)) {
                str = attributeValue;
            }
            i++;
            xmlPullParser2 = xmlPullParser;
        }
        if (c2614d != null) {
            long j3 = c2614d.f6053d;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jM2689u != -9223372036854775807L) {
                    jM2689u += j3;
                }
                if (jM2689u2 != -9223372036854775807L) {
                    jM2689u2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (jM2689u2 != j) {
            j2 = jM2689u2;
        } else if (jM2689u3 != j) {
            j2 = jM2689u + jM2689u3;
        } else if (c2614d != null) {
            long j4 = c2614d.f6054e;
            if (j4 != j) {
                j2 = j4;
            } else {
                j2 = jM2689u2;
            }
        } else {
            j2 = jM2689u2;
        }
        return new C2614d(xmlPullParser.getName(), null, jM2689u, j2, c2616fM2687s, strArr, str, strSubstring, c2614d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:109:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:128:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:150:0x0243  */
    /* JADX WARN: Code duplicated, block: B:251:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:254:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00de  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: s */
    public static C2616f m2687s(XmlPullParser xmlPullParser, C2616f c2616f) {
        byte b2;
        byte b3;
        C2612b c2612b;
        int attributeCount = xmlPullParser.getAttributeCount();
        C2616f c2616fM2679k = c2616f;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            int i2 = -1;
            byte b4 = 1;
            switch (attributeName) {
                case "fontStyle":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    c2616fM2679k.f6081i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "fontFamily":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    c2616fM2679k.f6073a = attributeValue;
                    break;
                case "textAlign":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    c2616fM2679k.f6087o = m2681m(attributeValue);
                    break;
                case "textDecoration":
                    String strM4349u1 = C3404f.m4349u1(attributeValue);
                    strM4349u1.hashCode();
                    switch (strM4349u1.hashCode()) {
                        case -1461280213:
                            if (strM4349u1.equals("nounderline")) {
                                i2 = 0;
                            }
                            break;
                        case -1026963764:
                            if (strM4349u1.equals("underline")) {
                                i2 = 1;
                            }
                            break;
                        case 913457136:
                            if (strM4349u1.equals("nolinethrough")) {
                                i2 = 2;
                            }
                            break;
                        case 1679736913:
                            if (strM4349u1.equals("linethrough")) {
                                i2 = 3;
                            }
                            break;
                    }
                    if (i2 == 0) {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        c2616fM2679k.f6079g = 0;
                        break;
                    } else {
                        if (i2 == 1) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6079g = 1;
                        } else if (i2 == 2) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6078f = 0;
                        } else if (i2 == 3) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6078f = 1;
                        }
                        break;
                    }
                    break;
                case "fontWeight":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    c2616fM2679k.f6080h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        c2616fM2679k.f6084l = attributeValue;
                        break;
                    }
                    break;
                case "ruby":
                    String strM4349u2 = C3404f.m4349u1(attributeValue);
                    strM4349u2.hashCode();
                    switch (strM4349u2.hashCode()) {
                        case -618561360:
                            if (strM4349u2.equals("baseContainer")) {
                                i2 = 0;
                            }
                            break;
                        case -410956671:
                            if (strM4349u2.equals("container")) {
                                i2 = 1;
                            }
                            break;
                        case -250518009:
                            if (strM4349u2.equals("delimiter")) {
                                i2 = 2;
                            }
                            break;
                        case -136074796:
                            if (strM4349u2.equals("textContainer")) {
                                i2 = 3;
                            }
                            break;
                        case 3016401:
                            if (strM4349u2.equals("base")) {
                                i2 = 4;
                            }
                            break;
                        case 3556653:
                            if (strM4349u2.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                                i2 = 5;
                            }
                            break;
                    }
                    if (i2 != 0) {
                        if (i2 == 1) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6085m = 1;
                        } else if (i2 == 2) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6085m = 4;
                        } else if (i2 == 3) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6085m = 3;
                        } else if (i2 == 4) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6085m = 2;
                        } else if (i2 == 5) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6085m = 3;
                        }
                        break;
                    } else {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        c2616fM2679k.f6085m = 2;
                        break;
                    }
                    break;
                case "color":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    try {
                        c2616fM2679k.f6074b = C2742i.m3024a(attributeValue, false);
                        c2616fM2679k.f6075c = true;
                        break;
                    } catch (IllegalArgumentException unused) {
                        String strValueOf = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf.length() != 0 ? "Failed parsing color value: ".concat(strValueOf) : new String("Failed parsing color value: "));
                        break;
                    }
                    break;
                case "shear":
                    C2616f c2616fM2679k2 = m2679k(c2616fM2679k);
                    Matcher matcher = f6037q.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(1);
                            Objects.requireNonNull(strGroup);
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                        } catch (NumberFormatException e) {
                            String strValueOf2 = String.valueOf(attributeValue);
                            C2750q.m3040c("TtmlDecoder", strValueOf2.length() != 0 ? "Failed to parse shear: ".concat(strValueOf2) : new String("Failed to parse shear: "), e);
                        }
                        break;
                    } else {
                        String strValueOf3 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf3.length() != 0 ? "Invalid value for shear: ".concat(strValueOf3) : new String("Invalid value for shear: "));
                    }
                    c2616fM2679k2.f6091s = fMin;
                    c2616fM2679k = c2616fM2679k2;
                    break;
                case "textCombine":
                    String strM4349u3 = C3404f.m4349u1(attributeValue);
                    strM4349u3.hashCode();
                    if (!strM4349u3.equals("all")) {
                        if (strM4349u3.equals("none")) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6089q = 0;
                        }
                        break;
                    } else {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        c2616fM2679k.f6089q = 1;
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        m2683o(attributeValue, c2616fM2679k);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        String strValueOf4 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf4.length() != 0 ? "Failed parsing fontSize value: ".concat(strValueOf4) : new String("Failed parsing fontSize value: "));
                        break;
                    }
                    break;
                case "textEmphasis":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    Pattern pattern = C2612b.f6026a;
                    C2612b c2612b2 = null;
                    if (attributeValue != null) {
                        String strM4349u4 = C3404f.m4349u1(attributeValue.trim());
                        if (!strM4349u4.isEmpty()) {
                            AbstractC4527r abstractC4527rM6282n = AbstractC4527r.m6282n(TextUtils.split(strM4349u4, C2612b.f6026a));
                            String str = (String) C3404f.m4308k0(C4507h.m6239b(C2612b.f6030e, abstractC4527rM6282n), "outside");
                            int iHashCode = str.hashCode();
                            if (iHashCode != -1392885889) {
                                if (iHashCode != -1106037339) {
                                    if (iHashCode == 92734940 && str.equals("after")) {
                                        b2 = 0;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (str.equals("outside")) {
                                    b2 = 1;
                                } else {
                                    b2 = -1;
                                }
                            } else if (str.equals("before")) {
                                b2 = 2;
                            } else {
                                b2 = -1;
                            }
                            int i3 = b2 != 0 ? b2 != 1 ? 1 : -2 : 2;
                            C4507h.a aVar = (C4507h.a) C4507h.m6239b(C2612b.f6027b, abstractC4527rM6282n);
                            if (aVar.isEmpty()) {
                                AbstractC4524p0 abstractC4524p0M6239b = C4507h.m6239b(C2612b.f6029d, abstractC4527rM6282n);
                                AbstractC4524p0 abstractC4524p0M6239b2 = C4507h.m6239b(C2612b.f6028c, abstractC4527rM6282n);
                                if (((C4507h.a) abstractC4524p0M6239b).isEmpty() && ((C4507h.a) abstractC4524p0M6239b2).isEmpty()) {
                                    c2612b = new C2612b(-1, 0, i3);
                                } else {
                                    String str2 = (String) C3404f.m4308k0(abstractC4524p0M6239b, "filled");
                                    int iHashCode2 = str2.hashCode();
                                    if (iHashCode2 != -1274499742) {
                                        if (iHashCode2 == 3417674 && str2.equals("open")) {
                                            b3 = 0;
                                        } else {
                                            b3 = -1;
                                        }
                                    } else if (str2.equals("filled")) {
                                        b3 = 1;
                                    } else {
                                        b3 = -1;
                                    }
                                    int i4 = b3 != 0 ? 1 : 2;
                                    String str3 = (String) C3404f.m4308k0(abstractC4524p0M6239b2, "circle");
                                    int iHashCode3 = str3.hashCode();
                                    if (iHashCode3 != -1360216880) {
                                        if (iHashCode3 != -905816648) {
                                            if (iHashCode3 == 99657 && str3.equals("dot")) {
                                                i2 = 0;
                                            }
                                        } else if (str3.equals("sesame")) {
                                            i2 = 1;
                                        }
                                    } else if (str3.equals("circle")) {
                                        i2 = 2;
                                    }
                                    c2612b = new C2612b(i2 != 0 ? i2 != 1 ? 1 : 3 : 2, i4, i3);
                                }
                            } else {
                                String str4 = (String) new C4520n0(aVar).next();
                                int iHashCode4 = str4.hashCode();
                                if (iHashCode4 != 3005871) {
                                    if (iHashCode4 == 3387192 && str4.equals("none")) {
                                        b4 = 0;
                                    } else {
                                        b4 = -1;
                                    }
                                } else if (!str4.equals("auto")) {
                                    b4 = -1;
                                }
                                c2612b = new C2612b(b4 == 0 ? 0 : -1, 0, i3);
                            }
                            c2612b2 = c2612b;
                        }
                    }
                    c2616fM2679k.f6090r = c2612b2;
                    break;
                case "rubyPosition":
                    String strM4349u5 = C3404f.m4349u1(attributeValue);
                    strM4349u5.hashCode();
                    if (!strM4349u5.equals("before")) {
                        if (strM4349u5.equals("after")) {
                            c2616fM2679k = m2679k(c2616fM2679k);
                            c2616fM2679k.f6086n = 2;
                        }
                        break;
                    } else {
                        c2616fM2679k = m2679k(c2616fM2679k);
                        c2616fM2679k.f6086n = 1;
                        break;
                    }
                    break;
                case "backgroundColor":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    try {
                        c2616fM2679k.f6076d = C2742i.m3024a(attributeValue, false);
                        c2616fM2679k.f6077e = true;
                        break;
                    } catch (IllegalArgumentException unused3) {
                        String strValueOf5 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf5.length() != 0 ? "Failed parsing background value: ".concat(strValueOf5) : new String("Failed parsing background value: "));
                        break;
                    }
                    break;
                case "multiRowAlign":
                    c2616fM2679k = m2679k(c2616fM2679k);
                    c2616fM2679k.f6088p = m2681m(attributeValue);
                    break;
            }
        }
        return c2616fM2679k;
    }

    /* JADX INFO: renamed from: t */
    public static String[] m2688t(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = C2738e0.f6708a;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    /* JADX INFO: renamed from: u */
    public static long m2689u(String str, b bVar) throws SubtitleDecoderException {
        double d;
        double d2;
        Matcher matcher = f6034n.matcher(str);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            double d3 = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            double d4 = d3 + (Long.parseLong(strGroup2) * 60);
            String strGroup3 = matcher.group(3);
            Objects.requireNonNull(strGroup3);
            double d5 = d4 + Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d6 = d5 + (strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d);
            String strGroup5 = matcher.group(5);
            double d7 = d6 + (strGroup5 != null ? Long.parseLong(strGroup5) / bVar.f6045a : 0.0d);
            String strGroup6 = matcher.group(6);
            return (long) ((d7 + (strGroup6 != null ? (Long.parseLong(strGroup6) / ((double) bVar.f6046b)) / ((double) bVar.f6045a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f6035o.matcher(str);
        if (!matcher2.matches()) {
            String strValueOf = String.valueOf(str);
            throw new SubtitleDecoderException(strValueOf.length() != 0 ? "Malformed time expression: ".concat(strValueOf) : new String("Malformed time expression: "));
        }
        String strGroup7 = matcher2.group(1);
        Objects.requireNonNull(strGroup7);
        double d8 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        Objects.requireNonNull(strGroup8);
        switch (strGroup8) {
            case "f":
                d = bVar.f6045a;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            case "h":
                d2 = 3600.0d;
                break;
            case "m":
                d2 = 60.0d;
                break;
            case "t":
                d = bVar.f6047c;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            case "ms":
                d = 1000.0d;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            default:
                return (long) (d8 * 1000000.0d);
        }
        d8 *= d2;
        return (long) (d8 * 1000000.0d);
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public static c m2690v(XmlPullParser xmlPullParser) {
        String strM564r0 = C1460d.m564r0(xmlPullParser, "extent");
        if (strM564r0 == null) {
            return null;
        }
        Matcher matcher = f6039s.matcher(strM564r0);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", strM564r0.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(strM564r0) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            Objects.requireNonNull(strGroup);
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            Objects.requireNonNull(strGroup2);
            return new c(i, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", strM564r0.length() != 0 ? "Ignoring malformed tts extent: ".concat(strM564r0) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f6043w.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new C2615e("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            c cVarM2690v = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarM2684p = f6041u;
            a aVarM2682n = f6042v;
            C2617g c2617g = null;
            int i2 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                C2614d c2614d = (C2614d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarM2684p = m2684p(xmlPullParserNewPullParser);
                            aVarM2682n = m2682n(xmlPullParserNewPullParser, f6042v);
                            cVarM2690v = m2690v(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarM2690v;
                        b bVar2 = bVarM2684p;
                        a aVar = aVarM2682n;
                        if (!m2680l(name)) {
                            String strValueOf = String.valueOf(xmlPullParserNewPullParser.getName());
                            Log.i("TtmlDecoder", strValueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(strValueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            bVar = bVar2;
                        } else if ("head".equals(name)) {
                            bVar = bVar2;
                            m2685q(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                        } else {
                            bVar = bVar2;
                            try {
                                C2614d c2614dM2686r = m2686r(xmlPullParserNewPullParser, c2614d, map2, bVar);
                                arrayDeque.push(c2614dM2686r);
                                if (c2614d != null) {
                                    c2614d.m2693a(c2614dM2686r);
                                }
                            } catch (SubtitleDecoderException e) {
                                C2750q.m3040c("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                        bVarM2684p = bVar;
                        cVarM2690v = cVar;
                        aVarM2682n = aVar;
                    } else if (eventType == 4) {
                        Objects.requireNonNull(c2614d);
                        C2614d c2614dM2691b = C2614d.m2691b(xmlPullParserNewPullParser.getText());
                        if (c2614d.f6062m == null) {
                            c2614d.f6062m = new ArrayList();
                        }
                        c2614d.f6062m.add(c2614dM2691b);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            C2614d c2614d2 = (C2614d) arrayDeque.peek();
                            Objects.requireNonNull(c2614d2);
                            c2617g = new C2617g(c2614d2, map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (c2617g != null) {
                return c2617g;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
