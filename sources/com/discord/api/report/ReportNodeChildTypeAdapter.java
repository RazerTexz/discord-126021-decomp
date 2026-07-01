package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportNodeChildTypeAdapter extends TypeAdapter<ReportNodeChild> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeChild read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "reader");
        jsonReader.a();
        String strJ = jsonReader.J();
        int iY = jsonReader.y();
        jsonReader.e();
        Intrinsics3.checkNotNullExpressionValue(strJ, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ReportNodeChild(strJ, iY);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeChild reportNodeChild) throws IOException {
        ReportNodeChild reportNodeChild2 = reportNodeChild;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        Intrinsics3.checkNotNullParameter(reportNodeChild2, "child");
        jsonWriter.b().H(reportNodeChild2.getName()).D(Integer.valueOf(reportNodeChild2.getRef())).e();
    }
}
