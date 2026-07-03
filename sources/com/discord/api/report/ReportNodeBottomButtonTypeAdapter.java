package com.discord.api.report;

import com.discord.api.report.ReportNodeBottomButton;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import kotlin.Unit;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportNodeBottomButtonTypeAdapter extends TypeAdapter<ReportNodeBottomButton> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[6] = 1;
            iArr[5] = 2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.gson.TypeAdapter
    public ReportNodeBottomButton read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6879U();
            return null;
        }
        jsonReader.mo6883b();
        String strMo6877J = "";
        Object objMo6877J = "";
        while (jsonReader.mo6888q()) {
            String strMo6875C = jsonReader.mo6875C();
            if (strMo6875C != null) {
                int iHashCode = strMo6875C.hashCode();
                if (iHashCode != -880905839) {
                    if (iHashCode == 3575610 && strMo6875C.equals("type")) {
                        strMo6877J = jsonReader.mo6877J();
                        C12238m.checkNotNullExpressionValue(strMo6877J, "reader.nextString()");
                    }
                } else if (strMo6875C.equals("target")) {
                    JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
                    if (jsonTokenMo6878N != null) {
                        int iOrdinal = jsonTokenMo6878N.ordinal();
                        if (iOrdinal == 5) {
                            objMo6877J = jsonReader.mo6877J();
                        } else if (iOrdinal != 6) {
                            jsonReader.mo6879U();
                            objMo6877J = Unit.f27425a;
                        } else {
                            objMo6877J = Integer.valueOf(jsonReader.mo6891y());
                        }
                    } else {
                        jsonReader.mo6879U();
                        objMo6877J = Unit.f27425a;
                    }
                    C12238m.checkNotNullExpressionValue(objMo6877J, "when (reader.peek()) {\n …der.skipValue()\n        }");
                }
            }
            jsonReader.mo6879U();
        }
        jsonReader.mo6887f();
        switch (strMo6877J.hashCode()) {
            case -1367724422:
                if (strMo6877J.equals("cancel")) {
                    return ReportNodeBottomButton.Cancel.INSTANCE;
                }
                return null;
            case -891535336:
                if (strMo6877J.equals("submit")) {
                    return ReportNodeBottomButton.Submit.INSTANCE;
                }
                return null;
            case 3089282:
                if (strMo6877J.equals("done")) {
                    return ReportNodeBottomButton.Done.INSTANCE;
                }
                return null;
            case 3377907:
                if (!strMo6877J.equals("next")) {
                    return null;
                }
                Objects.requireNonNull(objMo6877J, "null cannot be cast to non-null type kotlin.Int");
                return new ReportNodeBottomButton.Next(((Integer) objMo6877J).intValue());
            default:
                return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeBottomButton reportNodeBottomButton) throws IOException {
        ReportNodeBottomButton reportNodeBottomButton2 = reportNodeBottomButton;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (reportNodeBottomButton2 == null) {
            jsonWriter.mo6905s();
            return;
        }
        JsonWriter jsonWriterMo6904n = jsonWriter.mo6901c().mo6904n("type").mo6895H(reportNodeBottomButton2.getType()).mo6904n("target");
        try {
            JsonWriter jsonWriterMo6894D = reportNodeBottomButton2 instanceof ReportNodeBottomButton.Next ? jsonWriterMo6904n.mo6894D(Integer.valueOf(((ReportNodeBottomButton.Next) reportNodeBottomButton2).getTarget())) : jsonWriterMo6904n.mo6905s();
            C12201b.closeFinally(jsonWriterMo6904n, null);
            jsonWriterMo6894D.mo6903f();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(jsonWriterMo6904n, th);
                throw th2;
            }
        }
    }
}
