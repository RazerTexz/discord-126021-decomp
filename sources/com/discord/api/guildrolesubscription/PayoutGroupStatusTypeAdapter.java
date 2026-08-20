package com.discord.api.guildrolesubscription;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PayoutGroupStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutGroupStatusTypeAdapter extends TypeAdapter<PayoutGroupStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupStatus read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        PayoutGroupStatus.Companion companion = PayoutGroupStatus.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        if (iMo6891y == 1) {
            return PayoutGroupStatus.OPEN;
        }
        if (iMo6891y != 2) {
            return iMo6891y != 3 ? PayoutGroupStatus.UNKNOWN : PayoutGroupStatus.CANCELED;
        }
        return PayoutGroupStatus.PAYOUT_CREATED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupStatus payoutGroupStatus) throws IOException {
        PayoutGroupStatus payoutGroupStatus2 = payoutGroupStatus;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupStatus2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(payoutGroupStatus2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
