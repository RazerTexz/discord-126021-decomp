package com.discord.api.guildrolesubscription;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: PayoutGroupType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupTypeAdapter extends TypeAdapter<PayoutGroupType> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        PayoutGroupType$Companion payoutGroupType$Companion = PayoutGroupType.Companion;
        String strJ = jsonReader.J();
        m.checkNotNullExpressionValue(strJ, "`in`.nextString()");
        Objects.requireNonNull(payoutGroupType$Companion);
        m.checkNotNullParameter(strJ, "apiValue");
        PayoutGroupType payoutGroupType = PayoutGroupType.MARKETPLACE;
        if (m.areEqual(strJ, payoutGroupType.getApiValue())) {
            return payoutGroupType;
        }
        PayoutGroupType payoutGroupType2 = PayoutGroupType.STAGE_EVENT_SKU;
        if (m.areEqual(strJ, payoutGroupType2.getApiValue())) {
            return payoutGroupType2;
        }
        PayoutGroupType payoutGroupType3 = PayoutGroupType.SERVER_ROLE_SUBSCRIPTION;
        return m.areEqual(strJ, payoutGroupType3.getApiValue()) ? payoutGroupType3 : PayoutGroupType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupType payoutGroupType) throws IOException {
        PayoutGroupType payoutGroupType2 = payoutGroupType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupType2 != null) {
            jsonWriter.H(payoutGroupType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
