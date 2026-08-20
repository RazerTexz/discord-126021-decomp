package p007b.p225i.p361c.p369m.p370d.p375m.p376x;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;
import p007b.p225i.p361c.p369m.p370d.p375m.C4674a;
import p007b.p225i.p361c.p369m.p370d.p375m.C4675b;
import p007b.p225i.p361c.p369m.p370d.p375m.C4676c;
import p007b.p225i.p361c.p369m.p370d.p375m.C4677d;
import p007b.p225i.p361c.p369m.p370d.p375m.C4678e;
import p007b.p225i.p361c.p369m.p370d.p375m.C4679f;
import p007b.p225i.p361c.p369m.p370d.p375m.C4680g;
import p007b.p225i.p361c.p369m.p370d.p375m.C4682i;
import p007b.p225i.p361c.p369m.p370d.p375m.C4683j;
import p007b.p225i.p361c.p369m.p370d.p375m.C4684k;
import p007b.p225i.p361c.p369m.p370d.p375m.C4685l;
import p007b.p225i.p361c.p369m.p370d.p375m.C4686m;
import p007b.p225i.p361c.p369m.p370d.p375m.C4687n;
import p007b.p225i.p361c.p369m.p370d.p375m.C4688o;
import p007b.p225i.p361c.p369m.p370d.p375m.C4689p;
import p007b.p225i.p361c.p369m.p370d.p375m.C4690q;
import p007b.p225i.p361c.p369m.p370d.p375m.C4691r;
import p007b.p225i.p361c.p369m.p370d.p375m.C4692s;
import p007b.p225i.p361c.p369m.p370d.p375m.C4693t;
import p007b.p225i.p361c.p369m.p370d.p375m.C4694u;
import p007b.p225i.p361c.p369m.p370d.p375m.C4696w;
import p007b.p225i.p361c.p393p.InterfaceC4782a;
import p007b.p225i.p361c.p393p.p395h.C4793d;
import p007b.p225i.p361c.p393p.p395h.C4794e;

/* JADX INFO: renamed from: b.i.c.m.d.m.x.h */
/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4704h {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4782a f12656a;

    /* JADX INFO: renamed from: b.i.c.m.d.m.x.h$a */
    /* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
    public interface a<T> {
        /* JADX INFO: renamed from: a */
        T mo6613a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        C4794e c4794e = new C4794e();
        ((C4674a) C4674a.f12497a).m6514a(c4794e);
        c4794e.f12825e = true;
        f12656a = new C4793d(c4794e);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static <T> C4696w<T> m6614a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.mo6613a(jsonReader));
        }
        jsonReader.endArray();
        return new C4696w<>(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x0182  */
    /* JADX WARN: Code duplicated, block: B:132:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:212:0x032a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0113  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [b.i.c.m.d.m.v$d$d$a$b] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [b.i.c.m.d.m.w] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [b.i.c.m.d.m.s$a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object, java.lang.String] */
    @NonNull
    /* JADX INFO: renamed from: b */
    public static AbstractC4695v.d.AbstractC13233d m6615b(@NonNull JsonReader jsonReader) throws IOException {
        String strM883w;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        jsonReader.beginObject();
        Long lValueOf = null;
        ?? ValueOf = 0;
        String str = null;
        C4684k c4684k = null;
        AbstractC4695v.d.AbstractC13233d.b bVarM6605a = null;
        C4692s c4692s = null;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                strM883w = lValueOf == null ? " timestamp" : "";
                if (str == null) {
                    strM883w = C1643a.m883w(strM883w, " type");
                }
                if (c4684k == null) {
                    strM883w = C1643a.m883w(strM883w, " app");
                }
                if (bVarM6605a == null) {
                    strM883w = C1643a.m883w(strM883w, " device");
                }
                if (strM883w.isEmpty()) {
                    return new C4683j(lValueOf.longValue(), str, c4684k, bVarM6605a, c4692s, null);
                }
                throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "device":
                    b2 = 0;
                    break;
                case "app":
                    b2 = 1;
                    break;
                case "log":
                    b2 = 2;
                    break;
                case "type":
                    b2 = 3;
                    break;
                case "timestamp":
                    b2 = 4;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                C4691r.b bVar = new C4691r.b();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    switch (strNextName2) {
                        case "batteryLevel":
                            b3 = 0;
                            break;
                        case "batteryVelocity":
                            b3 = 1;
                            break;
                        case "orientation":
                            b3 = 2;
                            break;
                        case "diskUsed":
                            b3 = 3;
                            break;
                        case "ramUsed":
                            b3 = 4;
                            break;
                        case "proximityOn":
                            b3 = 5;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    if (b3 == 0) {
                        bVar.f12635a = Double.valueOf(jsonReader.nextDouble());
                    } else if (b3 == 1) {
                        bVar.f12636b = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 2) {
                        bVar.f12638d = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 3) {
                        bVar.f12640f = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 == 4) {
                        bVar.f12639e = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.f12637c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarM6605a = bVar.m6605a();
            } else if (b2 == 1) {
                jsonReader.beginObject();
                ?? c4685l = ValueOf;
                ?? M6614a = c4685l;
                ?? ValueOf2 = M6614a;
                while (true) {
                    char c = 3;
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        strM883w = c4685l == 0 ? " execution" : "";
                        if (ValueOf == 0) {
                            strM883w = C1643a.m883w(strM883w, " uiOrientation");
                        }
                        if (!strM883w.isEmpty()) {
                            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
                        }
                        c4684k = new C4684k(c4685l, M6614a, ValueOf2, ValueOf.intValue(), null);
                        break;
                    }
                    String strNextName3 = jsonReader.nextName();
                    strNextName3.hashCode();
                    switch (strNextName3) {
                        case "background":
                            b4 = 0;
                            break;
                        case "execution":
                            b4 = 1;
                            break;
                        case "customAttributes":
                            b4 = 2;
                            break;
                        case "uiOrientation":
                            b4 = 3;
                            break;
                        default:
                            b4 = -1;
                            break;
                    }
                    if (b4 == 0) {
                        ValueOf2 = Boolean.valueOf(jsonReader.nextBoolean());
                    } else if (b4 == 1) {
                        jsonReader.beginObject();
                        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6616c = null;
                        C4688o c4688o = null;
                        C4696w c4696wM6614a = null;
                        C4696w c4696wM6614a2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName4 = jsonReader.nextName();
                            strNextName4.hashCode();
                            switch (strNextName4) {
                                case "threads":
                                    b5 = 0;
                                    break;
                                case "signal":
                                    b5 = 1;
                                    break;
                                case "binaries":
                                    b5 = 2;
                                    break;
                                case "exception":
                                    b5 = 3;
                                    break;
                                default:
                                    b5 = -1;
                                    break;
                            }
                            if (b5 == 0) {
                                c4696wM6614a2 = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.d
                                    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                                    /* JADX INFO: renamed from: a */
                                    public Object mo6613a(JsonReader jsonReader2) throws IOException {
                                        InterfaceC4782a interfaceC4782a = C4704h.f12656a;
                                        jsonReader2.beginObject();
                                        String strNextString = null;
                                        Integer numValueOf = null;
                                        C4696w c4696wM6614a3 = null;
                                        while (jsonReader2.hasNext()) {
                                            String strNextName5 = jsonReader2.nextName();
                                            strNextName5.hashCode();
                                            strNextName5.hashCode();
                                            switch (strNextName5) {
                                                case "frames":
                                                    c4696wM6614a3 = C4704h.m6614a(jsonReader2, new C4704h.a() { // from class: b.i.c.m.d.m.x.g
                                                        @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                                                        /* JADX INFO: renamed from: a */
                                                        public Object mo6613a(JsonReader jsonReader3) {
                                                            return C4704h.m6617d(jsonReader3);
                                                        }
                                                    });
                                                    break;
                                                case "name":
                                                    strNextString = jsonReader2.nextString();
                                                    Objects.requireNonNull(strNextString, "Null name");
                                                    break;
                                                case "importance":
                                                    numValueOf = Integer.valueOf(jsonReader2.nextInt());
                                                    break;
                                                default:
                                                    jsonReader2.skipValue();
                                                    break;
                                            }
                                        }
                                        jsonReader2.endObject();
                                        String strM883w2 = strNextString == null ? " name" : "";
                                        if (numValueOf == null) {
                                            strM883w2 = C1643a.m883w(strM883w2, " importance");
                                        }
                                        if (c4696wM6614a3 == null) {
                                            strM883w2 = C1643a.m883w(strM883w2, " frames");
                                        }
                                        if (strM883w2.isEmpty()) {
                                            return new C4689p(strNextString, numValueOf.intValue(), c4696wM6614a3, null);
                                        }
                                        throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w2));
                                    }
                                });
                            } else if (b5 == 1) {
                                jsonReader.beginObject();
                                Long lValueOf2 = null;
                                String str2 = null;
                                String str3 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName5 = jsonReader.nextName();
                                    strNextName5.hashCode();
                                    int iHashCode = strNextName5.hashCode();
                                    if (iHashCode != -1147692044) {
                                        if (iHashCode != 3059181) {
                                            if (iHashCode == 3373707 && strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                                b6 = 2;
                                            } else {
                                                b6 = -1;
                                            }
                                        } else if (strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                                            b6 = 1;
                                        } else {
                                            b6 = -1;
                                        }
                                    } else if (strNextName5.equals("address")) {
                                        b6 = 0;
                                    } else {
                                        b6 = -1;
                                    }
                                    if (b6 == 0) {
                                        lValueOf2 = Long.valueOf(jsonReader.nextLong());
                                    } else if (b6 == 1) {
                                        String strNextString = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString, "Null code");
                                        str3 = strNextString;
                                    } else if (b6 != 2) {
                                        jsonReader.skipValue();
                                    } else {
                                        String strNextString2 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString2, "Null name");
                                        str2 = strNextString2;
                                    }
                                }
                                jsonReader.endObject();
                                String strM883w2 = str2 == null ? " name" : "";
                                if (str3 == null) {
                                    strM883w2 = C1643a.m883w(strM883w2, " code");
                                }
                                if (lValueOf2 == null) {
                                    strM883w2 = C1643a.m883w(strM883w2, " address");
                                }
                                if (!strM883w2.isEmpty()) {
                                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w2));
                                }
                                c4688o = new C4688o(str2, str3, lValueOf2.longValue(), null);
                            } else if (b5 == 2) {
                                c4696wM6614a = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.e
                                    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                                    /* JADX INFO: renamed from: a */
                                    public Object mo6613a(JsonReader jsonReader2) throws IOException {
                                        InterfaceC4782a interfaceC4782a = C4704h.f12656a;
                                        jsonReader2.beginObject();
                                        Long lValueOf3 = null;
                                        Long lValueOf4 = null;
                                        String strNextString3 = null;
                                        String str4 = null;
                                        while (jsonReader2.hasNext()) {
                                            String strNextName6 = jsonReader2.nextName();
                                            strNextName6.hashCode();
                                            strNextName6.hashCode();
                                            switch (strNextName6) {
                                                case "name":
                                                    strNextString3 = jsonReader2.nextString();
                                                    Objects.requireNonNull(strNextString3, "Null name");
                                                    break;
                                                case "size":
                                                    lValueOf4 = Long.valueOf(jsonReader2.nextLong());
                                                    break;
                                                case "uuid":
                                                    str4 = new String(Base64.decode(jsonReader2.nextString(), 2), AbstractC4695v.f12647a);
                                                    break;
                                                case "baseAddress":
                                                    lValueOf3 = Long.valueOf(jsonReader2.nextLong());
                                                    break;
                                                default:
                                                    jsonReader2.skipValue();
                                                    break;
                                            }
                                        }
                                        jsonReader2.endObject();
                                        String strM883w3 = lValueOf3 == null ? " baseAddress" : "";
                                        if (lValueOf4 == null) {
                                            strM883w3 = C1643a.m883w(strM883w3, " size");
                                        }
                                        if (strNextString3 == null) {
                                            strM883w3 = C1643a.m883w(strM883w3, " name");
                                        }
                                        if (strM883w3.isEmpty()) {
                                            return new C4686m(lValueOf3.longValue(), lValueOf4.longValue(), strNextString3, str4, null);
                                        }
                                        throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w3));
                                    }
                                });
                            } else if (b5 != c) {
                                jsonReader.skipValue();
                            } else {
                                abstractC13236bM6616c = m6616c(jsonReader);
                            }
                            c = 3;
                        }
                        jsonReader.endObject();
                        String strM883w3 = c4696wM6614a2 == null ? " threads" : "";
                        if (abstractC13236bM6616c == null) {
                            strM883w3 = C1643a.m883w(strM883w3, " exception");
                        }
                        if (c4688o == null) {
                            strM883w3 = C1643a.m883w(strM883w3, " signal");
                        }
                        if (c4696wM6614a == null) {
                            strM883w3 = C1643a.m883w(strM883w3, " binaries");
                        }
                        if (!strM883w3.isEmpty()) {
                            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w3));
                        }
                        c4685l = new C4685l(c4696wM6614a2, abstractC13236bM6616c, c4688o, c4696wM6614a, null);
                    } else if (b4 == 2) {
                        M6614a = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.c
                            @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                            /* JADX INFO: renamed from: a */
                            public Object mo6613a(JsonReader jsonReader2) throws IOException {
                                InterfaceC4782a interfaceC4782a = C4704h.f12656a;
                                jsonReader2.beginObject();
                                String strNextString3 = null;
                                String strNextString4 = null;
                                while (jsonReader2.hasNext()) {
                                    String strNextName6 = jsonReader2.nextName();
                                    strNextName6.hashCode();
                                    if (strNextName6.equals("key")) {
                                        strNextString3 = jsonReader2.nextString();
                                        Objects.requireNonNull(strNextString3, "Null key");
                                    } else if (strNextName6.equals("value")) {
                                        strNextString4 = jsonReader2.nextString();
                                        Objects.requireNonNull(strNextString4, "Null value");
                                    } else {
                                        jsonReader2.skipValue();
                                    }
                                }
                                jsonReader2.endObject();
                                String strM883w4 = strNextString3 == null ? " key" : "";
                                if (strNextString4 == null) {
                                    strM883w4 = C1643a.m883w(strM883w4, " value");
                                }
                                if (strM883w4.isEmpty()) {
                                    return new C4676c(strNextString3, strNextString4, null);
                                }
                                throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w4));
                            }
                        });
                    } else if (b4 != 3) {
                        jsonReader.skipValue();
                    } else {
                        ValueOf = Integer.valueOf(jsonReader.nextInt());
                    }
                }
            } else if (b2 == 2) {
                jsonReader.beginObject();
                ?? NextString = ValueOf;
                while (jsonReader.hasNext()) {
                    String strNextName6 = jsonReader.nextName();
                    strNextName6.hashCode();
                    if (strNextName6.equals("content")) {
                        NextString = jsonReader.nextString();
                        Objects.requireNonNull(NextString, "Null content");
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                strM883w = NextString == 0 ? " content" : "";
                if (!strM883w.isEmpty()) {
                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
                }
                c4692s = new C4692s(NextString, ValueOf);
            } else if (b2 == 3) {
                String strNextString3 = jsonReader.nextString();
                Objects.requireNonNull(strNextString3, "Null type");
                str = strNextString3;
            } else if (b2 != 4) {
                jsonReader.skipValue();
            } else {
                lValueOf = Long.valueOf(jsonReader.nextLong());
            }
            ValueOf = 0;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: c */
    public static AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b m6616c(@NonNull JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Integer numValueOf = null;
        String strNextString = null;
        String strNextString2 = null;
        C4696w c4696wM6614a = null;
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6616c = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    c4696wM6614a = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.f
                        @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                        /* JADX INFO: renamed from: a */
                        public Object mo6613a(JsonReader jsonReader2) {
                            return C4704h.m6617d(jsonReader2);
                        }
                    });
                    break;
                case "reason":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "type":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null type");
                    break;
                case "causedBy":
                    abstractC13236bM6616c = m6616c(jsonReader);
                    break;
                case "overflowCount":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strM883w = strNextString == null ? " type" : "";
        if (c4696wM6614a == null) {
            strM883w = C1643a.m883w(strM883w, " frames");
        }
        if (numValueOf == null) {
            strM883w = C1643a.m883w(strM883w, " overflowCount");
        }
        if (strM883w.isEmpty()) {
            return new C4687n(strNextString, strNextString2, c4696wM6614a, abstractC13236bM6616c, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public static AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a m6617d(@NonNull JsonReader jsonReader) throws IOException {
        C4690q.b bVar = new C4690q.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    bVar.f12627d = Long.valueOf(jsonReader.nextLong());
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null symbol");
                    bVar.f12625b = strNextString;
                    break;
                case "pc":
                    bVar.f12624a = Long.valueOf(jsonReader.nextLong());
                    break;
                case "file":
                    bVar.f12626c = jsonReader.nextString();
                    break;
                case "importance":
                    bVar.f12628e = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.m6598a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:149:0x021a A[PHI: r17
      0x021a: PHI (r17v18 java.lang.String) = 
      (r17v10 java.lang.String)
      (r17v11 java.lang.String)
      (r17v12 java.lang.String)
      (r17v13 java.lang.String)
      (r17v14 java.lang.String)
      (r17v16 java.lang.String)
      (r17v19 java.lang.String)
     binds: [B:146:0x0215, B:142:0x020a, B:138:0x01fd, B:414:?, B:413:?, B:412:?, B:123:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:202:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:273:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:94:0x012b  */
    @NonNull
    /* JADX INFO: renamed from: e */
    public static AbstractC4695v m6618e(@NonNull JsonReader jsonReader) throws IOException {
        byte b2;
        String str;
        byte b3;
        String str2;
        byte b4;
        Charset charset = AbstractC4695v.f12647a;
        C4675b.b bVar = new C4675b.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ndkPayload":
                    b2 = 0;
                    break;
                case "sdkVersion":
                    b2 = 1;
                    break;
                case "buildVersion":
                    b2 = 2;
                    break;
                case "gmpAppId":
                    b2 = 3;
                    break;
                case "installationUuid":
                    b2 = 4;
                    break;
                case "platform":
                    b2 = 5;
                    break;
                case "displayVersion":
                    b2 = 6;
                    break;
                case "session":
                    b2 = 7;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            String str3 = "";
            switch (b2) {
                case 0:
                    jsonReader.beginObject();
                    String strNextString = null;
                    C4696w c4696wM6614a = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(ChatInputComponentTypes.FILES)) {
                            c4696wM6614a = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.b
                                @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                                /* JADX INFO: renamed from: a */
                                public Object mo6613a(JsonReader jsonReader2) throws IOException {
                                    InterfaceC4782a interfaceC4782a = C4704h.f12656a;
                                    jsonReader2.beginObject();
                                    String strNextString2 = null;
                                    byte[] bArrDecode = null;
                                    while (jsonReader2.hasNext()) {
                                        String strNextName3 = jsonReader2.nextName();
                                        strNextName3.hashCode();
                                        if (strNextName3.equals("filename")) {
                                            strNextString2 = jsonReader2.nextString();
                                            Objects.requireNonNull(strNextString2, "Null filename");
                                        } else if (strNextName3.equals("contents")) {
                                            bArrDecode = Base64.decode(jsonReader2.nextString(), 2);
                                            Objects.requireNonNull(bArrDecode, "Null contents");
                                        } else {
                                            jsonReader2.skipValue();
                                        }
                                    }
                                    jsonReader2.endObject();
                                    String strM883w = strNextString2 == null ? " filename" : "";
                                    if (bArrDecode == null) {
                                        strM883w = C1643a.m883w(strM883w, " contents");
                                    }
                                    if (strM883w.isEmpty()) {
                                        return new C4678e(strNextString2, bArrDecode, null);
                                    }
                                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
                                }
                            });
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    String str4 = c4696wM6614a == null ? " files" : "";
                    if (!str4.isEmpty()) {
                        throw new IllegalStateException(C1643a.m883w("Missing required properties:", str4));
                    }
                    bVar.f12533h = new C4677d(c4696wM6614a, strNextString, null);
                    break;
                    break;
                case 1:
                    String strNextString2 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString2, "Null sdkVersion");
                    bVar.f12526a = strNextString2;
                    break;
                case 2:
                    String strNextString3 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString3, "Null buildVersion");
                    bVar.f12530e = strNextString3;
                    break;
                case 3:
                    String strNextString4 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString4, "Null gmpAppId");
                    bVar.f12527b = strNextString4;
                    break;
                case 4:
                    String strNextString5 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString5, "Null installationUuid");
                    bVar.f12529d = strNextString5;
                    break;
                case 5:
                    bVar.f12528c = Integer.valueOf(jsonReader.nextInt());
                    break;
                case 6:
                    String strNextString6 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString6, "Null displayVersion");
                    bVar.f12531f = strNextString6;
                    break;
                case 7:
                    C4679f.b bVar2 = new C4679f.b();
                    bVar2.m6544b(false);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3) {
                            case "startedAt":
                                str = str3;
                                bVar2.f12553c = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "identifier":
                                str = str3;
                                bVar2.f12552b = new String(Base64.decode(jsonReader.nextString(), 2), AbstractC4695v.f12647a);
                                str3 = str;
                                break;
                            case "endedAt":
                                str = str3;
                                bVar2.f12554d = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "device":
                                str = str3;
                                C4682i.b bVar3 = new C4682i.b();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.hashCode();
                                    switch (strNextName4) {
                                        case "simulator":
                                            bVar3.f12583f = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString7, "Null manufacturer");
                                            bVar3.f12585h = strNextString7;
                                            break;
                                        case "ram":
                                            bVar3.f12581d = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "arch":
                                            bVar3.f12578a = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "diskSpace":
                                            bVar3.f12582e = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "cores":
                                            bVar3.f12580c = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString8, "Null model");
                                            bVar3.f12579b = strNextString8;
                                            break;
                                        case "state":
                                            bVar3.f12584g = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString9, "Null modelClass");
                                            bVar3.f12586i = strNextString9;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                bVar2.f12559i = bVar3.m6562a();
                                str3 = str;
                                break;
                            case "events":
                                str = str3;
                                bVar2.f12560j = m6614a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.a
                                    @Override // p007b.p225i.p361c.p369m.p370d.p375m.p376x.C4704h.a
                                    /* JADX INFO: renamed from: a */
                                    public Object mo6613a(JsonReader jsonReader2) {
                                        return C4704h.m6615b(jsonReader2);
                                    }
                                });
                                str3 = str;
                                break;
                            case "os":
                                str = str3;
                                jsonReader.beginObject();
                                Boolean boolValueOf = null;
                                Integer numValueOf = null;
                                String str5 = null;
                                String str6 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName5 = jsonReader.nextName();
                                    strNextName5.hashCode();
                                    switch (strNextName5) {
                                        case "buildVersion":
                                            b3 = 0;
                                            break;
                                        case "jailbroken":
                                            b3 = 1;
                                            break;
                                        case "version":
                                            b3 = 2;
                                            break;
                                        case "platform":
                                            b3 = 3;
                                            break;
                                        default:
                                            b3 = -1;
                                            break;
                                    }
                                    if (b3 == 0) {
                                        String strNextString10 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString10, "Null buildVersion");
                                        str6 = strNextString10;
                                    } else if (b3 == 1) {
                                        boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                                    } else if (b3 == 2) {
                                        String strNextString11 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString11, "Null version");
                                        str5 = strNextString11;
                                    } else if (b3 != 3) {
                                        jsonReader.skipValue();
                                    } else {
                                        numValueOf = Integer.valueOf(jsonReader.nextInt());
                                    }
                                }
                                jsonReader.endObject();
                                String strM883w = numValueOf == null ? " platform" : str;
                                if (str5 == null) {
                                    strM883w = C1643a.m883w(strM883w, " version");
                                }
                                if (str6 == null) {
                                    strM883w = C1643a.m883w(strM883w, " buildVersion");
                                }
                                if (boolValueOf == null) {
                                    strM883w = C1643a.m883w(strM883w, " jailbroken");
                                }
                                if (!strM883w.isEmpty()) {
                                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
                                }
                                bVar2.f12558h = new C4693t(numValueOf.intValue(), str5, str6, boolValueOf.booleanValue(), null);
                                str3 = str;
                                break;
                                break;
                            case "app":
                                jsonReader.beginObject();
                                String str7 = null;
                                String str8 = null;
                                String strNextString12 = null;
                                String strNextString13 = null;
                                String strNextString14 = null;
                                String strNextString15 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName6 = jsonReader.nextName();
                                    strNextName6.hashCode();
                                    switch (strNextName6.hashCode()) {
                                        case -1618432855:
                                            str2 = str3;
                                            if (!strNextName6.equals("identifier")) {
                                                b4 = -1;
                                            } else {
                                                b4 = 0;
                                            }
                                            break;
                                        case -519438642:
                                            str2 = str3;
                                            if (!strNextName6.equals("developmentPlatform")) {
                                                b4 = -1;
                                            } else {
                                                b4 = 1;
                                            }
                                            break;
                                        case 213652010:
                                            str2 = str3;
                                            if (!strNextName6.equals("developmentPlatformVersion")) {
                                                b4 = -1;
                                            } else {
                                                b4 = 2;
                                            }
                                            break;
                                        case 351608024:
                                            if (!strNextName6.equals("version")) {
                                                str2 = str3;
                                                b4 = -1;
                                            } else {
                                                b4 = 3;
                                                str2 = str3;
                                            }
                                            break;
                                        case 719853845:
                                            if (!strNextName6.equals("installationUuid")) {
                                                str2 = str3;
                                                b4 = -1;
                                            } else {
                                                b4 = 4;
                                                str2 = str3;
                                            }
                                            break;
                                        case 1975623094:
                                            if (!strNextName6.equals("displayVersion")) {
                                                str2 = str3;
                                                b4 = -1;
                                            } else {
                                                b4 = 5;
                                                str2 = str3;
                                            }
                                            break;
                                        default:
                                            str2 = str3;
                                            b4 = -1;
                                            break;
                                    }
                                    if (b4 == 0) {
                                        String strNextString16 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString16, "Null identifier");
                                        str7 = strNextString16;
                                    } else if (b4 == 1) {
                                        strNextString14 = jsonReader.nextString();
                                    } else if (b4 == 2) {
                                        strNextString15 = jsonReader.nextString();
                                    } else if (b4 == 3) {
                                        String strNextString17 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString17, "Null version");
                                        str8 = strNextString17;
                                    } else if (b4 == 4) {
                                        strNextString13 = jsonReader.nextString();
                                    } else if (b4 != 5) {
                                        jsonReader.skipValue();
                                    } else {
                                        strNextString12 = jsonReader.nextString();
                                    }
                                    str3 = str2;
                                }
                                str = str3;
                                jsonReader.endObject();
                                String strM883w2 = str7 == null ? " identifier" : str;
                                if (str8 == null) {
                                    strM883w2 = C1643a.m883w(strM883w2, " version");
                                }
                                if (!strM883w2.isEmpty()) {
                                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w2));
                                }
                                bVar2.f12556f = new C4680g(str7, str8, strNextString12, null, strNextString13, strNextString14, strNextString15, null);
                                str3 = str;
                                break;
                                break;
                            case "user":
                                jsonReader.beginObject();
                                String strNextString18 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName7 = jsonReader.nextName();
                                    strNextName7.hashCode();
                                    if (strNextName7.equals("identifier")) {
                                        strNextString18 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString18, "Null identifier");
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                String str9 = strNextString18 == null ? " identifier" : str3;
                                if (!str9.isEmpty()) {
                                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", str9));
                                }
                                bVar2.f12557g = new C4694u(strNextString18, null);
                                str = str3;
                                str3 = str;
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                Objects.requireNonNull(strNextString19, "Null generator");
                                bVar2.f12551a = strNextString19;
                                str = str3;
                                str3 = str;
                                break;
                            case "crashed":
                                bVar2.m6544b(jsonReader.nextBoolean());
                                str = str3;
                                str3 = str;
                                break;
                            case "generatorType":
                                bVar2.f12561k = Integer.valueOf(jsonReader.nextInt());
                                str = str3;
                                str3 = str;
                                break;
                            default:
                                str = str3;
                                jsonReader.skipValue();
                                str3 = str;
                                break;
                        }
                    }
                    jsonReader.endObject();
                    bVar.f12532g = bVar2.mo6543a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.mo6524a();
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public AbstractC4695v m6619f(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                AbstractC4695v abstractC4695vM6618e = m6618e(jsonReader);
                jsonReader.close();
                return abstractC4695vM6618e;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public String m6620g(@NonNull AbstractC4695v abstractC4695v) {
        return ((C4793d) f12656a).m6711a(abstractC4695v);
    }
}
