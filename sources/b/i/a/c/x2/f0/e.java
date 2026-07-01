package b.i.a.c.x2.f0;

import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import b.i.b.b.h0;
import b.i.b.b.n$b;
import b.i.b.b.p;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: XmpMotionPhotoDescriptionParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1182b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static b a(String str) throws XmlPullParserException, IOException {
        boolean z2;
        long j;
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!b.c.a.a0.d.Y0(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.a("Couldn't find xmp metadata", null);
        }
        b.i.b.b.a<Object> aVar = p.k;
        p<Object> pVarB = h0.l;
        long j2 = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (b.c.a.a0.d.Y0(xmlPullParserNewPullParser, "rdf:Description")) {
                String[] strArr = a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String strR0 = b.c.a.a0.d.r0(xmlPullParserNewPullParser, strArr[i]);
                        if (strR0 == null) {
                            i++;
                        } else if (Integer.parseInt(strR0) == 1) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    break;
                }
                if (!z2) {
                    return null;
                }
                String[] strArr2 = f1182b;
                int length2 = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String strR1 = b.c.a.a0.d.r0(xmlPullParserNewPullParser, strArr2[i2]);
                        if (strR1 != null) {
                            j = Long.parseLong(strR1);
                            if (j != -1) {
                                break;
                            }
                            break;
                        }
                        i2++;
                    }
                    j = -9223372036854775807L;
                    break;
                }
                String[] strArr3 = c;
                int length3 = strArr3.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length3) {
                        b.i.b.b.a<Object> aVar2 = p.k;
                        pVarB = h0.l;
                        break;
                    }
                    String strR2 = b.c.a.a0.d.r0(xmlPullParserNewPullParser, strArr3[i3]);
                    if (strR2 != null) {
                        long j3 = Long.parseLong(strR2);
                        b$a b_a = new b$a("image/jpeg", "Primary", 0L, 0L);
                        b$a b_a2 = new b$a("video/mp4", "MotionPhoto", j3, 0L);
                        b.i.b.b.a<Object> aVar3 = p.k;
                        pVarB = p.m(b_a, b_a2);
                        break;
                    }
                    i3++;
                }
                j2 = j;
            } else if (b.c.a.a0.d.Y0(xmlPullParserNewPullParser, "Container:Directory")) {
                pVarB = b(xmlPullParserNewPullParser, "Container", "Item");
            } else if (b.c.a.a0.d.Y0(xmlPullParserNewPullParser, "GContainer:Directory")) {
                pVarB = b(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!b.c.a.a0.d.R0(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (pVarB.isEmpty()) {
            return null;
        }
        return new b(j2, pVarB);
    }

    public static p<b$a> b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        b.i.b.b.a<Object> aVar = p.k;
        f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        int i = 0;
        do {
            xmlPullParser.next();
            if (b.c.a.a0.d.Y0(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strR0 = b.c.a.a0.d.r0(xmlPullParser, strConcat3);
                String strR1 = b.c.a.a0.d.r0(xmlPullParser, strConcat4);
                String strR2 = b.c.a.a0.d.r0(xmlPullParser, strConcat5);
                String strR3 = b.c.a.a0.d.r0(xmlPullParser, strConcat6);
                if (strR0 == null || strR1 == null) {
                    return h0.l;
                }
                b$a b_a = new b$a(strR0, strR1, strR2 != null ? Long.parseLong(strR2) : 0L, strR3 != null ? Long.parseLong(strR3) : 0L);
                int i2 = i + 1;
                if (objArrCopyOf.length < i2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i2));
                }
                objArrCopyOf[i] = b_a;
                i = i2;
            }
        } while (!b.c.a.a0.d.R0(xmlPullParser, strConcat2));
        return p.l(objArrCopyOf, i);
    }
}
