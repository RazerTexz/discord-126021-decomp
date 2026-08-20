package com.discord.api.guildrolesubscription;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PayoutStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayoutStatusAdapter extends TypeAdapter<PayoutStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutStatus read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        PayoutStatus.Companion companion = PayoutStatus.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        PayoutStatus payoutStatus = PayoutStatus.OPEN;
        if (iMo6891y == payoutStatus.getApiValue()) {
            return payoutStatus;
        }
        PayoutStatus payoutStatus2 = PayoutStatus.PAID;
        if (iMo6891y == payoutStatus2.getApiValue()) {
            return payoutStatus2;
        }
        PayoutStatus payoutStatus3 = PayoutStatus.PENDING;
        if (iMo6891y == payoutStatus3.getApiValue()) {
            return payoutStatus3;
        }
        PayoutStatus payoutStatus4 = PayoutStatus.MANUAL;
        if (iMo6891y == payoutStatus4.getApiValue()) {
            return payoutStatus4;
        }
        PayoutStatus payoutStatus5 = PayoutStatus.CANCELED;
        if (iMo6891y == payoutStatus5.getApiValue()) {
            return payoutStatus5;
        }
        PayoutStatus payoutStatus6 = PayoutStatus.DEFERRED;
        if (iMo6891y == payoutStatus6.getApiValue()) {
            return payoutStatus6;
        }
        PayoutStatus payoutStatus7 = PayoutStatus.DEFERRED_INTERNAL;
        if (iMo6891y == payoutStatus7.getApiValue()) {
            return payoutStatus7;
        }
        PayoutStatus payoutStatus8 = PayoutStatus.PROCESSING;
        if (iMo6891y == payoutStatus8.getApiValue()) {
            return payoutStatus8;
        }
        PayoutStatus payoutStatus9 = PayoutStatus.ERROR;
        if (iMo6891y == payoutStatus9.getApiValue()) {
            return payoutStatus9;
        }
        PayoutStatus payoutStatus10 = PayoutStatus.REJECTED;
        if (iMo6891y == payoutStatus10.getApiValue()) {
            return payoutStatus10;
        }
        PayoutStatus payoutStatus11 = PayoutStatus.RISK_REVIEW;
        if (iMo6891y == payoutStatus11.getApiValue()) {
            return payoutStatus11;
        }
        PayoutStatus payoutStatus12 = PayoutStatus.SUBMITTED;
        if (iMo6891y == payoutStatus12.getApiValue()) {
            return payoutStatus12;
        }
        PayoutStatus payoutStatus13 = PayoutStatus.PENDING_FUNDS;
        return iMo6891y == payoutStatus13.getApiValue() ? payoutStatus13 : PayoutStatus.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutStatus payoutStatus) throws IOException {
        PayoutStatus payoutStatus2 = payoutStatus;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (payoutStatus2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(payoutStatus2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
