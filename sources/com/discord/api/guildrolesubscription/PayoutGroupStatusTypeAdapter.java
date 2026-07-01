package com.discord.api.guildrolesubscription;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: PayoutGroupStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupStatusTypeAdapter extends TypeAdapter<PayoutGroupStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupStatus read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        PayoutGroupStatus$Companion payoutGroupStatus$Companion = PayoutGroupStatus.Companion;
        int iY = jsonReader.y();
        Objects.requireNonNull(payoutGroupStatus$Companion);
        if (iY == 1) {
            return PayoutGroupStatus.OPEN;
        }
        if (iY != 2) {
            return iY != 3 ? PayoutGroupStatus.UNKNOWN : PayoutGroupStatus.CANCELED;
        }
        return PayoutGroupStatus.PAYOUT_CREATED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupStatus payoutGroupStatus) throws IOException {
        PayoutGroupStatus payoutGroupStatus2 = payoutGroupStatus;
        m.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupStatus2 != null) {
            jsonWriter.D(Integer.valueOf(payoutGroupStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
