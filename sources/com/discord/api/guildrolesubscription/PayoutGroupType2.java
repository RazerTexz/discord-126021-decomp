package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.api.guildrolesubscription.PayoutGroupTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: PayoutGroupType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupType2 extends TypeAdapter<PayoutGroupType> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        PayoutGroupType.Companion companion = PayoutGroupType.INSTANCE;
        String strJ = jsonReader.J();
        Intrinsics3.checkNotNullExpressionValue(strJ, "`in`.nextString()");
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(strJ, "apiValue");
        PayoutGroupType payoutGroupType = PayoutGroupType.MARKETPLACE;
        if (Intrinsics3.areEqual(strJ, payoutGroupType.getApiValue())) {
            return payoutGroupType;
        }
        PayoutGroupType payoutGroupType2 = PayoutGroupType.STAGE_EVENT_SKU;
        if (Intrinsics3.areEqual(strJ, payoutGroupType2.getApiValue())) {
            return payoutGroupType2;
        }
        PayoutGroupType payoutGroupType3 = PayoutGroupType.SERVER_ROLE_SUBSCRIPTION;
        return Intrinsics3.areEqual(strJ, payoutGroupType3.getApiValue()) ? payoutGroupType3 : PayoutGroupType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupType payoutGroupType) throws IOException {
        PayoutGroupType payoutGroupType2 = payoutGroupType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupType2 != null) {
            jsonWriter.H(payoutGroupType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
