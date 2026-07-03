package p007b.p225i.p226a.p242c.p267x2.p271f0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p267x2.p271f0.C3019b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.e */
/* JADX INFO: compiled from: XmpMotionPhotoDescriptionParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3022e {

    /* JADX INFO: renamed from: a */
    public static final String[] f8176a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b */
    public static final String[] f8177b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c */
    public static final String[] f8178c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C3019b m3668a(String str) throws XmlPullParserException, IOException {
        boolean z2;
        long j;
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!C1460d.m490Y0(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.m8755a("Couldn't find xmp metadata", null);
        }
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        AbstractC4523p<Object> abstractC4523pM3669b = C4508h0.f12012l;
        long j2 = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (C1460d.m490Y0(xmlPullParserNewPullParser, "rdf:Description")) {
                String[] strArr = f8176a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String strM564r0 = C1460d.m564r0(xmlPullParserNewPullParser, strArr[i]);
                        if (strM564r0 == null) {
                            i++;
                        } else if (Integer.parseInt(strM564r0) == 1) {
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
                String[] strArr2 = f8177b;
                int length2 = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String strM564r1 = C1460d.m564r0(xmlPullParserNewPullParser, strArr2[i2]);
                        if (strM564r1 != null) {
                            j = Long.parseLong(strM564r1);
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
                String[] strArr3 = f8178c;
                int length3 = strArr3.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length3) {
                        AbstractC4493a<Object> abstractC4493a2 = AbstractC4523p.f12045k;
                        abstractC4523pM3669b = C4508h0.f12012l;
                        break;
                    }
                    String strM564r2 = C1460d.m564r0(xmlPullParserNewPullParser, strArr3[i3]);
                    if (strM564r2 != null) {
                        long j3 = Long.parseLong(strM564r2);
                        C3019b.a aVar = new C3019b.a("image/jpeg", "Primary", 0L, 0L);
                        C3019b.a aVar2 = new C3019b.a("video/mp4", "MotionPhoto", j3, 0L);
                        AbstractC4493a<Object> abstractC4493a3 = AbstractC4523p.f12045k;
                        abstractC4523pM3669b = AbstractC4523p.m6263m(aVar, aVar2);
                        break;
                    }
                    i3++;
                }
                j2 = j;
            } else if (C1460d.m490Y0(xmlPullParserNewPullParser, "Container:Directory")) {
                abstractC4523pM3669b = m3669b(xmlPullParserNewPullParser, "Container", "Item");
            } else if (C1460d.m490Y0(xmlPullParserNewPullParser, "GContainer:Directory")) {
                abstractC4523pM3669b = m3669b(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!C1460d.m469R0(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (abstractC4523pM3669b.isEmpty()) {
            return null;
        }
        return new C3019b(j2, abstractC4523pM3669b);
    }

    /* JADX INFO: renamed from: b */
    public static AbstractC4523p<C3019b.a> m3669b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        int i = 0;
        do {
            xmlPullParser.next();
            if (C1460d.m490Y0(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strM564r0 = C1460d.m564r0(xmlPullParser, strConcat3);
                String strM564r1 = C1460d.m564r0(xmlPullParser, strConcat4);
                String strM564r2 = C1460d.m564r0(xmlPullParser, strConcat5);
                String strM564r3 = C1460d.m564r0(xmlPullParser, strConcat6);
                if (strM564r0 == null || strM564r1 == null) {
                    return C4508h0.f12012l;
                }
                C3019b.a aVar = new C3019b.a(strM564r0, strM564r1, strM564r2 != null ? Long.parseLong(strM564r2) : 0L, strM564r3 != null ? Long.parseLong(strM564r3) : 0L);
                int i2 = i + 1;
                if (objArrCopyOf.length < i2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i2));
                }
                objArrCopyOf[i] = aVar;
                i = i2;
            }
        } while (!C1460d.m469R0(xmlPullParser, strConcat2));
        return AbstractC4523p.m6262l(objArrCopyOf, i);
    }
}
