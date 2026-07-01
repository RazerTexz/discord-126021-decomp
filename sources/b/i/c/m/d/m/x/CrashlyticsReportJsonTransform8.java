package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoCrashlyticsReportEncoder;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_CustomAttribute;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload_File;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Log;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_User;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.p.DataEncoder;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.m.d.m.x.h, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsReportJsonTransform8 {
    public static final DataEncoder a;

    /* JADX INFO: renamed from: b.i.c.m.d.m.x.h$a */
    /* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
    public interface a<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoCrashlyticsReportEncoder) AutoCrashlyticsReportEncoder.a).a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.e = true;
        a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @NonNull
    public static <T> ImmutableList3<T> a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return new ImmutableList3<>(arrayList);
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
    public static CrashlyticsReport.d.AbstractC0049d b(@NonNull JsonReader jsonReader) throws IOException {
        String strW;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        jsonReader.beginObject();
        Long lValueOf = null;
        ?? ValueOf = 0;
        String str = null;
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = null;
        CrashlyticsReport.d.AbstractC0049d.b bVarA = null;
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log = null;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                strW = lValueOf == null ? " timestamp" : "";
                if (str == null) {
                    strW = outline.w(strW, " type");
                }
                if (autoValue_CrashlyticsReport_Session_Event_Application == null) {
                    strW = outline.w(strW, " app");
                }
                if (bVarA == null) {
                    strW = outline.w(strW, " device");
                }
                if (strW.isEmpty()) {
                    return new AutoValue_CrashlyticsReport_Session_Event(lValueOf.longValue(), str, autoValue_CrashlyticsReport_Session_Event_Application, bVarA, autoValue_CrashlyticsReport_Session_Event_Log, null);
                }
                throw new IllegalStateException(outline.w("Missing required properties:", strW));
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
                AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
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
                        bVar.a = Double.valueOf(jsonReader.nextDouble());
                    } else if (b3 == 1) {
                        bVar.f1734b = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 2) {
                        bVar.d = Integer.valueOf(jsonReader.nextInt());
                    } else if (b3 == 3) {
                        bVar.f = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 == 4) {
                        bVar.e = Long.valueOf(jsonReader.nextLong());
                    } else if (b3 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarA = bVar.a();
            } else if (b2 == 1) {
                jsonReader.beginObject();
                ?? autoValue_CrashlyticsReport_Session_Event_Application_Execution = ValueOf;
                ?? A = autoValue_CrashlyticsReport_Session_Event_Application_Execution;
                ?? ValueOf2 = A;
                while (true) {
                    char c = 3;
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        strW = autoValue_CrashlyticsReport_Session_Event_Application_Execution == 0 ? " execution" : "";
                        if (ValueOf == 0) {
                            strW = outline.w(strW, " uiOrientation");
                        }
                        if (!strW.isEmpty()) {
                            throw new IllegalStateException(outline.w("Missing required properties:", strW));
                        }
                        autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, A, ValueOf2, ValueOf.intValue(), null);
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
                        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bC = null;
                        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = null;
                        ImmutableList3 immutableList3A = null;
                        ImmutableList3 immutableList3A2 = null;
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
                                immutableList3A2 = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.d
                                    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                                    public Object a(JsonReader jsonReader2) throws IOException {
                                        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
                                        jsonReader2.beginObject();
                                        String strNextString = null;
                                        Integer numValueOf = null;
                                        ImmutableList3 immutableList3A3 = null;
                                        while (jsonReader2.hasNext()) {
                                            String strNextName5 = jsonReader2.nextName();
                                            strNextName5.hashCode();
                                            strNextName5.hashCode();
                                            switch (strNextName5) {
                                                case "frames":
                                                    immutableList3A3 = CrashlyticsReportJsonTransform8.a(jsonReader2, new CrashlyticsReportJsonTransform8.a() { // from class: b.i.c.m.d.m.x.g
                                                        @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                                                        public Object a(JsonReader jsonReader3) {
                                                            return CrashlyticsReportJsonTransform8.d(jsonReader3);
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
                                        String strW2 = strNextString == null ? " name" : "";
                                        if (numValueOf == null) {
                                            strW2 = outline.w(strW2, " importance");
                                        }
                                        if (immutableList3A3 == null) {
                                            strW2 = outline.w(strW2, " frames");
                                        }
                                        if (strW2.isEmpty()) {
                                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(strNextString, numValueOf.intValue(), immutableList3A3, null);
                                        }
                                        throw new IllegalStateException(outline.w("Missing required properties:", strW2));
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
                                String strW2 = str2 == null ? " name" : "";
                                if (str3 == null) {
                                    strW2 = outline.w(strW2, " code");
                                }
                                if (lValueOf2 == null) {
                                    strW2 = outline.w(strW2, " address");
                                }
                                if (!strW2.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW2));
                                }
                                autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str2, str3, lValueOf2.longValue(), null);
                            } else if (b5 == 2) {
                                immutableList3A = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.e
                                    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                                    public Object a(JsonReader jsonReader2) throws IOException {
                                        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
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
                                                    str4 = new String(Base64.decode(jsonReader2.nextString(), 2), CrashlyticsReport.a);
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
                                        String strW3 = lValueOf3 == null ? " baseAddress" : "";
                                        if (lValueOf4 == null) {
                                            strW3 = outline.w(strW3, " size");
                                        }
                                        if (strNextString3 == null) {
                                            strW3 = outline.w(strW3, " name");
                                        }
                                        if (strW3.isEmpty()) {
                                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(lValueOf3.longValue(), lValueOf4.longValue(), strNextString3, str4, null);
                                        }
                                        throw new IllegalStateException(outline.w("Missing required properties:", strW3));
                                    }
                                });
                            } else if (b5 != c) {
                                jsonReader.skipValue();
                            } else {
                                abstractC0052bC = c(jsonReader);
                            }
                            c = 3;
                        }
                        jsonReader.endObject();
                        String strW3 = immutableList3A2 == null ? " threads" : "";
                        if (abstractC0052bC == null) {
                            strW3 = outline.w(strW3, " exception");
                        }
                        if (autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal == null) {
                            strW3 = outline.w(strW3, " signal");
                        }
                        if (immutableList3A == null) {
                            strW3 = outline.w(strW3, " binaries");
                        }
                        if (!strW3.isEmpty()) {
                            throw new IllegalStateException(outline.w("Missing required properties:", strW3));
                        }
                        autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3A2, abstractC0052bC, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, immutableList3A, null);
                    } else if (b4 == 2) {
                        A = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.c
                            @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                            public Object a(JsonReader jsonReader2) throws IOException {
                                DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
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
                                String strW4 = strNextString3 == null ? " key" : "";
                                if (strNextString4 == null) {
                                    strW4 = outline.w(strW4, " value");
                                }
                                if (strW4.isEmpty()) {
                                    return new AutoValue_CrashlyticsReport_CustomAttribute(strNextString3, strNextString4, null);
                                }
                                throw new IllegalStateException(outline.w("Missing required properties:", strW4));
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
                strW = NextString == 0 ? " content" : "";
                if (!strW.isEmpty()) {
                    throw new IllegalStateException(outline.w("Missing required properties:", strW));
                }
                autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(NextString, ValueOf);
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
    public static CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b c(@NonNull JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Integer numValueOf = null;
        String strNextString = null;
        String strNextString2 = null;
        ImmutableList3 immutableList3A = null;
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bC = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    immutableList3A = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.f
                        @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                        public Object a(JsonReader jsonReader2) {
                            return CrashlyticsReportJsonTransform8.d(jsonReader2);
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
                    abstractC0052bC = c(jsonReader);
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
        String strW = strNextString == null ? " type" : "";
        if (immutableList3A == null) {
            strW = outline.w(strW, " frames");
        }
        if (numValueOf == null) {
            strW = outline.w(strW, " overflowCount");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(strNextString, strNextString2, immutableList3A, abstractC0052bC, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }

    @NonNull
    public static CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a d(@NonNull JsonReader jsonReader) throws IOException {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    bVar.d = Long.valueOf(jsonReader.nextLong());
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null symbol");
                    bVar.f1732b = strNextString;
                    break;
                case "pc":
                    bVar.a = Long.valueOf(jsonReader.nextLong());
                    break;
                case "file":
                    bVar.c = jsonReader.nextString();
                    break;
                case "importance":
                    bVar.e = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.a();
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
    public static CrashlyticsReport e(@NonNull JsonReader jsonReader) throws IOException {
        byte b2;
        String str;
        byte b3;
        String str2;
        byte b4;
        Charset charset = CrashlyticsReport.a;
        AutoValue_CrashlyticsReport.b bVar = new AutoValue_CrashlyticsReport.b();
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
                    ImmutableList3 immutableList3A = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(ChatInputComponentTypes.FILES)) {
                            immutableList3A = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.b
                                @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                                public Object a(JsonReader jsonReader2) throws IOException {
                                    DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
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
                                    String strW = strNextString2 == null ? " filename" : "";
                                    if (bArrDecode == null) {
                                        strW = outline.w(strW, " contents");
                                    }
                                    if (strW.isEmpty()) {
                                        return new AutoValue_CrashlyticsReport_FilesPayload_File(strNextString2, bArrDecode, null);
                                    }
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW));
                                }
                            });
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    String str4 = immutableList3A == null ? " files" : "";
                    if (!str4.isEmpty()) {
                        throw new IllegalStateException(outline.w("Missing required properties:", str4));
                    }
                    bVar.h = new AutoValue_CrashlyticsReport_FilesPayload(immutableList3A, strNextString, null);
                    break;
                    break;
                case 1:
                    String strNextString2 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString2, "Null sdkVersion");
                    bVar.a = strNextString2;
                    break;
                case 2:
                    String strNextString3 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString3, "Null buildVersion");
                    bVar.e = strNextString3;
                    break;
                case 3:
                    String strNextString4 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString4, "Null gmpAppId");
                    bVar.f1714b = strNextString4;
                    break;
                case 4:
                    String strNextString5 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString5, "Null installationUuid");
                    bVar.d = strNextString5;
                    break;
                case 5:
                    bVar.c = Integer.valueOf(jsonReader.nextInt());
                    break;
                case 6:
                    String strNextString6 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString6, "Null displayVersion");
                    bVar.f = strNextString6;
                    break;
                case 7:
                    AutoValue_CrashlyticsReport_Session.b bVar2 = new AutoValue_CrashlyticsReport_Session.b();
                    bVar2.b(false);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3) {
                            case "startedAt":
                                str = str3;
                                bVar2.c = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "identifier":
                                str = str3;
                                bVar2.f1719b = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.a);
                                str3 = str;
                                break;
                            case "endedAt":
                                str = str3;
                                bVar2.d = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                                break;
                            case "device":
                                str = str3;
                                AutoValue_CrashlyticsReport_Session_Device.b bVar3 = new AutoValue_CrashlyticsReport_Session_Device.b();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.hashCode();
                                    switch (strNextName4) {
                                        case "simulator":
                                            bVar3.f = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString7, "Null manufacturer");
                                            bVar3.h = strNextString7;
                                            break;
                                        case "ram":
                                            bVar3.d = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "arch":
                                            bVar3.a = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "diskSpace":
                                            bVar3.e = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "cores":
                                            bVar3.c = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString8, "Null model");
                                            bVar3.f1722b = strNextString8;
                                            break;
                                        case "state":
                                            bVar3.g = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString9, "Null modelClass");
                                            bVar3.i = strNextString9;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                bVar2.i = bVar3.a();
                                str3 = str;
                                break;
                            case "events":
                                str = str3;
                                bVar2.j = a(jsonReader, new a() { // from class: b.i.c.m.d.m.x.a
                                    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
                                    public Object a(JsonReader jsonReader2) {
                                        return CrashlyticsReportJsonTransform8.b(jsonReader2);
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
                                String strW = numValueOf == null ? " platform" : str;
                                if (str5 == null) {
                                    strW = outline.w(strW, " version");
                                }
                                if (str6 == null) {
                                    strW = outline.w(strW, " buildVersion");
                                }
                                if (boolValueOf == null) {
                                    strW = outline.w(strW, " jailbroken");
                                }
                                if (!strW.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW));
                                }
                                bVar2.h = new AutoValue_CrashlyticsReport_Session_OperatingSystem(numValueOf.intValue(), str5, str6, boolValueOf.booleanValue(), null);
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
                                String strW2 = str7 == null ? " identifier" : str;
                                if (str8 == null) {
                                    strW2 = outline.w(strW2, " version");
                                }
                                if (!strW2.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW2));
                                }
                                bVar2.f = new AutoValue_CrashlyticsReport_Session_Application(str7, str8, strNextString12, null, strNextString13, strNextString14, strNextString15, null);
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
                                    throw new IllegalStateException(outline.w("Missing required properties:", str9));
                                }
                                bVar2.g = new AutoValue_CrashlyticsReport_Session_User(strNextString18, null);
                                str = str3;
                                str3 = str;
                                break;
                                break;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                Objects.requireNonNull(strNextString19, "Null generator");
                                bVar2.a = strNextString19;
                                str = str3;
                                str3 = str;
                                break;
                            case "crashed":
                                bVar2.b(jsonReader.nextBoolean());
                                str = str3;
                                str3 = str;
                                break;
                            case "generatorType":
                                bVar2.k = Integer.valueOf(jsonReader.nextInt());
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
                    bVar.g = bVar2.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.a();
    }

    @NonNull
    public CrashlyticsReport f(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport crashlyticsReportE = e(jsonReader);
                jsonReader.close();
                return crashlyticsReportE;
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
    public String g(@NonNull CrashlyticsReport crashlyticsReport) {
        return ((JsonDataEncoderBuilder4) a).a(crashlyticsReport);
    }
}
