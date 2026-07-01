package b.i.a.c.b3.t;

import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.ColorParser2;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.b.b.Collections2;
import b.i.b.b.ImmutableSet2;
import b.i.b.b.Sets2;
import b.i.b.b.Sets4;
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

/* JADX INFO: renamed from: b.i.a.c.b3.t.c, reason: use source file name */
/* JADX INFO: compiled from: TtmlDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder2 {
    public static final Pattern n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f880s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern t = Pattern.compile("^(\\d+) (\\d+)$");
    public static final b u = new b(30.0f, 1, 1);
    public static final a v = new a(32, 15);
    public final XmlPullParserFactory w;

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$a */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class a {
        public final int a;

        public a(int i, int i2) {
            this.a = i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$b */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class b {
        public final float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f881b;
        public final int c;

        public b(float f, int i, int i2) {
            this.a = f;
            this.f881b = i;
            this.c = i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.t.c$c */
    /* JADX INFO: compiled from: TtmlDecoder.java */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f882b;

        public c(int i, int i2) {
            this.a = i;
            this.f882b = i2;
        }
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.w = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static TtmlStyle k(@Nullable TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    public static boolean l(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals(ModelAuditLogEntry.CHANGE_KEY_REGION) || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment m(String str) {
        String strU1 = b.i.a.f.e.o.f.u1(str);
        strU1.hashCode();
        switch (strU1) {
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

    public static a n(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = t.matcher(attributeValue);
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

    public static void o(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        int i = Util2.a;
        String[] strArrSplit = str.split("\\s+", -1);
        if (strArrSplit.length == 1) {
            matcher = p.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                int length = strArrSplit.length;
                StringBuilder sb = new StringBuilder(52);
                sb.append("Invalid number of entries for fontSize: ");
                sb.append(length);
                sb.append(".");
                throw new SubtitleDecoderException(sb.toString());
            }
            matcher = p.matcher(strArrSplit[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(outline.k(str.length() + 36, "Invalid expression for fontSize: '", str, "'."));
        }
        String strGroup = matcher.group(3);
        Objects.requireNonNull(strGroup);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                ttmlStyle.j = 3;
                break;
            case "em":
                ttmlStyle.j = 2;
                break;
            case "px":
                ttmlStyle.j = 1;
                break;
            default:
                throw new SubtitleDecoderException(outline.k(strGroup.length() + 30, "Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        Objects.requireNonNull(strGroup2);
        ttmlStyle.k = Float.parseFloat(strGroup2);
    }

    public static b p(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i2 = Util2.a;
            String[] strArrSplit = attributeValue2.split(" ", -1);
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        }
        b bVar = u;
        int i3 = bVar.f881b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.c;
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
    public static Map<String, TtmlStyle> q(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, a aVar, @Nullable c cVar, Map<String, TtmlRegion> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        String strR0;
        TtmlRegion ttmlRegion;
        float f;
        float f2;
        String strR1;
        Matcher matcher;
        Matcher matcher2;
        float f3;
        float f4;
        String strR2;
        float f5;
        int i;
        String strR3;
        int i2;
        String strU1;
        int iHashCode;
        byte b2;
        String strU2;
        String str;
        String str2;
        do {
            xmlPullParser.next();
            if (AnimatableValueParser.Y0(xmlPullParser, "style")) {
                String strR4 = AnimatableValueParser.r0(xmlPullParser, "style");
                TtmlStyle ttmlStyleS = s(xmlPullParser, new TtmlStyle());
                if (strR4 != null) {
                    for (String str3 : t(strR4)) {
                        ttmlStyleS.a(map.get(str3));
                    }
                }
                String str4 = ttmlStyleS.l;
                if (str4 != null) {
                    map.put(str4, ttmlStyleS);
                }
            } else if (AnimatableValueParser.Y0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_REGION)) {
                String strR5 = AnimatableValueParser.r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID);
                if (strR5 != null) {
                    String strR6 = AnimatableValueParser.r0(xmlPullParser, "origin");
                    if (strR6 != null) {
                        Pattern pattern = r;
                        Matcher matcher3 = pattern.matcher(strR6);
                        Pattern pattern2 = f880s;
                        Matcher matcher4 = pattern2.matcher(strR6);
                        if (matcher3.matches()) {
                            try {
                                String strGroup = matcher3.group(1);
                                Objects.requireNonNull(strGroup);
                                f = Float.parseFloat(strGroup) / 100.0f;
                                String strGroup2 = matcher3.group(2);
                                Objects.requireNonNull(strGroup2);
                                f2 = Float.parseFloat(strGroup2) / 100.0f;
                                strR1 = AnimatableValueParser.r0(xmlPullParser, "extent");
                                if (strR1 != null) {
                                    matcher = pattern.matcher(strR1);
                                    matcher2 = pattern2.matcher(strR1);
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
                                            Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with malformed extent: ".concat(strR6) : new String("Ignoring region with malformed extent: "));
                                            ttmlRegion = null;
                                        }
                                    } else if (matcher2.matches()) {
                                        if (strR6.length() != 0) {
                                            str = "Ignoring region with unsupported extent: ".concat(strR6);
                                        } else {
                                            str = new String("Ignoring region with unsupported extent: ");
                                        }
                                        Log.w("TtmlDecoder", str);
                                    } else if (cVar == null) {
                                        if (strR6.length() != 0) {
                                            str2 = "Ignoring region with missing tts:extent: ".concat(strR6);
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
                                            f4 = i3 / cVar.a;
                                            f3 = f7 / cVar.f882b;
                                        } catch (NumberFormatException unused2) {
                                            Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with malformed extent: ".concat(strR6) : new String("Ignoring region with malformed extent: "));
                                            ttmlRegion = null;
                                        }
                                    }
                                    strR2 = AnimatableValueParser.r0(xmlPullParser, "displayAlign");
                                    if (strR2 != null) {
                                        strU2 = b.i.a.f.e.o.f.u1(strR2);
                                        strU2.hashCode();
                                        if (!strU2.equals("center")) {
                                            f5 = (f3 / 2.0f) + f2;
                                            i = 1;
                                        } else if (strU2.equals("after")) {
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
                                    float f8 = 1.0f / aVar.a;
                                    strR3 = AnimatableValueParser.r0(xmlPullParser, "writingMode");
                                    if (strR3 != null) {
                                        strU1 = b.i.a.f.e.o.f.u1(strR3);
                                        strU1.hashCode();
                                        iHashCode = strU1.hashCode();
                                        if (iHashCode != 3694) {
                                            if (iHashCode != 3553396) {
                                                if (iHashCode != 3553576 && strU1.equals("tbrl")) {
                                                    b2 = 2;
                                                } else {
                                                    b2 = -1;
                                                }
                                            } else if (strU1.equals("tblr")) {
                                                b2 = 1;
                                            } else {
                                                b2 = -1;
                                            }
                                        } else if (strU1.equals("tb")) {
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
                                    ttmlRegion = new TtmlRegion(strR5, f, f5, 0, i, f4, f3, 1, f8, i2);
                                } else {
                                    Log.w("TtmlDecoder", "Ignoring region without an extent");
                                }
                            } catch (NumberFormatException unused3) {
                                Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with malformed origin: ".concat(strR6) : new String("Ignoring region with malformed origin: "));
                            }
                        } else if (!matcher4.matches()) {
                            Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with unsupported origin: ".concat(strR6) : new String("Ignoring region with unsupported origin: "));
                        } else if (cVar == null) {
                            Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(strR6) : new String("Ignoring region with missing tts:extent: "));
                        } else {
                            try {
                                String strGroup7 = matcher4.group(1);
                                Objects.requireNonNull(strGroup7);
                                int i4 = Integer.parseInt(strGroup7);
                                String strGroup8 = matcher4.group(2);
                                Objects.requireNonNull(strGroup8);
                                int i5 = Integer.parseInt(strGroup8);
                                float f9 = i4 / cVar.a;
                                float f10 = i5 / cVar.f882b;
                                f = f9;
                                f2 = f10;
                                strR1 = AnimatableValueParser.r0(xmlPullParser, "extent");
                                if (strR1 != null) {
                                    matcher = pattern.matcher(strR1);
                                    matcher2 = pattern2.matcher(strR1);
                                    if (matcher.matches()) {
                                        String strGroup9 = matcher.group(1);
                                        Objects.requireNonNull(strGroup9);
                                        float f11 = Float.parseFloat(strGroup9) / 100.0f;
                                        String strGroup10 = matcher.group(2);
                                        Objects.requireNonNull(strGroup10);
                                        f3 = Float.parseFloat(strGroup10) / 100.0f;
                                        f4 = f11;
                                    } else if (matcher2.matches()) {
                                        if (strR6.length() != 0) {
                                            str = "Ignoring region with unsupported extent: ".concat(strR6);
                                        } else {
                                            str = new String("Ignoring region with unsupported extent: ");
                                        }
                                        Log.w("TtmlDecoder", str);
                                    } else if (cVar == null) {
                                        if (strR6.length() != 0) {
                                            str2 = "Ignoring region with missing tts:extent: ".concat(strR6);
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
                                        f4 = i6 / cVar.a;
                                        f3 = f12 / cVar.f882b;
                                    }
                                    strR2 = AnimatableValueParser.r0(xmlPullParser, "displayAlign");
                                    if (strR2 != null) {
                                        strU2 = b.i.a.f.e.o.f.u1(strR2);
                                        strU2.hashCode();
                                        if (!strU2.equals("center")) {
                                            f5 = (f3 / 2.0f) + f2;
                                            i = 1;
                                        } else if (strU2.equals("after")) {
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
                                    float f13 = 1.0f / aVar.a;
                                    strR3 = AnimatableValueParser.r0(xmlPullParser, "writingMode");
                                    if (strR3 != null) {
                                        strU1 = b.i.a.f.e.o.f.u1(strR3);
                                        strU1.hashCode();
                                        iHashCode = strU1.hashCode();
                                        if (iHashCode != 3694) {
                                            if (iHashCode != 3553396) {
                                                if (iHashCode != 3553576) {
                                                    b2 = -1;
                                                } else {
                                                    b2 = 2;
                                                }
                                            } else if (strU1.equals("tblr")) {
                                                b2 = -1;
                                            } else {
                                                b2 = 1;
                                            }
                                        } else if (strU1.equals("tb")) {
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
                                    ttmlRegion = new TtmlRegion(strR5, f, f5, 0, i, f4, f3, 1, f13, i2);
                                } else {
                                    Log.w("TtmlDecoder", "Ignoring region without an extent");
                                }
                            } catch (NumberFormatException unused4) {
                                Log.w("TtmlDecoder", strR6.length() != 0 ? "Ignoring region with malformed origin: ".concat(strR6) : new String("Ignoring region with malformed origin: "));
                            }
                        }
                    } else {
                        Log.w("TtmlDecoder", "Ignoring region without an origin");
                    }
                    ttmlRegion = null;
                } else {
                    ttmlRegion = null;
                }
                if (ttmlRegion != null) {
                    map2.put(ttmlRegion.a, ttmlRegion);
                }
            } else if (AnimatableValueParser.Y0(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (AnimatableValueParser.Y0(xmlPullParser, "image") && (strR0 = AnimatableValueParser.r0(xmlPullParser, ModelAuditLogEntry.CHANGE_KEY_ID)) != null) {
                        map3.put(strR0, xmlPullParser.nextText());
                    }
                } while (!AnimatableValueParser.R0(xmlPullParser, "metadata"));
            }
        } while (!AnimatableValueParser.R0(xmlPullParser, "head"));
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x007c  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fc  */
    public static TtmlNode r(XmlPullParser xmlPullParser, @Nullable TtmlNode ttmlNode, Map<String, TtmlRegion> map, b bVar) throws SubtitleDecoderException {
        long j;
        long j2;
        byte b2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleS = s(xmlPullParser2, null);
        String strSubstring = null;
        String str = "";
        long jU = -9223372036854775807L;
        long jU2 = -9223372036854775807L;
        long jU3 = -9223372036854775807L;
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
                    jU3 = u(attributeValue, bVar);
                } else if (b2 == 2) {
                    jU2 = u(attributeValue, bVar);
                } else if (b2 == 3) {
                    jU = u(attributeValue, bVar);
                } else if (b2 == 4) {
                    String[] strArrT = t(attributeValue);
                    if (strArrT.length > 0) {
                        strArr = strArrT;
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
        if (ttmlNode != null) {
            long j3 = ttmlNode.d;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jU != -9223372036854775807L) {
                    jU += j3;
                }
                if (jU2 != -9223372036854775807L) {
                    jU2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (jU2 != j) {
            j2 = jU2;
        } else if (jU3 != j) {
            j2 = jU + jU3;
        } else if (ttmlNode != null) {
            long j4 = ttmlNode.e;
            if (j4 != j) {
                j2 = j4;
            } else {
                j2 = jU2;
            }
        } else {
            j2 = jU2;
        }
        return new TtmlNode(xmlPullParser.getName(), null, jU, j2, ttmlStyleS, strArr, str, strSubstring, ttmlNode);
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
    public static TtmlStyle s(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        byte b2;
        byte b3;
        TextEmphasis textEmphasis;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleK = ttmlStyle;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            int i2 = -1;
            byte b4 = 1;
            switch (attributeName) {
                case "fontStyle":
                    ttmlStyleK = k(ttmlStyleK);
                    ttmlStyleK.i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "fontFamily":
                    ttmlStyleK = k(ttmlStyleK);
                    ttmlStyleK.a = attributeValue;
                    break;
                case "textAlign":
                    ttmlStyleK = k(ttmlStyleK);
                    ttmlStyleK.o = m(attributeValue);
                    break;
                case "textDecoration":
                    String strU1 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU1.hashCode();
                    switch (strU1.hashCode()) {
                        case -1461280213:
                            if (strU1.equals("nounderline")) {
                                i2 = 0;
                            }
                            break;
                        case -1026963764:
                            if (strU1.equals("underline")) {
                                i2 = 1;
                            }
                            break;
                        case 913457136:
                            if (strU1.equals("nolinethrough")) {
                                i2 = 2;
                            }
                            break;
                        case 1679736913:
                            if (strU1.equals("linethrough")) {
                                i2 = 3;
                            }
                            break;
                    }
                    if (i2 == 0) {
                        ttmlStyleK = k(ttmlStyleK);
                        ttmlStyleK.g = 0;
                        break;
                    } else {
                        if (i2 == 1) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.g = 1;
                        } else if (i2 == 2) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.f = 0;
                        } else if (i2 == 3) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.f = 1;
                        }
                        break;
                    }
                    break;
                case "fontWeight":
                    ttmlStyleK = k(ttmlStyleK);
                    ttmlStyleK.h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        ttmlStyleK = k(ttmlStyleK);
                        ttmlStyleK.l = attributeValue;
                        break;
                    }
                    break;
                case "ruby":
                    String strU2 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU2.hashCode();
                    switch (strU2.hashCode()) {
                        case -618561360:
                            if (strU2.equals("baseContainer")) {
                                i2 = 0;
                            }
                            break;
                        case -410956671:
                            if (strU2.equals("container")) {
                                i2 = 1;
                            }
                            break;
                        case -250518009:
                            if (strU2.equals("delimiter")) {
                                i2 = 2;
                            }
                            break;
                        case -136074796:
                            if (strU2.equals("textContainer")) {
                                i2 = 3;
                            }
                            break;
                        case 3016401:
                            if (strU2.equals("base")) {
                                i2 = 4;
                            }
                            break;
                        case 3556653:
                            if (strU2.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                                i2 = 5;
                            }
                            break;
                    }
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.m = 1;
                        } else if (i2 == 2) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.m = 4;
                        } else if (i2 == 3) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.m = 3;
                        } else if (i2 == 4) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.m = 2;
                        } else if (i2 == 5) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.m = 3;
                        }
                        break;
                    } else {
                        ttmlStyleK = k(ttmlStyleK);
                        ttmlStyleK.m = 2;
                        break;
                    }
                    break;
                case "color":
                    ttmlStyleK = k(ttmlStyleK);
                    try {
                        ttmlStyleK.f885b = ColorParser2.a(attributeValue, false);
                        ttmlStyleK.c = true;
                        break;
                    } catch (IllegalArgumentException unused) {
                        String strValueOf = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf.length() != 0 ? "Failed parsing color value: ".concat(strValueOf) : new String("Failed parsing color value: "));
                        break;
                    }
                    break;
                case "shear":
                    TtmlStyle ttmlStyleK2 = k(ttmlStyleK);
                    Matcher matcher = q.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(1);
                            Objects.requireNonNull(strGroup);
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                        } catch (NumberFormatException e) {
                            String strValueOf2 = String.valueOf(attributeValue);
                            Log2.c("TtmlDecoder", strValueOf2.length() != 0 ? "Failed to parse shear: ".concat(strValueOf2) : new String("Failed to parse shear: "), e);
                        }
                        break;
                    } else {
                        String strValueOf3 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf3.length() != 0 ? "Invalid value for shear: ".concat(strValueOf3) : new String("Invalid value for shear: "));
                    }
                    ttmlStyleK2.f886s = fMin;
                    ttmlStyleK = ttmlStyleK2;
                    break;
                case "textCombine":
                    String strU3 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU3.hashCode();
                    if (!strU3.equals("all")) {
                        if (strU3.equals("none")) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.q = 0;
                        }
                        break;
                    } else {
                        ttmlStyleK = k(ttmlStyleK);
                        ttmlStyleK.q = 1;
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        ttmlStyleK = k(ttmlStyleK);
                        o(attributeValue, ttmlStyleK);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        String strValueOf4 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf4.length() != 0 ? "Failed parsing fontSize value: ".concat(strValueOf4) : new String("Failed parsing fontSize value: "));
                        break;
                    }
                    break;
                case "textEmphasis":
                    ttmlStyleK = k(ttmlStyleK);
                    Pattern pattern = TextEmphasis.a;
                    TextEmphasis textEmphasis2 = null;
                    if (attributeValue != null) {
                        String strU4 = b.i.a.f.e.o.f.u1(attributeValue.trim());
                        if (!strU4.isEmpty()) {
                            ImmutableSet2 immutableSet2N = ImmutableSet2.n(TextUtils.split(strU4, TextEmphasis.a));
                            String str = (String) b.i.a.f.e.o.f.k0(Collections2.b(TextEmphasis.e, immutableSet2N), "outside");
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
                            Collections2.a aVar = (Collections2.a) Collections2.b(TextEmphasis.f879b, immutableSet2N);
                            if (aVar.isEmpty()) {
                                Sets4 sets4B = Collections2.b(TextEmphasis.d, immutableSet2N);
                                Sets4 sets4B2 = Collections2.b(TextEmphasis.c, immutableSet2N);
                                if (((Collections2.a) sets4B).isEmpty() && ((Collections2.a) sets4B2).isEmpty()) {
                                    textEmphasis = new TextEmphasis(-1, 0, i3);
                                } else {
                                    String str2 = (String) b.i.a.f.e.o.f.k0(sets4B, "filled");
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
                                    String str3 = (String) b.i.a.f.e.o.f.k0(sets4B2, "circle");
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
                                    textEmphasis = new TextEmphasis(i2 != 0 ? i2 != 1 ? 1 : 3 : 2, i4, i3);
                                }
                            } else {
                                String str4 = (String) new Sets2(aVar).next();
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
                                textEmphasis = new TextEmphasis(b4 == 0 ? 0 : -1, 0, i3);
                            }
                            textEmphasis2 = textEmphasis;
                        }
                    }
                    ttmlStyleK.r = textEmphasis2;
                    break;
                case "rubyPosition":
                    String strU5 = b.i.a.f.e.o.f.u1(attributeValue);
                    strU5.hashCode();
                    if (!strU5.equals("before")) {
                        if (strU5.equals("after")) {
                            ttmlStyleK = k(ttmlStyleK);
                            ttmlStyleK.n = 2;
                        }
                        break;
                    } else {
                        ttmlStyleK = k(ttmlStyleK);
                        ttmlStyleK.n = 1;
                        break;
                    }
                    break;
                case "backgroundColor":
                    ttmlStyleK = k(ttmlStyleK);
                    try {
                        ttmlStyleK.d = ColorParser2.a(attributeValue, false);
                        ttmlStyleK.e = true;
                        break;
                    } catch (IllegalArgumentException unused3) {
                        String strValueOf5 = String.valueOf(attributeValue);
                        Log.w("TtmlDecoder", strValueOf5.length() != 0 ? "Failed parsing background value: ".concat(strValueOf5) : new String("Failed parsing background value: "));
                        break;
                    }
                    break;
                case "multiRowAlign":
                    ttmlStyleK = k(ttmlStyleK);
                    ttmlStyleK.p = m(attributeValue);
                    break;
            }
        }
        return ttmlStyleK;
    }

    public static String[] t(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = Util2.a;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    public static long u(String str, b bVar) throws SubtitleDecoderException {
        double d;
        double d2;
        Matcher matcher = n.matcher(str);
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
            double d7 = d6 + (strGroup5 != null ? Long.parseLong(strGroup5) / bVar.a : 0.0d);
            String strGroup6 = matcher.group(6);
            return (long) ((d7 + (strGroup6 != null ? (Long.parseLong(strGroup6) / ((double) bVar.f881b)) / ((double) bVar.a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = o.matcher(str);
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
                d = bVar.a;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            case "h":
                d2 = 3600.0d;
                break;
            case "m":
                d2 = 60.0d;
                break;
            case "t":
                d = bVar.c;
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
    public static c v(XmlPullParser xmlPullParser) {
        String strR0 = AnimatableValueParser.r0(xmlPullParser, "extent");
        if (strR0 == null) {
            return null;
        }
        Matcher matcher = f880s.matcher(strR0);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", strR0.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(strR0) : new String("Ignoring non-pixel tts extent: "));
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
            Log.w("TtmlDecoder", strR0.length() != 0 ? "Ignoring malformed tts extent: ".concat(strR0) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.w.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            c cVarV = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarP = u;
            a aVarN = v;
            TtmlSubtitle ttmlSubtitle = null;
            int i2 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarP = p(xmlPullParserNewPullParser);
                            aVarN = n(xmlPullParserNewPullParser, v);
                            cVarV = v(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarV;
                        b bVar2 = bVarP;
                        a aVar = aVarN;
                        if (!l(name)) {
                            String strValueOf = String.valueOf(xmlPullParserNewPullParser.getName());
                            Log.i("TtmlDecoder", strValueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(strValueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            bVar = bVar2;
                        } else if ("head".equals(name)) {
                            bVar = bVar2;
                            q(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                        } else {
                            bVar = bVar2;
                            try {
                                TtmlNode ttmlNodeR = r(xmlPullParserNewPullParser, ttmlNode, map2, bVar);
                                arrayDeque.push(ttmlNodeR);
                                if (ttmlNode != null) {
                                    ttmlNode.a(ttmlNodeR);
                                }
                            } catch (SubtitleDecoderException e) {
                                Log2.c("TtmlDecoder", "Suppressing parser error", e);
                                i2++;
                            }
                        }
                        bVarP = bVar;
                        cVarV = cVar;
                        aVarN = aVar;
                    } else if (eventType == 4) {
                        Objects.requireNonNull(ttmlNode);
                        TtmlNode ttmlNodeB = TtmlNode.b(xmlPullParserNewPullParser.getText());
                        if (ttmlNode.m == null) {
                            ttmlNode.m = new ArrayList();
                        }
                        ttmlNode.m.add(ttmlNodeB);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.peek();
                            Objects.requireNonNull(ttmlNode2);
                            ttmlSubtitle = new TtmlSubtitle(ttmlNode2, map, map2, map3);
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
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }
}
