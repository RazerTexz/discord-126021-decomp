package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PayoutGroupType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupTypeAdapter extends TypeAdapter<PayoutGroupType> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        PayoutGroupType.Companion companion = PayoutGroupType.INSTANCE;
        String strMo6877J = jsonReader.mo6877J();
        C12238m.checkNotNullExpressionValue(strMo6877J, "`in`.nextString()");
        Objects.requireNonNull(companion);
        C12238m.checkNotNullParameter(strMo6877J, "apiValue");
        PayoutGroupType payoutGroupType = PayoutGroupType.MARKETPLACE;
        if (C12238m.areEqual(strMo6877J, payoutGroupType.getApiValue())) {
            return payoutGroupType;
        }
        PayoutGroupType payoutGroupType2 = PayoutGroupType.STAGE_EVENT_SKU;
        if (C12238m.areEqual(strMo6877J, payoutGroupType2.getApiValue())) {
            return payoutGroupType2;
        }
        PayoutGroupType payoutGroupType3 = PayoutGroupType.SERVER_ROLE_SUBSCRIPTION;
        return C12238m.areEqual(strMo6877J, payoutGroupType3.getApiValue()) ? payoutGroupType3 : PayoutGroupType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupType payoutGroupType) throws IOException {
        PayoutGroupType payoutGroupType2 = payoutGroupType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupType2 != null) {
            jsonWriter.mo6895H(payoutGroupType2.getApiValue());
        } else {
            jsonWriter.mo6905s();
        }
    }
}
