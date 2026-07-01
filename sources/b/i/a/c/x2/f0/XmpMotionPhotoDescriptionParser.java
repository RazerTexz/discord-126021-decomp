package b.i.a.c.x2.f0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.x2.f0.MotionPhotoDescription;
import b.i.a.f.e.o.f;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.e, reason: use source file name */
/* JADX INFO: compiled from: XmpMotionPhotoDescriptionParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class XmpMotionPhotoDescriptionParser {
    public static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1182b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static MotionPhotoDescription a(String str) throws XmlPullParserException, IOException {
        boolean z2;
        long j;
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!AnimatableValueParser.Y0(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.a("Couldn't find xmp metadata", null);
        }
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        ImmutableList2<Object> immutableList2B = RegularImmutableList.l;
        long j2 = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (AnimatableValueParser.Y0(xmlPullParserNewPullParser, "rdf:Description")) {
                String[] strArr = a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String strR0 = AnimatableValueParser.r0(xmlPullParserNewPullParser, strArr[i]);
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
                        String strR1 = AnimatableValueParser.r0(xmlPullParserNewPullParser, strArr2[i2]);
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
                        AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.k;
                        immutableList2B = RegularImmutableList.l;
                        break;
                    }
                    String strR2 = AnimatableValueParser.r0(xmlPullParserNewPullParser, strArr3[i3]);
                    if (strR2 != null) {
                        long j3 = Long.parseLong(strR2);
                        MotionPhotoDescription.a aVar = new MotionPhotoDescription.a("image/jpeg", "Primary", 0L, 0L);
                        MotionPhotoDescription.a aVar2 = new MotionPhotoDescription.a("video/mp4", "MotionPhoto", j3, 0L);
                        AbstractIndexedListIterator<Object> abstractIndexedListIterator3 = ImmutableList2.k;
                        immutableList2B = ImmutableList2.m(aVar, aVar2);
                        break;
                    }
                    i3++;
                }
                j2 = j;
            } else if (AnimatableValueParser.Y0(xmlPullParserNewPullParser, "Container:Directory")) {
                immutableList2B = b(xmlPullParserNewPullParser, "Container", "Item");
            } else if (AnimatableValueParser.Y0(xmlPullParserNewPullParser, "GContainer:Directory")) {
                immutableList2B = b(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!AnimatableValueParser.R0(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (immutableList2B.isEmpty()) {
            return null;
        }
        return new MotionPhotoDescription(j2, immutableList2B);
    }

    public static ImmutableList2<MotionPhotoDescription.a> b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        int i = 0;
        do {
            xmlPullParser.next();
            if (AnimatableValueParser.Y0(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strR0 = AnimatableValueParser.r0(xmlPullParser, strConcat3);
                String strR1 = AnimatableValueParser.r0(xmlPullParser, strConcat4);
                String strR2 = AnimatableValueParser.r0(xmlPullParser, strConcat5);
                String strR3 = AnimatableValueParser.r0(xmlPullParser, strConcat6);
                if (strR0 == null || strR1 == null) {
                    return RegularImmutableList.l;
                }
                MotionPhotoDescription.a aVar = new MotionPhotoDescription.a(strR0, strR1, strR2 != null ? Long.parseLong(strR2) : 0L, strR3 != null ? Long.parseLong(strR3) : 0L);
                int i2 = i + 1;
                if (objArrCopyOf.length < i2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i2));
                }
                objArrCopyOf[i] = aVar;
                i = i2;
            }
        } while (!AnimatableValueParser.R0(xmlPullParser, strConcat2));
        return ImmutableList2.l(objArrCopyOf, i);
    }
}
