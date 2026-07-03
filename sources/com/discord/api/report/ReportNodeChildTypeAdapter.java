package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportNodeChildTypeAdapter extends TypeAdapter<ReportNodeChild> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeChild read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "reader");
        jsonReader.mo6882a();
        String strMo6877J = jsonReader.mo6877J();
        int iMo6891y = jsonReader.mo6891y();
        jsonReader.mo6886e();
        C12238m.checkNotNullExpressionValue(strMo6877J, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ReportNodeChild(strMo6877J, iMo6891y);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeChild reportNodeChild) throws IOException {
        ReportNodeChild reportNodeChild2 = reportNodeChild;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        C12238m.checkNotNullParameter(reportNodeChild2, "child");
        jsonWriter.mo6900b().mo6895H(reportNodeChild2.getName()).mo6894D(Integer.valueOf(reportNodeChild2.getRef())).mo6902e();
    }
}
