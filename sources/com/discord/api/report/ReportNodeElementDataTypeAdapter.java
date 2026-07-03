package com.discord.api.report;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import p007b.p008a.p059w.C1316a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportNodeElementDataTypeAdapter extends TypeAdapter<ReportNodeElementData> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeElementData read(JsonReader jsonReader) {
        C12238m.checkNotNullParameter(jsonReader, "reader");
        Object objM9200d = new Gson().m9200d(jsonReader, C1316a.f2003a);
        C12238m.checkNotNullExpressionValue(objM9200d, "Gson().fromJson(reader, STRING_LIST_TYPE)");
        List list = (List) objM9200d;
        return new ReportNodeElementData((String) list.get(0), (String) list.get(1));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeElementData reportNodeElementData) throws IOException {
        ReportNodeElementData reportNodeElementData2 = reportNodeElementData;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (reportNodeElementData2 == null) {
            jsonWriter.mo6905s();
        } else {
            jsonWriter.mo6900b().mo6895H(reportNodeElementData2.getElementKey()).mo6895H(reportNodeElementData2.getElementValue()).mo6902e();
        }
    }
}
